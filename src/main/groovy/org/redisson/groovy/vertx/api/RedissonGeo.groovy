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
import io.vertx.core.json.JsonArray
import java.util.List
import org.redisson.api.GeoUnit
import org.redisson.api.GeoOrder
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import org.redisson.vertx.api.GeoEntry
/**
*/
@CompileStatic
public class RedissonGeo<V> {
  private final def org.redisson.vertx.api.RedissonGeo delegate;
  public RedissonGeo(Object delegate) {
    this.delegate = (org.redisson.vertx.api.RedissonGeo) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Adds geospatial member and gives back the number of elements added to the
   * sorted set, not including elements already existing for which 
   * the score was updated.
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param member - object itself
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> add(double longitude, double latitude, V member, Handler<AsyncResult<Long>> handler) {
    delegate.add(longitude, latitude, member != null ? InternalHelper.unwrapObject(member) : null, handler);
    return this;
  }
  /**
   * Adds geospatial member and gives back the number of elements added to the
   * sorted set, not including elements already existing for which 
   * the score was updated.
   * @param entry - GeoEntry object (see <a href="../../../../../../../cheatsheet/GeoEntry.html">GeoEntry</a>)
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> addEntry(Map<String, Object> entry = [:], Handler<AsyncResult<Long>> handler) {
    delegate.addEntry(entry != null ? new org.redisson.vertx.api.GeoEntry(io.vertx.lang.groovy.InternalHelper.toJsonObject(entry)) : null, handler);
    return this;
  }
  /**
   * Adds geospatial member and gives back the number of elements added to the
   * sorted set, not including elements already existing for which 
   * the score was updated.
   * @param entries - list of GeoEntry objects
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> add(List<Map<String, Object>> entries, Handler<AsyncResult<Long>> handler) {
    delegate.add(entries != null ? (List)entries.collect({new org.redisson.vertx.api.GeoEntry(io.vertx.lang.groovy.InternalHelper.toJsonObject(it))}) : null, handler);
    return this;
  }
  /**
   * Returns distance between members in <code>GeoUnit</code> units.
   * @param firstMember - first object
   * @param secondMember - second object
   * @param geoUnit - geo unit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> dist(V firstMember, V secondMember, GeoUnit geoUnit, Handler<AsyncResult<Double>> handler) {
    delegate.dist(firstMember != null ? InternalHelper.unwrapObject(firstMember) : null, secondMember != null ? InternalHelper.unwrapObject(secondMember) : null, geoUnit, handler);
    return this;
  }
  /**
   * Returns 11 characters Geohash string mapped by defined member in a form
   * of a JsonArray.
   * @param members - objects
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> hash(List<Object> members, Handler<AsyncResult<List<Object>>> handler) {
    delegate.hash(members != null ? new io.vertx.core.json.JsonArray(members) : null, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns geo-position mapped by defined member in a form of a JsonArray.
   * @param members - objects
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> pos(List<Object> members, Handler<AsyncResult<List<Object>>> handler) {
    delegate.pos(members != null ? new io.vertx.core.json.JsonArray(members) : null, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the members of a sorted set in a form of a JsonArray, which are
   * within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units.
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radius(longitude, latitude, radius, geoUnit, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the members of a sorted set in a form of a JsonArray, which are
   * within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units and limited by count
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radius(longitude, latitude, radius, geoUnit, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the members of a sorted set in a form of a JsonArray, which are
   * within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - order of result
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radius(longitude, latitude, radius, geoUnit, geoOrder, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the members of a sorted set in a form of a JsonArray, which are
   * within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * and limited by count
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - order of result
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radius(longitude, latitude, radius, geoUnit, geoOrder, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the distance mapped by member, distance between member and the location. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units.
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithDistance(longitude, latitude, radius, geoUnit, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the distance mapped by member, distance between member and the location. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units and limited by count.
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithDistance(longitude, latitude, radius, geoUnit, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the distance mapped by member, distance between member and the location. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - order of result
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithDistance(longitude, latitude, radius, geoUnit, geoOrder, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the distance mapped by member, distance between member and the location. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * and limited by count
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - order of result
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithDistance(longitude, latitude, radius, geoUnit, geoOrder, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the geo-position mapped by member. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units.
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithPosition(longitude, latitude, radius, geoUnit, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the geo-position mapped by member. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units and limited by count
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithPosition(longitude, latitude, radius, geoUnit, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the geo-position mapped by member. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - geo order
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithPosition(longitude, latitude, radius, geoUnit, geoOrder, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the geo-position mapped by member. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the center location 
   * and the maximum distance from the center (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * and limited by count
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - geo order
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithPosition(longitude, latitude, radius, geoUnit, geoOrder, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the members of a sorted set in a form of a JsonArray, which are
   * within the borders of the area specified with the defined member location
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units.
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radius(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the members of a sorted set in a form of a JsonArray, which are
   * within the borders of the area specified with the defined member location
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units and limited by count
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radius(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the members of a sorted set in a form of a JsonArray, which are
   * within the borders of the area specified with the defined member location
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - geo order
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radius(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, geoOrder, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the members of a sorted set in a form of a JsonArray, which are
   * within the borders of the area specified with the defined member location
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - geo order
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radius(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, geoOrder, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the distance mapped by member, distance between member and the defined member location. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the defined member location 
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units.
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithDistance(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the distance mapped by member, distance between member and the defined member location. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the defined member location 
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units and limited by count
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithDistance(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the distance mapped by member, distance between member and the defined member location. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the defined member location 
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - geo
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithDistance(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, geoOrder, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the distance mapped by member, distance between member and the defined member location. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the defined member location 
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * and limited by count
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - geo
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithDistance(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, geoOrder, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the geo-position mapped by member. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the defined member location 
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units.
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithPosition(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the geo-position mapped by member. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the defined member location 
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units and limited by count
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithPosition(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the geo-position mapped by member. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the defined member location 
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - geo order
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithPosition(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, geoOrder, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Returns the geo-position mapped by member. 
   * Members of a sorted set in a form of a JsonArray of JsonObjects, which
   * are within the borders of the area specified with the defined member location 
   * and the maximum distance from the defined member location (the radius) 
   * in <code>GeoUnit</code> units with <code>GeoOrder</code>
   * and limited by count
   * @param member - object
   * @param radius - radius in geo units
   * @param geoUnit - geo unit
   * @param geoOrder - geo order
   * @param count - result limit
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<List<Object>>> handler) {
    delegate.radiusWithPosition(member != null ? InternalHelper.unwrapObject(member) : null, radius, geoUnit, geoOrder, count, handler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonArray>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonArray> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture((List<Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
}
