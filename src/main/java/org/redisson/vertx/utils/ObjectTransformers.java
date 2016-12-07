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
package org.redisson.vertx.utils;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.redisson.api.GeoPosition;
import org.redisson.api.GeoEntry;

public class ObjectTransformers {

    public static final Function noTransform = r -> r;

    public static final Function collectionToJsonArray = r -> {
        JsonArray j = new JsonArray();
        j.getList().addAll((Collection) r);
        return j;
    };

    public static final Function mapValueToJsonArray = r -> {
        final JsonArray j = new JsonArray();
        j.getList().addAll(((Map) r).values());
        return j;
    };

    public static final Function geoHashTransformer
            = mapToJsonObjectArray("member", "hash");

    public static final Function geoRadiusWithDistanceTransformer
            = mapToJsonObjectArray("member", "distance");

    public static final Function geoPositionTransformer
            = mapToJsonObjectArray("member", "geoPosition", noTransform,
                    r -> new JsonObject()
                    .put("longitude", ((GeoPosition) r).getLongitude())
                    .put("latitude", ((GeoPosition) r).getLatitude()));

    public static final Function<JsonArray, GeoEntry[]> jsonArrayToGeoEntryArray
            = jsonArrayToArray(r -> new GeoEntry(r.getDouble("longitude"),
                            r.getDouble("latitude"),
                            r.getValue("member")),
                    r -> new GeoEntry[r]);

    public static Function mapToJsonObjectArray(String keyName,
            String valueName) {
        return mapToJsonObjectArray(keyName, valueName,
                noTransform, noTransform);
    }

    public static Function mapToJsonObjectArray(String keyName,
            String valueName, Function keyTransformer,
            Function valueTransformer) {
        return r -> {
            Map map = (Map) r;
            Stream<Map.Entry> stream = map.entrySet().stream();
            List list = stream.map(
                    (Map.Entry e) -> new JsonObject()
                    .put(keyName, keyTransformer.apply(e.getKey()))
                    .put(valueName, valueTransformer.apply(e.getValue()))
            ).collect(Collectors.toList());
            return new JsonArray(list);
        };
    }

    public static <T> Function<JsonArray, T[]> jsonArrayToArray(
            Function<JsonObject, T> elementTransformer,
            IntFunction<T[]> arraySupplier) {
        return r -> {
            Stream stream = r.getList().stream().map(m -> m instanceof JsonObject
                    ? elementTransformer.apply((JsonObject) m)
                    : m instanceof Map
                            ? elementTransformer.apply(new JsonObject((Map) m))
                            : m);
            return (T[]) stream.toArray(arraySupplier);
        };
    }

}
