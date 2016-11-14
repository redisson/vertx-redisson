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

import io.vertx.codegen.annotations.VertxGen;

/**
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@VertxGen
public enum RedisOptions {

    BINARY_PATH, DAEMONIZE, PIDFILE, PORT, TCP_BACKLOG, BIND(true), UNIXSOCKET, UNIXSOCKETPERM, TIMEOUT, TCP_KEEPALIVE, LOGLEVEL, LOGFILE, SYSLOG_ENABLED, SYSLOG_IDENT, SYSLOG_FACILITY, DATABASES, SAVE(true), STOP_WRITES_ON_BGSAVE_ERROR, RDBCOMPRESSION, RDBCHECKSUM, DBFILENAME, DIR, SLAVEOF, MASTERAUTH, SLAVE_SERVE_STALE_DATA, SLAVE_READ_ONLY, REPL_DISKLESS_SYNC, REPL_DISKLESS_SYNC_DELAY, REPL_PING_SLAVE_PERIOD, REPL_TIMEOUT, REPL_DISABLE_TCP_NODELAY, REPL_BACKLOG_SIZE, REPL_BACKLOG_TTL, SLAVE_PRIORITY, MIN_SLAVES_TO_WRITE, MIN_SLAVES_MAX_LAG, REQUREPASS, RENAME_COMMAND(true), MAXCLIENTS, MAXMEMORY, MAXMEMORY_POLICY, MAXMEMORY_SAMPLE, APPENDONLY, APPENDFILENAME, APPENDFSYNC, NO_APPENDFSYNC_ON_REWRITE, AUTO_AOF_REWRITE_PERCENTAGE, AUTO_AOF_REWRITE_MIN_SIZE, AOF_LOAD_TRUNCATED, LUA_TIME_LIMIT, CLUSTER_ENABLED, CLUSTER_CONFIG_FILE, CLUSTER_NODE_TIMEOUT, CLUSTER_SLAVE_VALIDITY_FACTOR, CLUSTER_MIGRATION_BARRIER, CLUSTER_REQUIRE_FULL_COVERAGE, SLOWLOG_LOG_SLOWER_THAN, SLOWLOG_MAX_LEN, LATENCY_MONITOR_THRESHOLD, NOFITY_KEYSPACE_EVENTS, HASH_MAX_ZIPLIST_ENTRIES, HASH_MAX_ZIPLIST_VALUE, LIST_MAX_ZIPLIST_ENTRIES, LIST_MAX_ZIPLIST_VALUE, SET_MAX_INTSET_ENTRIES, ZSET_MAX_ZIPLIST_ENTRIES, ZSET_MAX_ZIPLIST_VALUE, HLL_SPARSE_MAX_BYTES, ACTIVEREHASHING, CLIENT_OUTPUT_BUFFER_LIMIT$NORMAL, CLIENT_OUTPUT_BUFFER_LIMIT$SLAVE, CLIENT_OUTPUT_BUFFER_LIMIT$PUBSUB, HZ, AOF_REWRITE_INCREMENTAL_FSYNC;
    private final boolean allowMutiple;

    private RedisOptions() {
        this.allowMutiple = false;
    }

    private RedisOptions(boolean allowMutiple) {
        this.allowMutiple = allowMutiple;
    }

    public boolean isAllowMultiple() {
        return allowMutiple;
    }

}
