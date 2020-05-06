package service;

import com.alibaba.fastjson.JSON;

import entity.Student;
import redis.clients.jedis.Jedis;
import util.JedisUtils;

public class UpdateStuService {
	private static final String key="2021";
	public long updateStuById(Student stu) {
		Jedis jedis=JedisUtils.getJedis();
		jedis.hdel(key, stu.getId());
		Long hset = jedis.hset(key, stu.getId(),JSON.toJSONString(stu));
		return hset;
	}
}
