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

package org.redisson.groovy.vertx.api;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import java.util.List
import org.redisson.api.RType
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
*/
@CompileStatic
public class RedissonKeys {
  private final def org.redisson.vertx.api.RedissonKeys delegate;
  public RedissonKeys(Object delegate) {
    this.delegate = (org.redisson.vertx.api.RedissonKeys) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Get Redis object type by key. Returns the type of the key.
   * @param key - name of key
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys getType(String key, Handler<AsyncResult<RType>> handler) {
    delegate.getType(key, handler);
    return this;
  }
  /**
   * Get hash slot identifier for key in async mode. Returns the slot number.
   * Available for cluster nodes only
   * @param key - name of key
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys getSlot(String key, Handler<AsyncResult<Integer>> handler) {
    delegate.getSlot(key, handler);
    return this;
  }
  /**
   * Get random key in async mode, returns random key
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys randomKey(Handler<AsyncResult<String>> handler) {
    delegate.randomKey(handler);
    return this;
  }
  /**
   * Find keys by key search pattern in async mode. Returns a list of keys
   *
   *  Supported glob-style patterns:
   *    h?llo subscribes to hello, hallo and hxllo
   *    h*llo subscribes to hllo and heeeello
   *    h[ae]llo subscribes to hello and hallo, but not hillo
   * @param pattern - match pattern
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys findKeysByPattern(String pattern, Handler<AsyncResult<List<String>>> handler) {
    delegate.findKeysByPattern(pattern, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Delete multiple objects by a key pattern. Returns number of removed keys
   * <p>
   * Method executes in <b>NON atomic way</b> in cluster mode due to lua script limitations.
   * <p>
   *  Supported glob-style patterns:
   *    h?llo subscribes to hello, hallo and hxllo
   *    h*llo subscribes to hllo and heeeello
   *    h[ae]llo subscribes to hello and hallo, but not hillo
   * @param pattern - match pattern
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys deleteByPattern(String pattern, Handler<AsyncResult<Long>> handler) {
    delegate.deleteByPattern(pattern, handler);
    return this;
  }
  /**
   * Delete object by name, returns true if key is deleted.
   * @param key - object name
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys delete(String key, Handler<AsyncResult<Boolean>> handler) {
    delegate.delete(key, handler);
    return this;
  }
  /**
   * Delete multiple objects by name, returns number of removed keys
   * @param keys - object names
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys deleteList(List<String> keys, Handler<AsyncResult<Long>> handler) {
    delegate.deleteList(keys != null ? (List)keys.collect({it}) : null, handler);
    return this;
  }
  /**
   * Returns the number of keys in the currently-selected database in async mode
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys count(Handler<AsyncResult<Long>> handler) {
    delegate.count(handler);
    return this;
  }
  /**
   * Delete all keys of currently selected database
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys flushdb(Handler<AsyncResult<Void>> handler) {
    delegate.flushdb(handler);
    return this;
  }
  /**
   * Delete all keys of all existing databases
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonKeys flushall(Handler<AsyncResult<Void>> handler) {
    delegate.flushall(handler);
    return this;
  }
}
