package service;

import com.alibaba.fastjson.JSON;

import entity.Student;
import redis.clients.jedis.Jedis;
import util.JedisUtils;

public class GetStuById {
	private static final String key="2021";
	public Student getStuById(String id) {
		Jedis jedis=JedisUtils.getJedis();
		String string = jedis.hget(key, id);
		Student student=JSON.parseObject(string,Student.class);
		return student;
	}
}
