package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import entity.Student;
import redis.clients.jedis.Jedis;

public class JedisUtils {
	private static String IP="182.92.60.57";
	private static Integer PORT=6379;
	private static String password="123456";
	public static Jedis getJedis(){
		Jedis jedis=new Jedis(IP,PORT);
		jedis.auth(password);
		return jedis;
	}
	@Test
	public void testJedis(){
		
		Jedis jedis=JedisUtils.getJedis();
		jedis.auth("123456");
		System.out.println(jedis.ping());
	}
	
	public Map<String, Student> setStudent() throws IOException, ClassNotFoundException{
		Jedis jedis=JedisUtils.getJedis();
		Map<String, Student> map=new HashMap<String, Student>();
		Date birthday=new Date();
		SnowFlakeIdWorker sf=new SnowFlakeIdWorker(0, 0);
		Student s1=new Student(String.valueOf(sf.nextId()),"a",birthday,"haha",60);
		Student s2=new Student(String.valueOf(sf.nextId()),"b",birthday,"haha",57);
		Student s3=new Student(String.valueOf(sf.nextId()),"c",birthday,"haha",44);
		Student s4=new Student(String.valueOf(sf.nextId()),"d",birthday,"haha",92);
		Student s5=new Student(String.valueOf(sf.nextId()),"e",birthday,"haha",80);
		Student s6=new Student(String.valueOf(sf.nextId()),"f",birthday,"haha",77);
		Student s7=new Student(String.valueOf(sf.nextId()),"g",birthday,"haha",70);
		map.put(s1.getId(), s1);
		map.put(s2.getId(), s2);
		map.put(s3.getId(), s3);
		map.put(s4.getId(), s4);
		map.put(s5.getId(), s5);
		map.put(s6.getId(), s6);
		map.put(s7.getId(), s7);
		
		
		//jedis存数据
		ByteArrayOutputStream bai=new ByteArrayOutputStream();
		ObjectOutputStream obj=new ObjectOutputStream(bai);
		obj.writeObject(map);
		byte[] byt=bai.toByteArray();
		jedis.set("1919".getBytes(), byt);

		//jedis读取数据
		byte[] studentByte=jedis.get("1919".getBytes());
		ObjectInputStream ois=null;
		ByteArrayInputStream bis=null;
		bis=new ByteArrayInputStream(studentByte);
		ois=new ObjectInputStream(bis);
		
		
		Map<String, Student> result=(Map<String, Student>) ois.readObject();
		return result;
	}
}
