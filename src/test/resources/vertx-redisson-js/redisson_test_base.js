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
    var tests = [];
    var counter = 0;
    var restartRedis = false;
    var restartRedisson = false;
    var redisVer;
    var defaultTestTimeout = 10000;
    var sharedRedisson;
    var startDefaultRedis = function () {
        RedisRunner.startRedisServerInstance();
        redisVer = redisVer
                || RedisRunner.getRedisServerInstance().getRedisVersion();
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
            var args = arguments, name, version, fn, timeout;
            if (args.length === 1 && typeof args[0] === "function") {
                name = "test_" + counter;
                version = requiredRedisVersion;
                fn = args[0];
                timeout = defaultTestTimeout;
            } else if (args.length === 2
                    && typeof args[0] === "string"
                    && typeof args[1] === "function") {
                name = args[0];
                version = requiredRedisVersion;
                fn = args[1];
                timeout = defaultTestTimeout;
            } else if (args.length === 2
                    && typeof args[0] === "funciton"
                    && typeof args[1] === "number") {
                name = "test_" + counter;
                version = requiredRedisVersion;
                fn = args[0];
                timeout = args[1];
            } else if (args.length === 3
                    && typeof args[0] === "string"
                    && typeof args[1] === "string"
                    && typeof args[2] === "function") {
                name = args[0];
                version = args[1];
                fn = args[2];
                timeout = defaultTestTimeout;
            } else if (args.length === 3
                    && typeof args[0] === "string"
                    && typeof args[1] === "function"
                    && typeof args[2] === "number") {
                name = args[0];
                version = requiredRedisVersion;
                fn = args[1];
                timeout = args[2];
            } else if (args.length === 4
                    && typeof args[0] === "string"
                    && typeof args[1] === "string"
                    && typeof args[2] === "function"
                    && typeof args[3] === "number") {
                name = args[0];
                version = args[1];
                fn = args[2];
                timeout = args[3];
            } else
                throw new TypeError("function invoked with invalid arguments");
            tests[counter] = {
                "name": name,
                "version": version,
                "fn": fn,
                "timeout": timeout
            };
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
                    console.log("Start Shared Redis");
                    startDefaultRedis.call(me, context);
                }
                if (!restartRedisson) {
                    console.log("Start Shared Redisson");
                    sharedRedisson = startRedisson.call(me, context);
                }
            }).beforeEach(function (context) {
                if (restartRedis) {
                    console.log("Start Dedicated Redis");
                    startDefaultRedis.call(me, context);
                }
                if (restartRedisson) {
                    console.log("Start Dedicated Redisson");
                    context.put("redisson", startRedisson.call(me, context));
                }
            }).afterEach(function (context) {
                if (restartRedis) {
                    console.log("Stop Dedicated Redis");
                    stopDefaultRedis.call(me, context);
                }
                if (restartRedisson) {
                    console.log("Stop Dedicated Redis");
                    stopRedisson.call(me, context, context.get("redisson"));
                } else {
                    console.log("Flush Shared Redison");
                    var async = context.async();
                    sharedRedisson.getKeys().flushdb(function () {
                        async.complete();
                    });
                    async.awaitSuccess();
                }
            }).after(function (context) {
                if (!restartRedis) {
                    console.log("Stop Shared Redis");
                    stopDefaultRedis.call(me, context);
                }
                if (!restartRedisson) {
                    console.log("Stop Shared Redisson");
                    stopRedisson.call(me, context, sharedRedisson);
                }
            });
            tests[counter] = {
                name: "Finish Test Workaround",
                version: requiredRedisVersion,
                fn: function (context, redisson, async) {
                    async.complete();
                },
                timeout: defaultTestTimeout
            };
            for (var t = 0; t < tests.length; t++) {
                var test = tests[t];
                suite.test(test.name, function (context) {
                    if (RedisVersion.compareTo(redisVer, test.version) < 0) {
                        context.fail("Required Redis version is ["
                                + test.version
                                + "] while detected Redis version is only ["
                                + redisVer + "]");
                    }
                    var async = context.async();
                    test.fn(context
                    , restartRedisson ? context.get("redisson") : sharedRedisson
                    , async);
                    async.awaitSuccess();
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