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
package org.redisson.vertx.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.redisson.api.RedissonClient;
import org.redisson.misc.RedissonPromise;
import org.redisson.vertx.api.RedissonGeo;
import org.redisson.vertx.api.Redisson;
import org.redisson.vertx.api.RedissonKeys;
import org.redisson.vertx.config.Config;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
public class RedissonImpl implements Redisson {

    private final RedissonClient redisson;
    private final Vertx vertx;

    public RedissonImpl(Vertx vertx, Config config) {
        this.vertx = vertx;
        try {
            org.redisson.config.Config c = org.redisson.config.Config.fromJSON(config.toString());
//            c.setEventLoopGroup(vertx.nettyEventLoopGroup());
            redisson = org.redisson.Redisson.create(c);
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public RedissonClient getRedisson() {
        return redisson;
    }

    @Override
    public <V> RedissonGeo<V> getGeo(String name) {
        return RedissonGeo.create(redisson.getGeo(name));
    }

    @Override
    public RedissonKeys getKeys() {
        return RedissonKeys.create(redisson.getKeys());
    }

    @Override
    public void shutdown(Handler<AsyncResult<Void>> handler) {
        Future<Void> future = Future.<Void>future().setHandler(handler);
        RedissonPromise.runAsync(() -> {
            redisson.shutdown();
            future.complete();
        });
    }

    @Override
    public void shutdown(long quietPeriod, long timeout, TimeUnit unit, Handler<AsyncResult<Void>> handler) {
        Future<Void> future = Future.<Void>future().setHandler(handler);
        RedissonPromise.runAsync(() -> {
            redisson.shutdown(quietPeriod, timeout, unit);
            future.complete();
        });
    }

    @Override
    public void isShutdown(Handler<AsyncResult<Boolean>> handler) {
        Future<Boolean> future = Future.<Boolean>future().setHandler(handler);
        RedissonPromise.runAsync(() -> {
            future.complete(redisson.isShutdown());
        });
    }

    @Override
    public void isShuttingDown(Handler<AsyncResult<Boolean>> handler) {
        Future<Boolean> future = Future.<Boolean>future().setHandler(handler);
        RedissonPromise.runAsync(() -> {
            future.complete(redisson.isShuttingDown());
        });
    }

}
