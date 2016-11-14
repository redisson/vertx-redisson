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
'use strict';
var TestSuite = require('vertx-redisson-js/redisson_base_test');
var suite = TestSuite.create("redisson_geo_test");
suite.requireVersion("3.1.0");
suite.test("add", function (context, redisson) {
    var async = context.async();
    redisson.getGeo("myGeo").add(13.361389, 38.115556, "Sicily", function (r) {
        context.assertTrue(1 === r);
        async.complete();
    });
    async.awaitSuccess();
}).test("addEntry", function (context, redisson) {
    var async = context.async();
    redisson.getGeo("myGeo").addEntry(
            {"longitude": 3.11, "latitude": 9.10321, "member": "city1"}, function (r) {
        context.assertTrue(1 === r);
        async.complete();
    });
    async.awaitSuccess();
}).test("addList", function (context, redisson) {
    var async = context.async();
    redisson.getGeo("myGeo").add([
        {"longitude": 3.11, "latitude": 9.10321, "member": "city1"},
        {"longitude": 81.1231, "latitude": 38.65478, "member": "city2"}
    ], function (r) {
        context.assertTrue(2 === r);
        async.complete();
    });
    async.awaitSuccess();
}).test("dist", function (context, redisson) {
    var async = context.async();
    var geo = redisson.getGeo("myGeo");
    geo.add([
        {"longitude": 13.361389, "latitude": 38.115556, "member": "Palermo"},
        {"longitude": 15.087269, "latitude": 37.502669, "member": "Catania"}
    ], function (r) {
        geo.dist("Palermo", "Catania", "METERS", function (s) {
            context.assertTrue(166274.1516 === s);
            async.complete();
        });
    });
    async.awaitSuccess();
});
suite.run();
