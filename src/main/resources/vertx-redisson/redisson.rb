require 'vertx-redisson/redisson_keys'
require 'vertx-redisson/redisson_geo'
require 'vertx/vertx'
require 'vertx/util/utils.rb'
# Generated from org.redisson.vertx.api.Redisson
module VertxRedisson
  class Redisson
    # @private
    # @param j_del [::VertxRedisson::Redisson] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxRedisson::Redisson] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [::Vertx::Vertx] vertx 
    # @param [Hash] config 
    # @return [::VertxRedisson::Redisson]
    def self.create(vertx=nil,config=nil)
      if vertx.class.method_defined?(:j_del) && config.class == Hash && !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::OrgRedissonVertxApi::Redisson.java_method(:create, [Java::IoVertxCore::Vertx.java_class,Java::OrgRedissonVertxConfig::Config.java_class]).call(vertx.j_del,Java::OrgRedissonVertxConfig::Config.new(::Vertx::Util::Utils.to_json_object(config))),::VertxRedisson::Redisson)
      end
      raise ArgumentError, "Invalid arguments when calling create(vertx,config)"
    end
    #  Returns geospatial items holder instance by <code>name</code>.
    # @param [String] name - name of object
    # @return [::VertxRedisson::RedissonGeo] Geo object
    def get_geo(name=nil)
      if name.class == String && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:getGeo, [Java::java.lang.String.java_class]).call(name),::VertxRedisson::RedissonGeo)
      end
      raise ArgumentError, "Invalid arguments when calling get_geo(name)"
    end
    #  Returns interface with methods for Redis keys.
    #  Each of Redis/Redisson object associated with own key
    # @return [::VertxRedisson::RedissonKeys] RedissonKeys object
    def get_keys
      if !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:getKeys, []).call(),::VertxRedisson::RedissonKeys)
      end
      raise ArgumentError, "Invalid arguments when calling get_keys()"
    end
    #  Shuts down Redisson instance <b>NOT</b> Redis server
    #  
    #  Shutdown ensures that no tasks are submitted for <i>'the quiet period'</i>
    #  (usually a couple seconds) before it shuts itself down.  If a task is submitted during the quiet period,
    #  it is guaranteed to be accepted and the quiet period will start over.
    # @param [Fixnum] quietPeriod the quiet period as described in the documentation
    # @param [Fixnum] timeout the maximum amount of time to wait until the executor is  regardless if a task was submitted during the quiet period
    # @param [:NANOSECONDS,:MICROSECONDS,:MILLISECONDS,:SECONDS,:MINUTES,:HOURS,:DAYS] unit the unit of <code>quietPeriod</code> and <code>timeout</code>
    # @yield - Handler for the result of this call.
    # @return [void]
    def shutdown(quietPeriod=nil,timeout=nil,unit=nil)
      if block_given? && quietPeriod == nil && timeout == nil && unit == nil
        return @j_del.java_method(:shutdown, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
      elsif quietPeriod.class == Fixnum && timeout.class == Fixnum && unit.class == Symbol && block_given?
        return @j_del.java_method(:shutdown, [Java::long.java_class,Java::long.java_class,Java::JavaUtilConcurrent::TimeUnit.java_class,Java::IoVertxCore::Handler.java_class]).call(quietPeriod,timeout,Java::JavaUtilConcurrent::TimeUnit.valueOf(unit),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling shutdown(quietPeriod,timeout,unit)"
    end
    #  Returns <code>true</code> if this Redisson instance has been shut down.
    # @yield - Handler for the result of this call.
    # @return [void]
    def is_shutdown
      if block_given?
        return @j_del.java_method(:isShutdown, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling is_shutdown()"
    end
    #  Returns <code>true</code> if this Redisson instance was started to be shutdown
    #  or was shutdown  already.
    # 
    #  or was shutdown  already.
    # @yield - Handler for the result of this call.
    # @return [void]
    def is_shutting_down
      if block_given?
        return @j_del.java_method(:isShuttingDown, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling is_shutting_down()"
    end
  end
end
