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

/** @module vertx-redisson-test-js/redis_runner */
var utils = require('vertx-js/util/utils');
var RedisProcess = require('vertx-redisson-test-js/redis_process');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JRedisRunner = org.redisson.misc.RedisRunner;

/**

 @class
*/
var RedisRunner = function(j_val) {

  var j_redisRunner = j_val;
  var that = this;

  /**

   @public
   @param activerehashing {boolean} 
   @return {RedisRunner}
   */
  this.activerehashing = function(activerehashing) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["activerehashing(boolean)"](activerehashing);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param aofLoadTruncated {boolean} 
   @return {RedisRunner}
   */
  this.aofLoadTruncated = function(aofLoadTruncated) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["aofLoadTruncated(boolean)"](aofLoadTruncated);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param aofRewriteIncrementalFsync {boolean} 
   @return {RedisRunner}
   */
  this.aofRewriteIncrementalFsync = function(aofRewriteIncrementalFsync) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["aofRewriteIncrementalFsync(boolean)"](aofRewriteIncrementalFsync);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param appendfilename {string} 
   @return {RedisRunner}
   */
  this.appendfilename = function(appendfilename) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["appendfilename(java.lang.String)"](appendfilename);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param appendfsync {Object} 
   @return {RedisRunner}
   */
  this.appendfsync = function(appendfsync) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["appendfsync(org.redisson.misc.AppendFsyncModeOptions)"](org.redisson.misc.AppendFsyncModeOptions.valueOf(appendfsync));
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param appendonly {boolean} 
   @return {RedisRunner}
   */
  this.appendonly = function(appendonly) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["appendonly(boolean)"](appendonly);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param autoAofRewriteMinSize {string} 
   @return {RedisRunner}
   */
  this.autoAofRewriteMinSize = function(autoAofRewriteMinSize) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["autoAofRewriteMinSize(java.lang.String)"](autoAofRewriteMinSize);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param autoAofRewritePercentage {number} 
   @return {RedisRunner}
   */
  this.autoAofRewritePercentage = function(autoAofRewritePercentage) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["autoAofRewritePercentage(int)"](autoAofRewritePercentage);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param bind {string} 
   @return {RedisRunner}
   */
  this.bind = function(bind) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["bind(java.lang.String)"](bind);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param hardLimit {string} 
   @param softLimit {string} 
   @param softSeconds {number} 
   @return {RedisRunner}
   */
  this.clientOutputBufferLimit$Normal = function(hardLimit, softLimit, softSeconds) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] ==='number') {
      j_redisRunner["clientOutputBufferLimit$Normal(java.lang.String,java.lang.String,long)"](hardLimit, softLimit, softSeconds);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param hardLimit {string} 
   @param softLimit {string} 
   @param softSeconds {number} 
   @return {RedisRunner}
   */
  this.clientOutputBufferLimit$Pubsub = function(hardLimit, softLimit, softSeconds) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] ==='number') {
      j_redisRunner["clientOutputBufferLimit$Pubsub(java.lang.String,java.lang.String,long)"](hardLimit, softLimit, softSeconds);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param hardLimit {string} 
   @param softLimit {string} 
   @param softSeconds {number} 
   @return {RedisRunner}
   */
  this.clientOutputBufferLimit$Slave = function(hardLimit, softLimit, softSeconds) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] ==='number') {
      j_redisRunner["clientOutputBufferLimit$Slave(java.lang.String,java.lang.String,long)"](hardLimit, softLimit, softSeconds);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param clusterConfigFile {string} 
   @return {RedisRunner}
   */
  this.clusterConfigFile = function(clusterConfigFile) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["clusterConfigFile(java.lang.String)"](clusterConfigFile);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param clusterEnabled {boolean} 
   @return {RedisRunner}
   */
  this.clusterEnabled = function(clusterEnabled) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["clusterEnabled(boolean)"](clusterEnabled);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param clusterMigrationBarrier {number} 
   @return {RedisRunner}
   */
  this.clusterMigrationBarrier = function(clusterMigrationBarrier) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["clusterMigrationBarrier(long)"](clusterMigrationBarrier);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param clusterNodeTimeout {number} 
   @return {RedisRunner}
   */
  this.clusterNodeTimeout = function(clusterNodeTimeout) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["clusterNodeTimeout(long)"](clusterNodeTimeout);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param clusterRequireFullCoverage {boolean} 
   @return {RedisRunner}
   */
  this.clusterRequireFullCoverage = function(clusterRequireFullCoverage) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["clusterRequireFullCoverage(boolean)"](clusterRequireFullCoverage);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param clusterSlaveValidityFactor {number} 
   @return {RedisRunner}
   */
  this.clusterSlaveValidityFactor = function(clusterSlaveValidityFactor) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["clusterSlaveValidityFactor(long)"](clusterSlaveValidityFactor);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param daemonize {boolean} 
   @return {RedisRunner}
   */
  this.daemonize = function(daemonize) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["daemonize(boolean)"](daemonize);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param databases {number} 
   @return {RedisRunner}
   */
  this.databases = function(databases) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["databases(int)"](databases);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param dbfilename {string} 
   @return {RedisRunner}
   */
  this.dbfilename = function(dbfilename) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["dbfilename(java.lang.String)"](dbfilename);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {string}
   */
  this.defaultDir = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_redisRunner["defaultDir()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {boolean}
   */
  this.deleteDBfileDir = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_redisRunner["deleteDBfileDir()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param dir {string} 
   @return {RedisRunner}
   */
  this.dir = function(dir) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["dir(java.lang.String)"](dir);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {Array.<string>}
   */
  this.getBindAddr = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_redisRunner["getBindAddr()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {string}
   */
  this.getInitialBindAddr = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_redisRunner["getInitialBindAddr()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {number}
   */
  this.getPort = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_redisRunner["getPort()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param hashMaxZiplistEntries {number} 
   @return {RedisRunner}
   */
  this.hashMaxZiplistEntries = function(hashMaxZiplistEntries) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["hashMaxZiplistEntries(long)"](hashMaxZiplistEntries);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param hashMaxZiplistValue {number} 
   @return {RedisRunner}
   */
  this.hashMaxZiplistValue = function(hashMaxZiplistValue) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["hashMaxZiplistValue(long)"](hashMaxZiplistValue);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param hllSparseMaxBytes {number} 
   @return {RedisRunner}
   */
  this.hllSparseMaxBytes = function(hllSparseMaxBytes) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["hllSparseMaxBytes(long)"](hllSparseMaxBytes);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param hz {number} 
   @return {RedisRunner}
   */
  this.hz = function(hz) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["hz(int)"](hz);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {boolean}
   */
  this.isNosave = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_redisRunner["isNosave()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {boolean}
   */
  this.isRandomDir = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_redisRunner["isRandomDir()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param latencyMonitorThreshold {number} 
   @return {RedisRunner}
   */
  this.latencyMonitorThreshold = function(latencyMonitorThreshold) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["latencyMonitorThreshold(long)"](latencyMonitorThreshold);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param listMaxZiplistEntries {number} 
   @return {RedisRunner}
   */
  this.listMaxZiplistEntries = function(listMaxZiplistEntries) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["listMaxZiplistEntries(long)"](listMaxZiplistEntries);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param listMaxZiplistValue {number} 
   @return {RedisRunner}
   */
  this.listMaxZiplistValue = function(listMaxZiplistValue) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["listMaxZiplistValue(long)"](listMaxZiplistValue);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param logfile {string} 
   @return {RedisRunner}
   */
  this.logfile = function(logfile) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["logfile(java.lang.String)"](logfile);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param loglevel {Object} 
   @return {RedisRunner}
   */
  this.loglevel = function(loglevel) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["loglevel(org.redisson.misc.LogLevelOptions)"](org.redisson.misc.LogLevelOptions.valueOf(loglevel));
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param luaTimeLimit {number} 
   @return {RedisRunner}
   */
  this.luaTimeLimit = function(luaTimeLimit) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["luaTimeLimit(long)"](luaTimeLimit);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param masterauth {string} 
   @return {RedisRunner}
   */
  this.masterauth = function(masterauth) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["masterauth(java.lang.String)"](masterauth);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param maxclients {number} 
   @return {RedisRunner}
   */
  this.maxclients = function(maxclients) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["maxclients(long)"](maxclients);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param maxmemory {string} 
   @return {RedisRunner}
   */
  this.maxmemory = function(maxmemory) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["maxmemory(java.lang.String)"](maxmemory);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param maxmemoryPolicy {Object} 
   @return {RedisRunner}
   */
  this.maxmemoryPolicy = function(maxmemoryPolicy) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["maxmemoryPolicy(org.redisson.misc.MaxMemoryPolicyOptions)"](org.redisson.misc.MaxMemoryPolicyOptions.valueOf(maxmemoryPolicy));
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param maxmemorySamples {number} 
   @return {RedisRunner}
   */
  this.maxmemorySamples = function(maxmemorySamples) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["maxmemorySamples(long)"](maxmemorySamples);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param minSlaveMaxLag {number} 
   @return {RedisRunner}
   */
  this.minSlaveMaxLag = function(minSlaveMaxLag) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["minSlaveMaxLag(long)"](minSlaveMaxLag);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param minSlaveToWrite {number} 
   @return {RedisRunner}
   */
  this.minSlaveToWrite = function(minSlaveToWrite) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["minSlaveToWrite(long)"](minSlaveToWrite);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param noAppendfsyncOnRewrite {boolean} 
   @return {RedisRunner}
   */
  this.noAppendfsyncOnRewrite = function(noAppendfsyncOnRewrite) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["noAppendfsyncOnRewrite(boolean)"](noAppendfsyncOnRewrite);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Phantom option

   @public

   @return {RedisRunner} RedisRunnerImpl
   */
  this.nosave = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_redisRunner["nosave()"]();
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param notifyKeyspaceEvents {Object} 
   @return {RedisRunner}
   */
  this.notifyKeyspaceEvents = function(notifyKeyspaceEvents) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["notifyKeyspaceEvents(org.redisson.misc.KeyspaceEventsOptions)"](org.redisson.misc.KeyspaceEventsOptions.valueOf(notifyKeyspaceEvents));
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param pidfile {string} 
   @return {RedisRunner}
   */
  this.pidfile = function(pidfile) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["pidfile(java.lang.String)"](pidfile);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param port {number} 
   @return {RedisRunner}
   */
  this.port = function(port) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["port(int)"](port);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Phantom option

   @public

   @return {RedisRunner} RedisRunnerImpl
   */
  this.randomDir = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_redisRunner["randomDir()"]();
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param retryCount {number} 
   @return {RedisRunner}
   */
  this.randomPort = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_redisRunner["randomPort()"]();
      return that;
    }  else if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["randomPort(int)"](__args[0]);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param rdbchecksum {boolean} 
   @return {RedisRunner}
   */
  this.rdbchecksum = function(rdbchecksum) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["rdbchecksum(boolean)"](rdbchecksum);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param rdbcompression {boolean} 
   @return {RedisRunner}
   */
  this.rdbcompression = function(rdbcompression) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["rdbcompression(boolean)"](rdbcompression);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param renameCommand {string} 
   @return {RedisRunner}
   */
  this.renameCommand = function(renameCommand) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["renameCommand(java.lang.String)"](renameCommand);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param replBacklogSize {string} 
   @return {RedisRunner}
   */
  this.replBacklogSize = function(replBacklogSize) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["replBacklogSize(java.lang.String)"](replBacklogSize);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param replBacklogTtl {number} 
   @return {RedisRunner}
   */
  this.replBacklogTtl = function(replBacklogTtl) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["replBacklogTtl(long)"](replBacklogTtl);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param replDisableTcpNodelay {boolean} 
   @return {RedisRunner}
   */
  this.replDisableTcpNodelay = function(replDisableTcpNodelay) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["replDisableTcpNodelay(boolean)"](replDisableTcpNodelay);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param replDisklessSync {boolean} 
   @return {RedisRunner}
   */
  this.replDisklessSync = function(replDisklessSync) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["replDisklessSync(boolean)"](replDisklessSync);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param replDisklessSyncDelay {number} 
   @return {RedisRunner}
   */
  this.replDisklessSyncDelay = function(replDisklessSyncDelay) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["replDisklessSyncDelay(long)"](replDisklessSyncDelay);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param replPingSlavePeriod {number} 
   @return {RedisRunner}
   */
  this.replPingSlavePeriod = function(replPingSlavePeriod) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["replPingSlavePeriod(long)"](replPingSlavePeriod);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param replTimeout {number} 
   @return {RedisRunner}
   */
  this.replTimeout = function(replTimeout) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["replTimeout(long)"](replTimeout);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param requirepass {string} 
   @return {RedisRunner}
   */
  this.requirepass = function(requirepass) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["requirepass(java.lang.String)"](requirepass);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {RedisProcess}
   */
  this.run = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnVertxGen(j_redisRunner["run()"](), RedisProcess);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {RedisProcess}
   */
  this.runAndCheck = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnVertxGen(j_redisRunner["runAndCheck()"](), RedisProcess);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   To change the <b>redisBinary</b> system property for running the test,
   use <i>argLine</i> option from surefire plugin:
  
   $ mvn -DargLine="-DredisBinary=`which redis-server`" -Punit-test clean \
   verify

   @public
   @param configPath {string} 
   @return {RedisProcess} Process running redis instance
   */
  this.runWithConfigFile = function(configPath) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      return utils.convReturnVertxGen(j_redisRunner["runWithConfigFile(java.lang.String)"](configPath), RedisProcess);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param seconds {number} 
   @param changes {number} 
   @return {RedisRunner}
   */
  this.save = function(seconds, changes) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] ==='number' && typeof __args[1] ==='number') {
      j_redisRunner["save(long,long)"](seconds, changes);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param setMaxIntsetEntries {number} 
   @return {RedisRunner}
   */
  this.setMaxIntsetEntries = function(setMaxIntsetEntries) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["setMaxIntsetEntries(long)"](setMaxIntsetEntries);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param slavePriority {number} 
   @return {RedisRunner}
   */
  this.slavePriority = function(slavePriority) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["slavePriority(long)"](slavePriority);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param slaveReadOnly {boolean} 
   @return {RedisRunner}
   */
  this.slaveReadOnly = function(slaveReadOnly) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["slaveReadOnly(boolean)"](slaveReadOnly);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param slaveServeStaleData {boolean} 
   @return {RedisRunner}
   */
  this.slaveServeStaleData = function(slaveServeStaleData) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["slaveServeStaleData(boolean)"](slaveServeStaleData);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param masterip {string} 
   @param port {number} 
   @return {RedisRunner}
   */
  this.slaveof = function(masterip, port) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] ==='number') {
      j_redisRunner["slaveof(java.lang.String,int)"](masterip, port);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param slowlogLogSlowerThan {number} 
   @return {RedisRunner}
   */
  this.slowlogLogSlowerThan = function(slowlogLogSlowerThan) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["slowlogLogSlowerThan(long)"](slowlogLogSlowerThan);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param slowlogMaxLen {number} 
   @return {RedisRunner}
   */
  this.slowlogMaxLen = function(slowlogMaxLen) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["slowlogMaxLen(long)"](slowlogMaxLen);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param stopWritesOnBgsaveError {boolean} 
   @return {RedisRunner}
   */
  this.stopWritesOnBgsaveError = function(stopWritesOnBgsaveError) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["stopWritesOnBgsaveError(boolean)"](stopWritesOnBgsaveError);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param syslogEnabled {boolean} 
   @return {RedisRunner}
   */
  this.syslogEnabled = function(syslogEnabled) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='boolean') {
      j_redisRunner["syslogEnabled(boolean)"](syslogEnabled);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param syslogFacility {Object} 
   @return {RedisRunner}
   */
  this.syslogFacility = function(syslogFacility) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["syslogFacility(org.redisson.misc.SyslogFacilityOptions)"](org.redisson.misc.SyslogFacilityOptions.valueOf(syslogFacility));
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param syslogIdent {string} 
   @return {RedisRunner}
   */
  this.syslogIdent = function(syslogIdent) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["syslogIdent(java.lang.String)"](syslogIdent);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param tcpBacklog {number} 
   @return {RedisRunner}
   */
  this.tcpBacklog = function(tcpBacklog) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["tcpBacklog(long)"](tcpBacklog);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param tcpKeepalive {number} 
   @return {RedisRunner}
   */
  this.tcpKeepalive = function(tcpKeepalive) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["tcpKeepalive(long)"](tcpKeepalive);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param timeout {number} 
   @return {RedisRunner}
   */
  this.timeout = function(timeout) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["timeout(long)"](timeout);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param unixsocket {string} 
   @return {RedisRunner}
   */
  this.unixsocket = function(unixsocket) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      j_redisRunner["unixsocket(java.lang.String)"](unixsocket);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param unixsocketperm {number} 
   @return {RedisRunner}
   */
  this.unixsocketperm = function(unixsocketperm) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["unixsocketperm(int)"](unixsocketperm);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param zsetMaxZiplistEntries {number} 
   @return {RedisRunner}
   */
  this.zsetMaxZiplistEntries = function(zsetMaxZiplistEntries) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["zsetMaxZiplistEntries(long)"](zsetMaxZiplistEntries);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param zsetMaxZiplistValue {number} 
   @return {RedisRunner}
   */
  this.zsetMaxZiplistValue = function(zsetMaxZiplistValue) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] ==='number') {
      j_redisRunner["zsetMaxZiplistValue(long)"](zsetMaxZiplistValue);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_redisRunner;
};

/**

 @memberof module:vertx-redisson-test-js/redis_runner

 @return {RedisRunner}
 */
RedisRunner.newInstance = function() {
  var __args = arguments;
  if (__args.length === 0) {
    return utils.convReturnVertxGen(JRedisRunner["newInstance()"](), RedisRunner);
  } else throw new TypeError('function invoked with invalid arguments');
};

/**

 @memberof module:vertx-redisson-test-js/redis_runner

 @return {RedisProcess}
 */
RedisRunner.startRedisServerInstance = function() {
  var __args = arguments;
  if (__args.length === 0) {
    return utils.convReturnVertxGen(JRedisRunner["startRedisServerInstance()"](), RedisProcess);
  } else throw new TypeError('function invoked with invalid arguments');
};

/**

 @memberof module:vertx-redisson-test-js/redis_runner

 @return {number}
 */
RedisRunner.shutDownRedisServerInstance = function() {
  var __args = arguments;
  if (__args.length === 0) {
    return JRedisRunner["shutDownRedisServerInstance()"]();
  } else throw new TypeError('function invoked with invalid arguments');
};

/**

 @memberof module:vertx-redisson-test-js/redis_runner

 @return {boolean}
 */
RedisRunner.isRedisServerInstanceRunning = function() {
  var __args = arguments;
  if (__args.length === 0) {
    return JRedisRunner["isRedisServerInstanceRunning()"]();
  } else throw new TypeError('function invoked with invalid arguments');
};

/**

 @memberof module:vertx-redisson-test-js/redis_runner

 @return {RedisProcess}
 */
RedisRunner.getRedisServerInstance = function() {
  var __args = arguments;
  if (__args.length === 0) {
    return utils.convReturnVertxGen(JRedisRunner["getRedisServerInstance()"](), RedisProcess);
  } else throw new TypeError('function invoked with invalid arguments');
};

/**

 @memberof module:vertx-redisson-test-js/redis_runner

 @return {string}
 */
RedisRunner.getRedisServerBindAddressAndPort = function() {
  var __args = arguments;
  if (__args.length === 0) {
    return JRedisRunner["getRedisServerBindAddressAndPort()"]();
  } else throw new TypeError('function invoked with invalid arguments');
};

// We export the Constructor function
module.exports = RedisRunner;