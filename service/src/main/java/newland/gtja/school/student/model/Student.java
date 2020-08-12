package newland.gtja.school.student.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "T_STUDENT")
public class Student implements Serializable{
	
	@Id
	@TableGenerator(name = "T_STUDENT",table = "hibernate_sequences",initialValue = 10000,allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "T_STUDENT")
	@Column(name = "I_STUDENT")
	private Integer istudent;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "AGE")
	private Integer age;
	
	@JSONField(format = "yyyy-MM-dd")
	@Column(name = "TIME")
	private Date time;

	public Integer getIstudent() {
		return istudent;
	}

	public void setIstudent(Integer istudent) {
		this.istudent = istudent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
