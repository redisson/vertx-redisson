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
package org.redisson.vertx.utils;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import java.util.function.Function;
import org.redisson.api.RFuture;
import static org.redisson.vertx.utils.AsyncResultTransformers.noTransform;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 * @param <T>
 */
public class AsyncResultWrapper<T> {

    private final Handler<AsyncResult<T>> handler;

    private AsyncResultWrapper(Handler<AsyncResult<T>> handler) {
        this.handler = handler;
    }

    public static <T> AsyncResultWrapper wrap(Handler<AsyncResult<T>> handler) {
        return new AsyncResultWrapper<>(handler);
    }

    public AsyncResultWrapper.Transformed transform(Function transformer) {
        return new Transformed(transformer);
    }

    public void handle(RFuture<T> future) {
        new Transformed(noTransform).handle(future);
    }

    public class Transformed {

        private final Function transformer;

        private Transformed(Function transformer) {
            this.transformer = transformer;
        }

        public void handle(final RFuture<T> future) {
            io.vertx.core.Future<T> f = io.vertx.core.Future.<T>future().setHandler(handler);
            future.whenComplete((t, e) -> {
                if (future.isSuccess()) {
                    try {
                        f.complete((T) transformer.apply(t));
                    } catch (Exception ex) {
                        f.fail(ex);
                    }
                } else if (future.isCancelled()) {
                    f.fail("future is cancelled");
                } else {
                    f.fail(e);
                }
            });
        }
    }
}
