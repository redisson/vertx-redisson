/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.redisson.groovy.misc;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import org.redisson.misc.LogLevelOptions
import java.util.List
import org.redisson.misc.SyslogFacilityOptions
import org.redisson.misc.MaxMemoryPolicyOptions
import org.redisson.misc.KeyspaceEventsOptions
import org.redisson.misc.AppendFsyncModeOptions
/**
*/
@CompileStatic
public class RedisRunner {
  private final def org.redisson.misc.RedisRunner delegate;
  public RedisRunner(Object delegate) {
    this.delegate = (org.redisson.misc.RedisRunner) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static RedisRunner newInstance() {
    def ret = InternalHelper.safeCreate(org.redisson.misc.RedisRunner.newInstance(), org.redisson.groovy.misc.RedisRunner.class);
    return ret;
  }
  public RedisRunner redisBinary(String redisBinary) {
    delegate.redisBinary(redisBinary);
    return this;
  }
  public RedisRunner logger(RedisLogger logger) {
    delegate.logger(logger != null ? (org.redisson.misc.RedisLogger)logger.getDelegate() : null);
    return this;
  }
  public RedisRunner activerehashing(boolean activerehashing) {
    delegate.activerehashing(activerehashing);
    return this;
  }
  public RedisRunner aofLoadTruncated(boolean aofLoadTruncated) {
    delegate.aofLoadTruncated(aofLoadTruncated);
    return this;
  }
  public RedisRunner aofRewriteIncrementalFsync(boolean aofRewriteIncrementalFsync) {
    delegate.aofRewriteIncrementalFsync(aofRewriteIncrementalFsync);
    return this;
  }
  public RedisRunner appendfilename(String appendfilename) {
    delegate.appendfilename(appendfilename);
    return this;
  }
  public RedisRunner appendfsync(AppendFsyncModeOptions appendfsync) {
    delegate.appendfsync(appendfsync);
    return this;
  }
  public RedisRunner appendonly(boolean appendonly) {
    delegate.appendonly(appendonly);
    return this;
  }
  public RedisRunner autoAofRewriteMinSize(String autoAofRewriteMinSize) {
    delegate.autoAofRewriteMinSize(autoAofRewriteMinSize);
    return this;
  }
  public RedisRunner autoAofRewritePercentage(int autoAofRewritePercentage) {
    delegate.autoAofRewritePercentage(autoAofRewritePercentage);
    return this;
  }
  public RedisRunner bind(String bind) {
    delegate.bind(bind);
    return this;
  }
  public RedisRunner clientOutputBufferLimit$Normal(String hardLimit, String softLimit, long softSeconds) {
    delegate.clientOutputBufferLimit$Normal(hardLimit, softLimit, softSeconds);
    return this;
  }
  public RedisRunner clientOutputBufferLimit$Pubsub(String hardLimit, String softLimit, long softSeconds) {
    delegate.clientOutputBufferLimit$Pubsub(hardLimit, softLimit, softSeconds);
    return this;
  }
  public RedisRunner clientOutputBufferLimit$Slave(String hardLimit, String softLimit, long softSeconds) {
    delegate.clientOutputBufferLimit$Slave(hardLimit, softLimit, softSeconds);
    return this;
  }
  public RedisRunner clusterConfigFile(String clusterConfigFile) {
    delegate.clusterConfigFile(clusterConfigFile);
    return this;
  }
  public RedisRunner clusterEnabled(boolean clusterEnabled) {
    delegate.clusterEnabled(clusterEnabled);
    return this;
  }
  public RedisRunner clusterMigrationBarrier(long clusterMigrationBarrier) {
    delegate.clusterMigrationBarrier(clusterMigrationBarrier);
    return this;
  }
  public RedisRunner clusterNodeTimeout(long clusterNodeTimeout) {
    delegate.clusterNodeTimeout(clusterNodeTimeout);
    return this;
  }
  public RedisRunner clusterRequireFullCoverage(boolean clusterRequireFullCoverage) {
    delegate.clusterRequireFullCoverage(clusterRequireFullCoverage);
    return this;
  }
  public RedisRunner clusterSlaveValidityFactor(long clusterSlaveValidityFactor) {
    delegate.clusterSlaveValidityFactor(clusterSlaveValidityFactor);
    return this;
  }
  public RedisRunner daemonize(boolean daemonize) {
    delegate.daemonize(daemonize);
    return this;
  }
  public RedisRunner databases(int databases) {
    delegate.databases(databases);
    return this;
  }
  public RedisRunner dbfilename(String dbfilename) {
    delegate.dbfilename(dbfilename);
    return this;
  }
  public String defaultDir() {
    def ret = delegate.defaultDir();
    return ret;
  }
  public boolean deleteDBfileDir() {
    def ret = delegate.deleteDBfileDir();
    return ret;
  }
  public RedisRunner dir(String dir) {
    delegate.dir(dir);
    return this;
  }
  public List<String> getBindAddr() {
    def ret = delegate.getBindAddr();
    return ret;
  }
  public String getInitialBindAddr() {
    def ret = delegate.getInitialBindAddr();
    return ret;
  }
  public int getPort() {
    def ret = delegate.getPort();
    return ret;
  }
  public RedisRunner hashMaxZiplistEntries(long hashMaxZiplistEntries) {
    delegate.hashMaxZiplistEntries(hashMaxZiplistEntries);
    return this;
  }
  public RedisRunner hashMaxZiplistValue(long hashMaxZiplistValue) {
    delegate.hashMaxZiplistValue(hashMaxZiplistValue);
    return this;
  }
  public RedisRunner hllSparseMaxBytes(long hllSparseMaxBytes) {
    delegate.hllSparseMaxBytes(hllSparseMaxBytes);
    return this;
  }
  public RedisRunner hz(int hz) {
    delegate.hz(hz);
    return this;
  }
  public boolean isNosave() {
    def ret = delegate.isNosave();
    return ret;
  }
  public boolean isRandomDir() {
    def ret = delegate.isRandomDir();
    return ret;
  }
  public RedisRunner latencyMonitorThreshold(long latencyMonitorThreshold) {
    delegate.latencyMonitorThreshold(latencyMonitorThreshold);
    return this;
  }
  public RedisRunner listMaxZiplistEntries(long listMaxZiplistEntries) {
    delegate.listMaxZiplistEntries(listMaxZiplistEntries);
    return this;
  }
  public RedisRunner listMaxZiplistValue(long listMaxZiplistValue) {
    delegate.listMaxZiplistValue(listMaxZiplistValue);
    return this;
  }
  public RedisRunner logfile(String logfile) {
    delegate.logfile(logfile);
    return this;
  }
  public RedisRunner loglevel(LogLevelOptions loglevel) {
    delegate.loglevel(loglevel);
    return this;
  }
  public RedisRunner luaTimeLimit(long luaTimeLimit) {
    delegate.luaTimeLimit(luaTimeLimit);
    return this;
  }
  public RedisRunner masterauth(String masterauth) {
    delegate.masterauth(masterauth);
    return this;
  }
  public RedisRunner maxclients(long maxclients) {
    delegate.maxclients(maxclients);
    return this;
  }
  public RedisRunner maxmemory(String maxmemory) {
    delegate.maxmemory(maxmemory);
    return this;
  }
  public RedisRunner maxmemoryPolicy(MaxMemoryPolicyOptions maxmemoryPolicy) {
    delegate.maxmemoryPolicy(maxmemoryPolicy);
    return this;
  }
  public RedisRunner maxmemorySamples(long maxmemorySamples) {
    delegate.maxmemorySamples(maxmemorySamples);
    return this;
  }
  public RedisRunner minSlaveMaxLag(long minSlaveMaxLag) {
    delegate.minSlaveMaxLag(minSlaveMaxLag);
    return this;
  }
  public RedisRunner minSlaveToWrite(long minSlaveToWrite) {
    delegate.minSlaveToWrite(minSlaveToWrite);
    return this;
  }
  public RedisRunner noAppendfsyncOnRewrite(boolean noAppendfsyncOnRewrite) {
    delegate.noAppendfsyncOnRewrite(noAppendfsyncOnRewrite);
    return this;
  }
  /**
   * Phantom option
   * @return RedisRunnerImpl
   */
  public RedisRunner nosave() {
    delegate.nosave();
    return this;
  }
  public RedisRunner notifyKeyspaceEvents(KeyspaceEventsOptions notifyKeyspaceEvents) {
    delegate.notifyKeyspaceEvents(notifyKeyspaceEvents);
    return this;
  }
  public RedisRunner pidfile(String pidfile) {
    delegate.pidfile(pidfile);
    return this;
  }
  public RedisRunner port(int port) {
    delegate.port(port);
    return this;
  }
  /**
   * Phantom option
   * @return RedisRunnerImpl
   */
  public RedisRunner randomDir() {
    delegate.randomDir();
    return this;
  }
  public RedisRunner randomPort() {
    delegate.randomPort();
    return this;
  }
  public RedisRunner randomPort(int retryCount) {
    delegate.randomPort(retryCount);
    return this;
  }
  public RedisRunner rdbchecksum(boolean rdbchecksum) {
    delegate.rdbchecksum(rdbchecksum);
    return this;
  }
  public RedisRunner rdbcompression(boolean rdbcompression) {
    delegate.rdbcompression(rdbcompression);
    return this;
  }
  public RedisRunner renameCommand(String renameCommand) {
    delegate.renameCommand(renameCommand);
    return this;
  }
  public RedisRunner replBacklogSize(String replBacklogSize) {
    delegate.replBacklogSize(replBacklogSize);
    return this;
  }
  public RedisRunner replBacklogTtl(long replBacklogTtl) {
    delegate.replBacklogTtl(replBacklogTtl);
    return this;
  }
  public RedisRunner replDisableTcpNodelay(boolean replDisableTcpNodelay) {
    delegate.replDisableTcpNodelay(replDisableTcpNodelay);
    return this;
  }
  public RedisRunner replDisklessSync(boolean replDisklessSync) {
    delegate.replDisklessSync(replDisklessSync);
    return this;
  }
  public RedisRunner replDisklessSyncDelay(long replDisklessSyncDelay) {
    delegate.replDisklessSyncDelay(replDisklessSyncDelay);
    return this;
  }
  public RedisRunner replPingSlavePeriod(long replPingSlavePeriod) {
    delegate.replPingSlavePeriod(replPingSlavePeriod);
    return this;
  }
  public RedisRunner replTimeout(long replTimeout) {
    delegate.replTimeout(replTimeout);
    return this;
  }
  public RedisRunner requirepass(String requirepass) {
    delegate.requirepass(requirepass);
    return this;
  }
  public RedisProcess run() {
    def ret = InternalHelper.safeCreate(delegate.run(), org.redisson.groovy.misc.RedisProcess.class);
    return ret;
  }
  public RedisProcess runAndCheck() {
    def ret = InternalHelper.safeCreate(delegate.runAndCheck(), org.redisson.groovy.misc.RedisProcess.class);
    return ret;
  }
  /**
   * To change the <b>redisBinary</b> system property for running the test,
   * use <i>argLine</i> option from surefire plugin:
   *
   * $ mvn -DargLine="-DredisBinary=`which redis-server`" -Punit-test clean \
   * verify
   * @param configPath 
   * @return Process running redis instance
   */
  public RedisProcess runWithConfigFile(String configPath) {
    def ret = InternalHelper.safeCreate(delegate.runWithConfigFile(configPath), org.redisson.groovy.misc.RedisProcess.class);
    return ret;
  }
  public RedisRunner save(long seconds, long changes) {
    delegate.save(seconds, changes);
    return this;
  }
  public RedisRunner setMaxIntsetEntries(long setMaxIntsetEntries) {
    delegate.setMaxIntsetEntries(setMaxIntsetEntries);
    return this;
  }
  public RedisRunner slavePriority(long slavePriority) {
    delegate.slavePriority(slavePriority);
    return this;
  }
  public RedisRunner slaveReadOnly(boolean slaveReadOnly) {
    delegate.slaveReadOnly(slaveReadOnly);
    return this;
  }
  public RedisRunner slaveServeStaleData(boolean slaveServeStaleData) {
    delegate.slaveServeStaleData(slaveServeStaleData);
    return this;
  }
  public RedisRunner slaveof(String masterip, int port) {
    delegate.slaveof(masterip, port);
    return this;
  }
  public RedisRunner slowlogLogSlowerThan(long slowlogLogSlowerThan) {
    delegate.slowlogLogSlowerThan(slowlogLogSlowerThan);
    return this;
  }
  public RedisRunner slowlogMaxLen(long slowlogMaxLen) {
    delegate.slowlogMaxLen(slowlogMaxLen);
    return this;
  }
  public RedisRunner stopWritesOnBgsaveError(boolean stopWritesOnBgsaveError) {
    delegate.stopWritesOnBgsaveError(stopWritesOnBgsaveError);
    return this;
  }
  public RedisRunner syslogEnabled(boolean syslogEnabled) {
    delegate.syslogEnabled(syslogEnabled);
    return this;
  }
  public RedisRunner syslogFacility(SyslogFacilityOptions syslogFacility) {
    delegate.syslogFacility(syslogFacility);
    return this;
  }
  public RedisRunner syslogIdent(String syslogIdent) {
    delegate.syslogIdent(syslogIdent);
    return this;
  }
  public RedisRunner tcpBacklog(long tcpBacklog) {
    delegate.tcpBacklog(tcpBacklog);
    return this;
  }
  public RedisRunner tcpKeepalive(long tcpKeepalive) {
    delegate.tcpKeepalive(tcpKeepalive);
    return this;
  }
  public RedisRunner timeout(long timeout) {
    delegate.timeout(timeout);
    return this;
  }
  public RedisRunner unixsocket(String unixsocket) {
    delegate.unixsocket(unixsocket);
    return this;
  }
  public RedisRunner unixsocketperm(int unixsocketperm) {
    delegate.unixsocketperm(unixsocketperm);
    return this;
  }
  public RedisRunner zsetMaxZiplistEntries(long zsetMaxZiplistEntries) {
    delegate.zsetMaxZiplistEntries(zsetMaxZiplistEntries);
    return this;
  }
  public RedisRunner zsetMaxZiplistValue(long zsetMaxZiplistValue) {
    delegate.zsetMaxZiplistValue(zsetMaxZiplistValue);
    return this;
  }
  public static RedisProcess startRedisServerInstance() {
    def ret = InternalHelper.safeCreate(org.redisson.misc.RedisRunner.startRedisServerInstance(), org.redisson.groovy.misc.RedisProcess.class);
    return ret;
  }
  public static int shutDownRedisServerInstance() {
    def ret = org.redisson.misc.RedisRunner.shutDownRedisServerInstance();
    return ret;
  }
  public static boolean isRedisServerInstanceRunning() {
    def ret = org.redisson.misc.RedisRunner.isRedisServerInstanceRunning();
    return ret;
  }
  public static RedisProcess getRedisServerInstance() {
    def ret = InternalHelper.safeCreate(org.redisson.misc.RedisRunner.getRedisServerInstance(), org.redisson.groovy.misc.RedisProcess.class);
    return ret;
  }
  public static String getRedisServerBindAddressAndPort() {
    def ret = org.redisson.misc.RedisRunner.getRedisServerBindAddressAndPort();
    return ret;
  }
}
