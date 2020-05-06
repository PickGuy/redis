package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import entity.Page;
import entity.Student;
import redis.clients.jedis.Jedis;
import util.JedisUtils;
import util.dataUtils;

public class SelectService {
	private static Jedis jedis=JedisUtils.getJedis();
	private static final String key="2021";
	public static List<Student> getAll(){
		 List<Student> list=new ArrayList<Student>();
		 Student student=new Student();
		  Map<String, String> map = jedis.hgetAll(key);
		  for (Map.Entry<String, String> entry : map.entrySet()) {
			   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			    student=JSON.parseObject(entry.getValue(), Student.class);
			   if (student!=null) {
				list.add(student);
			}
		  }
		  //按平均分倒数排序
		  Collections.sort(list,new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int i=o2.getAvgScore()-o1.getAvgScore();
				return i;
			}
		});
		return list;
}
	public Page getPage(String currentPage){
		Page p=new Page();
		p.setCurrentPage(Integer.parseInt(currentPage));
		List<Student> students=getAll();
		p.setTotal(students.size());
		int pageNum=p.getTotal()/p.getPageSize()+1;
		if (p.getTotal()/p.getPageSize()==1&&p.getTotal()%p.getPageSize()==0) {
			pageNum=1;
		}
		p.setTotalPage(pageNum);
		if (p.getTotalPage()<p.getCurrentPage()) {
			p.setCurrentPage(p.getTotalPage());
		}
		List<Student> list=new ArrayList<>();
		for(int i=0;i<=students.size()-1;i++){
//			jedis.zrem("page", JSON.toJSONString(students.get(i)));
			jedis.zadd("page", i,JSON.toJSONString(students.get(i)));
		}
		int start=(p.getCurrentPage()-1)*p.getPageSize();
		int end=p.getCurrentPage()*p.getPageSize()-1;
		Set<String> set = jedis.zrangeByScore("page",start ,end );
		for (String string : set) {
			System.out.println(string);
			Student student=JSON.parseObject(string, Student.class);
			list.add(student);
		}
		p.setList(list);
		return p;
	}
	
	
	
}