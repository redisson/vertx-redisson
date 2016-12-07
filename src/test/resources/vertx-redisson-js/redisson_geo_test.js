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
            context.assertTrue(1 === r);
            async.complete();
        });
    },
    "addEntry": function (context, redisson, async) {
        redisson.getGeo("test").addEntry(
                {"longitude": 3.11, "latitude": 9.10321, "member": "city1"}, function (r) {
            context.assertTrue(1 === r);
            async.complete();
        });
    },
    "addList": function (context, redisson, async) {
        redisson.getGeo("test").add([
            {"longitude": 3.11, "latitude": 9.10321, "member": "city1"},
            {"longitude": 81.1231, "latitude": 38.65478, "member": "city2"}
        ], function (r) {
            context.assertTrue(2 === r);
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
                context.assertTrue(166274.1516 === s);
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
            context.assertTrue(0 === r.length);
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
                context.assertTrue(palermo.longitude === s[0].geoPosition.longitude);
                context.assertTrue(palermo.latitude === s[0].geoPosition.latitude);
                context.assertEquals(catania.member, s[1].member);
                context.assertTrue(catania.longitude === s[1].geoPosition.longitude);
                context.assertTrue(catania.latitude === s[1].geoPosition.latitude);
                async.complete();
            });
        });
    },
    "posEmpty": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        geo.pos(["test2", "Palermo", "test3", "Catania", "test1"], function (r) {
            context.assertTrue(0 === r.length);
            async.complete();
        });
    },
    "radius": function (context, redisson, async) {
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
            geo.radius(15, 37, 200, 'KILOMETERS', function (s) {
                context.assertTrue(2 === s.length);
                context.assertEquals("Palermo", s[0]);
                context.assertEquals("Catania", s[1]);
                async.complete();
            });
        });
    },
    "radiusCount": function (context, redisson, async) {
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
            geo.radius(15, 37, 200, 'KILOMETERS', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertEquals("Catania", s[0]);
                async.complete();
            });
        });
    },
    "radiusOrder": function (context, redisson, async) {
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
            geo.radius(15, 37, 200, 'KILOMETERS', 'DESC', function (s) {
                context.assertTrue(2 === s.length);
                context.assertEquals("Palermo", s[0]);
                context.assertEquals("Catania", s[1]);
                geo.radius(15, 37, 200, 'KILOMETERS', 'ASC', function (t) {
                    context.assertTrue(2 === t.length);
                    context.assertEquals("Catania", t[0]);
                    context.assertEquals("Palermo", t[1]);
                    async.complete();
                });
            });
        });
    },
    "radiusOrderCount": function (context, redisson, async) {
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
            geo.radius(15, 37, 200, 'KILOMETERS', 'DESC', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertEquals("Palermo", s[0]);
                geo.radius(15, 37, 200, 'KILOMETERS', 'ASC', 1, function (t) {
                    context.assertTrue(1 === t.length);
                    context.assertEquals("Catania", t[0]);
                    async.complete();
                });
            });
        });
    },
    "radiusEmpty": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        geo.radius(15, 37, 200, 'KILOMETERS', function (r) {
            context.assertTrue(0 === r.length);
            async.complete();
        });
    },
    "radiusWithDistance": function (context, redisson, async) {
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
            geo.radiusWithDistance(15, 37, 200, 'KILOMETERS', function (s) {
                context.assertTrue(2 === s.length);
                context.assertEquals("Palermo", s[0].member);
                context.assertTrue(190.4424 === s[0].distance);
                context.assertEquals("Catania", s[1].member);
                context.assertTrue(56.4413 === s[1].distance);
                async.complete();
            });
        });
    },
    "radiusWithDistanceCount": function (context, redisson, async) {
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
            geo.radiusWithDistance(15, 37, 200, 'KILOMETERS', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertEquals("Catania", s[0].member);
                context.assertTrue(56.4413 === s[0].distance);
                async.complete();
            });
        });
    },
    "radiusWithDistanceOrder": function (context, redisson, async) {
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
            geo.radiusWithDistance(15, 37, 200, 'KILOMETERS', 'DESC', function (s) {
                context.assertTrue(2 === s.length);
                context.assertEquals("Palermo", s[0].member);
                context.assertTrue(190.4424 === s[0].distance);
                context.assertEquals("Catania", s[1].member);
                context.assertTrue(56.4413 === s[1].distance);
                geo.radiusWithDistance(15, 37, 200, 'KILOMETERS', 'ASC', function (t) {
                    context.assertTrue(2 === t.length);
                    context.assertEquals("Catania", t[0].member);
                    context.assertTrue(56.4413 === t[0].distance);
                    context.assertEquals("Palermo", t[1].member);
                    context.assertTrue(190.4424 === t[1].distance);
                    async.complete();
                });
            });
        });
    },
    "radiusWithDistanceOrderCount": function (context, redisson, async) {
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
            geo.radiusWithDistance(15, 37, 200, 'KILOMETERS', 'DESC', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertEquals("Palermo", s[0].member);
                context.assertTrue(190.4424 === s[0].distance);
                geo.radiusWithDistance(15, 37, 200, 'KILOMETERS', 'ASC', 1, function (t) {
                    context.assertTrue(1 === t.length);
                    context.assertEquals("Catania", t[0].member);
                    context.assertTrue(56.4413 === t[0].distance);
                    async.complete();
                });
            });
        });
    },
    "radiusWithDistanceHugeAmount": {
        timeout: 10000,
        fn: function (context, redisson, async) {
            var geo = redisson.getGeo("test");
            var counts = 10000, m = 0;
            var iterate = function () {
                m++;
                geo.add(10 + 0.000001 * m, 11 + 0.000001 * m, "" + m, function (r) {
                    if (m === counts) {
                        geo.radiusWithDistance(10, 11, 200, 'KILOMETERS', function (s) {
                            context.assertTrue(counts === s.length);
                            async.complete();
                        });
                    } else {
                        iterate();
                    }
                });
            };
            iterate();
        }
    },
    "radiusWithPositionHugeAmount": {
        timeout: 10000,
        fn: function (context, redisson, async) {
            var geo = redisson.getGeo("test");
            var counts = 10000, m = 0;
            var iterate = function () {
                m++;
                geo.add(10 + 0.000001 * m, 11 + 0.000001 * m, "" + m, function (r) {
                    if (m === counts) {
                        geo.radiusWithPosition(10, 11, 200, 'KILOMETERS', function (s) {
                            context.assertTrue(counts === s.length);
                            async.complete();
                        });
                    } else {
                        iterate();
                    }
                });
            };
            iterate();
        }
    },
    "radiusWithDistanceBigObject": function (context, redisson, async) {
        var geo = redisson.getGeo("test");

        var map = {}, map1 = {}, map2 = {};
        for (var i = 0; i < 150; i++) {
            map["" + i] = "" + i;
            map1["" + i] = "" + i;
            map2["" + i] = "" + i;
        }
        delete map1["100"];
        delete map2["0"];
        geo.addEntry({
            "longitude": 13.361389,
            "latitude": 38.115556,
            "member": map
        }, function (r) {
            geo.addEntry({
                "longitude": 15.087269,
                "latitude": 37.502669,
                "member": map1
            }, function (s) {
                geo.addEntry({
                    "longitude": 15.081269,
                    "latitude": 37.502169,
                    "member": map2
                }, function (t) {
                    geo.radiusWithDistance(15, 37, 200, 'KILOMETERS', function (u) {
                        context.assertTrue(3 === u.length);
                        context.assertTrue(JSON.stringify(map) === JSON.stringify(u[0].member));
                        context.assertTrue(190.4424 === u[0].distance);
                        context.assertTrue(JSON.stringify(map1) === JSON.stringify(u[2].member));
                        context.assertTrue(56.4413 === u[2].distance);
                        context.assertTrue(JSON.stringify(map2) === JSON.stringify(u[1].member));
                        context.assertTrue(56.3159 === u[1].distance);
                        async.complete();
                    });
                });
            });
        });
    },
    "radiusWithDistanceEmpty": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        geo.radiusWithDistance(15, 37, 200, 'KILOMETERS', function (r) {
            context.assertTrue(0 === r.length);
            async.complete();
        });
    },
    "radiusWithPosition": function (context, redisson, async) {
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
            geo.radiusWithPosition(15, 37, 200, 'KILOMETERS', function (s) {
                context.assertTrue(2 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(13.361389338970184 === s[0].geoPosition.longitude);
                context.assertTrue(38.115556395496299 === s[0].geoPosition.latitude);
                context.assertTrue("Catania" === s[1].member);
                context.assertTrue(15.087267458438873 === s[1].geoPosition.longitude);
                context.assertTrue(37.50266842333162 === s[1].geoPosition.latitude);
                async.complete();
            });
        });
    },
    "radiusWithPositionCount": function (context, redisson, async) {
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
            geo.radiusWithPosition(15, 37, 200, 'KILOMETERS', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertTrue("Catania" === s[0].member);
                context.assertTrue(15.087267458438873 === s[0].geoPosition.longitude);
                context.assertTrue(37.50266842333162 === s[0].geoPosition.latitude);
                async.complete();
            });
        });
    },
    "radiusWithPositionOrder": function (context, redisson, async) {
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
            geo.radiusWithPosition(15, 37, 200, 'KILOMETERS', 'DESC', function (s) {
                context.assertTrue(2 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(13.361389338970184 === s[0].geoPosition.longitude);
                context.assertTrue(38.115556395496299 === s[0].geoPosition.latitude);
                context.assertTrue("Catania" === s[1].member);
                context.assertTrue(15.087267458438873 === s[1].geoPosition.longitude);
                context.assertTrue(37.50266842333162 === s[1].geoPosition.latitude);
                geo.radiusWithPosition(15, 37, 200, 'KILOMETERS', 'ASC', function (s) {
                    context.assertTrue(2 === s.length);
                    context.assertTrue("Catania" === s[0].member);
                    context.assertTrue(15.087267458438873 === s[0].geoPosition.longitude);
                    context.assertTrue(37.50266842333162 === s[0].geoPosition.latitude);
                    context.assertTrue("Palermo" === s[1].member);
                    context.assertTrue(13.361389338970184 === s[1].geoPosition.longitude);
                    context.assertTrue(38.115556395496299 === s[1].geoPosition.latitude);
                    async.complete();
                });
            });
        });
    },
    "radiusWithPositionOrderCount": function (context, redisson, async) {
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
            geo.radiusWithPosition(15, 37, 200, 'KILOMETERS', 'DESC', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(13.361389338970184 === s[0].geoPosition.longitude);
                context.assertTrue(38.115556395496299 === s[0].geoPosition.latitude);
                geo.radiusWithPosition(15, 37, 200, 'KILOMETERS', 'ASC', 1, function (s) {
                    context.assertTrue(1 === s.length);
                    context.assertTrue("Catania" === s[0].member);
                    context.assertTrue(15.087267458438873 === s[0].geoPosition.longitude);
                    context.assertTrue(37.50266842333162 === s[0].geoPosition.latitude);
                    async.complete();
                });
            });
        });
    },
    "radiusWithPositionEmpty": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        geo.radiusWithPosition(15, 37, 200, 'KILOMETERS', function (r) {
            context.assertTrue(0 === r.length);
            async.complete();
        });
    },
    "radiusMember": function (context, redisson, async) {
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
            geo.radius("Palermo", 200, 'KILOMETERS', function (s) {
                context.assertTrue(2 === s.length);
                context.assertTrue("Palermo" === s[0]);
                context.assertTrue("Catania" === s[1]);
                async.complete();
            });
        });
    },
    "radiusMemberCount": function (context, redisson, async) {
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
            geo.radius("Palermo", 200, 'KILOMETERS', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertTrue("Palermo" === s[0]);
                async.complete();
            });
        });
    },
    "radiusMemberOrder": function (context, redisson, async) {
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
            geo.radius("Palermo", 200, 'KILOMETERS', 'ASC', function (s) {
                context.assertTrue(2 === s.length);
                context.assertTrue("Palermo" === s[0]);
                context.assertTrue("Catania" === s[1]);
                geo.radius("Palermo", 200, 'KILOMETERS', 'DESC', function (s) {
                    context.assertTrue(2 === s.length);
                    context.assertTrue("Catania" === s[0]);
                    context.assertTrue("Palermo" === s[1]);
                    async.complete();
                });
            });
        });
    },
    "radiusMemberOrderCount": function (context, redisson, async) {
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
            geo.radius("Palermo", 200, 'KILOMETERS', 'ASC', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertTrue("Palermo" === s[0]);
                geo.radius("Palermo", 200, 'KILOMETERS', 'DESC', 1, function (s) {
                    context.assertTrue(1 === s.length);
                    context.assertTrue("Catania" === s[0]);
                    async.complete();
                });
            });
        });
    },
    "radiusMemberEmpty": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        geo.radius("Palermo", 200, 'KILOMETERS', function (r) {
            context.assertTrue(0 === r.length);
            async.complete();
        });
    },
    "radiusMemberWithDistance": function (context, redisson, async) {
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
            geo.radiusWithDistance("Palermo", 200, 'KILOMETERS', function (s) {
                context.assertTrue(2 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(0.0 === s[0].distance);
                context.assertTrue("Catania" === s[1].member);
                context.assertTrue(166.2742 === s[1].distance);
                async.complete();
            });
        });
    },
    "radiusMemberWithDistanceCount": function (context, redisson, async) {
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
            geo.radiusWithDistance("Palermo", 200, 'KILOMETERS', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(0.0 === s[0].distance);
                async.complete();
            });
        });
    },
    "radiusMemberWithDistanceOrder": function (context, redisson, async) {
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
            geo.radiusWithDistance("Palermo", 200, 'KILOMETERS', 'ASC', function (s) {
                context.assertTrue(2 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(0.0 === s[0].distance);
                context.assertTrue("Catania" === s[1].member);
                context.assertTrue(166.2742 === s[1].distance);
                geo.radiusWithDistance("Palermo", 200, 'KILOMETERS', 'DESC', function (s) {
                    context.assertTrue(2 === s.length);
                    context.assertTrue("Catania" === s[0].member);
                    context.assertTrue(166.2742 === s[0].distance);
                    context.assertTrue("Palermo" === s[1].member);
                    context.assertTrue(0.0 === s[1].distance);
                    async.complete();
                });
            });
        });
    },
    "radiusMemberWithDistanceOrderCount": function (context, redisson, async) {
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
            geo.radiusWithDistance("Palermo", 200, 'KILOMETERS', 'ASC', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(0.0 === s[0].distance);
                geo.radiusWithDistance("Palermo", 200, 'KILOMETERS', 'DESC', 1, function (s) {
                    context.assertTrue(1 === s.length);
                    context.assertTrue("Catania" === s[0].member);
                    context.assertTrue(166.2742 === s[0].distance);
                    async.complete();
                });
            });
        });
    },
    "radiusMemberWithDistanceEmpty": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        geo.radiusWithDistance("Palermo", 200, 'KILOMETERS', function (r) {
            context.assertTrue(0 === r.length);
            async.complete();
        });
    },
    "radiusMemberWithPosition": function (context, redisson, async) {
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
            geo.radiusWithPosition("Palermo", 200, 'KILOMETERS', function (s) {
                context.assertTrue(2 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(13.361389338970184 === s[0].geoPosition.longitude);
                context.assertTrue(38.115556395496299 === s[0].geoPosition.latitude);
                context.assertTrue("Catania" === s[1].member);
                context.assertTrue(15.087267458438873 === s[1].geoPosition.longitude);
                context.assertTrue(37.50266842333162 === s[1].geoPosition.latitude);
                async.complete();
            });
        });
    },
    "radiusMemberWithPositionCount": function (context, redisson, async) {
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
            geo.radiusWithPosition("Palermo", 200, 'KILOMETERS', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(13.361389338970184 === s[0].geoPosition.longitude);
                context.assertTrue(38.115556395496299 === s[0].geoPosition.latitude);
                async.complete();
            });
        });
    },
    "radiusMemberWithPositionOrder": function (context, redisson, async) {
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
            geo.radiusWithPosition("Palermo", 200, 'KILOMETERS', 'ASC', function (s) {
                context.assertTrue(2 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(13.361389338970184 === s[0].geoPosition.longitude);
                context.assertTrue(38.115556395496299 === s[0].geoPosition.latitude);
                context.assertTrue("Catania" === s[1].member);
                context.assertTrue(15.087267458438873 === s[1].geoPosition.longitude);
                context.assertTrue(37.50266842333162 === s[1].geoPosition.latitude);
                geo.radiusWithPosition("Palermo", 200, 'KILOMETERS', 'DESC', function (s) {
                    context.assertTrue(2 === s.length);
                    context.assertTrue("Catania" === s[0].member);
                    context.assertTrue(15.087267458438873 === s[0].geoPosition.longitude);
                    context.assertTrue(37.50266842333162 === s[0].geoPosition.latitude);
                    context.assertTrue("Palermo" === s[1].member);
                    context.assertTrue(13.361389338970184 === s[1].geoPosition.longitude);
                    context.assertTrue(38.115556395496299 === s[1].geoPosition.latitude);
                    async.complete();
                });
            });
        });
    },
    "radiusMemberWithPositionOrderCount": function (context, redisson, async) {
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
            geo.radiusWithPosition("Palermo", 200, 'KILOMETERS', 'ASC', 1, function (s) {
                context.assertTrue(1 === s.length);
                context.assertTrue("Palermo" === s[0].member);
                context.assertTrue(13.361389338970184 === s[0].geoPosition.longitude);
                context.assertTrue(38.115556395496299 === s[0].geoPosition.latitude);
                geo.radiusWithPosition("Palermo", 200, 'KILOMETERS', 'DESC', 1, function (s) {
                    context.assertTrue(1 === s.length);
                    context.assertTrue("Catania" === s[0].member);
                    context.assertTrue(15.087267458438873 === s[0].geoPosition.longitude);
                    context.assertTrue(37.50266842333162 === s[0].geoPosition.latitude);
                    async.complete();
                });
            });
        });
    },
    "radiusMemberWithPositionEmpty": function (context, redisson, async) {
        var geo = redisson.getGeo("test");
        geo.radiusWithPosition("Palermo", 200, 'KILOMETERS', function (r) {
            context.assertTrue(0 === r.length);
            async.complete();
        });
    }
};
module.exports = RedissonGeoTest;
