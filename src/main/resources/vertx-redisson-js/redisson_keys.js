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

/** @module vertx-redisson-js/redisson_keys */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JRedissonKeys = org.redisson.vertx.api.RedissonKeys;

/**

 @class
*/
var RedissonKeys = function(j_val) {

  var j_redissonKeys = j_val;
  var that = this;

  /**
   Get Redis object type by key. Returns the type of the key.

   @public
   @param key {string} - name of key 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.getType = function(key, handler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_redissonKeys["getType(java.lang.String,io.vertx.core.Handler)"](key, function(ar) {
      if (ar.succeeded()) {
        handler(utils.convReturnEnum(ar.result()), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Get hash slot identifier for key in async mode. Returns the slot number.
   Available for cluster nodes only

   @public
   @param key {string} - name of key 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.getSlot = function(key, handler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_redissonKeys["getSlot(java.lang.String,io.vertx.core.Handler)"](key, function(ar) {
      if (ar.succeeded()) {
        handler(ar.result(), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Get random key in async mode, returns random key

   @public
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.randomKey = function(handler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_redissonKeys["randomKey(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        handler(ar.result(), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Find keys by key search pattern in async mode. Returns a list of keys
  
    Supported glob-style patterns:
      h?llo subscribes to hello, hallo and hxllo
      h*llo subscribes to hllo and heeeello
      h[ae]llo subscribes to hello and hallo, but not hillo

   @public
   @param pattern {string} - match pattern 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.findKeysByPattern = function(pattern, handler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_redissonKeys["findKeysByPattern(java.lang.String,io.vertx.core.Handler)"](pattern, function(ar) {
      if (ar.succeeded()) {
        handler(ar.result(), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Delete multiple objects by a key pattern. Returns number of removed keys
   <p>
   Method executes in <b>NON atomic way</b> in cluster mode due to lua script limitations.
   <p>
    Supported glob-style patterns:
      h?llo subscribes to hello, hallo and hxllo
      h*llo subscribes to hllo and heeeello
      h[ae]llo subscribes to hello and hallo, but not hillo

   @public
   @param pattern {string} - match pattern 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.deleteByPattern = function(pattern, handler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_redissonKeys["deleteByPattern(java.lang.String,io.vertx.core.Handler)"](pattern, function(ar) {
      if (ar.succeeded()) {
        handler(utils.convReturnLong(ar.result()), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Delete object by name, returns true if key is deleted.

   @public
   @param key {string} - object name 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.delete = function(key, handler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_redissonKeys["delete(java.lang.String,io.vertx.core.Handler)"](key, function(ar) {
      if (ar.succeeded()) {
        handler(ar.result(), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Delete multiple objects by name, returns number of removed keys

   @public
   @param keys {Array.<string>} - object names 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.deleteList = function(keys, handler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'object' && __args[0] instanceof Array && typeof __args[1] === 'function') {
      j_redissonKeys["deleteList(java.util.List,io.vertx.core.Handler)"](utils.convParamListBasicOther(keys), function(ar) {
      if (ar.succeeded()) {
        handler(utils.convReturnLong(ar.result()), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Returns the number of keys in the currently-selected database in async mode

   @public
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.count = function(handler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_redissonKeys["count(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        handler(utils.convReturnLong(ar.result()), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Delete all keys of currently selected database

   @public
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.flushdb = function(handler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_redissonKeys["flushdb(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        handler(null, null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Delete all keys of all existing databases

   @public
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonKeys} this
   */
  this.flushall = function(handler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_redissonKeys["flushall(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        handler(null, null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_redissonKeys;
};

// We export the Constructor function
module.exports = RedissonKeys;