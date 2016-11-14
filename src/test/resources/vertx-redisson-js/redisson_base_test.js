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
/* global org, vertx, module */

'use strict';
var TestSuite = require("vertx-unit-js/test_suite");
var Redisson = require("vertx-redisson-js/redisson");
var RedisRunner = require("vertx-redisson-test-js/redis_runner");
var RedisVersion = org.redisson.misc.RedisVersion;

var RedissonTestSuit = function (name) {
    var suite = TestSuite.create(name || "redisson_base_test");
    var requiredRedisVersion = "2.8.0";
    var tests = {};
    var counter = 0;
    var restartRedis = false;
    var restartRedisson = false;
    var redisVer;
    var sharedRedisson;
    var startDefaultRedis = function () {
        RedisRunner.startRedisServerInstance();
        redisVer = redisVer || RedisRunner.getRedisServerInstance().getRedisVersion();
    };
    var stopDefaultRedis = function () {
        RedisRunner.shutDownRedisServerInstance();
    };
    var startRedisson = function () {
        var config = {
            "singleServerConfig": {
                "address": [
                    "//" + RedisRunner.getRedisServerBindAddressAndPort()
                ],
                "connectTimeout": 1000000,
                "timeout": 1000000
            }
        };
        return Redisson.create(vertx, config);
    };
    var stopRedisson = function (context, redisson) {
        var async = context.async();
        redisson.shutdown(function () {
            console.log("SHUTDOWN REDISSON");
            async.complete();
        });
        async.awaitSuccess();
    };
    return {
        test: function () {
            var args = arguments, name, version, fn;
            if (args.length === 1 && typeof args[0] === "function") {
                name = "test_" + counter;
                version = requiredRedisVersion;
                fn = args[0];
            } else if (args.length === 2 && typeof args[0] === "string" && typeof args[1] === "function") {
                name = args[0];
                version = requiredRedisVersion;
                fn = args[1];
            } else if (args.length === 3 && typeof args[0] === "string" && typeof args[1] === "string" && typeof args[2] === "function") {
                name = args[0];
                version = args[1];
                fn = args[2];
            } else
                throw new TypeError("function invoked with invalid arguments");
            tests[name] = {"version": version, "fn": fn};
            counter++;
            return this;
        },
        requireVersion: function (version) {
            requiredRedisVersion = version;
            return this;
        },
        forEachRestartRedis: function (restart) {
            restartRedis = restart;
        },
        forEachRestartRedisson: function (restart) {
            restartRedisson = restartRedis || restart;
        },
        run: function () {
            var me = this;
            suite.before(function (context) {
                if (!restartRedis) {
                    startDefaultRedis.call(me, context);
                }
                if (!restartRedisson) {
                    sharedRedisson = startRedisson.call(me, context);
                }
            }).beforeEach(function (context) {
                if (restartRedis) {
                    startDefaultRedis.call(me, context);
                }
                if (restartRedisson) {
                    context.put("redisson", startRedisson.call(me, context));
                }
            }).afterEach(function (context) {
                if (restartRedis) {
                    stopDefaultRedis.call(me, context);
                }
                if (restartRedisson) {
                    stopRedisson.call(me, context, context.get("redisson"));
                } else {
                    var async = context.async();
                    sharedRedisson.getKeys().flushdb(function () {
                        async.complete();
                    });
                    async.awaitSuccess();
                }
            }).after(function (context) {
                if (!restartRedis) {
                    stopDefaultRedis.call(me, context);
                }
                if (!restartRedisson) {
                    stopRedisson.call(me, context, sharedRedisson);
                }
            });
            for (var t in tests) {
                var test = tests[t];
                suite.test(t, function (context) {
                    if (RedisVersion.compareTo(redisVer, test.version) < 0) {
                        context.fail("Required Redis version is [" + test.version + "] while detected Redis version is only [" + redisVer + "]");
                    }
                    test.fn(context, restartRedisson ? context.get("redisson") : sharedRedisson);
                });
            }
            suite.run({
                "reporters": [
                    {
                        "to": "console"
                    }
                ]
            });
        }
    };
};
RedissonTestSuit.create = function (name) {
    return new RedissonTestSuit(name);
};
module.exports = RedissonTestSuit;