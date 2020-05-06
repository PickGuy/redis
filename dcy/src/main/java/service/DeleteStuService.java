package service;

import com.alibaba.fastjson.JSON;

import entity.Student;
import redis.clients.jedis.Jedis;
import util.JedisUtils;

public class DeleteStuService {
	private static final String key="2021";
	private static final String page="page";
	public Long deleteStuById(String id){
		Jedis jedis=JedisUtils.getJedis();
		Student student=new GetStuById().getStuById(id);
		Long hdel = jedis.hdel(key, id);
		jedis.zrem(page, JSON.toJSONString(student));
		return hdel;
	}
}
