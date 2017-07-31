package com.ifly.edu.redis.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: TestCase
 * @Description: TODO
 * @author pangzhw
 * @date 2015年1月28日
 */
public class TestCase {
//    public static void main(String[] args) {  
//    	  
//        // ...when closing your application:  
//        RedisUtil.getPool().destroy();  
//  
//    } 
//    public static void Hello() {  
//        Jedis jedis = RedisUtil.getJedis();  
//        try {  
//            // 向key-->name中放入了value-->minxr  
//            jedis.set("name", "minxr");  
//            String ss = jedis.get("name");  
//            System.out.println(ss);  
//  
//            // 很直观，类似map 将jintao append到已经有的value之后  
//            jedis.append("name", "jintao");  
//            ss = jedis.get("name");  
//            System.out.println(ss);  
//  
//            // 2、直接覆盖原来的数据  
//            jedis.set("name", "jintao");  
//            System.out.println(jedis.get("jintao"));  
//  
//            // 删除key对应的记录  
//            jedis.del("name");  
//            System.out.println(jedis.get("name"));// 执行结果：null  
//  
//            /** 
//             * mset相当于 jedis.set("name","minxr"); jedis.set("jarorwar","aaa"); 
//             */  
//            jedis.mset("name", "minxr", "jarorwar", "aaa");  
//            System.out.println(jedis.mget("name", "jarorwar"));  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            RedisUtil.getPool().returnResource(jedis);  
//        }  
//  
//    }  
//    
//    private void testKey() {  
//        Jedis jedis = RedisUtil.getJedis();  
//        System.out.println("=============key==========================");  
//        // 清空数据  
//        System.out.println(jedis.flushDB());  
//        System.out.println(jedis.echo("foo"));  
//        // 判断key否存在  
//        System.out.println(jedis.exists("foo"));  
//        jedis.set("key", "values");  
//        System.out.println(jedis.exists("key"));  
//    }  
//  
//    public static void testString() {  
//        System.out.println("==String==");  
//        Jedis jedis = RedisUtil.getJedis();  
//        try {  
//            // String  
//            jedis.set("key", "Hello World!");  
//            String value = jedis.get("key");  
//            System.out.println(value);  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            RedisUtil.getPool().returnResource(jedis);  
//        }  
//  
//        System.out.println("=============String==========================");  
//        // 清空数据  
//        System.out.println(jedis.flushDB());  
//        // 存储数据  
//        jedis.set("foo", "bar");  
//        System.out.println(jedis.get("foo"));  
//        // 若key不存在，则存储  
//        jedis.setnx("foo", "foo not exits");  
//        System.out.println(jedis.get("foo"));  
//        // 覆盖数据  
//        jedis.set("foo", "foo update");  
//        System.out.println(jedis.get("foo"));  
//        // 追加数据  
//        jedis.append("foo", " hello, world");  
//        System.out.println(jedis.get("foo"));  
//        // 设置key的有效期，并存储数据  
//        jedis.setex("foo", 2, "foo not exits");  
//        System.out.println(jedis.get("foo"));  
//        try {  
//            Thread.sleep(3000);  
//        } catch (InterruptedException e) {  
//        }  
//        System.out.println(jedis.get("foo"));  
//        // 获取并更改数据  
//        jedis.set("foo", "foo update");  
//        System.out.println(jedis.getSet("foo", "foo modify"));  
//        // 截取value的值  
//        System.out.println(jedis.getrange("foo", 1, 3));  
//        System.out.println(jedis.mset("mset1", "mvalue1", "mset2", "mvalue2",  
//                "mset3", "mvalue3", "mset4", "mvalue4"));  
//        System.out.println(jedis.mget("mset1", "mset2", "mset3", "mset4"));  
//        System.out.println(jedis.del(new String[] { "foo", "foo1", "foo3" }));  
//    }  
//  
//    
//    public static void testList() {  
//        System.out.println("==List==");  
//        Jedis jedis = RedisUtil.getJedis();  
//        try {  
//            // 开始前，先移除所有的内容  
//            jedis.del("messages");  
//            jedis.rpush("messages", "Hello how are you?");  
//            jedis.rpush("messages", "Fine thanks. I'm having fun with redis.");  
//            jedis.rpush("messages", "I should look into this NOSQL thing ASAP");  
//  
//            // 再取出所有数据jedis.lrange是按范围取出，  
//            // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有  
//            List<String> values = jedis.lrange("messages", 0, -1);  
//            System.out.println(values);  
//  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            RedisUtil.getPool().returnResource(jedis);  
//        }  
//  
//        // 清空数据  
//        System.out.println(jedis.flushDB());  
//        // 添加数据  
//        jedis.lpush("lists", "vector");  
//        jedis.lpush("lists", "ArrayList");  
//        jedis.lpush("lists", "LinkedList");  
//        // 数组长度  
//        System.out.println(jedis.llen("lists"));  
//        // 排序  
//        System.out.println(jedis.sort("lists"));  
//        // 字串  
//        System.out.println(jedis.lrange("lists", 0, 3));  
//        // 修改列表中单个值  
//        jedis.lset("lists", 0, "hello list!");  
//        // 获取列表指定下标的值  
//        System.out.println(jedis.lindex("lists", 1));  
//        // 删除列表指定下标的值  
//        System.out.println(jedis.lrem("lists", 1, "vector"));  
//        // 删除区间以外的数据  
//        System.out.println(jedis.ltrim("lists", 0, 1));  
//        // 列表出栈  
//        System.out.println(jedis.lpop("lists"));  
//        // 整个列表值  
//        System.out.println(jedis.lrange("lists", 0, -1));  
//    }  
//  
//    public static void testSet() {  
//        System.out.println("==Set==");  
//        Jedis jedis = RedisUtil.getJedis();  
//        try {  
//            jedis.sadd("myset", "1");  
//            jedis.sadd("myset", "2");  
//            jedis.sadd("myset", "3");  
//            jedis.sadd("myset", "4");  
//            Set<String> setValues = jedis.smembers("myset");  
//            System.out.println(setValues);  
//  
//            // 移除noname  
//            jedis.srem("myset", "4");  
//            System.out.println(jedis.smembers("myset"));// 获取所有加入的value  
//            System.out.println(jedis.sismember("myset", "4"));// 判断 minxr  
//                                                                // 是否是sname集合的元素  
//            System.out.println(jedis.scard("sname"));// 返回集合的元素个数  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            RedisUtil.getPool().returnResource(jedis);  
//        }  
//  
//        // 清空数据  
//        System.out.println(jedis.flushDB());  
//        // 添加数据  
//        jedis.sadd("sets", "HashSet");  
//        jedis.sadd("sets", "SortedSet");  
//        jedis.sadd("sets", "TreeSet");  
//        // 判断value是否在列表中  
//        System.out.println(jedis.sismember("sets", "TreeSet"));  
//        ;  
//        // 整个列表值  
//        System.out.println(jedis.smembers("sets"));  
//        // 删除指定元素  
//        System.out.println(jedis.srem("sets", "SortedSet"));  
//        // 出栈  
//        System.out.println(jedis.spop("sets"));  
//        System.out.println(jedis.smembers("sets"));  
//        //  
//        jedis.sadd("sets1", "HashSet1");  
//        jedis.sadd("sets1", "SortedSet1");  
//        jedis.sadd("sets1", "TreeSet");  
//        jedis.sadd("sets2", "HashSet2");  
//        jedis.sadd("sets2", "SortedSet1");  
//        jedis.sadd("sets2", "TreeSet1");  
//        // 交集  
//        System.out.println(jedis.sinter("sets1", "sets2"));  
//        // 并集  
//        System.out.println(jedis.sunion("sets1", "sets2"));  
//        // 差集  
//        System.out.println(jedis.sdiff("sets1", "sets2"));  
//    }  
//    
//    public static void sortedSet() {  
//        System.out.println("==SoretedSet==");  
//        Jedis jedis = RedisUtil.getJedis();  
//        try {  
//            jedis.zadd("hackers", 1940, "Alan Kay");  
//            jedis.zadd("hackers", 1953, "Richard Stallman");  
//            jedis.zadd("hackers", 1965, "Yukihiro Matsumoto");  
//            jedis.zadd("hackers", 1916, "Claude Shannon");  
//            jedis.zadd("hackers", 1969, "Linus Torvalds");  
//            jedis.zadd("hackers", 1912, "Alan Turing");  
//            Set<String> setValues = jedis.zrange("hackers", 0, -1);  
//            System.out.println(setValues);  
//            Set<String> setValues2 = jedis.zrevrange("hackers", 0, -1);  
//            System.out.println(setValues2);  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            RedisUtil.getPool().returnResource(jedis);  
//        }  
//  
//        // 清空数据  
//        System.out.println(jedis.flushDB());  
//        // 添加数据  
//        jedis.zadd("zset", 10.1, "hello");  
//        jedis.zadd("zset", 10.0, ":");  
//        jedis.zadd("zset", 9.0, "zset");  
//        jedis.zadd("zset", 11.0, "zset!");  
//        // 元素个数  
//        System.out.println(jedis.zcard("zset"));  
//        // 元素下标  
//        System.out.println(jedis.zscore("zset", "zset"));  
//        // 集合子集  
//        System.out.println(jedis.zrange("zset", 0, -1));  
//        // 删除元素  
//        System.out.println(jedis.zrem("zset", "zset!"));  
//        System.out.println(jedis.zcount("zset", 9.5, 10.5));  
//        // 整个集合值  
//        System.out.println(jedis.zrange("zset", 0, -1));  
//    }  
//    
//    public static void testHsh() {  
//        System.out.println("==Hash==");  
//        Jedis jedis = RedisUtil.getJedis();  
//        try {  
//            Map<String, String> pairs = new HashMap<String, String>();  
//            pairs.put("name", "Akshi");  
//            pairs.put("age", "2");  
//            pairs.put("sex", "Female");  
//            jedis.hmset("kid", pairs);  
//            List<String> name = jedis.hmget("kid", "name");// 结果是个泛型的LIST  
//            // jedis.hdel("kid","age"); //删除map中的某个键值  
//            System.out.println(jedis.hmget("kid", "pwd")); // 因为删除了，所以返回的是null  
//            System.out.println(jedis.hlen("kid")); // 返回key为user的键中存放的值的个数  
//            System.out.println(jedis.exists("kid"));// 是否存在key为user的记录  
//            System.out.println(jedis.hkeys("kid"));// 返回map对象中的所有key  
//            System.out.println(jedis.hvals("kid"));// 返回map对象中的所有value  
//  
//            Iterator<String> iter = jedis.hkeys("kid").iterator();  
//            while (iter.hasNext()) {  
//                String key = iter.next();  
//                System.out.println(key + ":" + jedis.hmget("kid", key));  
//            }  
//  
//            List<String> values = jedis.lrange("messages", 0, -1);  
//            values = jedis.hmget("kid", new String[] { "name", "age", "sex" });  
//            System.out.println(values);  
//            Set<String> setValues = jedis.zrange("hackers", 0, -1);  
//            setValues = jedis.hkeys("kid");  
//            System.out.println(setValues);  
//            values = jedis.hvals("kid");  
//            System.out.println(values);  
//            pairs = jedis.hgetAll("kid");  
//            System.out.println(pairs);  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            RedisUtil.getPool().returnResource(jedis);  
//        }  
//  
//        // 清空数据  
//        System.out.println(jedis.flushDB());  
//        // 添加数据  
//        jedis.hset("hashs", "entryKey", "entryValue");  
//        jedis.hset("hashs", "entryKey1", "entryValue1");  
//        jedis.hset("hashs", "entryKey2", "entryValue2");  
//        // 判断某个值是否存在  
//        System.out.println(jedis.hexists("hashs", "entryKey"));  
//        // 获取指定的值  
//        System.out.println(jedis.hget("hashs", "entryKey")); // 批量获取指定的值  
//        System.out.println(jedis.hmget("hashs", "entryKey", "entryKey1"));  
//        // 删除指定的值  
//        System.out.println(jedis.hdel("hashs", "entryKey"));  
//        // 为key中的域 field 的值加上增量 increment  
//        System.out.println(jedis.hincrBy("hashs", "entryKey", 123l));  
//        // 获取所有的keys  
//        System.out.println(jedis.hkeys("hashs"));  
//        // 获取所有的values  
//        System.out.println(jedis.hvals("hashs"));  
//    }  
//    public static void testOther() throws InterruptedException {  
//        Jedis jedis = RedisUtil.getJedis();  
//  
//        try {  
//            // keys中传入的可以用通配符  
//            System.out.println(jedis.keys("*")); // 返回当前库中所有的key [sose, sanme,  
//                                                    // name, jarorwar, foo,  
//                                                    // sname, java framework,  
//                                                    // user, braand]  
//            System.out.println(jedis.keys("*name"));// 返回的sname [sname, name]  
//            System.out.println(jedis.del("sanmdde"));// 删除key为sanmdde的对象 删除成功返回1  
//                                                        // 删除失败（或者不存在）返回 0  
//            System.out.println(jedis.ttl("sname"));// 返回给定key的有效时间，如果是-1则表示永远有效  
//            jedis.setex("timekey", 10, "min");// 通过此方法，可以指定key的存活（有效时间） 时间为秒  
//            Thread.sleep(5000);// 睡眠5秒后，剩余时间将为<=5  
//            System.out.println(jedis.ttl("timekey")); // 输出结果为5  
//            jedis.setex("timekey", 1, "min"); // 设为1后，下面再看剩余时间就是1了  
//            System.out.println(jedis.ttl("timekey")); // 输出结果为1  
//            System.out.println(jedis.exists("key"));// 检查key是否存在  
//            System.out.println(jedis.rename("timekey", "time"));  
//            System.out.println(jedis.get("timekey"));// 因为移除，返回为null  
//            System.out.println(jedis.get("time")); // 因为将timekey 重命名为time  
//                                                    // 所以可以取得值 min  
//            // jedis 排序  
//            // 注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）  
//            jedis.del("a");// 先清除数据，再加入数据进行测试  
//            jedis.rpush("a", "1");  
//            jedis.lpush("a", "6");  
//            jedis.lpush("a", "3");  
//            jedis.lpush("a", "9");  
//            System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]  
//            System.out.println(jedis.sort("a")); // [1, 3, 6, 9] //输入排序后结果  
//            System.out.println(jedis.lrange("a", 0, -1));  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            RedisUtil.getPool().returnResource(jedis);  
//        }  
//    }
}
