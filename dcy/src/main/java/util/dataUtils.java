package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import entity.Student;
import redis.clients.jedis.Jedis;

public class dataUtils {
	
	@Test
	public  void setData(){
		Jedis jedis=JedisUtils.getJedis();
		Date birthday=new Date();
		SnowFlakeIdWorker sf=new SnowFlakeIdWorker(0, 0);
		Student s1=new Student(String.valueOf(sf.nextId()),"a",birthday,"haha",60);
		Student s2=new Student(String.valueOf(sf.nextId()),"b",birthday,"haha",57);
		Student s3=new Student(String.valueOf(sf.nextId()),"c",birthday,"haha",44);
		Student s4=new Student(String.valueOf(sf.nextId()),"d",birthday,"haha",92);
		Student s5=new Student(String.valueOf(sf.nextId()),"e",birthday,"haha",80);
		Student s6=new Student(String.valueOf(sf.nextId()),"f",birthday,"haha",77);
		Student s7=new Student(String.valueOf(sf.nextId()),"g",birthday,"haha",70);
		Student s8=new Student(String.valueOf(sf.nextId()),"h",birthday,"haha",85);
		List<Student> list=new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		list.add(s7);
		list.add(s8);
		for (Student student : list) {
//			jedis.hset(student.getId(), "id",student.getId());
//			jedis.hset(student.getId(), "name", student.getName());
//			jedis.hset(student.getId(), "birthday",String.valueOf(student.getBirthday()));
//			jedis.hset(student.getId(), "description",student.getDescription());
//			jedis.hset(student.getId(), "avgScore",String.valueOf(student.getAvgScore()));
			
//			jedis.sadd("1919", student.getId());
			jedis.hset("2021",student.getId(), JSON.toJSONString(student));
		}
//		String key="2020";
//		jedis.set(key, JSON.toJSONString(list));
		
	}
}
