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
package org.redisson.misc;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import org.redisson.client.RedisClient;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@VertxGen
public interface RedisProcess {

    @GenIgnore
    RedisClient createRedisClientInstance();

    @GenIgnore
    Process getRedisProcess();

    String getRedisServerAddressAndPort();

    String getRedisServerBindAddress();

    int getRedisServerPort();

    String getRedisVersion();

    int stop();
    
}
