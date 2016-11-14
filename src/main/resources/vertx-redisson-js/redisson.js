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

/** @module vertx-redisson-js/redisson */
var utils = require('vertx-js/util/utils');
var RedissonKeys = require('vertx-redisson-js/redisson_keys');
var RedissonGeo = require('vertx-redisson-js/redisson_geo');
var Vertx = require('vertx-js/vertx');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JRedisson = org.redisson.vertx.api.Redisson;
var Config = org.redisson.vertx.config.Config;

/**

 @class
*/
var Redisson = function(j_val) {

  var j_redisson = j_val;
  var that = this;

  /**
   Returns geospatial items holder instance by <code>name</code>.

   @public
   @param name {string} - name of object 
   @return {RedissonGeo} Geo object
   */
  this.getGeo = function(name) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      return utils.convReturnVertxGen(j_redisson["getGeo(java.lang.String)"](name), RedissonGeo);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Returns interface with methods for Redis keys.
   Each of Redis/Redisson object associated with own key

   @public

   @return {RedissonKeys} RedissonKeys object
   */
  this.getKeys = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnVertxGen(j_redisson["getKeys()"](), RedissonKeys);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Shuts down Redisson instance <b>NOT</b> Redis server
   
   Shutdown ensures that no tasks are submitted for <i>'the quiet period'</i>
   (usually a couple seconds) before it shuts itself down.  If a task is submitted during the quiet period,
   it is guaranteed to be accepted and the quiet period will start over.

   @public
   @param quietPeriod {number} the quiet period as described in the documentation 
   @param timeout {number} the maximum amount of time to wait until the executor is  regardless if a task was submitted during the quiet period 
   @param unit {Object} the unit of <code>quietPeriod</code> and <code>timeout</code> 
   @param handler {function} - Handler for the result of this call. 
   */
  this.shutdown = function() {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_redisson["shutdown(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        __args[0](null, null);
      } else {
        __args[0](null, ar.cause());
      }
    });
    }  else if (__args.length === 4 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_redisson["shutdown(long,long,java.util.concurrent.TimeUnit,io.vertx.core.Handler)"](__args[0], __args[1], java.util.concurrent.TimeUnit.valueOf(__args[2]), function(ar) {
      if (ar.succeeded()) {
        __args[3](null, null);
      } else {
        __args[3](null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Returns <code>true</code> if this Redisson instance has been shut down.

   @public
   @param handler {function} - Handler for the result of this call. 
   */
  this.isShutdown = function(handler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_redisson["isShutdown(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        handler(ar.result(), null);
      } else {
        handler(null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Returns <code>true</code> if this Redisson instance was started to be shutdown
   or was shutdown  already.
  
   or was shutdown  already.

   @public
   @param handler {function} - Handler for the result of this call. 
   */
  this.isShuttingDown = function(handler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_redisson["isShuttingDown(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        handler(ar.result(), null);
      } else {
        handler(null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_redisson;
};

/**

 @memberof module:vertx-redisson-js/redisson
 @param vertx {Vertx} 
 @param config {Object} 
 @return {Redisson}
 */
Redisson.create = function(vertx, config) {
  var __args = arguments;
  if (__args.length === 2 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null)) {
    return utils.convReturnVertxGen(JRedisson["create(io.vertx.core.Vertx,org.redisson.vertx.config.Config)"](vertx._jdel, config != null ? new Config(new JsonObject(JSON.stringify(config))) : null), Redisson);
  } else throw new TypeError('function invoked with invalid arguments');
};

// We export the Constructor function
module.exports = Redisson;