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

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
import org.redisson.api.GeoEntry;
import org.redisson.api.GeoPosition;
import org.redisson.api.GeoUnit;
import org.redisson.vertx.api.RedissonGeo;

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
    public void testAddList1() throws Exception {
        JsonObject city1 = new JsonObject(Json.encode(new GeoEntry(3.11, 9.10321, "city1")));
        JsonObject city2 = new JsonObject(Json.encode(new GeoEntry(81.1231, 38.65478, "city2")));
        redisson.<String>getGeo("myGeo").add(new JsonArray().add(city1).add(city2), onSuccess(r -> {
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
    public void testAddEntry1() throws Exception {
        redisson.<String>getGeo("myGeo").addEntry(new JsonObject(Json.encode(new GeoEntry(3.11, 9.10321, "city1"))), onSuccess(r -> {
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

    @Test
    public void testDistEmpty() {
        RedissonGeo<String> geo = redisson.<String>getGeo("test");
        geo.dist("Palermo", "Catania", GeoUnit.METERS, onSuccess(r -> {
            assertNull(r);
            testComplete();
        }));
        await();
    }

    @Test
    public void testHash() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("Palermo", "sqc8b49rny0");
        expected.put("Catania", "sqdtr74hyu0");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.hash(Arrays.asList("Palermo","Catania"), onSuccess(s -> {
                assertTrue(s.containsKey("Palermo"));
                assertEquals(expected.get("Palermo"), s.get("Palermo"));
                assertTrue(s.containsKey("Catania"));
                assertEquals(expected.get("Catania"), s.get("Catania"));
                testComplete();
            }));
        }));
        await();
    }

    @Test
    public void testHash1() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("Palermo", "sqc8b49rny0");
        expected.put("Catania", "sqdtr74hyu0");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.hash(new JsonArray().add("Palermo").add("Catania"), onSuccess(s -> {
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertEquals(expected.get("Palermo"), s.getJsonObject(0).getString("hash"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertEquals(expected.get("Catania"), s.getJsonObject(1).getString("hash"));
                testComplete();
            }));
        }));
        await();
    }

    @Test
    public void testHashEmpty() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.hash(new JsonArray().add("Palermo").add("Catania"), onSuccess(r -> {
            assertEquals(0, r.size());
            testComplete();
        }));
        await();
    }

    @Test
    public void testPos() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        Map<String, GeoPosition> expected = new LinkedHashMap<>();
        expected.put("Palermo", new GeoPosition(13.361389338970184, 38.115556395496299));
        expected.put("Catania", new GeoPosition(15.087267458438873, 37.50266842333162));
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.pos(Arrays.asList("test2", "Palermo", "test3", "Catania", "test1"), onSuccess(s -> {
                assertTrue(s.containsKey("Palermo"));
                assertTrue(expected.get("Palermo").getLongitude() == s.get("Palermo").getLongitude());
                assertTrue(expected.get("Palermo").getLatitude() == s.get("Palermo").getLatitude());
                assertTrue(s.containsKey("Catania"));
                assertTrue(expected.get("Catania").getLongitude() == s.get("Catania").getLongitude());
                assertTrue(expected.get("Catania").getLatitude() == s.get("Catania").getLatitude());
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testPos1() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        Map<String, GeoPosition> expected = new LinkedHashMap<>();
        expected.put("Palermo", new GeoPosition(13.361389338970184, 38.115556395496299));
        expected.put("Catania", new GeoPosition(15.087267458438873, 37.50266842333162));
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.pos(new JsonArray().add("test2").add("Palermo").add("test3").add("Catania").add("test1"), onSuccess(s -> {
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(expected.get("Palermo").getLongitude() == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(expected.get("Palermo").getLatitude()== s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(expected.get("Catania").getLongitude() == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(expected.get("Catania").getLatitude()== s.getJsonObject(1).getJsonObject("geoPosition").getDouble("latitude"));
                testComplete();
            }));
        }));
        await();
    }
}
