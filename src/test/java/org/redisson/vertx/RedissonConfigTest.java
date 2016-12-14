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

import io.vertx.core.json.JsonArray;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.redisson.codec.DefaultCodecProvider;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.ReadMode;
import org.redisson.connection.balancer.RoundRobinLoadBalancer;
import org.redisson.liveobject.provider.DefaultResolverProvider;
import org.redisson.misc.URIBuilder;
import org.redisson.vertx.config.ClusterServersConfig;
import org.redisson.vertx.config.Config;
import org.redisson.vertx.config.ElasticacheServersConfig;
import org.redisson.vertx.config.MasterSlaveServersConfig;
import org.redisson.vertx.config.SentinelServersConfig;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
public class RedissonConfigTest {
    
    @Test
    public void testRoot() throws IOException {
        Config config = new Config()
                .resolverProvider("org.redisson.liveobject.provider.DefaultResolverProvider")
                .setCodec("org.redisson.codec.JsonJacksonCodec")
                .setCodecProvider("org.redisson.codec.DefaultCodecProvider")
                .setNettyThreads(10)
                .setRedissonReferenceEnabled(Boolean.TRUE)
                .setThreads(11)
                .setUseLinuxNativeEpoll(Boolean.TRUE);
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config()
                .setResolverProvider(new DefaultResolverProvider())
                .setCodec(new JsonJacksonCodec())
                .setCodecProvider(new DefaultCodecProvider())
                .setThreads(11)
                .setNettyThreads(10)
                .setUseLinuxNativeEpoll(true);
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testDefault() throws IOException {
        Config config = new Config();
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testSingle() throws IOException {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setConnectionMinimumIdleSize(20)
                .setConnectionPoolSize(30)
                .setDatabase(1)
                .setDnsMonitoring(Boolean.TRUE)
                .setDnsMonitoringInterval(40l)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSubscriptionConnectionMinimumIdleSize(110)
                .setSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        config1.useSingleServer()
                .setAddress("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setConnectionMinimumIdleSize(20)
                .setConnectionPoolSize(30)
                .setDatabase(1)
                .setDnsMonitoring(Boolean.TRUE)
                .setDnsMonitoringInterval(40l)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSubscriptionConnectionMinimumIdleSize(110)
                .setSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testSingleDefault() throws IOException {
        Config config = new Config();
        config.useSingleServer();
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        config1.useSingleServer();
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testMasterSlave() throws IOException {
        Config config = new Config();
        MasterSlaveServersConfig c = config.useMasterSlaveServers()
                .setMasterAddress("123.123.123.123:1234")
                .addSlaveAddr("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setMasterConnectionMinimumIdleSize(20)
                .setMasterConnectionPoolSize(30)
                .setSlaveConnectionMinimumIdleSize(33)
                .setSlaveConnectionPoolSize(37)
                .setLoadBalancer("org.redisson.connection.balancer.RoundRobinLoadBalancer")
                .setReadMode(ReadMode.SLAVE)
                .setDatabase(1)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSlaveSubscriptionConnectionMinimumIdleSize(110)
                .setSlaveSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        c.addSlaveAddr(new JsonArray().add("10.10.10.10:1234"));
        c.setSlaveAddresses(new JsonArray().add("10.10.10.10:1234").add("11.11.11.11:1234"));
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        org.redisson.config.MasterSlaveServersConfig c1 = config1.useMasterSlaveServers()
                .setMasterAddress("123.123.123.123:1234")
                .addSlaveAddress("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setMasterConnectionMinimumIdleSize(20)
                .setMasterConnectionPoolSize(30)
                .setSlaveConnectionMinimumIdleSize(33)
                .setSlaveConnectionPoolSize(37)
                .setLoadBalancer(new RoundRobinLoadBalancer())
                .setReadMode(ReadMode.SLAVE)
                .setDatabase(1)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSlaveSubscriptionConnectionMinimumIdleSize(110)
                .setSlaveSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        c1.addSlaveAddress("10.10.10.10:1234");
        Set<URI> uris = new HashSet<URI>();
        uris.add(URIBuilder.create("10.10.10.10:1234"));
        uris.add(URIBuilder.create("11.11.11.11:1234"));
        c1.setSlaveAddresses(uris);
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testMasterSlaveDefault() throws IOException {
        Config config = new Config();
        config.useMasterSlaveServers();
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        config1.useMasterSlaveServers();
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testSentinelSlave() throws IOException {
        Config config = new Config();
        SentinelServersConfig c = config.useSentinelServers()
                .addSentinelAddr("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setMasterConnectionMinimumIdleSize(20)
                .setMasterConnectionPoolSize(30)
                .setSlaveConnectionMinimumIdleSize(33)
                .setSlaveConnectionPoolSize(37)
                .setLoadBalancer("org.redisson.connection.balancer.RoundRobinLoadBalancer")
                .setReadMode(ReadMode.SLAVE)
                .setDatabase(1)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSlaveSubscriptionConnectionMinimumIdleSize(110)
                .setSlaveSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        c.addSentinelAddr(new JsonArray().add("10.10.10.10:1234"));
        c.addSentinelAddr(new JsonArray().add("10.10.10.10:1234").add("11.11.11.11:1234"));
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        org.redisson.config.SentinelServersConfig c1 = config1.useSentinelServers()
                .addSentinelAddress("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setMasterConnectionMinimumIdleSize(20)
                .setMasterConnectionPoolSize(30)
                .setSlaveConnectionMinimumIdleSize(33)
                .setSlaveConnectionPoolSize(37)
                .setLoadBalancer(new RoundRobinLoadBalancer())
                .setReadMode(ReadMode.SLAVE)
                .setDatabase(1)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSlaveSubscriptionConnectionMinimumIdleSize(110)
                .setSlaveSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        c1.addSentinelAddress("10.10.10.10:1234");
        c1.addSentinelAddress("10.10.10.10:1234", "11.11.11.11:1234");
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    
    @Test
    public void testSentinelDefault() throws IOException {
        Config config = new Config();
        config.useSentinelServers();
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        config1.useSentinelServers();
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testClusterlSlave() throws IOException {
        Config config = new Config();
        ClusterServersConfig c = config.useClusterServers()
                .addNodeAddr("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setMasterConnectionMinimumIdleSize(20)
                .setMasterConnectionPoolSize(30)
                .setSlaveConnectionMinimumIdleSize(33)
                .setSlaveConnectionPoolSize(37)
                .setLoadBalancer("org.redisson.connection.balancer.RoundRobinLoadBalancer")
                .setReadMode(ReadMode.SLAVE)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSlaveSubscriptionConnectionMinimumIdleSize(110)
                .setSlaveSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        c.addNodeAddr(new JsonArray().add("10.10.10.10:1234"));
        c.addNodeAddr(new JsonArray().add("10.10.10.10:1234").add("11.11.11.11:1234"));
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        org.redisson.config.ClusterServersConfig c1 = config1.useClusterServers()
                .addNodeAddress("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setMasterConnectionMinimumIdleSize(20)
                .setMasterConnectionPoolSize(30)
                .setSlaveConnectionMinimumIdleSize(33)
                .setSlaveConnectionPoolSize(37)
                .setLoadBalancer(new RoundRobinLoadBalancer())
                .setReadMode(ReadMode.SLAVE)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSlaveSubscriptionConnectionMinimumIdleSize(110)
                .setSlaveSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        c1.addNodeAddress("10.10.10.10:1234");
        c1.addNodeAddress("10.10.10.10:1234", "11.11.11.11:1234");
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    
    @Test
    public void testClusterDefault() throws IOException {
        Config config = new Config();
        config.useClusterServers();
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        config1.useClusterServers();
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testElastiCachelSlave() throws IOException {
        Config config = new Config();
        ElasticacheServersConfig c = config.useElasticacheServers()
                .addNodeAddr("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setMasterConnectionMinimumIdleSize(20)
                .setMasterConnectionPoolSize(30)
                .setSlaveConnectionMinimumIdleSize(33)
                .setSlaveConnectionPoolSize(37)
                .setLoadBalancer("org.redisson.connection.balancer.RoundRobinLoadBalancer")
                .setReadMode(ReadMode.SLAVE)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSlaveSubscriptionConnectionMinimumIdleSize(110)
                .setSlaveSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        c.addNodeAddr(new JsonArray().add("10.10.10.10:1234"));
        c.addNodeAddr(new JsonArray().add("10.10.10.10:1234").add("11.11.11.11:1234"));
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        org.redisson.config.ElasticacheServersConfig c1 = config1.useElasticacheServers()
                .addNodeAddress("123.123.123.123:1234")
                .setClientName("qqq")
                .setConnectTimeout(10)
                .setMasterConnectionMinimumIdleSize(20)
                .setMasterConnectionPoolSize(30)
                .setSlaveConnectionMinimumIdleSize(33)
                .setSlaveConnectionPoolSize(37)
                .setLoadBalancer(new RoundRobinLoadBalancer())
                .setReadMode(ReadMode.SLAVE)
                .setFailedAttempts(50)
                .setIdleConnectionTimeout(60)
                .setPassword("777")
                .setPingTimeout(70)
                .setReconnectionTimeout(80)
                .setRetryAttempts(90)
                .setRetryInterval(100)
                .setSlaveSubscriptionConnectionMinimumIdleSize(110)
                .setSlaveSubscriptionConnectionPoolSize(120)
                .setSubscriptionsPerConnection(130)
                .setTimeout(140);
        c1.addNodeAddress("10.10.10.10:1234");
        c1.addNodeAddress("10.10.10.10:1234", "11.11.11.11:1234");
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
    
    @Test
    public void testElastiCacheDefault() throws IOException {
        Config config = new Config();
        config.useElasticacheServers();
        String s = config.toString();
        org.redisson.config.Config config0 = org.redisson.config.Config.fromJSON(s);
        org.redisson.config.Config config1 = new org.redisson.config.Config();
        config1.useElasticacheServers();
        Assert.assertEquals(config0.toJSON(), config1.toJSON());
    }
}
