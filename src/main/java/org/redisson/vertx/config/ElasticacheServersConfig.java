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

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.List;
import java.util.stream.Collectors;
import org.redisson.config.ReadMode;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@DataObject
public class ElasticacheServersConfig {
    
    private final JsonObject json;
    
    public ElasticacheServersConfig(JsonObject json) {
        this.json = json;
    }
    
    /**************************************************************************/
    // Base config start
    
    /**
     * Subscriptions per Redis connection limit
     * Default is 5
     *
     * @param subscriptionsPerConnection amount
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setSubscriptionsPerConnection(Integer subscriptionsPerConnection) {
        json.put("subscriptionsPerConnection", subscriptionsPerConnection);
        return this;
    }

    public Integer getSubscriptionsPerConnection() {
        return json.getInteger("subscriptionsPerConnection");
    }

    /**
     * Password for Redis authentication. Should be null if not needed
     * Default is <code>null</code>
     *
     * @param password for connection
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setPassword(String password) {
        json.put("password", password);
        return this;
    }

    public String getPassword() {
        return json.getString("password");
    }

    /**
     * Error will be thrown if Redis command can't be sended to Redis server after <code>retryAttempts</code>.
     * But if it sent succesfully then <code>timeout</code> will be started.
     * <p>
     * Default is <code>3</code> attempts
     *
     * @see #timeout
     * @param retryAttempts - retry attempts
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setRetryAttempts(Integer retryAttempts) {
        json.put("retryAttempts", retryAttempts);
        return this;
    }

    public Integer getRetryAttempts() {
        return json.getInteger("retryAttempts");
    }

    /**
     * Time interval after which another one attempt to send Redis command will be executed.
     * <p>
     * Default is <code>1500</code> milliseconds
     *
     * @see retryAttempts
     * @param retryInterval - time in milliseconds
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setRetryInterval(Integer retryInterval) {
        json.put("retryInterval", retryInterval);
        return this;
    }

    public Integer getRetryInterval() {
        return json.getInteger("retryInterval");
    }

    /**
     * Redis server response timeout.
     * <p>
     * Default is <code>3000</code> milliseconds
     *
     * @param timeout in milliseconds
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setTimeout(Integer timeout) {
        json.put("timeout", timeout);
        return this;
    }

    public Integer getTimeout() {
        return json.getInteger("timeout");
    }

    /**
     * Setup connection name during connection init
     * via CLIENT SETNAME command
     *
     * @param clientName - name of client
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setClientName(String clientName) {
        json.put("clientName", clientName);
        return this;
    }

    public String getClientName() {
        return json.getString("clientName");
    }

    /**
     * Ping timeout used in <code>Node.ping</code> and <code>Node.pingAll</code> operation
     *
     * @param pingTimeout - timeout in milliseconds
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setPingTimeout(Integer pingTimeout) {
        json.put("pingTimeout", pingTimeout);
        return this;
    }

    public Integer getPingTimeout() {
        return json.getInteger("pingTimeout");
    }

    /**
     * Timeout during connecting to any Redis server.
     * <p>
     * Default is <code>10000</code> milliseconds.
     * 
     * @param connectTimeout - timeout in milliseconds
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setConnectTimeout(Integer connectTimeout) {
        json.put("connectTimeout", connectTimeout);
        return this;
    }

    public Integer getConnectTimeout() {
        return json.getInteger("connectTimeout");
    }

    /**
     * If pooled connection not used for a <code>timeout</code> time
     * and current connections amount bigger than minimum idle connections pool size,
     * then it will closed and removed from pool.
     *
     * @param idleConnectionTimeout - timeout in milliseconds
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setIdleConnectionTimeout(Integer idleConnectionTimeout) {
        json.put("idleConnectionTimeout", idleConnectionTimeout);
        return this;
    }

    public Integer getIdleConnectionTimeout() {
        return json.getInteger("idleConnectionTimeout");
    }

    /**
     * Reconnection attempt timeout to Redis server when
     * it has been excluded from internal list of available servers.
     * <p>
     * On every such timeout event Redisson tries
     * to connect to disconnected Redis server.
     * <p>
     * Default is 3000
     *
     * @see #failedAttempts
     *
     * @param reconnectionTimeout - reconnection timeout in milliseconds
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setReconnectionTimeout(Integer reconnectionTimeout) {
        json.put("reconnectionTimeout", reconnectionTimeout);
        return this;
    }

    public Integer getReconnectionTimeout() {
        return json.getInteger("reconnectionTimeout");
    }

    /**
     * Redis server will be excluded from the internal list of available nodes
     * when sequential unsuccessful execution attempts of any Redis command
     * on this server reaches <code>failedAttempts</code>.
     * <p>
     * Default is 3
     *
     * @param failedAttempts - attempts
     * @return this
     */
    @Fluent
    public ElasticacheServersConfig setFailedAttempts(Integer failedAttempts) {
        json.put("failedAttempts", failedAttempts);
        return this;
    }

    public Integer getFailedAttempts() {
        return json.getInteger("failedAttempts");
    }

    // Base config end
    /**************************************************************************/
    
    /**************************************************************************/
    // Base Master Slave config start
    
    /**
     * Redis 'slave' servers connection pool size for <b>each</b> slave node.
     * <p>
     * Default is <code>64</code>
     * <p>
     * @see #setSlaveConnectionMinimumIdleSize(int)
     *
     * @param slaveConnectionPoolSize - size of pool
     * @return config
     */
    @Fluent
    public ElasticacheServersConfig setSlaveConnectionPoolSize(Integer slaveConnectionPoolSize) {
        json.put("slaveConnectionPoolSize", slaveConnectionPoolSize);
        return this;
    }
    
    public Integer getSlaveConnectionPoolSize() {
        return json.getInteger("slaveConnectionPoolSize");
    }

    /**
     * Redis 'master' server connection pool size.
     * <p>
     * Default is <code>64</code>
     *
     * @see #setMasterConnectionMinimumIdleSize(int)
     * 
     * @param masterConnectionPoolSize - pool size
     * @return config
     *
     */
    @Fluent
    public ElasticacheServersConfig setMasterConnectionPoolSize(Integer masterConnectionPoolSize) {
        json.put("masterConnectionPoolSize", masterConnectionPoolSize);
        return this;
    }
    
    public Integer getMasterConnectionPoolSize() {
        return json.getInteger("masterConnectionPoolSize");
    }

    /**
     * Сonnection load balancer to multiple Redis slave servers.
     * Uses Round-robin algorithm by default
     *
     * @param loadBalancer class name
     * @return config
     *
     * @see org.redisson.connection.balancer.RandomLoadBalancer
     * @see org.redisson.connection.balancer.RoundRobinLoadBalancer
     * @see org.redisson.connection.balancer.WeightedRoundRobinBalancer
     */
    @Fluent
    public ElasticacheServersConfig setLoadBalancer(String loadBalancer) {
        json.put("loadBalancer", new JsonObject().put("class", loadBalancer));
        return this;
    }
    
    public String getLoadBalancer() {
        return json.getJsonObject("loadBalancer", new JsonObject()).getString("class");
    }

    /**
     * Redis 'slave' node maximum subscription (pub/sub) connection pool size for <b>each</b> slave node
     * <p>
     * Default is <code>50</code>
     * <p>
     * @see #setSlaveSubscriptionConnectionMinimumIdleSize(int)
     * 
     * @param slaveSubscriptionConnectionPoolSize - pool size
     * @return config
     */
    @Fluent
    public ElasticacheServersConfig setSlaveSubscriptionConnectionPoolSize(Integer slaveSubscriptionConnectionPoolSize) {
        json.put("slaveSubscriptionConnectionPoolSize", slaveSubscriptionConnectionPoolSize);
        return this;
    }
    
    public Integer getSlaveSubscriptionConnectionPoolSize() {
        return json.getInteger("slaveSubscriptionConnectionPoolSize");
    }

    /**
     * Redis 'slave' node minimum idle connection amount for <b>each</b> slave node
     * <p>
     * Default is <code>10</code>
     * <p>
     * @see #setSlaveConnectionPoolSize(int)
     * 
     * @param slaveConnectionMinimumIdleSize - pool size
     * @return config
     */
    @Fluent
    public ElasticacheServersConfig setSlaveConnectionMinimumIdleSize(Integer slaveConnectionMinimumIdleSize) {
        json.put("slaveConnectionMinimumIdleSize", slaveConnectionMinimumIdleSize);
        return this;
    }
    
    public Integer getSlaveConnectionMinimumIdleSize() {
        return json.getInteger("slaveConnectionMinimumIdleSize");
    }

    /**
     * Redis 'master' node minimum idle connection amount for <b>each</b> slave node
     * <p>
     * Default is <code>10</code>
     * <p>
     * @see #setMasterConnectionPoolSize(int)
     * 
     * @param masterConnectionMinimumIdleSize - pool size
     * @return config
     */
    @Fluent
    public ElasticacheServersConfig setMasterConnectionMinimumIdleSize(Integer masterConnectionMinimumIdleSize) {
        json.put("masterConnectionMinimumIdleSize", masterConnectionMinimumIdleSize);
        return this;
    }
    
    public Integer getMasterConnectionMinimumIdleSize() {
        return json.getInteger("masterConnectionMinimumIdleSize");
    }

    /**
     * Redis 'slave' node minimum idle subscription (pub/sub) connection amount for <b>each</b> slave node.
     * <p>
     * Default is <code>1</code>
     * <p>
     * @see #setSlaveSubscriptionConnectionPoolSize(int)
     * 
     * @param slaveSubscriptionConnectionMinimumIdleSize - pool size
     * @return config
     */
    @Fluent
    public ElasticacheServersConfig setSlaveSubscriptionConnectionMinimumIdleSize(Integer slaveSubscriptionConnectionMinimumIdleSize) {
        json.put("slaveSubscriptionConnectionMinimumIdleSize", slaveSubscriptionConnectionMinimumIdleSize);
        return this;
    }
    
    public Integer getSlaveSubscriptionConnectionMinimumIdleSize() {
        return json.getInteger("slaveSubscriptionConnectionMinimumIdleSize");
    }

    /**
     * Set node type used for read operation.
     * <p>
     * Default is <code>SLAVE</code>
     *
     * @param readMode param
     * @return config
     */
    @Fluent
    public ElasticacheServersConfig setReadMode(ReadMode readMode) {
        json.put("readMode", readMode.toString());
        return this;
    }
    
    public ReadMode getReadMode() {
        return ReadMode.valueOf(json.getString("readMode"));
    }

    // Base Master Slave config end
    /**************************************************************************/
        
    /**
     * Add Redis cluster node address. Use follow format -- <code>//host:port</code>
     *
     * @param addresses in <code>host:port</code> format
     * @return config
     */
    @Fluent
    public ElasticacheServersConfig addNodeAddr(JsonArray addresses) {
        if (!json.containsKey("nodeAddresses")) {
            json.put("nodeAddresses", new JsonArray());
        }
        List<String> l = ((List<String>) addresses.getList())
                .stream().map(a -> a.contains("//") ? a : "//" + a)
                .collect(Collectors.toList());
        
        json.getJsonArray("nodeAddresses").addAll(new JsonArray(l));
        return this;
    }
    
    @Fluent
    public ElasticacheServersConfig addNodeAddr(String slaveAddress) {
        return addNodeAddr(new JsonArray().add(slaveAddress));
    }
    
    public JsonArray getNodeAddresses() {
        return json.getJsonArray("nodeAddresses", new JsonArray());
    }
    
    @Fluent
    public ElasticacheServersConfig setNodeAddresses(JsonArray slaveAddress) {
        json.put("nodeAddresses", slaveAddress);
        return this;
    }

    public Integer getScanInterval() {
        return json.getInteger("scanInterval");
    }
    /**
     * Elasticache node scan interval in milliseconds
     *
     * @param scanInterval in milliseconds
     * @return config
     */
    @Fluent
    public ElasticacheServersConfig setScanInterval(Integer scanInterval) {
        json.put("scanInterval", scanInterval);
        return this;
    }

    /**
     * Database index used for Redis connection
     * Default is <code>0</code>
     *
     * @param database number
     * @return config
     */
    public ElasticacheServersConfig setDatabase(Integer database) {
        json.put("database", database);
        return this;
    }
    
    public Integer getDatabase() {
        return json.getInteger("database");
    }

}
