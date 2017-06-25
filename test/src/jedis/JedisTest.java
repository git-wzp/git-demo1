package jedis;


import org.junit.Test;

import redis.clients.jedis.Jedis;
import utils.JedisUtils;

public class JedisTest {
	
	
	@Test
	public void test(){
		Jedis jedis = new Jedis("192.168.204.128", 6379);
		jedis.hset("hashmap", "name", "wzp");
		String hget = jedis.hget("hashmap", "name");
		System.out.println(hget);
		jedis.close();
	}
	@Test
	public void test1(){
		Jedis jedis = JedisUtils.getJedis();
		jedis.set("name", "hah");
//		Long dbSize = jedis.dbSize();
		String string = jedis.get("name");
		System.out.println(string);
	}
}
