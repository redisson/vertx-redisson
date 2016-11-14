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

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import java.util.List;
import org.redisson.api.RKeysAsync;
import org.redisson.api.RType;
import org.redisson.vertx.impl.RedissonKeysImpl;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@VertxGen
public interface RedissonKeys {
    
    @GenIgnore
    static <V> RedissonKeys create(RKeysAsync redissonKeys) {
        return new RedissonKeysImpl(redissonKeys);
    }
    
    /**
     * Get Redis object type by key. Returns the type of the key.
     * 
     * @param key - name of key
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys getType(String key, Handler<AsyncResult<RType>> handler);
    
    /**
     * Get hash slot identifier for key in async mode. Returns the slot number.
     * Available for cluster nodes only
     *
     * @param key - name of key
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys getSlot(String key, Handler<AsyncResult<Integer>> handler);

    /**
     * Get random key in async mode, returns random key
     *
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys randomKey(Handler<AsyncResult<String>> handler);

    /**
     * Find keys by key search pattern in async mode. Returns a list of keys
     *
     *  Supported glob-style patterns:
     *    h?llo subscribes to hello, hallo and hxllo
     *    h*llo subscribes to hllo and heeeello
     *    h[ae]llo subscribes to hello and hallo, but not hillo
     *
     * @param pattern - match pattern
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys findKeysByPattern(String pattern, Handler<AsyncResult<List<String>>> handler);

    /**
     * Delete multiple objects by a key pattern. Returns number of removed keys
     * <p>
     * Method executes in <b>NON atomic way</b> in cluster mode due to lua script limitations.
     * <p>
     *  Supported glob-style patterns:
     *    h?llo subscribes to hello, hallo and hxllo
     *    h*llo subscribes to hllo and heeeello
     *    h[ae]llo subscribes to hello and hallo, but not hillo
     *
     * @param pattern - match pattern
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys deleteByPattern(String pattern, Handler<AsyncResult<Long>> handler);

    /**
     * Delete object by name, returns true if key is deleted.
     *
     * @param key - object name
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys delete(String key, Handler<AsyncResult<Boolean>> handler);
    
    /**
     * Delete multiple objects by name, returns number of removed keys
     *
     * @param keys - object names
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys deleteList(List<String> keys, Handler<AsyncResult<Long>> handler);

    /**
     * Returns the number of keys in the currently-selected database in async mode
     *
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys count(Handler<AsyncResult<Long>> handler);

    /**
     * Delete all keys of currently selected database
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys flushdb(Handler<AsyncResult<Void>> handler);

    /**
     * Delete all keys of all existing databases
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonKeys flushall(Handler<AsyncResult<Void>> handler);

}
