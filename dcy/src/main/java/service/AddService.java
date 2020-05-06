package service;

import com.alibaba.fastjson.JSON;

import entity.Student;
import redis.clients.jedis.Jedis;
import util.JedisUtils;

public class AddService {
	private static final String key="2021";
	public long addStu(Student stu) {
		Jedis jedis=JedisUtils.getJedis();
		Long long1 = jedis.hset(key, stu.getId(),JSON.toJSONString(stu) );
		return long1;
	}
}
