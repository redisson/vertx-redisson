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
package org.redisson.vertx.api;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.redisson.api.GeoOrder;
import org.redisson.api.GeoUnit;
import org.redisson.api.RGeoAsync;
import org.redisson.vertx.impl.RedissonGeoImpl;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 * @param <V> type of value
 */
@VertxGen
public interface RedissonGeo<V> {
    
    @GenIgnore
    static <V> RedissonGeo<V> create(RGeoAsync redissonGeo) {
        return new RedissonGeoImpl<>(redissonGeo);
    }
    
    /**
     * Adds geospatial member and gives back the number of elements added to the
     * sorted set, not including elements already existing for which 
     * the score was updated.
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param member - object itself
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> add(double longitude, double latitude, V member, Handler<AsyncResult<Long>> handler);
    
    /**
     * Adds geospatial member and gives back the number of elements added to the
     * sorted set, not including elements already existing for which 
     * the score was updated.
     * 
     * @param entry - GeoEntry object
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> addEntry(GeoEntry entry, Handler<AsyncResult<Long>> handler);

    /**
     * Adds geospatial member and gives back the number of elements added to the
     * sorted set, not including elements already existing for which 
     * the score was updated.
     * 
     * @param entries - list of GeoEntry objects
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> add(List<GeoEntry> entries, Handler<AsyncResult<Long>> handler);
    
    /**
     * Returns distance between members in <code>GeoUnit</code> units.
     * 
     * @param firstMember - first object
     * @param secondMember - second object
     * @param geoUnit - geo unit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> dist(V firstMember, V secondMember, GeoUnit geoUnit, Handler<AsyncResult<Double>> handler);
    
    /**
     * Returns 11 characters Geohash string mapped by defined member in a form
     * of a JsonArray.
     * 
     * @param members - objects
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> hash(JsonArray members, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns geo-position mapped by defined member in a form of a JsonArray.
     * 
     * @param members - objects
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> pos(JsonArray members, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the members of a sorted set in a form of a JsonArray, which are
     * within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units.
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the members of a sorted set in a form of a JsonArray, which are
     * within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units and limited by count
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the members of a sorted set in a form of a JsonArray, which are
     * within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - order of result
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the members of a sorted set in a form of a JsonArray, which are
     * within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * and limited by count
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - order of result
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler);
 
    /**
     * Returns the distance mapped by member, distance between member and the location. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units.
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the distance mapped by member, distance between member and the location. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units and limited by count.
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the distance mapped by member, distance between member and the location. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - order of result
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the distance mapped by member, distance between member and the location. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * and limited by count
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - order of result
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the geo-position mapped by member. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units.
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the geo-position mapped by member. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units and limited by count
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the geo-position mapped by member. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - geo order
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the geo-position mapped by member. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the center location 
     * and the maximum distance from the center (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * and limited by count
     * 
     * @param longitude - longitude of object
     * @param latitude - latitude of object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - geo order
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the members of a sorted set in a form of a JsonArray, which are
     * within the borders of the area specified with the defined member location
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units.
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the members of a sorted set in a form of a JsonArray, which are
     * within the borders of the area specified with the defined member location
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units and limited by count
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the members of a sorted set in a form of a JsonArray, which are
     * within the borders of the area specified with the defined member location
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - geo order
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the members of a sorted set in a form of a JsonArray, which are
     * within the borders of the area specified with the defined member location
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - geo order
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the distance mapped by member, distance between member and the defined member location. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the defined member location 
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units.
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the distance mapped by member, distance between member and the defined member location. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the defined member location 
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units and limited by count
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the distance mapped by member, distance between member and the defined member location. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the defined member location 
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - geo
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the distance mapped by member, distance between member and the defined member location. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the defined member location 
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * and limited by count
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - geo
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler);
    
    /**
     * Returns the geo-position mapped by member. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the defined member location 
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units.
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the geo-position mapped by member. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the defined member location 
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units and limited by count
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the geo-position mapped by member. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the defined member location 
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - geo order
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler);

    /**
     * Returns the geo-position mapped by member. 
     * Members of a sorted set in a form of a JsonArray of JsonObjects, which
     * are within the borders of the area specified with the defined member location 
     * and the maximum distance from the defined member location (the radius) 
     * in <code>GeoUnit</code> units with <code>GeoOrder</code>
     * and limited by count
     * 
     * @param member - object
     * @param radius - radius in geo units
     * @param geoUnit - geo unit
     * @param geoOrder - geo order
     * @param count - result limit
     * @param handler - Handler for the result of this call.
     * @return this
     */
    @Fluent
    RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler);
    
}
