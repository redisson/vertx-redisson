require 'vertx/util/utils.rb'
# Generated from org.redisson.misc.RedisProcess
module VertxRedissonTest
  class RedisProcess
    # @private
    # @param j_del [::VertxRedissonTest::RedisProcess] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxRedissonTest::RedisProcess] the underlying java delegate
    def j_del
      @j_del
    end
    # @return [String]
    def get_redis_server_address_and_port
      if !block_given?
        return @j_del.java_method(:getRedisServerAddressAndPort, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_redis_server_address_and_port()"
    end
    # @return [String]
    def get_redis_server_bind_address
      if !block_given?
        return @j_del.java_method(:getRedisServerBindAddress, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_redis_server_bind_address()"
    end
    # @return [Fixnum]
    def get_redis_server_port
      if !block_given?
        return @j_del.java_method(:getRedisServerPort, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_redis_server_port()"
    end
    # @return [String]
    def get_redis_version
      if !block_given?
        return @j_del.java_method(:getRedisVersion, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_redis_version()"
    end
    # @return [Fixnum]
    def stop
      if !block_given?
        return @j_del.java_method(:stop, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling stop()"
    end
  end
end
