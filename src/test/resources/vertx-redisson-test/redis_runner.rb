require 'vertx-redisson-test/redis_process'
require 'vertx-redisson-test/redis_logger'
require 'vertx/util/utils.rb'
# Generated from org.redisson.misc.RedisRunner
module VertxRedissonTest
  class RedisRunner
    # @private
    # @param j_del [::VertxRedissonTest::RedisRunner] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxRedissonTest::RedisRunner] the underlying java delegate
    def j_del
      @j_del
    end
    # @return [::VertxRedissonTest::RedisRunner]
    def self.new_instance
      if !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::OrgRedissonMisc::RedisRunner.java_method(:newInstance, []).call(),::VertxRedissonTest::RedisRunner)
      end
      raise ArgumentError, "Invalid arguments when calling new_instance()"
    end
    # @param [String] redisBinary 
    # @return [self]
    def redis_binary(redisBinary=nil)
      if redisBinary.class == String && !block_given?
        @j_del.java_method(:redisBinary, [Java::java.lang.String.java_class]).call(redisBinary)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling redis_binary(redisBinary)"
    end
    # @param [::VertxRedissonTest::RedisLogger] logger 
    # @return [self]
    def logger(logger=nil)
      if logger.class.method_defined?(:j_del) && !block_given?
        @j_del.java_method(:logger, [Java::OrgRedissonMisc::RedisLogger.java_class]).call(logger.j_del)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling logger(logger)"
    end
    # @param [true,false] activerehashing 
    # @return [self]
    def activerehashing(activerehashing=nil)
      if (activerehashing.class == TrueClass || activerehashing.class == FalseClass) && !block_given?
        @j_del.java_method(:activerehashing, [Java::boolean.java_class]).call(activerehashing)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling activerehashing(activerehashing)"
    end
    # @param [true,false] aofLoadTruncated 
    # @return [self]
    def aof_load_truncated(aofLoadTruncated=nil)
      if (aofLoadTruncated.class == TrueClass || aofLoadTruncated.class == FalseClass) && !block_given?
        @j_del.java_method(:aofLoadTruncated, [Java::boolean.java_class]).call(aofLoadTruncated)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling aof_load_truncated(aofLoadTruncated)"
    end
    # @param [true,false] aofRewriteIncrementalFsync 
    # @return [self]
    def aof_rewrite_incremental_fsync(aofRewriteIncrementalFsync=nil)
      if (aofRewriteIncrementalFsync.class == TrueClass || aofRewriteIncrementalFsync.class == FalseClass) && !block_given?
        @j_del.java_method(:aofRewriteIncrementalFsync, [Java::boolean.java_class]).call(aofRewriteIncrementalFsync)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling aof_rewrite_incremental_fsync(aofRewriteIncrementalFsync)"
    end
    # @param [String] appendfilename 
    # @return [self]
    def appendfilename(appendfilename=nil)
      if appendfilename.class == String && !block_given?
        @j_del.java_method(:appendfilename, [Java::java.lang.String.java_class]).call(appendfilename)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling appendfilename(appendfilename)"
    end
    # @param [:ALWAYS,:EVERYSEC,:NO] appendfsync 
    # @return [self]
    def appendfsync(appendfsync=nil)
      if appendfsync.class == Symbol && !block_given?
        @j_del.java_method(:appendfsync, [Java::OrgRedissonMisc::AppendFsyncModeOptions.java_class]).call(Java::OrgRedissonMisc::AppendFsyncModeOptions.valueOf(appendfsync))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling appendfsync(appendfsync)"
    end
    # @param [true,false] appendonly 
    # @return [self]
    def appendonly(appendonly=nil)
      if (appendonly.class == TrueClass || appendonly.class == FalseClass) && !block_given?
        @j_del.java_method(:appendonly, [Java::boolean.java_class]).call(appendonly)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling appendonly(appendonly)"
    end
    # @param [String] autoAofRewriteMinSize 
    # @return [self]
    def auto_aof_rewrite_min_size(autoAofRewriteMinSize=nil)
      if autoAofRewriteMinSize.class == String && !block_given?
        @j_del.java_method(:autoAofRewriteMinSize, [Java::java.lang.String.java_class]).call(autoAofRewriteMinSize)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling auto_aof_rewrite_min_size(autoAofRewriteMinSize)"
    end
    # @param [Fixnum] autoAofRewritePercentage 
    # @return [self]
    def auto_aof_rewrite_percentage(autoAofRewritePercentage=nil)
      if autoAofRewritePercentage.class == Fixnum && !block_given?
        @j_del.java_method(:autoAofRewritePercentage, [Java::int.java_class]).call(autoAofRewritePercentage)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling auto_aof_rewrite_percentage(autoAofRewritePercentage)"
    end
    # @param [String] bind 
    # @return [self]
    def bind(bind=nil)
      if bind.class == String && !block_given?
        @j_del.java_method(:bind, [Java::java.lang.String.java_class]).call(bind)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling bind(bind)"
    end
    # @param [String] hardLimit 
    # @param [String] softLimit 
    # @param [Fixnum] softSeconds 
    # @return [self]
    def client_output_buffer_limit$_normal(hardLimit=nil,softLimit=nil,softSeconds=nil)
      if hardLimit.class == String && softLimit.class == String && softSeconds.class == Fixnum && !block_given?
        @j_del.java_method(:clientOutputBufferLimit$Normal, [Java::java.lang.String.java_class,Java::java.lang.String.java_class,Java::long.java_class]).call(hardLimit,softLimit,softSeconds)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling client_output_buffer_limit$_normal(hardLimit,softLimit,softSeconds)"
    end
    # @param [String] hardLimit 
    # @param [String] softLimit 
    # @param [Fixnum] softSeconds 
    # @return [self]
    def client_output_buffer_limit$_pubsub(hardLimit=nil,softLimit=nil,softSeconds=nil)
      if hardLimit.class == String && softLimit.class == String && softSeconds.class == Fixnum && !block_given?
        @j_del.java_method(:clientOutputBufferLimit$Pubsub, [Java::java.lang.String.java_class,Java::java.lang.String.java_class,Java::long.java_class]).call(hardLimit,softLimit,softSeconds)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling client_output_buffer_limit$_pubsub(hardLimit,softLimit,softSeconds)"
    end
    # @param [String] hardLimit 
    # @param [String] softLimit 
    # @param [Fixnum] softSeconds 
    # @return [self]
    def client_output_buffer_limit$_slave(hardLimit=nil,softLimit=nil,softSeconds=nil)
      if hardLimit.class == String && softLimit.class == String && softSeconds.class == Fixnum && !block_given?
        @j_del.java_method(:clientOutputBufferLimit$Slave, [Java::java.lang.String.java_class,Java::java.lang.String.java_class,Java::long.java_class]).call(hardLimit,softLimit,softSeconds)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling client_output_buffer_limit$_slave(hardLimit,softLimit,softSeconds)"
    end
    # @param [String] clusterConfigFile 
    # @return [self]
    def cluster_config_file(clusterConfigFile=nil)
      if clusterConfigFile.class == String && !block_given?
        @j_del.java_method(:clusterConfigFile, [Java::java.lang.String.java_class]).call(clusterConfigFile)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling cluster_config_file(clusterConfigFile)"
    end
    # @param [true,false] clusterEnabled 
    # @return [self]
    def cluster_enabled(clusterEnabled=nil)
      if (clusterEnabled.class == TrueClass || clusterEnabled.class == FalseClass) && !block_given?
        @j_del.java_method(:clusterEnabled, [Java::boolean.java_class]).call(clusterEnabled)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling cluster_enabled(clusterEnabled)"
    end
    # @param [Fixnum] clusterMigrationBarrier 
    # @return [self]
    def cluster_migration_barrier(clusterMigrationBarrier=nil)
      if clusterMigrationBarrier.class == Fixnum && !block_given?
        @j_del.java_method(:clusterMigrationBarrier, [Java::long.java_class]).call(clusterMigrationBarrier)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling cluster_migration_barrier(clusterMigrationBarrier)"
    end
    # @param [Fixnum] clusterNodeTimeout 
    # @return [self]
    def cluster_node_timeout(clusterNodeTimeout=nil)
      if clusterNodeTimeout.class == Fixnum && !block_given?
        @j_del.java_method(:clusterNodeTimeout, [Java::long.java_class]).call(clusterNodeTimeout)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling cluster_node_timeout(clusterNodeTimeout)"
    end
    # @param [true,false] clusterRequireFullCoverage 
    # @return [self]
    def cluster_require_full_coverage(clusterRequireFullCoverage=nil)
      if (clusterRequireFullCoverage.class == TrueClass || clusterRequireFullCoverage.class == FalseClass) && !block_given?
        @j_del.java_method(:clusterRequireFullCoverage, [Java::boolean.java_class]).call(clusterRequireFullCoverage)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling cluster_require_full_coverage(clusterRequireFullCoverage)"
    end
    # @param [Fixnum] clusterSlaveValidityFactor 
    # @return [self]
    def cluster_slave_validity_factor(clusterSlaveValidityFactor=nil)
      if clusterSlaveValidityFactor.class == Fixnum && !block_given?
        @j_del.java_method(:clusterSlaveValidityFactor, [Java::long.java_class]).call(clusterSlaveValidityFactor)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling cluster_slave_validity_factor(clusterSlaveValidityFactor)"
    end
    # @param [true,false] daemonize 
    # @return [self]
    def daemonize(daemonize=nil)
      if (daemonize.class == TrueClass || daemonize.class == FalseClass) && !block_given?
        @j_del.java_method(:daemonize, [Java::boolean.java_class]).call(daemonize)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling daemonize(daemonize)"
    end
    # @param [Fixnum] databases 
    # @return [self]
    def databases(databases=nil)
      if databases.class == Fixnum && !block_given?
        @j_del.java_method(:databases, [Java::int.java_class]).call(databases)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling databases(databases)"
    end
    # @param [String] dbfilename 
    # @return [self]
    def dbfilename(dbfilename=nil)
      if dbfilename.class == String && !block_given?
        @j_del.java_method(:dbfilename, [Java::java.lang.String.java_class]).call(dbfilename)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling dbfilename(dbfilename)"
    end
    # @return [String]
    def default_dir
      if !block_given?
        return @j_del.java_method(:defaultDir, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling default_dir()"
    end
    # @return [true,false]
    def delete_d_bfile_dir?
      if !block_given?
        return @j_del.java_method(:deleteDBfileDir, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling delete_d_bfile_dir?()"
    end
    # @param [String] dir 
    # @return [self]
    def dir(dir=nil)
      if dir.class == String && !block_given?
        @j_del.java_method(:dir, [Java::java.lang.String.java_class]).call(dir)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling dir(dir)"
    end
    # @return [Array<String>]
    def get_bind_addr
      if !block_given?
        return @j_del.java_method(:getBindAddr, []).call().to_a.map { |elt| elt }
      end
      raise ArgumentError, "Invalid arguments when calling get_bind_addr()"
    end
    # @return [String]
    def get_initial_bind_addr
      if !block_given?
        return @j_del.java_method(:getInitialBindAddr, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_initial_bind_addr()"
    end
    # @return [Fixnum]
    def get_port
      if !block_given?
        return @j_del.java_method(:getPort, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_port()"
    end
    # @param [Fixnum] hashMaxZiplistEntries 
    # @return [self]
    def hash_max_ziplist_entries(hashMaxZiplistEntries=nil)
      if hashMaxZiplistEntries.class == Fixnum && !block_given?
        @j_del.java_method(:hashMaxZiplistEntries, [Java::long.java_class]).call(hashMaxZiplistEntries)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling hash_max_ziplist_entries(hashMaxZiplistEntries)"
    end
    # @param [Fixnum] hashMaxZiplistValue 
    # @return [self]
    def hash_max_ziplist_value(hashMaxZiplistValue=nil)
      if hashMaxZiplistValue.class == Fixnum && !block_given?
        @j_del.java_method(:hashMaxZiplistValue, [Java::long.java_class]).call(hashMaxZiplistValue)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling hash_max_ziplist_value(hashMaxZiplistValue)"
    end
    # @param [Fixnum] hllSparseMaxBytes 
    # @return [self]
    def hll_sparse_max_bytes(hllSparseMaxBytes=nil)
      if hllSparseMaxBytes.class == Fixnum && !block_given?
        @j_del.java_method(:hllSparseMaxBytes, [Java::long.java_class]).call(hllSparseMaxBytes)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling hll_sparse_max_bytes(hllSparseMaxBytes)"
    end
    # @param [Fixnum] hz 
    # @return [self]
    def hz(hz=nil)
      if hz.class == Fixnum && !block_given?
        @j_del.java_method(:hz, [Java::int.java_class]).call(hz)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling hz(hz)"
    end
    # @return [true,false]
    def nosave?
      if !block_given?
        return @j_del.java_method(:isNosave, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling nosave?()"
    end
    # @return [true,false]
    def random_dir?
      if !block_given?
        return @j_del.java_method(:isRandomDir, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling random_dir?()"
    end
    # @param [Fixnum] latencyMonitorThreshold 
    # @return [self]
    def latency_monitor_threshold(latencyMonitorThreshold=nil)
      if latencyMonitorThreshold.class == Fixnum && !block_given?
        @j_del.java_method(:latencyMonitorThreshold, [Java::long.java_class]).call(latencyMonitorThreshold)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling latency_monitor_threshold(latencyMonitorThreshold)"
    end
    # @param [Fixnum] listMaxZiplistEntries 
    # @return [self]
    def list_max_ziplist_entries(listMaxZiplistEntries=nil)
      if listMaxZiplistEntries.class == Fixnum && !block_given?
        @j_del.java_method(:listMaxZiplistEntries, [Java::long.java_class]).call(listMaxZiplistEntries)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling list_max_ziplist_entries(listMaxZiplistEntries)"
    end
    # @param [Fixnum] listMaxZiplistValue 
    # @return [self]
    def list_max_ziplist_value(listMaxZiplistValue=nil)
      if listMaxZiplistValue.class == Fixnum && !block_given?
        @j_del.java_method(:listMaxZiplistValue, [Java::long.java_class]).call(listMaxZiplistValue)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling list_max_ziplist_value(listMaxZiplistValue)"
    end
    # @param [String] logfile 
    # @return [self]
    def logfile(logfile=nil)
      if logfile.class == String && !block_given?
        @j_del.java_method(:logfile, [Java::java.lang.String.java_class]).call(logfile)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling logfile(logfile)"
    end
    # @param [:DEBUG,:VERBOSE,:NOTICE,:WARNING] loglevel 
    # @return [self]
    def loglevel(loglevel=nil)
      if loglevel.class == Symbol && !block_given?
        @j_del.java_method(:loglevel, [Java::OrgRedissonMisc::LogLevelOptions.java_class]).call(Java::OrgRedissonMisc::LogLevelOptions.valueOf(loglevel))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling loglevel(loglevel)"
    end
    # @param [Fixnum] luaTimeLimit 
    # @return [self]
    def lua_time_limit(luaTimeLimit=nil)
      if luaTimeLimit.class == Fixnum && !block_given?
        @j_del.java_method(:luaTimeLimit, [Java::long.java_class]).call(luaTimeLimit)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling lua_time_limit(luaTimeLimit)"
    end
    # @param [String] masterauth 
    # @return [self]
    def masterauth(masterauth=nil)
      if masterauth.class == String && !block_given?
        @j_del.java_method(:masterauth, [Java::java.lang.String.java_class]).call(masterauth)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling masterauth(masterauth)"
    end
    # @param [Fixnum] maxclients 
    # @return [self]
    def maxclients(maxclients=nil)
      if maxclients.class == Fixnum && !block_given?
        @j_del.java_method(:maxclients, [Java::long.java_class]).call(maxclients)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling maxclients(maxclients)"
    end
    # @param [String] maxmemory 
    # @return [self]
    def maxmemory(maxmemory=nil)
      if maxmemory.class == String && !block_given?
        @j_del.java_method(:maxmemory, [Java::java.lang.String.java_class]).call(maxmemory)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling maxmemory(maxmemory)"
    end
    # @param [:VOLATILE_LRU,:ALLKEYS_LRU,:VOLATILE_RANDOM,:ALLKEYS_RANDOM,:VOLATILE_TTL,:NOEVICTION] maxmemoryPolicy 
    # @return [self]
    def maxmemory_policy(maxmemoryPolicy=nil)
      if maxmemoryPolicy.class == Symbol && !block_given?
        @j_del.java_method(:maxmemoryPolicy, [Java::OrgRedissonMisc::MaxMemoryPolicyOptions.java_class]).call(Java::OrgRedissonMisc::MaxMemoryPolicyOptions.valueOf(maxmemoryPolicy))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling maxmemory_policy(maxmemoryPolicy)"
    end
    # @param [Fixnum] maxmemorySamples 
    # @return [self]
    def maxmemory_samples(maxmemorySamples=nil)
      if maxmemorySamples.class == Fixnum && !block_given?
        @j_del.java_method(:maxmemorySamples, [Java::long.java_class]).call(maxmemorySamples)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling maxmemory_samples(maxmemorySamples)"
    end
    # @param [Fixnum] minSlaveMaxLag 
    # @return [self]
    def min_slave_max_lag(minSlaveMaxLag=nil)
      if minSlaveMaxLag.class == Fixnum && !block_given?
        @j_del.java_method(:minSlaveMaxLag, [Java::long.java_class]).call(minSlaveMaxLag)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling min_slave_max_lag(minSlaveMaxLag)"
    end
    # @param [Fixnum] minSlaveToWrite 
    # @return [self]
    def min_slave_to_write(minSlaveToWrite=nil)
      if minSlaveToWrite.class == Fixnum && !block_given?
        @j_del.java_method(:minSlaveToWrite, [Java::long.java_class]).call(minSlaveToWrite)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling min_slave_to_write(minSlaveToWrite)"
    end
    # @param [true,false] noAppendfsyncOnRewrite 
    # @return [self]
    def no_appendfsync_on_rewrite(noAppendfsyncOnRewrite=nil)
      if (noAppendfsyncOnRewrite.class == TrueClass || noAppendfsyncOnRewrite.class == FalseClass) && !block_given?
        @j_del.java_method(:noAppendfsyncOnRewrite, [Java::boolean.java_class]).call(noAppendfsyncOnRewrite)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling no_appendfsync_on_rewrite(noAppendfsyncOnRewrite)"
    end
    #  Phantom option
    # @return [self]
    def nosave
      if !block_given?
        @j_del.java_method(:nosave, []).call()
        return self
      end
      raise ArgumentError, "Invalid arguments when calling nosave()"
    end
    # @param [:K,:E,:g,:$,:l,:s,:h,:z,:x,:e,:A] notifyKeyspaceEvents 
    # @return [self]
    def notify_keyspace_events(notifyKeyspaceEvents=nil)
      if notifyKeyspaceEvents.class == Symbol && !block_given?
        @j_del.java_method(:notifyKeyspaceEvents, [Java::OrgRedissonMisc::KeyspaceEventsOptions.java_class]).call(Java::OrgRedissonMisc::KeyspaceEventsOptions.valueOf(notifyKeyspaceEvents))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling notify_keyspace_events(notifyKeyspaceEvents)"
    end
    # @param [String] pidfile 
    # @return [self]
    def pidfile(pidfile=nil)
      if pidfile.class == String && !block_given?
        @j_del.java_method(:pidfile, [Java::java.lang.String.java_class]).call(pidfile)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling pidfile(pidfile)"
    end
    # @param [Fixnum] port 
    # @return [self]
    def port(port=nil)
      if port.class == Fixnum && !block_given?
        @j_del.java_method(:port, [Java::int.java_class]).call(port)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling port(port)"
    end
    #  Phantom option
    # @return [self]
    def random_dir
      if !block_given?
        @j_del.java_method(:randomDir, []).call()
        return self
      end
      raise ArgumentError, "Invalid arguments when calling random_dir()"
    end
    # @param [Fixnum] retryCount 
    # @return [self]
    def random_port(retryCount=nil)
      if !block_given? && retryCount == nil
        @j_del.java_method(:randomPort, []).call()
        return self
      elsif retryCount.class == Fixnum && !block_given?
        @j_del.java_method(:randomPort, [Java::int.java_class]).call(retryCount)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling random_port(retryCount)"
    end
    # @param [true,false] rdbchecksum 
    # @return [self]
    def rdbchecksum(rdbchecksum=nil)
      if (rdbchecksum.class == TrueClass || rdbchecksum.class == FalseClass) && !block_given?
        @j_del.java_method(:rdbchecksum, [Java::boolean.java_class]).call(rdbchecksum)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling rdbchecksum(rdbchecksum)"
    end
    # @param [true,false] rdbcompression 
    # @return [self]
    def rdbcompression(rdbcompression=nil)
      if (rdbcompression.class == TrueClass || rdbcompression.class == FalseClass) && !block_given?
        @j_del.java_method(:rdbcompression, [Java::boolean.java_class]).call(rdbcompression)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling rdbcompression(rdbcompression)"
    end
    # @param [String] renameCommand 
    # @return [self]
    def rename_command(renameCommand=nil)
      if renameCommand.class == String && !block_given?
        @j_del.java_method(:renameCommand, [Java::java.lang.String.java_class]).call(renameCommand)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling rename_command(renameCommand)"
    end
    # @param [String] replBacklogSize 
    # @return [self]
    def repl_backlog_size(replBacklogSize=nil)
      if replBacklogSize.class == String && !block_given?
        @j_del.java_method(:replBacklogSize, [Java::java.lang.String.java_class]).call(replBacklogSize)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling repl_backlog_size(replBacklogSize)"
    end
    # @param [Fixnum] replBacklogTtl 
    # @return [self]
    def repl_backlog_ttl(replBacklogTtl=nil)
      if replBacklogTtl.class == Fixnum && !block_given?
        @j_del.java_method(:replBacklogTtl, [Java::long.java_class]).call(replBacklogTtl)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling repl_backlog_ttl(replBacklogTtl)"
    end
    # @param [true,false] replDisableTcpNodelay 
    # @return [self]
    def repl_disable_tcp_nodelay(replDisableTcpNodelay=nil)
      if (replDisableTcpNodelay.class == TrueClass || replDisableTcpNodelay.class == FalseClass) && !block_given?
        @j_del.java_method(:replDisableTcpNodelay, [Java::boolean.java_class]).call(replDisableTcpNodelay)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling repl_disable_tcp_nodelay(replDisableTcpNodelay)"
    end
    # @param [true,false] replDisklessSync 
    # @return [self]
    def repl_diskless_sync(replDisklessSync=nil)
      if (replDisklessSync.class == TrueClass || replDisklessSync.class == FalseClass) && !block_given?
        @j_del.java_method(:replDisklessSync, [Java::boolean.java_class]).call(replDisklessSync)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling repl_diskless_sync(replDisklessSync)"
    end
    # @param [Fixnum] replDisklessSyncDelay 
    # @return [self]
    def repl_diskless_sync_delay(replDisklessSyncDelay=nil)
      if replDisklessSyncDelay.class == Fixnum && !block_given?
        @j_del.java_method(:replDisklessSyncDelay, [Java::long.java_class]).call(replDisklessSyncDelay)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling repl_diskless_sync_delay(replDisklessSyncDelay)"
    end
    # @param [Fixnum] replPingSlavePeriod 
    # @return [self]
    def repl_ping_slave_period(replPingSlavePeriod=nil)
      if replPingSlavePeriod.class == Fixnum && !block_given?
        @j_del.java_method(:replPingSlavePeriod, [Java::long.java_class]).call(replPingSlavePeriod)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling repl_ping_slave_period(replPingSlavePeriod)"
    end
    # @param [Fixnum] replTimeout 
    # @return [self]
    def repl_timeout(replTimeout=nil)
      if replTimeout.class == Fixnum && !block_given?
        @j_del.java_method(:replTimeout, [Java::long.java_class]).call(replTimeout)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling repl_timeout(replTimeout)"
    end
    # @param [String] requirepass 
    # @return [self]
    def requirepass(requirepass=nil)
      if requirepass.class == String && !block_given?
        @j_del.java_method(:requirepass, [Java::java.lang.String.java_class]).call(requirepass)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling requirepass(requirepass)"
    end
    # @return [::VertxRedissonTest::RedisProcess]
    def run
      if !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:run, []).call(),::VertxRedissonTest::RedisProcess)
      end
      raise ArgumentError, "Invalid arguments when calling run()"
    end
    # @return [::VertxRedissonTest::RedisProcess]
    def run_and_check
      if !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:runAndCheck, []).call(),::VertxRedissonTest::RedisProcess)
      end
      raise ArgumentError, "Invalid arguments when calling run_and_check()"
    end
    #  To change the <b>redisBinary</b> system property for running the test,
    #  use <i>argLine</i> option from surefire plugin:
    # 
    #  $ mvn -DargLine="-DredisBinary=`which redis-server`" -Punit-test clean \
    #  verify
    # @param [String] configPath 
    # @return [::VertxRedissonTest::RedisProcess] Process running redis instance
    def run_with_config_file(configPath=nil)
      if configPath.class == String && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:runWithConfigFile, [Java::java.lang.String.java_class]).call(configPath),::VertxRedissonTest::RedisProcess)
      end
      raise ArgumentError, "Invalid arguments when calling run_with_config_file(configPath)"
    end
    # @param [Fixnum] seconds 
    # @param [Fixnum] changes 
    # @return [self]
    def save(seconds=nil,changes=nil)
      if seconds.class == Fixnum && changes.class == Fixnum && !block_given?
        @j_del.java_method(:save, [Java::long.java_class,Java::long.java_class]).call(seconds,changes)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling save(seconds,changes)"
    end
    # @param [Fixnum] setMaxIntsetEntries 
    # @return [self]
    def set_max_intset_entries(setMaxIntsetEntries=nil)
      if setMaxIntsetEntries.class == Fixnum && !block_given?
        @j_del.java_method(:setMaxIntsetEntries, [Java::long.java_class]).call(setMaxIntsetEntries)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling set_max_intset_entries(setMaxIntsetEntries)"
    end
    # @param [Fixnum] slavePriority 
    # @return [self]
    def slave_priority(slavePriority=nil)
      if slavePriority.class == Fixnum && !block_given?
        @j_del.java_method(:slavePriority, [Java::long.java_class]).call(slavePriority)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling slave_priority(slavePriority)"
    end
    # @param [true,false] slaveReadOnly 
    # @return [self]
    def slave_read_only(slaveReadOnly=nil)
      if (slaveReadOnly.class == TrueClass || slaveReadOnly.class == FalseClass) && !block_given?
        @j_del.java_method(:slaveReadOnly, [Java::boolean.java_class]).call(slaveReadOnly)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling slave_read_only(slaveReadOnly)"
    end
    # @param [true,false] slaveServeStaleData 
    # @return [self]
    def slave_serve_stale_data(slaveServeStaleData=nil)
      if (slaveServeStaleData.class == TrueClass || slaveServeStaleData.class == FalseClass) && !block_given?
        @j_del.java_method(:slaveServeStaleData, [Java::boolean.java_class]).call(slaveServeStaleData)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling slave_serve_stale_data(slaveServeStaleData)"
    end
    # @param [String] masterip 
    # @param [Fixnum] port 
    # @return [self]
    def slaveof(masterip=nil,port=nil)
      if masterip.class == String && port.class == Fixnum && !block_given?
        @j_del.java_method(:slaveof, [Java::java.lang.String.java_class,Java::int.java_class]).call(masterip,port)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling slaveof(masterip,port)"
    end
    # @param [Fixnum] slowlogLogSlowerThan 
    # @return [self]
    def slowlog_log_slower_than(slowlogLogSlowerThan=nil)
      if slowlogLogSlowerThan.class == Fixnum && !block_given?
        @j_del.java_method(:slowlogLogSlowerThan, [Java::long.java_class]).call(slowlogLogSlowerThan)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling slowlog_log_slower_than(slowlogLogSlowerThan)"
    end
    # @param [Fixnum] slowlogMaxLen 
    # @return [self]
    def slowlog_max_len(slowlogMaxLen=nil)
      if slowlogMaxLen.class == Fixnum && !block_given?
        @j_del.java_method(:slowlogMaxLen, [Java::long.java_class]).call(slowlogMaxLen)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling slowlog_max_len(slowlogMaxLen)"
    end
    # @param [true,false] stopWritesOnBgsaveError 
    # @return [self]
    def stop_writes_on_bgsave_error(stopWritesOnBgsaveError=nil)
      if (stopWritesOnBgsaveError.class == TrueClass || stopWritesOnBgsaveError.class == FalseClass) && !block_given?
        @j_del.java_method(:stopWritesOnBgsaveError, [Java::boolean.java_class]).call(stopWritesOnBgsaveError)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling stop_writes_on_bgsave_error(stopWritesOnBgsaveError)"
    end
    # @param [true,false] syslogEnabled 
    # @return [self]
    def syslog_enabled(syslogEnabled=nil)
      if (syslogEnabled.class == TrueClass || syslogEnabled.class == FalseClass) && !block_given?
        @j_del.java_method(:syslogEnabled, [Java::boolean.java_class]).call(syslogEnabled)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling syslog_enabled(syslogEnabled)"
    end
    # @param [:USER,:LOCAL0,:LOCAL1,:LOCAL2,:LOCAL3,:LOCAL4,:LOCAL5,:LOCAL6,:LOCAL7] syslogFacility 
    # @return [self]
    def syslog_facility(syslogFacility=nil)
      if syslogFacility.class == Symbol && !block_given?
        @j_del.java_method(:syslogFacility, [Java::OrgRedissonMisc::SyslogFacilityOptions.java_class]).call(Java::OrgRedissonMisc::SyslogFacilityOptions.valueOf(syslogFacility))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling syslog_facility(syslogFacility)"
    end
    # @param [String] syslogIdent 
    # @return [self]
    def syslog_ident(syslogIdent=nil)
      if syslogIdent.class == String && !block_given?
        @j_del.java_method(:syslogIdent, [Java::java.lang.String.java_class]).call(syslogIdent)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling syslog_ident(syslogIdent)"
    end
    # @param [Fixnum] tcpBacklog 
    # @return [self]
    def tcp_backlog(tcpBacklog=nil)
      if tcpBacklog.class == Fixnum && !block_given?
        @j_del.java_method(:tcpBacklog, [Java::long.java_class]).call(tcpBacklog)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling tcp_backlog(tcpBacklog)"
    end
    # @param [Fixnum] tcpKeepalive 
    # @return [self]
    def tcp_keepalive(tcpKeepalive=nil)
      if tcpKeepalive.class == Fixnum && !block_given?
        @j_del.java_method(:tcpKeepalive, [Java::long.java_class]).call(tcpKeepalive)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling tcp_keepalive(tcpKeepalive)"
    end
    # @param [Fixnum] timeout 
    # @return [self]
    def timeout(timeout=nil)
      if timeout.class == Fixnum && !block_given?
        @j_del.java_method(:timeout, [Java::long.java_class]).call(timeout)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling timeout(timeout)"
    end
    # @param [String] unixsocket 
    # @return [self]
    def unixsocket(unixsocket=nil)
      if unixsocket.class == String && !block_given?
        @j_del.java_method(:unixsocket, [Java::java.lang.String.java_class]).call(unixsocket)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling unixsocket(unixsocket)"
    end
    # @param [Fixnum] unixsocketperm 
    # @return [self]
    def unixsocketperm(unixsocketperm=nil)
      if unixsocketperm.class == Fixnum && !block_given?
        @j_del.java_method(:unixsocketperm, [Java::int.java_class]).call(unixsocketperm)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling unixsocketperm(unixsocketperm)"
    end
    # @param [Fixnum] zsetMaxZiplistEntries 
    # @return [self]
    def zset_max_ziplist_entries(zsetMaxZiplistEntries=nil)
      if zsetMaxZiplistEntries.class == Fixnum && !block_given?
        @j_del.java_method(:zsetMaxZiplistEntries, [Java::long.java_class]).call(zsetMaxZiplistEntries)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling zset_max_ziplist_entries(zsetMaxZiplistEntries)"
    end
    # @param [Fixnum] zsetMaxZiplistValue 
    # @return [self]
    def zset_max_ziplist_value(zsetMaxZiplistValue=nil)
      if zsetMaxZiplistValue.class == Fixnum && !block_given?
        @j_del.java_method(:zsetMaxZiplistValue, [Java::long.java_class]).call(zsetMaxZiplistValue)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling zset_max_ziplist_value(zsetMaxZiplistValue)"
    end
    # @return [::VertxRedissonTest::RedisProcess]
    def self.start_redis_server_instance
      if !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::OrgRedissonMisc::RedisRunner.java_method(:startRedisServerInstance, []).call(),::VertxRedissonTest::RedisProcess)
      end
      raise ArgumentError, "Invalid arguments when calling start_redis_server_instance()"
    end
    # @return [Fixnum]
    def self.shut_down_redis_server_instance
      if !block_given?
        return Java::OrgRedissonMisc::RedisRunner.java_method(:shutDownRedisServerInstance, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling shut_down_redis_server_instance()"
    end
    # @return [true,false]
    def self.redis_server_instance_running?
      if !block_given?
        return Java::OrgRedissonMisc::RedisRunner.java_method(:isRedisServerInstanceRunning, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling redis_server_instance_running?()"
    end
    # @return [::VertxRedissonTest::RedisProcess]
    def self.get_redis_server_instance
      if !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::OrgRedissonMisc::RedisRunner.java_method(:getRedisServerInstance, []).call(),::VertxRedissonTest::RedisProcess)
      end
      raise ArgumentError, "Invalid arguments when calling get_redis_server_instance()"
    end
    # @return [String]
    def self.get_redis_server_bind_address_and_port
      if !block_given?
        return Java::OrgRedissonMisc::RedisRunner.java_method(:getRedisServerBindAddressAndPort, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_redis_server_bind_address_and_port()"
    end
  end
end
