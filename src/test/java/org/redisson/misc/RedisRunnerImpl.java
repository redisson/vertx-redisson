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
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.redisson.client.RedisClient;
import org.redisson.client.RedisConnection;
import org.redisson.client.protocol.RedisStrictCommand;
import org.redisson.client.protocol.convertor.VoidReplayConvertor;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
public class RedisRunnerImpl implements RedisRunner {

    private final LinkedHashMap<RedisOptions, String> options = new LinkedHashMap<>();
    private static RedisRunnerImpl.RedisProcessImpl defaultRedisInstance;
    private static int defaultRedisInstanceExitCode;

    private String defaultDir = Paths.get("").toString();
    private boolean nosave = false;
    private boolean randomDir = false;
    private ArrayList<String> bindAddr = new ArrayList<>();
    private int port = 6379;
    private int retryCount = Integer.MAX_VALUE;
    private boolean randomPort = false;

    {
        this.options.put(RedisOptions.BINARY_PATH, RedissonRuntimeEnvironment.redisBinaryPath);
    }

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
    @Override
    public RedisProcessImpl runWithConfigFile(String configPath) {
        URL resource = RedisRunnerImpl.class.getResource(configPath);
        return runWithOptions(new RedisRunnerImpl(), RedissonRuntimeEnvironment.redisBinaryPath, resource.getFile());
    }

    private RedisProcessImpl runWithOptions(RedisRunnerImpl runner, String... options) {
        try {
            List<String> launchOptions = Arrays.stream(options)
                    .map(x -> Arrays.asList(x.split(" "))).flatMap(x -> x.stream())
                    .collect(Collectors.toList());
            System.out.println("REDIS LAUNCH OPTIONS: " + Arrays.toString(launchOptions.toArray()));
            ProcessBuilder master = new ProcessBuilder(launchOptions)
                    .redirectErrorStream(true)
                    .directory(new File(RedissonRuntimeEnvironment.tempDir));
            Process p = master.start();
            new Thread(() -> {
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                try {
                    while (p.isAlive() && (line = reader.readLine()) != null && !RedissonRuntimeEnvironment.isTravis) {
                        System.out.println("REDIS PROCESS: " + line);
                    }
                } catch (IOException ex) {
                    System.out.println("Exception: " + ex.getLocalizedMessage());
                }
            }).start();
            Thread.sleep(1500);
            return new RedisProcessImpl(p, runner);
        } catch (Exception exception) {
            throw new FailedToStartRedisException(exception);
        }
    }

    @Override
    public RedisProcessImpl run() {
        if (!options.containsKey(RedisOptions.DIR)) {
            addConfigOption(RedisOptions.DIR, defaultDir);
        }
        if (randomPort) {
            for (int i = 0; i < retryCount; i++) {
                this.port = findFreePort();
                addConfigOption(RedisOptions.PORT, this.port);
                return runAndCheck();
            }
            throw new FailedToStartRedisException();
        } else {
            return runAndCheck();
        }
    }

    @Override
    public RedisProcessImpl runAndCheck() {
        RedisProcessImpl rp = runWithOptions(this, options.values().toArray(new String[0]));
        try {
            if (rp.redisProcess.waitFor(1000, TimeUnit.MILLISECONDS)) {
                throw new FailedToStartRedisException();
            }
        } catch (InterruptedException ex) {
            throw new FailedToStartRedisException(ex);
        }
        return rp;
    }

    private void addConfigOption(RedisOptions option, Object... args) {
        StringBuilder sb = new StringBuilder("--")
                .append(option.toString()
                        .replaceAll("_", "-")
                        .replaceAll("\\$", " ")
                        .toLowerCase())
                .append(" ")
                .append(Arrays.stream(args).map(Object::toString)
                        .collect(Collectors.joining(" ")));
        this.options.put(option,
                option.isAllowMultiple()
                        ? sb.insert(0, this.options.getOrDefault(option, "")).toString()
                        : sb.toString());
    }

    private String convertBoolean(boolean b) {
        return b ? "yes" : "no";
    }

    @Override
    public RedisRunnerImpl daemonize(boolean daemonize) {
        addConfigOption(RedisOptions.DAEMONIZE, convertBoolean(daemonize));
        return this;
    }

    @Override
    public RedisRunnerImpl pidfile(String pidfile) {
        addConfigOption(RedisOptions.PIDFILE, pidfile);
        return this;
    }

    @Override
    public RedisRunnerImpl port(int port) {
        this.port = port;
        this.randomPort = false;
        addConfigOption(RedisOptions.PORT, port);
        return this;
    }

    @Override
    public RedisRunnerImpl randomPort() {
        return randomPort(Integer.MAX_VALUE);
    }

    @Override
    public RedisRunnerImpl randomPort(int retryCount) {
        this.randomPort = true;
        this.retryCount = retryCount;
        options.remove(RedisOptions.PORT);
        return this;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public RedisRunnerImpl tcpBacklog(long tcpBacklog) {
        addConfigOption(RedisOptions.TCP_BACKLOG, tcpBacklog);
        return this;
    }

    @Override
    public RedisRunnerImpl bind(String bind) {
        this.bindAddr.add(bind);
        addConfigOption(RedisOptions.BIND, bind);
        return this;
    }

    @Override
    public ArrayList<String> getBindAddr() {
        return this.bindAddr;
    }

    @Override
    public RedisRunnerImpl unixsocket(String unixsocket) {
        addConfigOption(RedisOptions.UNIXSOCKET, unixsocket);
        return this;
    }

    @Override
    public RedisRunnerImpl unixsocketperm(int unixsocketperm) {
        addConfigOption(RedisOptions.UNIXSOCKETPERM, unixsocketperm);
        return this;
    }

    @Override
    public RedisRunnerImpl timeout(long timeout) {
        addConfigOption(RedisOptions.TIMEOUT, timeout);
        return this;
    }

    @Override
    public RedisRunnerImpl tcpKeepalive(long tcpKeepalive) {
        addConfigOption(RedisOptions.TCP_KEEPALIVE, tcpKeepalive);
        return this;
    }

    @Override
    public RedisRunnerImpl loglevel(LogLevelOptions loglevel) {
        addConfigOption(RedisOptions.LOGLEVEL, loglevel.toString());
        return this;
    }

    @Override
    public RedisRunnerImpl logfile(String logfile) {
        addConfigOption(RedisOptions.LOGLEVEL, logfile);
        return this;
    }

    @Override
    public RedisRunnerImpl syslogEnabled(boolean syslogEnabled) {
        addConfigOption(RedisOptions.SYSLOG_ENABLED, convertBoolean(syslogEnabled));
        return this;
    }

    @Override
    public RedisRunnerImpl syslogIdent(String syslogIdent) {
        addConfigOption(RedisOptions.SYSLOG_IDENT, syslogIdent);
        return this;
    }

    @Override
    public RedisRunnerImpl syslogFacility(SyslogFacilityOptions syslogFacility) {
        addConfigOption(RedisOptions.SYSLOG_IDENT, syslogFacility.toString());
        return this;
    }

    @Override
    public RedisRunnerImpl databases(int databases) {
        addConfigOption(RedisOptions.DATABASES, databases);
        return this;
    }

    @Override
    public RedisRunnerImpl save(long seconds, long changes) {
        if (!nosave) {
            addConfigOption(RedisOptions.SAVE, seconds, changes);
        }
        return this;
    }

    /**
     * Phantom option
     *
     * @return RedisRunnerImpl
     */
    @Override
    public RedisRunnerImpl nosave() {
        this.nosave = true;
        options.remove(RedisOptions.SAVE);
        addConfigOption(RedisOptions.SAVE, "''");
        return this;
    }

    @Override
    public RedisRunnerImpl stopWritesOnBgsaveError(boolean stopWritesOnBgsaveError) {
        addConfigOption(RedisOptions.STOP_WRITES_ON_BGSAVE_ERROR, convertBoolean(stopWritesOnBgsaveError));
        return this;
    }

    @Override
    public RedisRunnerImpl rdbcompression(boolean rdbcompression) {
        addConfigOption(RedisOptions.RDBCOMPRESSION, convertBoolean(rdbcompression));
        return this;
    }

    @Override
    public RedisRunnerImpl rdbchecksum(boolean rdbchecksum) {
        addConfigOption(RedisOptions.RDBCHECKSUM, convertBoolean(rdbchecksum));
        return this;
    }

    @Override
    public RedisRunnerImpl dbfilename(String dbfilename) {
        addConfigOption(RedisOptions.DBFILENAME, dbfilename);
        return this;
    }

    @Override
    public RedisRunnerImpl dir(String dir) {
        if (!randomDir) {
            addConfigOption(RedisOptions.DIR, dir);
        }
        return this;
    }

    /**
     * Phantom option
     *
     * @return RedisRunnerImpl
     */
    @Override
    public RedisRunnerImpl randomDir() {
        this.randomDir = true;
        options.remove(RedisOptions.DIR);
        makeRandomDefaultDir();
        addConfigOption(RedisOptions.DIR, defaultDir);
        return this;
    }

    @Override
    public RedisRunnerImpl slaveof(String masterip, int port) {
        addConfigOption(RedisOptions.SLAVEOF, masterip, port);
        return this;
    }

    @Override
    public RedisRunnerImpl masterauth(String masterauth) {
        addConfigOption(RedisOptions.MASTERAUTH, masterauth);
        return this;
    }

    @Override
    public RedisRunnerImpl slaveServeStaleData(boolean slaveServeStaleData) {
        addConfigOption(RedisOptions.SLAVE_SERVE_STALE_DATA, convertBoolean(slaveServeStaleData));
        return this;
    }

    @Override
    public RedisRunnerImpl slaveReadOnly(boolean slaveReadOnly) {
        addConfigOption(RedisOptions.SLAVE_READ_ONLY, convertBoolean(slaveReadOnly));
        return this;
    }

    @Override
    public RedisRunnerImpl replDisklessSync(boolean replDisklessSync) {
        addConfigOption(RedisOptions.REPL_DISKLESS_SYNC, convertBoolean(replDisklessSync));
        return this;
    }

    @Override
    public RedisRunnerImpl replDisklessSyncDelay(long replDisklessSyncDelay) {
        addConfigOption(RedisOptions.REPL_DISKLESS_SYNC_DELAY, replDisklessSyncDelay);
        return this;
    }

    @Override
    public RedisRunnerImpl replPingSlavePeriod(long replPingSlavePeriod) {
        addConfigOption(RedisOptions.REPL_PING_SLAVE_PERIOD, replPingSlavePeriod);
        return this;
    }

    @Override
    public RedisRunnerImpl replTimeout(long replTimeout) {
        addConfigOption(RedisOptions.REPL_TIMEOUT, replTimeout);
        return this;
    }

    @Override
    public RedisRunnerImpl replDisableTcpNodelay(boolean replDisableTcpNodelay) {
        addConfigOption(RedisOptions.REPL_DISABLE_TCP_NODELAY, convertBoolean(replDisableTcpNodelay));
        return this;
    }

    @Override
    public RedisRunnerImpl replBacklogSize(String replBacklogSize) {
        addConfigOption(RedisOptions.REPL_BACKLOG_SIZE, replBacklogSize);
        return this;
    }

    @Override
    public RedisRunnerImpl replBacklogTtl(long replBacklogTtl) {
        addConfigOption(RedisOptions.REPL_BACKLOG_TTL, replBacklogTtl);
        return this;
    }

    @Override
    public RedisRunnerImpl slavePriority(long slavePriority) {
        addConfigOption(RedisOptions.SLAVE_PRIORITY, slavePriority);
        return this;
    }

    @Override
    public RedisRunnerImpl minSlaveToWrite(long minSlaveToWrite) {
        addConfigOption(RedisOptions.MIN_SLAVES_TO_WRITE, minSlaveToWrite);
        return this;
    }

    @Override
    public RedisRunnerImpl minSlaveMaxLag(long minSlaveMaxLag) {
        addConfigOption(RedisOptions.MIN_SLAVES_MAX_LAG, minSlaveMaxLag);
        return this;
    }

    @Override
    public RedisRunnerImpl requirepass(String requirepass) {
        addConfigOption(RedisOptions.REQUREPASS, requirepass);
        return this;
    }

    @Override
    public RedisRunnerImpl renameCommand(String renameCommand) {
        addConfigOption(RedisOptions.RENAME_COMMAND, renameCommand);
        return this;
    }

    @Override
    public RedisRunnerImpl maxclients(long maxclients) {
        addConfigOption(RedisOptions.MAXCLIENTS, maxclients);
        return this;
    }

    @Override
    public RedisRunnerImpl maxmemory(String maxmemory) {
        addConfigOption(RedisOptions.MAXMEMORY, maxmemory);
        return this;
    }

    @Override
    public RedisRunnerImpl maxmemoryPolicy(MaxMemoryPolicyOptions maxmemoryPolicy) {
        addConfigOption(RedisOptions.MAXMEMORY, maxmemoryPolicy.toString());
        return this;
    }

    @Override
    public RedisRunnerImpl maxmemorySamples(long maxmemorySamples) {
        addConfigOption(RedisOptions.MAXMEMORY, maxmemorySamples);
        return this;
    }

    @Override
    public RedisRunnerImpl appendonly(boolean appendonly) {
        addConfigOption(RedisOptions.APPENDONLY, convertBoolean(appendonly));
        return this;
    }

    @Override
    public RedisRunnerImpl appendfilename(String appendfilename) {
        addConfigOption(RedisOptions.APPENDFILENAME, appendfilename);
        return this;
    }

    @Override
    public RedisRunnerImpl appendfsync(AppendFsyncModeOptions appendfsync) {
        addConfigOption(RedisOptions.APPENDFSYNC, appendfsync.toString());
        return this;
    }

    @Override
    public RedisRunnerImpl noAppendfsyncOnRewrite(boolean noAppendfsyncOnRewrite) {
        addConfigOption(RedisOptions.NO_APPENDFSYNC_ON_REWRITE, convertBoolean(noAppendfsyncOnRewrite));
        return this;
    }

    @Override
    public RedisRunnerImpl autoAofRewritePercentage(int autoAofRewritePercentage) {
        addConfigOption(RedisOptions.AUTO_AOF_REWRITE_PERCENTAGE, autoAofRewritePercentage);
        return this;
    }

    @Override
    public RedisRunnerImpl autoAofRewriteMinSize(String autoAofRewriteMinSize) {
        addConfigOption(RedisOptions.AUTO_AOF_REWRITE_MIN_SIZE, autoAofRewriteMinSize);
        return this;
    }

    @Override
    public RedisRunnerImpl aofLoadTruncated(boolean aofLoadTruncated) {
        addConfigOption(RedisOptions.AOF_LOAD_TRUNCATED, convertBoolean(aofLoadTruncated));
        return this;
    }

    @Override
    public RedisRunnerImpl luaTimeLimit(long luaTimeLimit) {
        addConfigOption(RedisOptions.AOF_LOAD_TRUNCATED, luaTimeLimit);
        return this;
    }

    @Override
    public RedisRunnerImpl clusterEnabled(boolean clusterEnabled) {
        addConfigOption(RedisOptions.CLUSTER_ENABLED, convertBoolean(clusterEnabled));
        return this;
    }

    @Override
    public RedisRunnerImpl clusterConfigFile(String clusterConfigFile) {
        addConfigOption(RedisOptions.CLUSTER_CONFIG_FILE, clusterConfigFile);
        return this;
    }

    @Override
    public RedisRunnerImpl clusterNodeTimeout(long clusterNodeTimeout) {
        addConfigOption(RedisOptions.CLUSTER_NODE_TIMEOUT, clusterNodeTimeout);
        return this;
    }

    @Override
    public RedisRunnerImpl clusterSlaveValidityFactor(long clusterSlaveValidityFactor) {
        addConfigOption(RedisOptions.CLUSTER_SLAVE_VALIDITY_FACTOR, clusterSlaveValidityFactor);
        return this;
    }

    @Override
    public RedisRunnerImpl clusterMigrationBarrier(long clusterMigrationBarrier) {
        addConfigOption(RedisOptions.CLUSTER_MIGRATION_BARRIER, clusterMigrationBarrier);
        return this;
    }

    @Override
    public RedisRunnerImpl clusterRequireFullCoverage(boolean clusterRequireFullCoverage) {
        addConfigOption(RedisOptions.CLUSTER_REQUIRE_FULL_COVERAGE, convertBoolean(clusterRequireFullCoverage));
        return this;
    }

    @Override
    public RedisRunnerImpl slowlogLogSlowerThan(long slowlogLogSlowerThan) {
        addConfigOption(RedisOptions.SLOWLOG_LOG_SLOWER_THAN, slowlogLogSlowerThan);
        return this;
    }

    @Override
    public RedisRunnerImpl slowlogMaxLen(long slowlogMaxLen) {
        addConfigOption(RedisOptions.SLOWLOG_MAX_LEN, slowlogMaxLen);
        return this;
    }

    @Override
    public RedisRunnerImpl latencyMonitorThreshold(long latencyMonitorThreshold) {
        addConfigOption(RedisOptions.LATENCY_MONITOR_THRESHOLD, latencyMonitorThreshold);
        return this;
    }

    @Override
    public RedisRunnerImpl notifyKeyspaceEvents(KeyspaceEventsOptions notifyKeyspaceEvents) {
        String existing = this.options.getOrDefault(RedisOptions.CLUSTER_CONFIG_FILE, "");
        addConfigOption(RedisOptions.CLUSTER_CONFIG_FILE,
                existing.contains(notifyKeyspaceEvents.toString())
                        ? existing
                        : (existing + notifyKeyspaceEvents.toString()));
        return this;
    }

    @Override
    public RedisRunnerImpl hashMaxZiplistEntries(long hashMaxZiplistEntries) {
        addConfigOption(RedisOptions.HASH_MAX_ZIPLIST_ENTRIES, hashMaxZiplistEntries);
        return this;
    }

    @Override
    public RedisRunnerImpl hashMaxZiplistValue(long hashMaxZiplistValue) {
        addConfigOption(RedisOptions.HASH_MAX_ZIPLIST_VALUE, hashMaxZiplistValue);
        return this;
    }

    @Override
    public RedisRunnerImpl listMaxZiplistEntries(long listMaxZiplistEntries) {
        addConfigOption(RedisOptions.LIST_MAX_ZIPLIST_ENTRIES, listMaxZiplistEntries);
        return this;
    }

    @Override
    public RedisRunnerImpl listMaxZiplistValue(long listMaxZiplistValue) {
        addConfigOption(RedisOptions.LIST_MAX_ZIPLIST_VALUE, listMaxZiplistValue);
        return this;
    }

    @Override
    public RedisRunnerImpl setMaxIntsetEntries(long setMaxIntsetEntries) {
        addConfigOption(RedisOptions.SET_MAX_INTSET_ENTRIES, setMaxIntsetEntries);
        return this;
    }

    @Override
    public RedisRunnerImpl zsetMaxZiplistEntries(long zsetMaxZiplistEntries) {
        addConfigOption(RedisOptions.ZSET_MAX_ZIPLIST_ENTRIES, zsetMaxZiplistEntries);
        return this;
    }

    @Override
    public RedisRunnerImpl zsetMaxZiplistValue(long zsetMaxZiplistValue) {
        addConfigOption(RedisOptions.ZSET_MAX_ZIPLIST_VALUE, zsetMaxZiplistValue);
        return this;
    }

    @Override
    public RedisRunnerImpl hllSparseMaxBytes(long hllSparseMaxBytes) {
        addConfigOption(RedisOptions.HLL_SPARSE_MAX_BYTES, hllSparseMaxBytes);
        return this;
    }

    @Override
    public RedisRunnerImpl activerehashing(boolean activerehashing) {
        addConfigOption(RedisOptions.ACTIVEREHASHING, convertBoolean(activerehashing));
        return this;
    }

    @Override
    public RedisRunnerImpl clientOutputBufferLimit$Normal(String hardLimit, String softLimit, long softSeconds) {
        addConfigOption(RedisOptions.CLIENT_OUTPUT_BUFFER_LIMIT$NORMAL, hardLimit, softLimit, softSeconds);
        return this;
    }

    @Override
    public RedisRunnerImpl clientOutputBufferLimit$Slave(String hardLimit, String softLimit, long softSeconds) {
        addConfigOption(RedisOptions.CLIENT_OUTPUT_BUFFER_LIMIT$SLAVE, hardLimit, softLimit, softSeconds);
        return this;
    }

    @Override
    public RedisRunnerImpl clientOutputBufferLimit$Pubsub(String hardLimit, String softLimit, long softSeconds) {
        addConfigOption(RedisOptions.CLIENT_OUTPUT_BUFFER_LIMIT$PUBSUB, hardLimit, softLimit, softSeconds);
        return this;
    }

    @Override
    public RedisRunnerImpl hz(int hz) {
        addConfigOption(RedisOptions.HZ, hz);
        return this;
    }

    @Override
    public RedisRunnerImpl aofRewriteIncrementalFsync(boolean aofRewriteIncrementalFsync) {
        addConfigOption(RedisOptions.AOF_REWRITE_INCREMENTAL_FSYNC, convertBoolean(aofRewriteIncrementalFsync));
        return this;
    }

    @Override
    public boolean isRandomDir() {
        return this.randomDir;
    }

    @Override
    public boolean isNosave() {
        return this.nosave;
    }

    @Override
    public String defaultDir() {
        return this.defaultDir;
    }

    @Override
    public String getInitialBindAddr() {
        return bindAddr.size() > 0 ? bindAddr.get(0) : "localhost";
    }

    @Override
    public boolean deleteDBfileDir() {
        File f = new File(defaultDir);
        if (f.exists()) {
            System.out.println("REDIS RUNNER: Deleting directory " + defaultDir);
            return f.delete();
        }
        return false;
    }

    private void makeRandomDefaultDir() {
        File f = new File(RedissonRuntimeEnvironment.tempDir + "/" + UUID.randomUUID());
        if (f.exists()) {
            makeRandomDefaultDir();
        } else {
            System.out.println("REDIS RUNNER: Making directory " + f.getAbsolutePath());
            f.mkdirs();
            this.defaultDir = f.getAbsolutePath();
        }
    }

    public final class RedisProcessImpl implements RedisProcess {

        private final Process redisProcess;
        private final RedisRunnerImpl runner;
        private RedisVersion redisVersion;

        private RedisProcessImpl(Process redisProcess, RedisRunnerImpl runner) {
            this.redisProcess = redisProcess;
            this.runner = runner;
        }

        @Override
        public int stop() {
            try {
                if (runner.isNosave() && !runner.isRandomDir()) {
                    RedisClient c = createDefaultRedisClientInstance();
                    RedisConnection connection = c.connect();
                    connection.async(new RedisStrictCommand<Void>("SHUTDOWN", "NOSAVE", new VoidReplayConvertor()))
                            .await(3, TimeUnit.SECONDS);
                    c.shutdown();
                    connection.closeAsync().syncUninterruptibly();
                }
                redisProcess.destroy();
                int exitCode = redisProcess.isAlive() ? redisProcess.waitFor() : redisProcess.exitValue();
                if (runner.isRandomDir()) {
                    runner.deleteDBfileDir();
                }
                return exitCode == 1 && RedissonRuntimeEnvironment.isWindows ? 0 : exitCode;
            } catch (Exception e) {
                throw new FailedToStopRedisException(e);
            }
        }

        @GenIgnore
        @Override
        public Process getRedisProcess() {
            return redisProcess;
        }

        @GenIgnore
        @Override
        public RedisClient createRedisClientInstance() {
            if (redisProcess.isAlive()) {
                return new RedisClient(runner.getInitialBindAddr(), runner.getPort());
            }
            throw new IllegalStateException("Redis server instance is not running.");
        }

        @Override
        public String getRedisVersion() {
            if (redisVersion == null) {
                redisVersion = new RedisVersion(createRedisClientInstance().serverInfo().get("redis_version"));
            }
            return redisVersion.getFullVersion();
        }

        @Override
        public int getRedisServerPort() {
            return runner.getPort();
        }

        @Override
        public String getRedisServerBindAddress() {
            return runner.getInitialBindAddr();
        }

        @Override
        public String getRedisServerAddressAndPort() {
            return getRedisServerBindAddress() + ":" + getRedisServerPort();
        }
    }

    public static RedisRunnerImpl.RedisProcessImpl startDefaultRedisServerInstance() {
        if (defaultRedisInstance == null) {
            System.out.println("REDIS RUNNER: Starting up default instance...");
            defaultRedisInstance = new RedisRunnerImpl().nosave().randomDir().randomPort().run();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                shutDownDefaultRedisServerInstance();
            }));
        }
        return defaultRedisInstance;
    }

    public static int shutDownDefaultRedisServerInstance() {
        if (defaultRedisInstance != null) {
            System.out.println("REDIS RUNNER: Shutting down default instance...");
            try {
                defaultRedisInstanceExitCode = defaultRedisInstance.stop();
            } finally {
                defaultRedisInstance = null;
            }
        } else {
            System.out.println("REDIS RUNNER: Default instance is already down with an exit code " + defaultRedisInstanceExitCode);
        }
        return defaultRedisInstanceExitCode;
    }

    public static boolean isDefaultRedisServerInstanceRunning() {
        return defaultRedisInstance != null && defaultRedisInstance.redisProcess.isAlive();
    }

    @GenIgnore
    public static RedisClient createDefaultRedisClientInstance() {
        return defaultRedisInstance.createRedisClientInstance();
    }

    public static RedisProcess getDefaultRedisServerInstance() {
        return defaultRedisInstance;
    }

    public static String getDefaultRedisServerBindAddressAndPort() {
        return defaultRedisInstance.getRedisServerBindAddress()
                + ":"
                + defaultRedisInstance.getRedisServerPort();
    }

    public static int findFreePort() {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(0);
            socket.setReuseAddress(true);
            int port = socket.getLocalPort();
            try {
                socket.close();
            } catch (IOException e) {
                // Ignore IOException on close()
            }
            return port;
        } catch (IOException e) {
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
        throw new IllegalStateException("Could not find a free TCP/IP port.");
    }

    public static class FailedToStartRedisException extends RuntimeException {

        private FailedToStartRedisException() {
        }

        private FailedToStartRedisException(Throwable e) {
            super(e);
        }
    }

    public static class FailedToStopRedisException extends RuntimeException {

        private FailedToStopRedisException() {
        }

        private FailedToStopRedisException(Throwable e) {
            super(e);
        }
    }
}
