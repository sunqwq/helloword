package com.atguigu.jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        //建立连接
        Jedis jedis = new Jedis("192.168.194.130", 6379);
        //使用连接对象发送命名操作redis
        String ping = jedis.ping();
        System.out.println(ping);

        jedis.zadd("topN", 999, "李光光的故事");
        jedis.zadd("topN", 1, "李光光的撩妹技巧");
        jedis.zadd("topN", 6666, "李光光编写的上海富婆通讯录");
        jedis.zadd("topN", 1111, "李光光的娇妻");
        Set<String> topN = jedis.zrange("topN", 0, 2);
        for (String s : topN) {
            System.out.println("s = " + s);
        }
        //关闭连接
        jedis.close();

    }
}
