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

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@DataObject
public class SingleServerConfig {
    
    private final JsonObject json;
    
    public SingleServerConfig(JsonObject json) {
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
    public SingleServerConfig setSubscriptionsPerConnection(Integer subscriptionsPerConnection) {
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
    public SingleServerConfig setPassword(String password) {
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
    public SingleServerConfig setRetryAttempts(Integer retryAttempts) {
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
    public SingleServerConfig setRetryInterval(Integer retryInterval) {
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
    public SingleServerConfig setTimeout(Integer timeout) {
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
    public SingleServerConfig setClientName(String clientName) {
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
    public SingleServerConfig setPingTimeout(Integer pingTimeout) {
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
    public SingleServerConfig setConnectTimeout(Integer connectTimeout) {
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
    public SingleServerConfig setIdleConnectionTimeout(Integer idleConnectionTimeout) {
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
    public SingleServerConfig setReconnectionTimeout(Integer reconnectionTimeout) {
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
    public SingleServerConfig setFailedAttempts(Integer failedAttempts) {
        json.put("failedAttempts", failedAttempts);
        return this;
    }

    public Integer getFailedAttempts() {
        return json.getInteger("failedAttempts");
    }

    // Base config end
    /**************************************************************************/
    
    /**
     * Redis connection pool size
     * <p>
     * Default is <code>64</code>
     *
     * @param connectionPoolSize - pool size
     * @return this
     */
    @Fluent
    public SingleServerConfig setConnectionPoolSize(Integer connectionPoolSize) {
        json.put("connectionPoolSize", connectionPoolSize);
        return this;
    }
    
    public Integer getConnectionPoolSize() {
        return json.getInteger("connectionPoolSize");
    }

    /**
     * Redis subscription-connection pool size limit
     * <p>
     * Default is 50
     *
     * @param subscriptionConnectionPoolSize - pool size
     * @return this
     */
    public SingleServerConfig setSubscriptionConnectionPoolSize(Integer subscriptionConnectionPoolSize) {
        json.put("subscriptionConnectionPoolSize", subscriptionConnectionPoolSize);
        return this;
    }
    
    public Integer getSubscriptionConnectionPoolSize() {
        return json.getInteger("subscriptionConnectionPoolSize");
    }

    /**
     * Set server address. Use follow format -- host:port
     *
     * @param address of Redis
     * @return this
     */
    public SingleServerConfig setAddress(String address) {
        json.put("address", new JsonArray().add(address.contains("//") ? address : "//" + address));
        return this;
    }
    
    public String getAddress() {
        return json.getString("address");
    }

    /**
     * Monitoring of the endpoint address for DNS changes.
     *
     * Default is false
     *
     * @param dnsMonitoring flag
     * @return this
     */
    public SingleServerConfig setDnsMonitoring(Boolean dnsMonitoring) {
        json.put("dnsMonitoring", dnsMonitoring);
        return this;
    }
    
    public Boolean isDnsMonitoring() {
        return json.getBoolean("dnsMonitoring");
    }

    /**
     * Interval in milliseconds to check the endpoint DNS if {@link #isDnsMonitoring()} is true.
     *
     * Default is 5000
     *
     * @param dnsMonitoringInterval time
     * @return this
     */
    public SingleServerConfig setDnsMonitoringInterval(Long dnsMonitoringInterval) {
        json.put("dnsMonitoringInterval", dnsMonitoringInterval);
        return this;
    }
    
    public Long getDnsMonitoringInterval() {
        return json.getLong("dnsMonitoringInterval");
    }

    /**
     * Minimum idle subscription connection amount.
     * <p>
     * Default is 1
     * 
     * @param subscriptionConnectionMinimumIdleSize - connections amount
     * @return this
     *
     */
    public SingleServerConfig setSubscriptionConnectionMinimumIdleSize(Integer subscriptionConnectionMinimumIdleSize) {
        json.put("subscriptionConnectionMinimumIdleSize", subscriptionConnectionMinimumIdleSize);
        return this;
    }
    
    public Integer getSubscriptionConnectionMinimumIdleSize() {
        return json.getInteger("subscriptionConnectionMinimumIdleSize");
    }

    /**
     * Minimum idle Redis connection amount.
     * <p>
     * Default is 10
     *
     * @param connectionMinimumIdleSize - connections amount
     * @return this
     */
    public SingleServerConfig setConnectionMinimumIdleSize(Integer connectionMinimumIdleSize) {
        json.put("connectionMinimumIdleSize", connectionMinimumIdleSize);
        return this;
    }
    
    public Integer getConnectionMinimumIdleSize() {
        return json.getInteger("connectionMinimumIdleSize");
    }

    /**
     * Database index used for Redis connection
     * Default is <code>0</code>
     *
     * @param database index
     * @return this
     */
    public SingleServerConfig setDatabase(Integer database) {
        json.put("database", database);
        return this;
    }
    
    public Integer getDatabase() {
        return json.getInteger("database");
    }

    public JsonObject toJSON() {
        return json;
    }
    
    @Override
    public String toString() {
        return json.encode();
    }

}
