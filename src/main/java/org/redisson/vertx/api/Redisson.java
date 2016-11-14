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
package org.redisson.vertx.api;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import java.util.concurrent.TimeUnit;
import org.redisson.api.RedissonClient;
import org.redisson.vertx.config.Config;
import org.redisson.vertx.impl.RedissonImpl;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@VertxGen
public interface Redisson {
    
    public static Redisson create(Vertx vertx, Config config) {
        return new RedissonImpl(vertx, config);
    }
    
    @GenIgnore
    RedissonClient getRedisson();
    
    /**
     * Returns geospatial items holder instance by <code>name</code>.
     * 
     * @param <V> type of value
     * @param name - name of object
     * @return Geo object
     */
    <V> RedissonGeo<V> getGeo(String name);

    /**
     * Returns interface with methods for Redis keys.
     * Each of Redis/Redisson object associated with own key
     *
     * @return RedissonKeys object
     */
    RedissonKeys getKeys();

    /**
     * Shutdown Redisson instance but <b>NOT</b> Redis server
     * 
     * This equates to invoke shutdown(2, 15, TimeUnit.SECONDS);
     * @param handler - Handler for the result of this call.
     */
    void shutdown(Handler<AsyncResult<Void>> handler);
    
    /**
     * Shuts down Redisson instance <b>NOT</b> Redis server
     * 
     * Shutdown ensures that no tasks are submitted for <i>'the quiet period'</i>
     * (usually a couple seconds) before it shuts itself down.  If a task is submitted during the quiet period,
     * it is guaranteed to be accepted and the quiet period will start over.
     * 
     * @param quietPeriod the quiet period as described in the documentation
     * @param timeout     the maximum amount of time to wait until the executor is {@linkplain #shutdown()}
     *                    regardless if a task was submitted during the quiet period
     * @param unit        the unit of {@code quietPeriod} and {@code timeout}
     * @param handler - Handler for the result of this call.
     */
    void shutdown(long quietPeriod, long timeout, TimeUnit unit, Handler<AsyncResult<Void>> handler);
    
    /**
     * Returns {@code true} if this Redisson instance has been shut down.
     *
     * @param handler - Handler for the result of this call.
     */
    void isShutdown(Handler<AsyncResult<Boolean>> handler);

    /**
     * Returns {@code true} if this Redisson instance was started to be shutdown
     * or was shutdown {@link #isShutdown()} already.
     *
     * or was shutdown {@link #isShutdown()} already.
     * @param handler - Handler for the result of this call.
     */
    void isShuttingDown(Handler<AsyncResult<Boolean>> handler);

}
