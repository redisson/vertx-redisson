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
package org.redisson.vertx;

import org.redisson.vertx.api.GeoEntry;
import org.redisson.vertx.api.RedissonGeo;
import java.util.Arrays;
import org.junit.Test;
import org.redisson.api.GeoUnit;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
public class RedissonGeoTest extends RedissonTestBase {

    @Override
    protected String requiredRedisVersion() {
        return "3.1.0";
    }

    @Test
    public void testAdd() throws Exception {
        redisson.<String>getGeo("myGeo").add(13.361389, 38.115556, "Sicily", onSuccess(r -> {
            assertEquals(1l, r.longValue());
            testComplete();
        }));
        await();
    }

    @Test
    public void testAddList() throws Exception {
        redisson.<String>getGeo("myGeo").add(Arrays.asList(new GeoEntry(3.11, 9.10321, "city1"), new GeoEntry(81.1231, 38.65478, "city2")), onSuccess(r -> {
            assertEquals(2l, r.longValue());
            testComplete();
        }));
        await();
    }

    @Test
    public void testAddEntry() throws Exception {
        redisson.<String>getGeo("myGeo").addEntry(new GeoEntry(3.11, 9.10321, "city1"), onSuccess(r -> {
            assertEquals(1l, r.longValue());
            testComplete();
        }));
        await();
    }

    @Test
    public void testDist() {
        RedissonGeo<String> geo = redisson.<String>getGeo("myGeo");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.dist("Palermo", "Catania", GeoUnit.METERS, onSuccess(s -> {
                assertTrue(166274.1516D == s);
                testComplete();
            }));
        }));
        await();
    }

}
