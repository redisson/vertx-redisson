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

/** @module vertx-redisson-js/redisson_geo */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JRedissonGeo = org.redisson.vertx.api.RedissonGeo;
var GeoEntry = org.redisson.vertx.api.GeoEntry;

/**

 @class
*/
var RedissonGeo = function(j_val) {

  var j_redissonGeo = j_val;
  var that = this;

  /**
   Adds geospatial member and gives back the number of elements added to the
   sorted set, not including elements already existing for which 
   the score was updated.

   @public
   @param longitude {number} - longitude of object 
   @param latitude {number} - latitude of object 
   @param member {Object} - object itself 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonGeo} this
   */
  this.add = function() {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'object' && __args[0] instanceof Array && typeof __args[1] === 'function') {
      j_redissonGeo["add(java.util.List,io.vertx.core.Handler)"](utils.convParamListDataObject(__args[0], function(json) { return new GeoEntry(json); }), function(ar) {
      if (ar.succeeded()) {
        __args[1](utils.convReturnLong(ar.result()), null);
      } else {
        __args[1](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 4 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] !== 'function' && typeof __args[3] === 'function') {
      j_redissonGeo["add(double,double,java.lang.Object,io.vertx.core.Handler)"](__args[0], __args[1], utils.convParamTypeUnknown(__args[2]), function(ar) {
      if (ar.succeeded()) {
        __args[3](utils.convReturnLong(ar.result()), null);
      } else {
        __args[3](null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Adds geospatial member and gives back the number of elements added to the
   sorted set, not including elements already existing for which 
   the score was updated.

   @public
   @param entry {Object} - GeoEntry object 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonGeo} this
   */
  this.addEntry = function(entry, handler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_redissonGeo["addEntry(org.redisson.vertx.api.GeoEntry,io.vertx.core.Handler)"](entry != null ? new GeoEntry(new JsonObject(JSON.stringify(entry))) : null, function(ar) {
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
   Returns distance between members in <code>GeoUnit</code> units.

   @public
   @param firstMember {Object} - first object 
   @param secondMember {Object} - second object 
   @param geoUnit {Object} - geo unit 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonGeo} this
   */
  this.dist = function(firstMember, secondMember, geoUnit, handler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] !== 'function' && typeof __args[1] !== 'function' && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_redissonGeo["dist(java.lang.Object,java.lang.Object,org.redisson.api.GeoUnit,io.vertx.core.Handler)"](utils.convParamTypeUnknown(firstMember), utils.convParamTypeUnknown(secondMember), org.redisson.api.GeoUnit.valueOf(geoUnit), function(ar) {
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
   Returns 11 characters Geohash string mapped by defined member in a form
   of a JsonArray.

   @public
   @param members {todo} - objects 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonGeo} this
   */
  this.hash = function(members, handler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'object' && __args[0] instanceof Array && typeof __args[1] === 'function') {
      j_redissonGeo["hash(io.vertx.core.json.JsonArray,io.vertx.core.Handler)"](utils.convParamJsonArray(members), function(ar) {
      if (ar.succeeded()) {
        handler(utils.convReturnJson(ar.result()), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Returns geo-position mapped by defined member in a form of a JsonArray.

   @public
   @param members {todo} - objects 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonGeo} this
   */
  this.pos = function(members, handler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'object' && __args[0] instanceof Array && typeof __args[1] === 'function') {
      j_redissonGeo["pos(io.vertx.core.json.JsonArray,io.vertx.core.Handler)"](utils.convParamJsonArray(members), function(ar) {
      if (ar.succeeded()) {
        handler(utils.convReturnJson(ar.result()), null);
      } else {
        handler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Returns the members of a sorted set in a form of a JsonArray, which are
   within the borders of the area specified with the center location 
   and the maximum distance from the center (the radius) 
   in <code>GeoUnit</code> units with <code>GeoOrder</code>
   and limited by count

   @public
   @param longitude {number} - longitude of object 
   @param latitude {number} - latitude of object 
   @param radius {number} - radius in geo units 
   @param geoUnit {Object} - geo unit 
   @param geoOrder {Object} - order of result 
   @param count {number} - result limit 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonGeo} this
   */
  this.radius = function() {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_redissonGeo["radius(java.lang.Object,double,org.redisson.api.GeoUnit,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), function(ar) {
      if (ar.succeeded()) {
        __args[3](utils.convReturnJson(ar.result()), null);
      } else {
        __args[3](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'function') {
      j_redissonGeo["radius(double,double,double,org.redisson.api.GeoUnit,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] ==='number' && typeof __args[4] === 'function') {
      j_redissonGeo["radius(java.lang.Object,double,org.redisson.api.GeoUnit,int,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), __args[3], function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'string' && typeof __args[4] === 'function') {
      j_redissonGeo["radius(java.lang.Object,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), org.redisson.api.GeoOrder.valueOf(__args[3]), function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] ==='number' && typeof __args[5] === 'function') {
      j_redissonGeo["radius(double,double,double,org.redisson.api.GeoUnit,int,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), __args[4], function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'string' && typeof __args[5] === 'function') {
      j_redissonGeo["radius(double,double,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), org.redisson.api.GeoOrder.valueOf(__args[4]), function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'string' && typeof __args[4] ==='number' && typeof __args[5] === 'function') {
      j_redissonGeo["radius(java.lang.Object,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,int,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), org.redisson.api.GeoOrder.valueOf(__args[3]), __args[4], function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 7 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'string' && typeof __args[5] ==='number' && typeof __args[6] === 'function') {
      j_redissonGeo["radius(double,double,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,int,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), org.redisson.api.GeoOrder.valueOf(__args[4]), __args[5], function(ar) {
      if (ar.succeeded()) {
        __args[6](utils.convReturnJson(ar.result()), null);
      } else {
        __args[6](null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Returns the distance mapped by member, distance between member and the location. 
   Members of a sorted set in a form of a JsonArray of JsonObjects, which
   are within the borders of the area specified with the center location 
   and the maximum distance from the center (the radius) 
   in <code>GeoUnit</code> units with <code>GeoOrder</code>
   and limited by count

   @public
   @param longitude {number} - longitude of object 
   @param latitude {number} - latitude of object 
   @param radius {number} - radius in geo units 
   @param geoUnit {Object} - geo unit 
   @param geoOrder {Object} - order of result 
   @param count {number} - result limit 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonGeo} this
   */
  this.radiusWithDistance = function() {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_redissonGeo["radiusWithDistance(java.lang.Object,double,org.redisson.api.GeoUnit,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), function(ar) {
      if (ar.succeeded()) {
        __args[3](utils.convReturnJson(ar.result()), null);
      } else {
        __args[3](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'function') {
      j_redissonGeo["radiusWithDistance(double,double,double,org.redisson.api.GeoUnit,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] ==='number' && typeof __args[4] === 'function') {
      j_redissonGeo["radiusWithDistance(java.lang.Object,double,org.redisson.api.GeoUnit,int,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), __args[3], function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'string' && typeof __args[4] === 'function') {
      j_redissonGeo["radiusWithDistance(java.lang.Object,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), org.redisson.api.GeoOrder.valueOf(__args[3]), function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] ==='number' && typeof __args[5] === 'function') {
      j_redissonGeo["radiusWithDistance(double,double,double,org.redisson.api.GeoUnit,int,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), __args[4], function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'string' && typeof __args[5] === 'function') {
      j_redissonGeo["radiusWithDistance(double,double,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), org.redisson.api.GeoOrder.valueOf(__args[4]), function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'string' && typeof __args[4] ==='number' && typeof __args[5] === 'function') {
      j_redissonGeo["radiusWithDistance(java.lang.Object,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,int,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), org.redisson.api.GeoOrder.valueOf(__args[3]), __args[4], function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 7 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'string' && typeof __args[5] ==='number' && typeof __args[6] === 'function') {
      j_redissonGeo["radiusWithDistance(double,double,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,int,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), org.redisson.api.GeoOrder.valueOf(__args[4]), __args[5], function(ar) {
      if (ar.succeeded()) {
        __args[6](utils.convReturnJson(ar.result()), null);
      } else {
        __args[6](null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Returns the geo-position mapped by member. 
   Members of a sorted set in a form of a JsonArray of JsonObjects, which
   are within the borders of the area specified with the center location 
   and the maximum distance from the center (the radius) 
   in <code>GeoUnit</code> units with <code>GeoOrder</code>
   and limited by count

   @public
   @param longitude {number} - longitude of object 
   @param latitude {number} - latitude of object 
   @param radius {number} - radius in geo units 
   @param geoUnit {Object} - geo unit 
   @param geoOrder {Object} - geo order 
   @param count {number} - result limit 
   @param handler {function} - Handler for the result of this call. 
   @return {RedissonGeo} this
   */
  this.radiusWithPosition = function() {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_redissonGeo["radiusWithPosition(java.lang.Object,double,org.redisson.api.GeoUnit,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), function(ar) {
      if (ar.succeeded()) {
        __args[3](utils.convReturnJson(ar.result()), null);
      } else {
        __args[3](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'function') {
      j_redissonGeo["radiusWithPosition(double,double,double,org.redisson.api.GeoUnit,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] ==='number' && typeof __args[4] === 'function') {
      j_redissonGeo["radiusWithPosition(java.lang.Object,double,org.redisson.api.GeoUnit,int,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), __args[3], function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 5 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'string' && typeof __args[4] === 'function') {
      j_redissonGeo["radiusWithPosition(java.lang.Object,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), org.redisson.api.GeoOrder.valueOf(__args[3]), function(ar) {
      if (ar.succeeded()) {
        __args[4](utils.convReturnJson(ar.result()), null);
      } else {
        __args[4](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] ==='number' && typeof __args[5] === 'function') {
      j_redissonGeo["radiusWithPosition(double,double,double,org.redisson.api.GeoUnit,int,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), __args[4], function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'string' && typeof __args[5] === 'function') {
      j_redissonGeo["radiusWithPosition(double,double,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), org.redisson.api.GeoOrder.valueOf(__args[4]), function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 6 && typeof __args[0] !== 'function' && typeof __args[1] ==='number' && typeof __args[2] === 'string' && typeof __args[3] === 'string' && typeof __args[4] ==='number' && typeof __args[5] === 'function') {
      j_redissonGeo["radiusWithPosition(java.lang.Object,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,int,io.vertx.core.Handler)"](utils.convParamTypeUnknown(__args[0]), __args[1], org.redisson.api.GeoUnit.valueOf(__args[2]), org.redisson.api.GeoOrder.valueOf(__args[3]), __args[4], function(ar) {
      if (ar.succeeded()) {
        __args[5](utils.convReturnJson(ar.result()), null);
      } else {
        __args[5](null, ar.cause());
      }
    });
      return that;
    }  else if (__args.length === 7 && typeof __args[0] ==='number' && typeof __args[1] ==='number' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && typeof __args[4] === 'string' && typeof __args[5] ==='number' && typeof __args[6] === 'function') {
      j_redissonGeo["radiusWithPosition(double,double,double,org.redisson.api.GeoUnit,org.redisson.api.GeoOrder,int,io.vertx.core.Handler)"](__args[0], __args[1], __args[2], org.redisson.api.GeoUnit.valueOf(__args[3]), org.redisson.api.GeoOrder.valueOf(__args[4]), __args[5], function(ar) {
      if (ar.succeeded()) {
        __args[6](utils.convReturnJson(ar.result()), null);
      } else {
        __args[6](null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_redissonGeo;
};

// We export the Constructor function
module.exports = RedissonGeo;