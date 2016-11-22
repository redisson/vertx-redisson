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
/* global module */

'use strict';
var RedissonGeoTest = {
    "_requireVersion": "3.1.0",
    "add": function (context, redisson, async) {
        redisson.getGeo("test").add(13.361389, 38.115556, "Sicily", function (r) {
            context.assertEquals(1, r);
            async.complete();
        })
    },
    "addEntry": function (context, redisson, async) {
        redisson.getGeo("test").addEntry(
                {"longitude": 3.11, "latitude": 9.10321, "member": "city1"}, function (r) {
            context.assertEquals(1, r);
            async.complete();
        });
    },
    "addList": function (context, redisson, async) {
        redisson.getGeo("test").add([
            {"longitude": 3.11, "latitude": 9.10321, "member": "city1"},
            {"longitude": 81.1231, "latitude": 38.65478, "member": "city2"}
        ], function (r) {
            context.assertEquals(2, r);
            async.complete();
        });
    },
    "dist": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        geo.add([
            {"longitude": 13.361389, "latitude": 38.115556, "member": "Palermo"},
            {"longitude": 15.087269, "latitude": 37.502669, "member": "Catania"}
        ], function (r) {
            geo.dist("Palermo", "Catania", "METERS", function (s) {
                context.assertEquals(166274.1516, s);
                async.complete();
            });
        });
    },
    "distEmpty": function (context, redisson, async) {
        redisson.getGeo("test").dist("Palermo", "Catania", "METERS", function (r) {
            context.assertNull(r);
            async.complete();
        });
    },
    "hash": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        var expected = {};
        expected["Palermo"] = "sqc8b49rny0";
        expected["Catania"] = "sqdtr74hyu0";
        geo.add([
            {"longitude": 13.361389, "latitude": 38.115556, "member": "Palermo"},
            {"longitude": 15.087269, "latitude": 37.502669, "member": "Catania"}
        ], function (r) {
            geo.hash(["Palermo", "Catania"], function (s) {
                context.assertEquals("Palermo", s[0]["member"]);
                context.assertEquals(expected["Palermo"], s[0]["hash"]);
                context.assertEquals("Catania", s[1]["member"]);
                context.assertEquals(expected["Catania"], s[1]["hash"]);
                async.complete();
            });
        });
    },
    "hashEmpty": function (context, redisson, async) {
        redisson.getGeo("test").hash(["Palermo", "Catania"], function (r) {
            context.assertEquals(0, r.length);
            async.complete();
        });
    },
    "pos": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        var palermo = {
            "longitude": 13.361389338970184,
            "latitude": 38.115556395496299,
            "member": "Palermo"
        },
        catania = {
            "longitude": 15.087267458438873,
            "latitude": 37.50266842333162,
            "member": "Catania"
        };
        geo.add([palermo, catania], function (r) {
            geo.pos(["test2", "Palermo", "test3", "Catania", "test1"], function (s) {
                context.assertEquals(palermo.member, s[0].member);
                context.assertEquals(palermo.longitude, s[0].longitude);
                context.assertEquals(palermo.latitude, s[0].latitude);
                context.assertEquals(catania.member, s[1].member);
                context.assertTrue(catania.longitude, s[1].longitude);
                context.assertTrue(catania.latitude, s[1].latitude);
                async.complete();
            });
        });
    }
};
module.exports = RedissonGeoTest;
