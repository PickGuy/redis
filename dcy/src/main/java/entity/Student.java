package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.jar.Attributes.Name;

/**
 * 实体类
 * @author Administrator
 *
 */
public class Student implements Serializable,Comparable<Student> {
	private String id;
	private String name;
	private Date birthday;
	private String description;
	private Integer avgScore;
	public Student(String id, String name, Date birthday, String description, Integer avgScore) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.description = description;
		this.avgScore = avgScore;
	}
	public Student() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(Integer avgScore) {
		this.avgScore = avgScore;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", description=" + description
				+ ", avgScore=" + avgScore + "]";
	}
	@Override
	public int compareTo(Student o) {
		
		return avgScore-o.avgScore;
	}
	
}
