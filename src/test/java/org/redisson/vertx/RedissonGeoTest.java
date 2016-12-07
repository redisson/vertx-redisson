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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.redisson.api.GeoEntry;
import org.redisson.api.GeoOrder;
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
            geo.hash(Arrays.asList("Palermo", "Catania"), onSuccess(s -> {
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
                assertTrue(expected.get("Palermo").getLatitude() == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(expected.get("Catania").getLongitude() == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(expected.get("Catania").getLatitude() == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("latitude"));
                testComplete();
            }));
        }));
        await();
    }

    @Test
    public void testPosEmpty() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.pos(Arrays.asList("test2", "Palermo", "test3", "Catania", "test1"), onSuccess(r -> {
            assertEquals(0, r.size());
            testComplete();
        }));
        await();
    }

    @Test
    public void testRadius() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radius(15, 37, 200, GeoUnit.KILOMETERS, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getString(0));
                assertEquals("Catania", s.getString(1));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radius(15, 37, 200, GeoUnit.KILOMETERS, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getString(0));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusOrder() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radius(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.DESC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getString(0));
                assertEquals("Catania", s.getString(1));
                l.countDown();
            }));
            geo.radius(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.ASC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Catania", s.getString(0));
                assertEquals("Palermo", s.getString(1));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusOrderCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radius(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.DESC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getString(0));
                l.countDown();
            }));
            geo.radius(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.ASC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getString(0));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusEmpty() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.radius(15, 37, 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(0, r.size());
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusWithDistance() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(190.4424 == s.getJsonObject(0).getDouble("distance"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(56.4413 == s.getJsonObject(1).getDouble("distance"));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusWithDistanceCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(56.4413 == s.getJsonObject(0).getDouble("distance"));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusWithDistanceOrder() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.DESC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(190.4424 == s.getJsonObject(0).getDouble("distance"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(56.4413 == s.getJsonObject(1).getDouble("distance"));
                l.countDown();
            }));
            geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.ASC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(56.4413 == s.getJsonObject(0).getDouble("distance"));
                assertEquals("Palermo", s.getJsonObject(1).getString("member"));
                assertTrue(190.4424 == s.getJsonObject(1).getDouble("distance"));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusWithDistanceOrderCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.DESC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(190.4424 == s.getJsonObject(0).getDouble("distance"));
                l.countDown();
            }));
            geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.ASC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(56.4413 == s.getJsonObject(0).getDouble("distance"));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusWithDistanceHugeAmount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        int counts = 10000;
        CountDownLatch l = new CountDownLatch(counts);
        for (int i = 0; i < counts; i++) {
            geo.add(10 + 0.000001*i, 11 + 0.000001*i, "" + i, onSuccess(r -> l.countDown()));
        }
        try {
            l.await(5, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            fail(ex);
        }
        geo.radiusWithDistance(10, 11, 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(counts, r.size());
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusWithPositionHugeAmount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        int counts = 10000;
        CountDownLatch l = new CountDownLatch(counts);
        for (int i = 0; i < counts; i++) {
            geo.add(10 + 0.000001*i, 11 + 0.000001*i, "" + i, onSuccess(r -> l.countDown()));
        }
        try {
            l.await(5, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            fail(ex);
        }
        geo.radiusWithPosition(10, 11, 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(counts, r.size());
            testComplete();
        }));
        await();
    }

    @Test
    public void testRadiusWithDistanceBigObject() {
        RedissonGeo<String> geo = redisson.getGeo("test");

        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 150; i++) {
            map.put("" + i, "" + i);
        }
        CountDownLatch l = new CountDownLatch(3);
        geo.addEntry(new GeoEntry(13.361389, 38.115556, map), onSuccess(r -> l.countDown()));
        
        Map<String, String> map1 = new HashMap<String, String>(map);
        map1.remove("100");
        geo.addEntry(new GeoEntry(15.087269, 37.502669, map1), onSuccess(r -> l.countDown()));
        
        Map<String, String> map2 = new HashMap<String, String>(map);
        map2.remove("0");
        geo.addEntry(new GeoEntry(15.081269, 37.502169, map2), onSuccess(r -> l.countDown()));
        try {
            l.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            fail(ex);
        }
        
        geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(3, r.size());
            assertEquals(Json.encode(map), r.getJsonObject(0).getJsonObject("member").encode());
            assertTrue(190.4424 == r.getJsonObject(0).getDouble("distance"));
            assertEquals(Json.encode(map1), r.getJsonObject(2).getJsonObject("member").encode());
            assertTrue(56.4413 == r.getJsonObject(2).getDouble("distance"));
            assertEquals(Json.encode(map2), r.getJsonObject(1).getJsonObject("member").encode());
            assertTrue(56.3159 == r.getJsonObject(1).getDouble("distance"));
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusWithDistanceEmpty() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(0, r.size());
            testComplete();
        }));
        await();
    }

    @Test
    public void testRadiusWithPosition() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("latitude"));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusWithPositionCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusWithPositionOrder() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.DESC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("latitude"));
                l.countDown();
            }));
            geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.ASC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                assertEquals("Palermo", s.getJsonObject(1).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("latitude"));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusWithPositionOrderCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.DESC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                l.countDown();
            }));
            geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS, GeoOrder.ASC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }

    @Test
    public void testRadiusWithPositionEmpty() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(0, r.size());
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusMember() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radius("Palermo", 200, GeoUnit.KILOMETERS, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getString(0));
                assertEquals("Catania", s.getString(1));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusMemberCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radius("Palermo", 200, GeoUnit.KILOMETERS, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getString(0));
                testComplete();
            }));
        }));
        await();
    }

    @Test
    public void testRadiusMemberOrder() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radius("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.DESC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Catania", s.getString(0));
                assertEquals("Palermo", s.getString(1));
                l.countDown();
            }));
            geo.radius("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.ASC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getString(0));
                assertEquals("Catania", s.getString(1));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusMemberOrderCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radius("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.DESC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getString(0));
                l.countDown();
            }));
            geo.radius("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.ASC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getString(0));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }

    @Test
    public void testRadiusMemberEmpty() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.radius("Palermo", 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(0, r.size());
            testComplete();
        }));
        await();
    }

    @Test
    public void testRadiusMemberWithDistance() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radiusWithDistance("Palermo", 200, GeoUnit.KILOMETERS, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(0.0 == s.getJsonObject(0).getDouble("distance"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(166.2742 == s.getJsonObject(1).getDouble("distance"));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusMemberWithDistanceCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radiusWithDistance("Palermo", 200, GeoUnit.KILOMETERS, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(0.0 == s.getJsonObject(0).getDouble("distance"));
                testComplete();
            }));
        }));
        await();
    }

    @Test
    public void testRadiusMemberWithDistanceOrder() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radiusWithDistance("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.DESC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(166.2742 == s.getJsonObject(0).getDouble("distance"));
                assertEquals("Palermo", s.getJsonObject(1).getString("member"));
                assertTrue(0.0 == s.getJsonObject(1).getDouble("distance"));
                l.countDown();
            }));
            geo.radiusWithDistance("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.ASC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(0.0 == s.getJsonObject(0).getDouble("distance"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(166.2742 == s.getJsonObject(1).getDouble("distance"));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusMemberWithDistanceOrderCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radiusWithDistance("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.DESC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(166.2742 == s.getJsonObject(0).getDouble("distance"));
                l.countDown();
            }));
            geo.radiusWithDistance("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.ASC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(0.0 == s.getJsonObject(0).getDouble("distance"));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusMemberWithDistanceEmpty() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.radiusWithDistance("Palermo", 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(0, r.size());
            testComplete();
        }));
        await();
    }

    @Test
    public void testRadiusMemberWithPosition() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radiusWithPosition("Palermo", 200, GeoUnit.KILOMETERS, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("latitude"));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusMemberWithPositionCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            geo.radiusWithPosition("Palermo", 200, GeoUnit.KILOMETERS, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                testComplete();
            }));
        }));
        await();
    }
    
    @Test
    public void testRadiusMemberWithPositionOrder() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radiusWithPosition("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.DESC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                assertEquals("Palermo", s.getJsonObject(1).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("latitude"));
                l.countDown();
            }));
            geo.radiusWithPosition("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.ASC, onSuccess(s -> {
                assertEquals(2, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                assertEquals("Catania", s.getJsonObject(1).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(1).getJsonObject("geoPosition").getDouble("latitude"));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }

    @Test
    public void testRadiusMemberWithPositionOrderCount() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.add(Arrays.asList(new GeoEntry(13.361389, 38.115556, "Palermo"), new GeoEntry(15.087269, 37.502669, "Catania")), onSuccess(r -> {
            CountDownLatch l = new CountDownLatch(2);
            geo.radiusWithPosition("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.DESC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Catania", s.getJsonObject(0).getString("member"));
                assertTrue(15.087267458438873 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(37.50266842333162 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                l.countDown();
            }));
            geo.radiusWithPosition("Palermo", 200, GeoUnit.KILOMETERS, GeoOrder.ASC, 1, onSuccess(s -> {
                assertEquals(1, s.size());
                assertEquals("Palermo", s.getJsonObject(0).getString("member"));
                assertTrue(13.361389338970184 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("longitude"));
                assertTrue(38.115556395496299 == s.getJsonObject(0).getJsonObject("geoPosition").getDouble("latitude"));
                l.countDown();
            }));
            try {
                l.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                fail(ex);
            }
            testComplete();
        }));
        await();
    }
    
    @Test
    public void testRadiusMemberWithPositionEmpty() {
        RedissonGeo<String> geo = redisson.getGeo("test");
        geo.radiusWithPosition("Palermo", 200, GeoUnit.KILOMETERS, onSuccess(r -> {
            assertEquals(0, r.size());
            testComplete();
        }));
        await();
    }
}
