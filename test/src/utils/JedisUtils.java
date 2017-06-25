package utils;


import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	private static JedisPool jedisPool = null;
	private static  JedisPoolConfig poolConfig = null;
	
	static{
		ResourceBundle rb = ResourceBundle.getBundle("jedis");
		
		poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(Integer.valueOf(rb.getString("maxtotal")));
		poolConfig.setMaxWaitMillis(3000);
		   jedisPool = new JedisPool(poolConfig,rb.getString("host"),Integer.valueOf(rb.getString("port")));
	}
	public static Jedis getJedis(){
		Jedis resource = jedisPool.getResource();
		return resource; 
	}
}
