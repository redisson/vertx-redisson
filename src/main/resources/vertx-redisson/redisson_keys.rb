require 'vertx/util/utils.rb'
# Generated from org.redisson.vertx.api.RedissonKeys
module VertxRedisson
  class RedissonKeys
    # @private
    # @param j_del [::VertxRedisson::RedissonKeys] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxRedisson::RedissonKeys] the underlying java delegate
    def j_del
      @j_del
    end
    #  Get Redis object type by key. Returns the type of the key.
    # @param [String] key - name of key
    # @yield - Handler for the result of this call.
    # @return [self]
    def get_type(key=nil)
      if key.class == String && block_given?
        @j_del.java_method(:getType, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(key,nil)
        return self
      end
      raise ArgumentError, "Invalid arguments when calling get_type(key)"
    end
    #  Get hash slot identifier for key in async mode. Returns the slot number.
    #  Available for cluster nodes only
    # @param [String] key - name of key
    # @yield - Handler for the result of this call.
    # @return [self]
    def get_slot(key=nil)
      if key.class == String && block_given?
        @j_del.java_method(:getSlot, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(key,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling get_slot(key)"
    end
    #  Get random key in async mode, returns random key
    # @yield - Handler for the result of this call.
    # @return [self]
    def random_key
      if block_given?
        @j_del.java_method(:randomKey, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling random_key()"
    end
    #  Find keys by key search pattern in async mode. Returns a list of keys
    # 
    #   Supported glob-style patterns:
    #     h?llo subscribes to hello, hallo and hxllo
    #     h*llo subscribes to hllo and heeeello
    #     h[ae]llo subscribes to hello and hallo, but not hillo
    # @param [String] pattern - match pattern
    # @yield - Handler for the result of this call.
    # @return [self]
    def find_keys_by_pattern(pattern=nil)
      if pattern.class == String && block_given?
        @j_del.java_method(:findKeysByPattern, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(pattern,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result.to_a.map { |elt| elt } : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling find_keys_by_pattern(pattern)"
    end
    #  Delete multiple objects by a key pattern. Returns number of removed keys
    #  <p>
    #  Method executes in <b>NON atomic way</b> in cluster mode due to lua script limitations.
    #  <p>
    #   Supported glob-style patterns:
    #     h?llo subscribes to hello, hallo and hxllo
    #     h*llo subscribes to hllo and heeeello
    #     h[ae]llo subscribes to hello and hallo, but not hillo
    # @param [String] pattern - match pattern
    # @yield - Handler for the result of this call.
    # @return [self]
    def delete_by_pattern(pattern=nil)
      if pattern.class == String && block_given?
        @j_del.java_method(:deleteByPattern, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(pattern,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling delete_by_pattern(pattern)"
    end
    #  Delete object by name, returns true if key is deleted.
    # @param [String] key - object name
    # @yield - Handler for the result of this call.
    # @return [self]
    def delete(key=nil)
      if key.class == String && block_given?
        @j_del.java_method(:delete, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(key,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling delete(key)"
    end
    #  Delete multiple objects by name, returns number of removed keys
    # @param [Array<String>] keys - object names
    # @yield - Handler for the result of this call.
    # @return [self]
    def delete_list(keys=nil)
      if keys.class == Array && block_given?
        @j_del.java_method(:deleteList, [Java::JavaUtil::List.java_class,Java::IoVertxCore::Handler.java_class]).call(keys.map { |element| element },(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling delete_list(keys)"
    end
    #  Returns the number of keys in the currently-selected database in async mode
    # @yield - Handler for the result of this call.
    # @return [self]
    def count
      if block_given?
        @j_del.java_method(:count, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling count()"
    end
    #  Delete all keys of currently selected database
    # @yield - Handler for the result of this call.
    # @return [self]
    def flushdb
      if block_given?
        @j_del.java_method(:flushdb, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling flushdb()"
    end
    #  Delete all keys of all existing databases
    # @yield - Handler for the result of this call.
    # @return [self]
    def flushall
      if block_given?
        @j_del.java_method(:flushall, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling flushall()"
    end
  end
end
