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

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import java.io.IOException;
import java.util.List;
import org.redisson.client.RedisClient;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@VertxGen
public interface RedisRunner {

    static RedisRunner newInstance() {
        return new RedisRunnerImpl();
    }
    
    @Fluent
    RedisRunner activerehashing(boolean activerehashing);

    @Fluent
    RedisRunner aofLoadTruncated(boolean aofLoadTruncated);

    @Fluent
    RedisRunner aofRewriteIncrementalFsync(boolean aofRewriteIncrementalFsync);

    @Fluent
    RedisRunner appendfilename(String appendfilename);

    @Fluent
    RedisRunner appendfsync(AppendFsyncModeOptions appendfsync);

    @Fluent
    RedisRunner appendonly(boolean appendonly);

    @Fluent
    RedisRunner autoAofRewriteMinSize(String autoAofRewriteMinSize);

    @Fluent
    RedisRunner autoAofRewritePercentage(int autoAofRewritePercentage);

    @Fluent
    RedisRunner bind(String bind);

    @Fluent
    RedisRunner clientOutputBufferLimit$Normal(String hardLimit, String softLimit, long softSeconds);

    @Fluent
    RedisRunner clientOutputBufferLimit$Pubsub(String hardLimit, String softLimit, long softSeconds);

    @Fluent
    RedisRunner clientOutputBufferLimit$Slave(String hardLimit, String softLimit, long softSeconds);

    @Fluent
    RedisRunner clusterConfigFile(String clusterConfigFile);

    @Fluent
    RedisRunner clusterEnabled(boolean clusterEnabled);

    @Fluent
    RedisRunner clusterMigrationBarrier(long clusterMigrationBarrier);

    @Fluent
    RedisRunner clusterNodeTimeout(long clusterNodeTimeout);

    @Fluent
    RedisRunner clusterRequireFullCoverage(boolean clusterRequireFullCoverage);

    @Fluent
    RedisRunner clusterSlaveValidityFactor(long clusterSlaveValidityFactor);

    @Fluent
    RedisRunner daemonize(boolean daemonize);

    @Fluent
    RedisRunner databases(int databases);

    @Fluent
    RedisRunner dbfilename(String dbfilename);

    String defaultDir();

    boolean deleteDBfileDir();

    @Fluent
    RedisRunner dir(String dir);

    List<String> getBindAddr();

    String getInitialBindAddr();

    int getPort();

    @Fluent
    RedisRunner hashMaxZiplistEntries(long hashMaxZiplistEntries);

    @Fluent
    RedisRunner hashMaxZiplistValue(long hashMaxZiplistValue);

    @Fluent
    RedisRunner hllSparseMaxBytes(long hllSparseMaxBytes);

    @Fluent
    RedisRunner hz(int hz);

    boolean isNosave();

    boolean isRandomDir();

    @Fluent
    RedisRunner latencyMonitorThreshold(long latencyMonitorThreshold);

    @Fluent
    RedisRunner listMaxZiplistEntries(long listMaxZiplistEntries);

    @Fluent
    RedisRunner listMaxZiplistValue(long listMaxZiplistValue);

    @Fluent
    RedisRunner logfile(String logfile);

    @Fluent
    RedisRunner loglevel(LogLevelOptions loglevel);

    @Fluent
    RedisRunner luaTimeLimit(long luaTimeLimit);

    @Fluent
    RedisRunner masterauth(String masterauth);

    @Fluent
    RedisRunner maxclients(long maxclients);

    @Fluent
    RedisRunner maxmemory(String maxmemory);

    @Fluent
    RedisRunner maxmemoryPolicy(MaxMemoryPolicyOptions maxmemoryPolicy);

    @Fluent
    RedisRunner maxmemorySamples(long maxmemorySamples);

    @Fluent
    RedisRunner minSlaveMaxLag(long minSlaveMaxLag);

    @Fluent
    RedisRunner minSlaveToWrite(long minSlaveToWrite);

    @Fluent
    RedisRunner noAppendfsyncOnRewrite(boolean noAppendfsyncOnRewrite);

    /**
     * Phantom option
     *
     * @return RedisRunnerImpl
     */
    @Fluent
    RedisRunner nosave();

    @Fluent
    RedisRunner notifyKeyspaceEvents(KeyspaceEventsOptions notifyKeyspaceEvents);

    @Fluent
    RedisRunner pidfile(String pidfile);

    @Fluent
    RedisRunner port(int port);

    /**
     * Phantom option
     *
     * @return RedisRunnerImpl
     */
    @Fluent
    RedisRunner randomDir();

    @Fluent
    RedisRunner randomPort();

    @Fluent
    RedisRunner randomPort(int retryCount);

    @Fluent
    RedisRunner rdbchecksum(boolean rdbchecksum);

    @Fluent
    RedisRunner rdbcompression(boolean rdbcompression);

    @Fluent
    RedisRunner renameCommand(String renameCommand);

    @Fluent
    RedisRunner replBacklogSize(String replBacklogSize);

    @Fluent
    RedisRunner replBacklogTtl(long replBacklogTtl);

    @Fluent
    RedisRunner replDisableTcpNodelay(boolean replDisableTcpNodelay);

    @Fluent
    RedisRunner replDisklessSync(boolean replDisklessSync);

    @Fluent
    RedisRunner replDisklessSyncDelay(long replDisklessSyncDelay);

    @Fluent
    RedisRunner replPingSlavePeriod(long replPingSlavePeriod);

    @Fluent
    RedisRunner replTimeout(long replTimeout);

    @Fluent
    RedisRunner requirepass(String requirepass);

    RedisProcess run();

    RedisProcess runAndCheck();

    /**
     * To change the <b>redisBinary</b> system property for running the test,
     * use <i>argLine</i> option from surefire plugin:
     *
     * $ mvn -DargLine="-DredisBinary=`which redis-server`" -Punit-test clean \
     * verify
     *
     * @param configPath
     * @return Process running redis instance
     * @throws IOException
     * @throws InterruptedException
     * @see
     * <a href="http://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#argLine">
     * http://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#argLine</a>
     */
    RedisProcess runWithConfigFile(String configPath);

    @Fluent
    RedisRunner save(long seconds, long changes);

    @Fluent
    RedisRunner setMaxIntsetEntries(long setMaxIntsetEntries);

    @Fluent
    RedisRunner slavePriority(long slavePriority);

    @Fluent
    RedisRunner slaveReadOnly(boolean slaveReadOnly);

    @Fluent
    RedisRunner slaveServeStaleData(boolean slaveServeStaleData);

    @Fluent
    RedisRunner slaveof(String masterip, int port);

    @Fluent
    RedisRunner slowlogLogSlowerThan(long slowlogLogSlowerThan);

    @Fluent
    RedisRunner slowlogMaxLen(long slowlogMaxLen);

    @Fluent
    RedisRunner stopWritesOnBgsaveError(boolean stopWritesOnBgsaveError);

    @Fluent
    RedisRunner syslogEnabled(boolean syslogEnabled);

    @Fluent
    RedisRunner syslogFacility(SyslogFacilityOptions syslogFacility);

    @Fluent
    RedisRunner syslogIdent(String syslogIdent);

    @Fluent
    RedisRunner tcpBacklog(long tcpBacklog);

    @Fluent
    RedisRunner tcpKeepalive(long tcpKeepalive);

    @Fluent
    RedisRunner timeout(long timeout);

    @Fluent
    RedisRunner unixsocket(String unixsocket);

    @Fluent
    RedisRunner unixsocketperm(int unixsocketperm);

    @Fluent
    RedisRunner zsetMaxZiplistEntries(long zsetMaxZiplistEntries);

    @Fluent
    RedisRunner zsetMaxZiplistValue(long zsetMaxZiplistValue);

    
    static RedisProcess startRedisServerInstance() {
        return RedisRunnerImpl.startDefaultRedisServerInstance();
    }

    static int shutDownRedisServerInstance() {
        return RedisRunnerImpl.shutDownDefaultRedisServerInstance();
    }

    static boolean isRedisServerInstanceRunning() {
        return RedisRunnerImpl.isDefaultRedisServerInstanceRunning();
    }

    @GenIgnore
    static RedisClient createRedisClientInstance() {
        return RedisRunnerImpl.createDefaultRedisClientInstance();
    }

    static RedisProcess getRedisServerInstance() {
        return RedisRunnerImpl.getDefaultRedisServerInstance();
    }

    static String getRedisServerBindAddressAndPort() {
        return RedisRunnerImpl.getDefaultRedisServerBindAddressAndPort();
    }

}
