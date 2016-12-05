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

package org.redisson.groovy.misc;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
/**
*/
@CompileStatic
public class RedisLogger {
  private final def org.redisson.misc.RedisLogger delegate;
  public RedisLogger(Object delegate) {
    this.delegate = (org.redisson.misc.RedisLogger) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public void log(String s) {
    delegate.log(s);
  }
}
