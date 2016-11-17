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
import io.vertx.core.Handler;
import java.util.List;
import org.redisson.api.RKeysAsync;
import org.redisson.api.RType;
import org.redisson.vertx.api.RedissonKeys;
import org.redisson.vertx.utils.AsyncResultWrapper;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
public class RedissonKeysImpl implements RedissonKeys {

    private final RKeysAsync delegate;

    public RedissonKeysImpl(RKeysAsync rKeys) {
        this.delegate = rKeys;
    }

    @Override
    public RedissonKeys getType(String key, Handler<AsyncResult<RType>> handler) {
        AsyncResultWrapper
                .<RType>wrap(handler)
                .handle(delegate.getTypeAsync(key));
        return this;
    }

    @Override
    public RedissonKeys getSlot(String key, Handler<AsyncResult<Integer>> handler) {
        AsyncResultWrapper
                .<Integer>wrap(handler)
                .handle(delegate.getSlotAsync(key));
        return this;
    }

    @Override
    public RedissonKeys randomKey(Handler<AsyncResult<String>> handler) {
        AsyncResultWrapper
                .<String>wrap(handler)
                .handle(delegate.randomKeyAsync());
        return this;
    }

    @Override
    public RedissonKeys findKeysByPattern(String pattern, Handler<AsyncResult<List<String>>> handler) {
        AsyncResultWrapper
                .<List<String>>wrap(handler)
                .handle(delegate.findKeysByPatternAsync(pattern));
        return this;
    }

    @Override
    public RedissonKeys deleteByPattern(String pattern, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.deleteByPatternAsync(pattern));
        return this;
    }

    @Override
    public RedissonKeys delete(String key, Handler<AsyncResult<Boolean>> handler) {
        AsyncResultWrapper
                .<Boolean>wrap(handler)
                .transform(r -> 1 == (Long) r)
                .handle(delegate.deleteAsync(key));
        return this;
    }

    @Override
    public RedissonKeys deleteList(List<String> keys, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.deleteAsync((String[]) keys.toArray()));
        return this;
    }

    @Override
    public RedissonKeys count(Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.countAsync());
        return this;
    }

    @Override
    public RedissonKeys flushdb(Handler<AsyncResult<Void>> handler) {
        AsyncResultWrapper
                .<Void>wrap(handler)
                .handle(delegate.flushdbAsync());
        return this;
    }

    @Override
    public RedissonKeys flushall(Handler<AsyncResult<Void>> handler) {
        AsyncResultWrapper
                .<Void>wrap(handler)
                .handle(delegate.flushallAsync());
        return this;
    }
}
