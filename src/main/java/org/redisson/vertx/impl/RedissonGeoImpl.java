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
package org.redisson.vertx.impl;

import org.redisson.vertx.utils.AsyncResultWrapper;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.List;
import java.util.Map;
import org.redisson.api.GeoOrder;
import org.redisson.api.GeoPosition;
import org.redisson.api.GeoUnit;
import org.redisson.api.RGeoAsync;
import org.redisson.api.GeoEntry;
import org.redisson.vertx.api.RedissonGeo;
import org.redisson.vertx.utils.ObjectTransformers;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 * @param <V>
 */
public class RedissonGeoImpl<V> implements RedissonGeo<V> {

    private final RGeoAsync<V> delegate;

    public RedissonGeoImpl(RGeoAsync<V> rGeo) {
        this.delegate = rGeo;
    }

    @Override
    public RedissonGeo<V> add(double longitude, double latitude, V member, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.addAsync(longitude, latitude, member));
        return this;
    }

    @Override
    public RedissonGeo<V> addEntry(GeoEntry entry, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.addAsync(entry));
        return this;
    }

    @Override
    public RedissonGeo<V> addEntry(JsonObject entry, Handler<AsyncResult<Long>> handler) {
        return add(new JsonArray().add(entry), handler);
    }

    @Override
    public RedissonGeo<V> add(List<GeoEntry> entries, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.addAsync(entries.toArray(new GeoEntry[0])));
        return this;
    }

    @Override
    public RedissonGeo<V> add(JsonArray entries, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.addAsync(ObjectTransformers.jsonArrayToGeoEntryArray.apply(entries)));
        return this;
    }

    @Override
    public RedissonGeo<V> dist(V firstMember, V secondMember, GeoUnit geoUnit, Handler<AsyncResult<Double>> handler) {
        AsyncResultWrapper
                .<Double>wrap(handler)
                .handle(delegate.distAsync(firstMember, secondMember, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<V> hash(List<V> members, Handler<AsyncResult<Map<V, String>>> handler) {
        AsyncResultWrapper
                .<Map<V, String>>wrap(handler)
                .handle(delegate.hashAsync((V[]) members.toArray()));
        return this;
    }

    @Override
    public RedissonGeo<V> hash(JsonArray members, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoHashTransformer)
                .handle(delegate.hashAsync((V[]) members.getList().toArray()));
        return this;
    }

    @Override
    public RedissonGeo<V> pos(List<V> members, Handler<AsyncResult<Map<V, GeoPosition>>> handler) {
        AsyncResultWrapper
                .<Map<V, GeoPosition>>wrap(handler)
                .handle(delegate.posAsync((V[]) members.toArray()));
        return this;
    }

    @Override
    public RedissonGeo<V> pos(JsonArray members, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.posAsync((V[]) members.getList().toArray()));
        return this;
    }

    @Override
    public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(longitude, latitude, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(longitude, latitude, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(longitude, latitude, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<V> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(longitude, latitude, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(longitude, latitude, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(longitude, latitude, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(longitude, latitude, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(longitude, latitude, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(longitude, latitude, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(longitude, latitude, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(longitude, latitude, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(longitude, latitude, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(member, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(member, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(member, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<V> radius(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(member, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(member, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(member, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(member, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithDistance(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(member, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(member, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(member, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(member, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<V> radiusWithPosition(V member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(ObjectTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(member, radius, geoUnit, geoOrder, count));
        return this;
    }

}
