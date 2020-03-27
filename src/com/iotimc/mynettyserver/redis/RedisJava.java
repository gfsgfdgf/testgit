package com.iotimc.mynettyserver.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.iotimc.mynettyserver.testport.ConnectPortUtil;

import redis.clients.jedis.Jedis;

public class RedisJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //连接本地的 Redis 服务
       //Jedis jedis = new Jedis("127.0.0.1");
		Jedis jedis = RedisUtil.getJedis();
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        /*Map<String,Object> data = new HashMap<String,Object>();
        data.put("data", "www.runoob.com");*/
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
        
        //存储hash数组
        jedis.hset("user", "name", "5001");
        System.out.println("redis 存储的user对应的map数据为: "+ jedis.hget("user","name"));
        
        // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
        
        System.out.println("对应服务是否开启: "+ ConnectPortUtil.isConnect("192.168.11.39", 8180));
	}

}
