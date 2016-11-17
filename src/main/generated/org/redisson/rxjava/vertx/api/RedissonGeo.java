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
import io.vertx.core.json.JsonArray;
import org.redisson.api.GeoUnit;
import io.vertx.core.json.JsonObject;
import org.redisson.api.GeoOrder;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link org.redisson.vertx.api.RedissonGeo original} non RX-ified interface using Vert.x codegen.
 */

public class RedissonGeo<V> {

  final org.redisson.vertx.api.RedissonGeo delegate;

  public RedissonGeo(org.redisson.vertx.api.RedissonGeo delegate) {
    this.delegate = delegate;
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
    delegate.add(longitude, latitude, member, handler);
    return this;
  }

  /**
   * Adds geospatial member and gives back the number of elements added to the
   * sorted set, not including elements already existing for which 
   * the score was updated.
   * @param longitude - longitude of object
   * @param latitude - latitude of object
   * @param member - object itself
   * @return 
   */
  public Observable<Long> addObservable(double longitude, double latitude, V member) { 
    io.vertx.rx.java.ObservableFuture<Long> handler = io.vertx.rx.java.RxHelper.observableFuture();
    add(longitude, latitude, member, handler.toHandler());
    return handler;
  }

  /**
   * Adds geospatial member and gives back the number of elements added to the
   * sorted set, not including elements already existing for which 
   * the score was updated.
   * 
   * JsonObject format: 
   * {
   *      longitude: double,
   *      latitude: double,
   *      member: Object
   * }
   * @param entry - JsonObject object.
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> addEntry(JsonObject entry, Handler<AsyncResult<Long>> handler) { 
    delegate.addEntry(entry, handler);
    return this;
  }

  /**
   * Adds geospatial member and gives back the number of elements added to the
   * sorted set, not including elements already existing for which 
   * the score was updated.
   * 
   * JsonObject format: 
   * {
   *      longitude: double,
   *      latitude: double,
   *      member: Object
   * }
   * @param entry - JsonObject object.
   * @return 
   */
  public Observable<Long> addEntryObservable(JsonObject entry) { 
    io.vertx.rx.java.ObservableFuture<Long> handler = io.vertx.rx.java.RxHelper.observableFuture();
    addEntry(entry, handler.toHandler());
    return handler;
  }

  /**
   * Adds geospatial member and gives back the number of elements added to the
   * sorted set, not including elements already existing for which 
   * the score was updated.
   * 
   * JsonArray format: 
   * [{
   *      longitude: double,
   *      latitude: double,
   *      member: Object
   * }, 
   * ...
   * ]
   * @param entries - JsonArray object
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> add(JsonArray entries, Handler<AsyncResult<Long>> handler) { 
    delegate.add(entries, handler);
    return this;
  }

  /**
   * Adds geospatial member and gives back the number of elements added to the
   * sorted set, not including elements already existing for which 
   * the score was updated.
   * 
   * JsonArray format: 
   * [{
   *      longitude: double,
   *      latitude: double,
   *      member: Object
   * }, 
   * ...
   * ]
   * @param entries - JsonArray object
   * @return 
   */
  public Observable<Long> addObservable(JsonArray entries) { 
    io.vertx.rx.java.ObservableFuture<Long> handler = io.vertx.rx.java.RxHelper.observableFuture();
    add(entries, handler.toHandler());
    return handler;
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
    delegate.dist(firstMember, secondMember, geoUnit, handler);
    return this;
  }

  /**
   * Returns distance between members in <code>GeoUnit</code> units.
   * @param firstMember - first object
   * @param secondMember - second object
   * @param geoUnit - geo unit
   * @return 
   */
  public Observable<Double> distObservable(V firstMember, V secondMember, GeoUnit geoUnit) { 
    io.vertx.rx.java.ObservableFuture<Double> handler = io.vertx.rx.java.RxHelper.observableFuture();
    dist(firstMember, secondMember, geoUnit, handler.toHandler());
    return handler;
  }

  /**
   * Returns 11 characters Geohash string mapped by defined member in a form
   * of a JsonArray.
   * 
   * Result JsonArray format:
   * [{
   *    member: Object,
   *    hash: String
   * },
   * ...
   * ]
   * @param members - objects
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> hash(JsonArray members, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.hash(members, handler);
    return this;
  }

  /**
   * Returns 11 characters Geohash string mapped by defined member in a form
   * of a JsonArray.
   * 
   * Result JsonArray format:
   * [{
   *    member: Object,
   *    hash: String
   * },
   * ...
   * ]
   * @param members - objects
   * @return 
   */
  public Observable<JsonArray> hashObservable(JsonArray members) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    hash(members, handler.toHandler());
    return handler;
  }

  /**
   * Returns geo-position mapped by defined member in a form of a JsonArray.
   * @param members - objects
   * @param handler - Handler for the result of this call.
   * @return this
   */
  public RedissonGeo<V> pos(JsonArray members, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.pos(members, handler);
    return this;
  }

  /**
   * Returns geo-position mapped by defined member in a form of a JsonArray.
   * @param members - objects
   * @return 
   */
  public Observable<JsonArray> posObservable(JsonArray members) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    pos(members, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radius(longitude, latitude, radius, geoUnit, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusObservable(double longitude, double latitude, double radius, GeoUnit geoUnit) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radius(longitude, latitude, radius, geoUnit, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radius(longitude, latitude, radius, geoUnit, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radius(longitude, latitude, radius, geoUnit, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radius(longitude, latitude, radius, geoUnit, geoOrder, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radius(longitude, latitude, radius, geoUnit, geoOrder, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radius(longitude, latitude, radius, geoUnit, geoOrder, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radius(longitude, latitude, radius, geoUnit, geoOrder, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithDistance(longitude, latitude, radius, geoUnit, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithDistanceObservable(double longitude, double latitude, double radius, GeoUnit geoUnit) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithDistance(longitude, latitude, radius, geoUnit, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithDistance(longitude, latitude, radius, geoUnit, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithDistanceObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithDistance(longitude, latitude, radius, geoUnit, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithDistance(longitude, latitude, radius, geoUnit, geoOrder, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithDistanceObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithDistance(longitude, latitude, radius, geoUnit, geoOrder, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithDistance(longitude, latitude, radius, geoUnit, geoOrder, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithDistanceObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithDistance(longitude, latitude, radius, geoUnit, geoOrder, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithPosition(longitude, latitude, radius, geoUnit, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithPositionObservable(double longitude, double latitude, double radius, GeoUnit geoUnit) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithPosition(longitude, latitude, radius, geoUnit, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithPosition(longitude, latitude, radius, geoUnit, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithPositionObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithPosition(longitude, latitude, radius, geoUnit, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithPosition(longitude, latitude, radius, geoUnit, geoOrder, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithPositionObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithPosition(longitude, latitude, radius, geoUnit, geoOrder, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithPosition(longitude, latitude, radius, geoUnit, geoOrder, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithPositionObservable(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithPosition(longitude, latitude, radius, geoUnit, geoOrder, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radius(member, radius, geoUnit, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusObservable(V member, double radius, GeoUnit geoUnit) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radius(member, radius, geoUnit, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radius(member, radius, geoUnit, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusObservable(V member, double radius, GeoUnit geoUnit, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radius(member, radius, geoUnit, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radius(member, radius, geoUnit, geoOrder, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusObservable(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radius(member, radius, geoUnit, geoOrder, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radius(member, radius, geoUnit, geoOrder, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusObservable(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radius(member, radius, geoUnit, geoOrder, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithDistance(member, radius, geoUnit, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithDistanceObservable(V member, double radius, GeoUnit geoUnit) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithDistance(member, radius, geoUnit, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithDistance(member, radius, geoUnit, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithDistanceObservable(V member, double radius, GeoUnit geoUnit, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithDistance(member, radius, geoUnit, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithDistance(member, radius, geoUnit, geoOrder, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithDistanceObservable(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithDistance(member, radius, geoUnit, geoOrder, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithDistance(member, radius, geoUnit, geoOrder, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithDistanceObservable(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithDistance(member, radius, geoUnit, geoOrder, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithPosition(member, radius, geoUnit, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithPositionObservable(V member, double radius, GeoUnit geoUnit) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithPosition(member, radius, geoUnit, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithPosition(member, radius, geoUnit, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithPositionObservable(V member, double radius, GeoUnit geoUnit, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithPosition(member, radius, geoUnit, count, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithPosition(member, radius, geoUnit, geoOrder, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithPositionObservable(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithPosition(member, radius, geoUnit, geoOrder, handler.toHandler());
    return handler;
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
  public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) { 
    delegate.radiusWithPosition(member, radius, geoUnit, geoOrder, count, handler);
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
   * @return 
   */
  public Observable<JsonArray> radiusWithPositionObservable(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count) { 
    io.vertx.rx.java.ObservableFuture<JsonArray> handler = io.vertx.rx.java.RxHelper.observableFuture();
    radiusWithPosition(member, radius, geoUnit, geoOrder, count, handler.toHandler());
    return handler;
  }


  public static <V> RedissonGeo newInstance(org.redisson.vertx.api.RedissonGeo arg) {
    return arg != null ? new RedissonGeo<V> (arg) : null;
  }
}
