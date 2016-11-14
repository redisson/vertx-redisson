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
import java.util.List;
import org.redisson.api.GeoOrder;
import org.redisson.api.GeoUnit;
import org.redisson.api.RGeoAsync;
import org.redisson.vertx.api.GeoEntry;
import org.redisson.vertx.api.RedissonGeo;
import org.redisson.vertx.utils.AsyncResultTransformers;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
public class RedissonGeoImpl<T> implements RedissonGeo<T> {

    private final RGeoAsync<T> delegate;

    public RedissonGeoImpl(RGeoAsync<T> rGeo) {
        this.delegate = rGeo;
    }

    @Override
    public RedissonGeo<T> add(double longitude, double latitude, T member, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.addAsync(longitude, latitude, member));
        return this;
    }

    @Override
    public RedissonGeo<T> addEntry(GeoEntry entry, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.addAsync(entry));
        return this;
    }

    @Override
    public RedissonGeo<T> add(List<GeoEntry> entries, Handler<AsyncResult<Long>> handler) {
        AsyncResultWrapper
                .<Long>wrap(handler)
                .handle(delegate.addAsync(entries.toArray(new GeoEntry[0])));
        return this;
    }

    @Override
    public RedissonGeo<T> dist(T firstMember, T secondMember, GeoUnit geoUnit, Handler<AsyncResult<Double>> handler) {
        AsyncResultWrapper
                .<Double>wrap(handler)
                .handle(delegate.distAsync(firstMember, secondMember, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<T> hash(JsonArray members, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoHashTransformer)
                .handle(delegate.hashAsync((T[]) members.getList().toArray()));
        return this;
    }

    @Override
    public RedissonGeo<T> pos(JsonArray members, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.posAsync((T[]) members.getList().toArray()));
        return this;
    }

    @Override
    public RedissonGeo<T> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(longitude, latitude, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<T> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(longitude, latitude, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(longitude, latitude, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<T> radius(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(longitude, latitude, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(longitude, latitude, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(longitude, latitude, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(longitude, latitude, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithDistance(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(longitude, latitude, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(longitude, latitude, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(longitude, latitude, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(longitude, latitude, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithPosition(double longitude, double latitude, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(longitude, latitude, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radius(T member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(member, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<T> radius(T member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(member, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radius(T member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(member, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<T> radius(T member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.collectionToJsonArray)
                .handle(delegate.radiusAsync(member, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithDistance(T member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(member, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithDistance(T member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(member, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithDistance(T member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(member, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithDistance(T member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoRadiusWithDistanceTransformer)
                .handle(delegate.radiusWithDistanceAsync(member, radius, geoUnit, geoOrder, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithPosition(T member, double radius, GeoUnit geoUnit, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(member, radius, geoUnit));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithPosition(T member, double radius, GeoUnit geoUnit, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(member, radius, geoUnit, count));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithPosition(T member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(member, radius, geoUnit, geoOrder));
        return this;
    }

    @Override
    public RedissonGeo<T> radiusWithPosition(T member, double radius, GeoUnit geoUnit, GeoOrder geoOrder, int count, Handler<AsyncResult<JsonArray>> handler) {
        AsyncResultWrapper
                .<JsonArray>wrap(handler)
                .transform(AsyncResultTransformers.geoPositionTransformer)
                .handle(delegate.radiusWithPositionAsync(member, radius, geoUnit, geoOrder, count));
        return this;
    }

}
