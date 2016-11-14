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
package org.redisson.vertx.config;

import io.netty.channel.EventLoopGroup;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import org.redisson.client.codec.Codec;
import org.redisson.codec.CodecProvider;
import org.redisson.liveobject.provider.ResolverProvider;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@DataObject
public class Config {

    private final JsonObject json;

    public Config(JsonObject json) throws IOException {
        this.json = json.copy();
    }
    
    public Config(Config config) throws IOException {
        this(config.toJSON());
    }
    
    public Config() {
        json = new JsonObject();
    }

    /**
     * Redis key/value codec. Default is json-codec
     *
     * @see org.redisson.client.codec.Codec
     * 
     * @param codec class name
     * @return this
     */
    @Fluent
    public Config setCodec(String codec) {
        json.put("codec", new JsonObject().put("class", codec));
        return this;
    }

    public String getCodec() {
        return json.getJsonObject("codec", new JsonObject()).getString("class");
    }
    
    /**
     * For codec registry and look up. DefaultCodecProvider used by default.
     * 
     * @param codecProvider class name 
     * @return this
     * @see org.redisson.codec.CodecProvider
     */
    @Fluent
    public Config setCodecProvider(String codecProvider) {
        json.put("codecProvider", new JsonObject().put("class", codecProvider));
        return this;
    }

    /**
     * Returns the CodecProvider instance
     * 
     * @return CodecProvider class name
     */
    public String getCodecProvider() {
        return json.getJsonObject("codecProvider", new JsonObject()).getString("class");
    }
    
    /**
     * For resolver registry and look up. DefaultResolverProvider used by default.
     * 
     * @param resolverProvider class name
     * @return this
     */
    @Fluent
    public Config resolverProvider(String resolverProvider) {
        json.put("resolverProvider", new JsonObject().put("class", resolverProvider));
        return this;
    }
    
    /**
     * Returns the ResolverProvider instance
     * 
     * @return resolverProvider class name
     */
    public String resolverProvider() {
        return json.getJsonObject("resolverProvider", new JsonObject()).getString("class");
    }
    
    /**
     * Config option for enabling Redisson Reference feature
     * <p>
     * Default value is <code>true</code>
     * 
     * @param redissonReferenceEnabled flag
     * @return this
     */
    @Fluent
    public Config setRedissonReferenceEnabled(Boolean redissonReferenceEnabled) {
        json.put("redissonReferenceEnabled", redissonReferenceEnabled);
        return this;
    }
    
    /**
     * Config option indicate whether Redisson Reference feature is enabled.
     * <p>
     * Default value is <code>true</code>
     * 
     * @return <code>true</code> if Redisson Reference feature enabled
     */
    public Boolean isRedissonReferenceEnabled() {
        return json.getBoolean("redissonReferenceEnabled");
    }
//
//    public ClusterServersConfig useClusterServers() {
//    }
//
//    void setClusterServersConfig(ClusterServersConfig clusterServersConfig) {
//    }
//
//    public ElasticacheServersConfig useElasticacheServers() {
//    }
//
//    void setElasticacheServersConfig(ElasticacheServersConfig elasticacheServersConfig) {
//    }

    /**
     * Init single server configuration.
     *
     * @return SingleServerConfig
     */
    public SingleServerConfig useSingleServer() {
        json.put("singleServerConfig", new JsonObject());
        return new SingleServerConfig(json.getJsonObject("singleServerConfig"));
    }
    
//
//    public SentinelServersConfig useSentinelServers() {
//    }
//
//    void setSentinelServersConfig(SentinelServersConfig sentinelConnectionConfig) {
//    }
//
//    public MasterSlaveServersConfig useMasterSlaveServers() {
//    }
//
//    void setMasterSlaveServersConfig(MasterSlaveServersConfig masterSlaveConnectionConfig) {
//    }

    /**
     * Threads amount shared across all listeners of <code>RTopic</code> object, 
     * invocation handlers of <code>RRemoteService</code> object  
     * and <code>RExecutorService</code> tasks.
     * <p>
     * Default is <code>0</code>.
     * <p>
     * <code>0</code> means <code>current_processors_amount * 2</code>
     *
     * @param threads amount
     * @return config
     */
    public Config setThreads(Integer threads) {
        json.put("threads", threads);
        return this;
    }

    public Integer getThreads() {
        return json.getInteger("threads");
    }
    
    /**
     * Activates an unix socket if servers binded to loopback interface.
     * Also used for epoll transport activation.
     * <b>netty-transport-native-epoll</b> library should be in classpath
     *
     * @param useLinuxNativeEpoll flag
     * @return config
     */
    @Fluent
    public Config setUseLinuxNativeEpoll(Boolean useLinuxNativeEpoll) {
        json.put("useLinuxNativeEpoll", useLinuxNativeEpoll);
        return this;
    }
    
    public Boolean isUseLinuxNativeEpoll() {
        return json.getBoolean("useLinuxNativeEpoll");
    }
    
    
    /**
     * Threads amount shared between all redis clients used by Redisson.
     * <p>
     * Default is <code>0</code>.
     * <p>
     * <code>0</code> means <code>current_processors_amount * 2</code>
     *
     * @param nettyThreads amount
     * @return this
     */
    @Fluent
    public Config setNettyThreads(Integer nettyThreads) {
        json.put("nettyThreads", nettyThreads);
        return this;
    }
    
    public Integer getNettyThreads() {
        return json.getInteger("nettyThreads");
    }

    public JsonObject toJSON() {
        return json;
    }
    
    @Override
    public String toString() {
        return json.encode();
    }

}
