/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.redisson.rxjava.vertx.api;

import java.util.Map;
import rx.Observable;
import java.util.concurrent.TimeUnit;
import io.vertx.rxjava.core.Vertx;
import org.redisson.vertx.config.Config;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link org.redisson.vertx.api.Redisson original} non RX-ified interface using Vert.x codegen.
 */

public class Redisson {

  final org.redisson.vertx.api.Redisson delegate;

  public Redisson(org.redisson.vertx.api.Redisson delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public static Redisson create(Vertx vertx, Config config) { 
    Redisson ret = Redisson.newInstance(org.redisson.vertx.api.Redisson.create((io.vertx.core.Vertx)vertx.getDelegate(), config));
    return ret;
  }

  /**
   * Returns geospatial items holder instance by <code>name</code>.
   * @param name - name of object
   * @return Geo object
   */
  public <V> RedissonGeo<V> getGeo(String name) { 
    RedissonGeo<V> ret = RedissonGeo.newInstance(delegate.getGeo(name));
    return ret;
  }

  /**
   * Returns interface with methods for Redis keys.
   * Each of Redis/Redisson object associated with own key
   * @return RedissonKeys object
   */
  public RedissonKeys getKeys() { 
    RedissonKeys ret = RedissonKeys.newInstance(delegate.getKeys());
    return ret;
  }

  /**
   * Shutdown Redisson instance but <b>NOT</b> Redis server
   * 
   * This equates to invoke shutdown(2, 15, TimeUnit.SECONDS);
   * @param handler - Handler for the result of this call.
   */
  public void shutdown(Handler<AsyncResult<Void>> handler) { 
    delegate.shutdown(handler);
  }

  /**
   * Shutdown Redisson instance but <b>NOT</b> Redis server
   * 
   * This equates to invoke shutdown(2, 15, TimeUnit.SECONDS);
   * @return 
   */
  public Observable<Void> shutdownObservable() { 
    io.vertx.rx.java.ObservableFuture<Void> handler = io.vertx.rx.java.RxHelper.observableFuture();
    shutdown(handler.toHandler());
    return handler;
  }

  /**
   * Shuts down Redisson instance <b>NOT</b> Redis server
   * 
   * Shutdown ensures that no tasks are submitted for <i>'the quiet period'</i>
   * (usually a couple seconds) before it shuts itself down.  If a task is submitted during the quiet period,
   * it is guaranteed to be accepted and the quiet period will start over.
   * @param quietPeriod the quiet period as described in the documentation
   * @param timeout the maximum amount of time to wait until the executor is  regardless if a task was submitted during the quiet period
   * @param unit the unit of <code>quietPeriod</code> and <code>timeout</code>
   * @param handler - Handler for the result of this call.
   */
  public void shutdown(long quietPeriod, long timeout, TimeUnit unit, Handler<AsyncResult<Void>> handler) { 
    delegate.shutdown(quietPeriod, timeout, unit, handler);
  }

  /**
   * Shuts down Redisson instance <b>NOT</b> Redis server
   * 
   * Shutdown ensures that no tasks are submitted for <i>'the quiet period'</i>
   * (usually a couple seconds) before it shuts itself down.  If a task is submitted during the quiet period,
   * it is guaranteed to be accepted and the quiet period will start over.
   * @param quietPeriod the quiet period as described in the documentation
   * @param timeout the maximum amount of time to wait until the executor is  regardless if a task was submitted during the quiet period
   * @param unit the unit of <code>quietPeriod</code> and <code>timeout</code>
   * @return 
   */
  public Observable<Void> shutdownObservable(long quietPeriod, long timeout, TimeUnit unit) { 
    io.vertx.rx.java.ObservableFuture<Void> handler = io.vertx.rx.java.RxHelper.observableFuture();
    shutdown(quietPeriod, timeout, unit, handler.toHandler());
    return handler;
  }

  /**
   * Returns <code>true</code> if this Redisson instance has been shut down.
   * @param handler - Handler for the result of this call.
   */
  public void isShutdown(Handler<AsyncResult<Boolean>> handler) { 
    delegate.isShutdown(handler);
  }

  /**
   * Returns <code>true</code> if this Redisson instance has been shut down.
   * @return 
   */
  public Observable<Boolean> isShutdownObservable() { 
    io.vertx.rx.java.ObservableFuture<Boolean> handler = io.vertx.rx.java.RxHelper.observableFuture();
    isShutdown(handler.toHandler());
    return handler;
  }

  /**
   * Returns <code>true</code> if this Redisson instance was started to be shutdown
   * or was shutdown  already.
   *
   * or was shutdown  already.
   * @param handler - Handler for the result of this call.
   */
  public void isShuttingDown(Handler<AsyncResult<Boolean>> handler) { 
    delegate.isShuttingDown(handler);
  }

  /**
   * Returns <code>true</code> if this Redisson instance was started to be shutdown
   * or was shutdown  already.
   *
   * or was shutdown  already.
   * @return 
   */
  public Observable<Boolean> isShuttingDownObservable() { 
    io.vertx.rx.java.ObservableFuture<Boolean> handler = io.vertx.rx.java.RxHelper.observableFuture();
    isShuttingDown(handler.toHandler());
    return handler;
  }


  public static Redisson newInstance(org.redisson.vertx.api.Redisson arg) {
    return arg != null ? new Redisson(arg) : null;
  }
}
