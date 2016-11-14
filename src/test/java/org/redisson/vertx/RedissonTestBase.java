/**
 * Copyright 2016 Rui Gu (https://github.com/jackygurui)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.vertx;

import org.redisson.vertx.api.Redisson;
import io.vertx.test.core.VertxTestBase;
import java.util.concurrent.CountDownLatch;
import org.junit.Assume;
import org.redisson.misc.RedisRunner;
import org.redisson.misc.RedisVersion;
import org.redisson.vertx.config.Config;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
public class RedissonTestBase extends VertxTestBase {

    protected Redisson redisson;

    protected String requiredRedisVersion() {
        return "2.8.0";
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RedisRunner.startRedisServerInstance();
        Assume.assumeTrue(RedisVersion.compareTo(RedisRunner.getRedisServerInstance().getRedisVersion(), requiredRedisVersion()) > 0);
        redisson = createInstance();
    }

    @Override
    public void tearDown() throws Exception {
        try {
            RedisRunner.shutDownRedisServerInstance();
        } catch (Exception ex) {
            fail(ex);
        }
        final CountDownLatch l = new CountDownLatch(1);
        if (redisson != null) {
            redisson.shutdown(done -> {
                l.countDown();
            });
        }
        l.await();
        final CountDownLatch ll = new CountDownLatch(1);
        vertx.close(c -> {
            try {
                super.tearDown();
                ll.countDown();
            } catch (Exception ex) {
                ex.printStackTrace();
                ll.countDown();
            }
        });
        ll.await();
    }

    public Config createConfig() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(RedisRunner.getRedisServerBindAddressAndPort())
                .setConnectTimeout(1000000)
                .setTimeout(1000000);
        return config;
    }

    private Redisson createInstance() {
        Config config = createConfig();
        return Redisson.create(vertx, config);
    }

}
