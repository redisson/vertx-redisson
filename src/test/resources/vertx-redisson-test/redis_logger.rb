require 'vertx/util/utils.rb'
# Generated from org.redisson.misc.RedisLogger
module VertxRedissonTest
  class RedisLogger
    # @private
    # @param j_del [::VertxRedissonTest::RedisLogger] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxRedissonTest::RedisLogger] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [String] s 
    # @return [void]
    def log(s=nil)
      if s.class == String && !block_given?
        return @j_del.java_method(:log, [Java::java.lang.String.java_class]).call(s)
      end
      raise ArgumentError, "Invalid arguments when calling log(s)"
    end
  end
end
