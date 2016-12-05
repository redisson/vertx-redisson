require 'vertx/util/utils.rb'
# Generated from org.redisson.vertx.api.RedissonGeo
module VertxRedisson
  class RedissonGeo
    # @private
    # @param j_del [::VertxRedisson::RedissonGeo] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxRedisson::RedissonGeo] the underlying java delegate
    def j_del
      @j_del
    end
    #  Adds geospatial member and gives back the number of elements added to the
    #  sorted set, not including elements already existing for which 
    #  the score was updated.
    # @overload add(entries,handler)
    #   @param [Array<String,Object>] entries - JsonArray object
    #   @yield - Handler for the result of this call.
    # @overload add(longitude,latitude,member,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Object] member - object itself
    #   @yield - Handler for the result of this call.
    # @return [self]
    def add(param_1=nil,param_2=nil,param_3=nil)
      if param_1.class == Array && block_given? && param_2 == nil && param_3 == nil
        @j_del.java_method(:add, [Java::IoVertxCoreJson::JsonArray.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_json_array(param_1),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && (param_3.class == String  || param_3.class == Hash || param_3.class == Array || param_3.class == NilClass || param_3.class == TrueClass || param_3.class == FalseClass || param_3.class == Fixnum || param_3.class == Float) && block_given?
        @j_del.java_method(:add, [Java::double.java_class,Java::double.java_class,Java::java.lang.Object.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_object(param_3),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling add(param_1,param_2,param_3)"
    end
    #  Adds geospatial member and gives back the number of elements added to the
    #  sorted set, not including elements already existing for which 
    #  the score was updated.
    #  
    #  Required JsonObject format: 
    #  <pre><code>
    #  {
    #       longitude: double,
    #       latitude: double,
    #       member: Object
    #  }
    #  </code></pre>
    # @param [Hash{String => Object}] entry - JsonObject object.
    # @yield - Handler for the result of this call.
    # @return [self]
    def add_entry(entry=nil)
      if entry.class == Hash && block_given?
        @j_del.java_method(:addEntry, [Java::IoVertxCoreJson::JsonObject.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_json_object(entry),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling add_entry(entry)"
    end
    #  Returns distance between members in <code>GeoUnit</code> units.
    # @param [Object] firstMember - first object
    # @param [Object] secondMember - second object
    # @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    # @yield - Handler for the result of this call.
    # @return [self]
    def dist(firstMember=nil,secondMember=nil,geoUnit=nil)
      if (firstMember.class == String  || firstMember.class == Hash || firstMember.class == Array || firstMember.class == NilClass || firstMember.class == TrueClass || firstMember.class == FalseClass || firstMember.class == Fixnum || firstMember.class == Float) && (secondMember.class == String  || secondMember.class == Hash || secondMember.class == Array || secondMember.class == NilClass || secondMember.class == TrueClass || secondMember.class == FalseClass || secondMember.class == Fixnum || secondMember.class == Float) && geoUnit.class == Symbol && block_given?
        @j_del.java_method(:dist, [Java::java.lang.Object.java_class,Java::java.lang.Object.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(firstMember),::Vertx::Util::Utils.to_object(secondMember),Java::OrgRedissonApi::GeoUnit.valueOf(geoUnit),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling dist(firstMember,secondMember,geoUnit)"
    end
    #  Returns 11 characters Geohash string mapped by defined member in a form
    #  of a JsonArray.
    #  
    #  Result JsonArray format:
    #  <pre><code>
    #  [{
    #     member: Object,
    #     hash: String
    #  },
    #  ...
    #  ]
    #  </code></pre>
    # @param [Array<String,Object>] members - objects
    # @yield - Handler for the result of this call.
    # @return [self]
    def hash(members=nil)
      if members.class == Array && block_given?
        @j_del.java_method(:hash, [Java::IoVertxCoreJson::JsonArray.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_json_array(members),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling hash(members)"
    end
    #  Returns geo-position mapped by defined member in a form of a JsonArray.
    #  
    #  Result JsonArray format:
    #  <pre><code>
    #  [{
    #     member: Object,
    #     geoPosition: {
    #         longitude: double,
    #         latitude: double
    #     }
    #  },
    #  ...
    #  ]
    #  </code></pre>
    # @param [Array<String,Object>] members - objects
    # @yield - Handler for the result of this call.
    # @return [self]
    def pos(members=nil)
      if members.class == Array && block_given?
        @j_del.java_method(:pos, [Java::IoVertxCoreJson::JsonArray.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_json_array(members),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling pos(members)"
    end
    #  Returns the members of a sorted set in a form of a JsonArray, which are
    #  within the borders of the area specified with the center location 
    #  and the maximum distance from the center (the radius) 
    #  in <code>GeoUnit</code> units with <code>GeoOrder</code>
    #  and limited by count
    #  
    #  Result JsonArray format:
    #  <pre><code>
    #  [ object1, object2, ... ]
    #  </code></pre>
    # @overload radius(member,radius,geoUnit,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @yield - Handler for the result of this call.
    # @overload radius(longitude,latitude,radius,geoUnit,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @yield - Handler for the result of this call.
    # @overload radius(member,radius,geoUnit,count,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radius(member,radius,geoUnit,geoOrder,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - geo order
    #   @yield - Handler for the result of this call.
    # @overload radius(longitude,latitude,radius,geoUnit,count,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radius(longitude,latitude,radius,geoUnit,geoOrder,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - order of result
    #   @yield - Handler for the result of this call.
    # @overload radius(member,radius,geoUnit,geoOrder,count,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - geo order
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radius(longitude,latitude,radius,geoUnit,geoOrder,count,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - order of result
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @return [self]
    def radius(param_1=nil,param_2=nil,param_3=nil,param_4=nil,param_5=nil,param_6=nil)
      if (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && block_given? && param_4 == nil && param_5 == nil && param_6 == nil
        @j_del.java_method(:radius, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radius, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Fixnum && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radius, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),param_4,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Symbol && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radius, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),Java::OrgRedissonApi::GeoOrder.valueOf(param_4),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Fixnum && block_given? && param_6 == nil
        @j_del.java_method(:radius, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),param_5,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Symbol && block_given? && param_6 == nil
        @j_del.java_method(:radius, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),Java::OrgRedissonApi::GeoOrder.valueOf(param_5),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Symbol && param_5.class == Fixnum && block_given? && param_6 == nil
        @j_del.java_method(:radius, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),Java::OrgRedissonApi::GeoOrder.valueOf(param_4),param_5,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Symbol && param_6.class == Fixnum && block_given?
        @j_del.java_method(:radius, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),Java::OrgRedissonApi::GeoOrder.valueOf(param_5),param_6,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling radius(param_1,param_2,param_3,param_4,param_5,param_6)"
    end
    #  Returns the distance mapped by member, distance between member and the location. 
    #  Members of a sorted set in a form of a JsonArray of JsonObjects, which
    #  are within the borders of the area specified with the center location 
    #  and the maximum distance from the center (the radius) 
    #  in <code>GeoUnit</code> units with <code>GeoOrder</code>
    #  and limited by count
    #  
    #  Result JsonArray format:
    #  <pre><code>
    #  [{
    #     member: Object,
    #     distance: double
    #  },
    #  ...
    #  ]
    #  </code></pre>
    # @overload radiusWithDistance(member,radius,geoUnit,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithDistance(longitude,latitude,radius,geoUnit,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithDistance(member,radius,geoUnit,count,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithDistance(member,radius,geoUnit,geoOrder,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - geo
    #   @yield - Handler for the result of this call.
    # @overload radiusWithDistance(longitude,latitude,radius,geoUnit,count,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithDistance(longitude,latitude,radius,geoUnit,geoOrder,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - order of result
    #   @yield - Handler for the result of this call.
    # @overload radiusWithDistance(member,radius,geoUnit,geoOrder,count,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - geo
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithDistance(longitude,latitude,radius,geoUnit,geoOrder,count,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - order of result
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @return [self]
    def radius_with_distance(param_1=nil,param_2=nil,param_3=nil,param_4=nil,param_5=nil,param_6=nil)
      if (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && block_given? && param_4 == nil && param_5 == nil && param_6 == nil
        @j_del.java_method(:radiusWithDistance, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radiusWithDistance, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Fixnum && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radiusWithDistance, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),param_4,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Symbol && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radiusWithDistance, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),Java::OrgRedissonApi::GeoOrder.valueOf(param_4),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Fixnum && block_given? && param_6 == nil
        @j_del.java_method(:radiusWithDistance, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),param_5,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Symbol && block_given? && param_6 == nil
        @j_del.java_method(:radiusWithDistance, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),Java::OrgRedissonApi::GeoOrder.valueOf(param_5),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Symbol && param_5.class == Fixnum && block_given? && param_6 == nil
        @j_del.java_method(:radiusWithDistance, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),Java::OrgRedissonApi::GeoOrder.valueOf(param_4),param_5,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Symbol && param_6.class == Fixnum && block_given?
        @j_del.java_method(:radiusWithDistance, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),Java::OrgRedissonApi::GeoOrder.valueOf(param_5),param_6,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling radius_with_distance(param_1,param_2,param_3,param_4,param_5,param_6)"
    end
    #  Returns the geo-position mapped by member. 
    #  Members of a sorted set in a form of a JsonArray of JsonObjects, which
    #  are within the borders of the area specified with the center location 
    #  and the maximum distance from the center (the radius) 
    #  in <code>GeoUnit</code> units with <code>GeoOrder</code>
    #  and limited by count
    #  
    #  Result JsonArray format:
    #  <pre><code>
    #  [{
    #     member: Object,
    #     geoPosition: {
    #         longitude: double,
    #         latitude: double
    #     }
    #  },
    #  ...
    #  ]
    #  </code></pre>
    # @overload radiusWithPosition(member,radius,geoUnit,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithPosition(longitude,latitude,radius,geoUnit,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithPosition(member,radius,geoUnit,count,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithPosition(member,radius,geoUnit,geoOrder,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - geo order
    #   @yield - Handler for the result of this call.
    # @overload radiusWithPosition(longitude,latitude,radius,geoUnit,count,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithPosition(longitude,latitude,radius,geoUnit,geoOrder,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - geo order
    #   @yield - Handler for the result of this call.
    # @overload radiusWithPosition(member,radius,geoUnit,geoOrder,count,handler)
    #   @param [Object] member - object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - geo order
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @overload radiusWithPosition(longitude,latitude,radius,geoUnit,geoOrder,count,handler)
    #   @param [Float] longitude - longitude of object
    #   @param [Float] latitude - latitude of object
    #   @param [Float] radius - radius in geo units
    #   @param [:METERS,:KILOMETERS,:MILES,:FEET] geoUnit - geo unit
    #   @param [:ASC,:DESC] geoOrder - geo order
    #   @param [Fixnum] count - result limit
    #   @yield - Handler for the result of this call.
    # @return [self]
    def radius_with_position(param_1=nil,param_2=nil,param_3=nil,param_4=nil,param_5=nil,param_6=nil)
      if (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && block_given? && param_4 == nil && param_5 == nil && param_6 == nil
        @j_del.java_method(:radiusWithPosition, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radiusWithPosition, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Fixnum && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radiusWithPosition, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),param_4,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Symbol && block_given? && param_5 == nil && param_6 == nil
        @j_del.java_method(:radiusWithPosition, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),Java::OrgRedissonApi::GeoOrder.valueOf(param_4),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Fixnum && block_given? && param_6 == nil
        @j_del.java_method(:radiusWithPosition, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),param_5,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Symbol && block_given? && param_6 == nil
        @j_del.java_method(:radiusWithPosition, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),Java::OrgRedissonApi::GeoOrder.valueOf(param_5),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif (param_1.class == String  || param_1.class == Hash || param_1.class == Array || param_1.class == NilClass || param_1.class == TrueClass || param_1.class == FalseClass || param_1.class == Fixnum || param_1.class == Float) && param_2.class == Float && param_3.class == Symbol && param_4.class == Symbol && param_5.class == Fixnum && block_given? && param_6 == nil
        @j_del.java_method(:radiusWithPosition, [Java::java.lang.Object.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_object(param_1),::Vertx::Util::Utils.to_double(param_2),Java::OrgRedissonApi::GeoUnit.valueOf(param_3),Java::OrgRedissonApi::GeoOrder.valueOf(param_4),param_5,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      elsif param_1.class == Float && param_2.class == Float && param_3.class == Float && param_4.class == Symbol && param_5.class == Symbol && param_6.class == Fixnum && block_given?
        @j_del.java_method(:radiusWithPosition, [Java::double.java_class,Java::double.java_class,Java::double.java_class,Java::OrgRedissonApi::GeoUnit.java_class,Java::OrgRedissonApi::GeoOrder.java_class,Java::int.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_double(param_1),::Vertx::Util::Utils.to_double(param_2),::Vertx::Util::Utils.to_double(param_3),Java::OrgRedissonApi::GeoUnit.valueOf(param_4),Java::OrgRedissonApi::GeoOrder.valueOf(param_5),param_6,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling radius_with_position(param_1,param_2,param_3,param_4,param_5,param_6)"
    end
  end
end
