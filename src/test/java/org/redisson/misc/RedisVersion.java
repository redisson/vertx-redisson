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

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@DataObject
public class RedisVersion implements Comparable<RedisVersion>{

    private final String fullVersion;
    private final Integer majorVersion;
    private final Integer minorVersion;
    private final Integer patchVersion;

    public RedisVersion(JsonObject json) {
        this(json.getString("fullVersion"));
    }
    
    public RedisVersion(String fullVersion) {
        this.fullVersion = fullVersion;
        Matcher matcher = Pattern.compile("^([\\d]+)\\.([\\d]+)\\.([\\d]+)$").matcher(fullVersion);
        matcher.find();
        majorVersion = Integer.parseInt(matcher.group(1));
        minorVersion = Integer.parseInt(matcher.group(2));
        patchVersion = Integer.parseInt(matcher.group(3));
    }

    public String getFullVersion() {
        return fullVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getPatchVersion() {
        return patchVersion;
    }

    @Override
    public int compareTo(RedisVersion o) {
        int ma = this.majorVersion.compareTo(o.majorVersion);
        int mi = this.minorVersion.compareTo(o.minorVersion);
        int pa = this.patchVersion.compareTo(o.patchVersion);
        return ma != 0 ? ma : mi != 0 ? mi : pa;
    }
    
    public int compareTo(String redisVersion) {
        return this.compareTo(new RedisVersion(redisVersion));
    }
    
    public static int compareTo(String redisVersion1, String redisVersion2) {
        return new RedisVersion(redisVersion1).compareTo(redisVersion2);
    }
    
}
