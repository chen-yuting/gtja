package newland.gtja.school.student.cond;

import java.util.Date;

import commons.query.criterion.Condition;
import commons.query.criterion.annotation.ConditionClass;
import commons.query.criterion.annotation.Expression;
import commons.query.criterion.annotation.Operator;
import newland.gtja.school.student.model.Student;

@ConditionClass(Student.class)
public class StudentCond extends Condition{
	@Expression(operator = Operator.eq,propertyName = "istudent")
	private Integer istudent;
	
	@Expression(operator = Operator.like,propertyName = "name")
	private String name;
	
	@Expression(operator = Operator.eq,propertyName = "age")
	private Integer age;
	
	@Expression(operator = Operator.ge,propertyName = "time")
	private Date startTime;
	
	@Expression(operator = Operator.le,propertyName = "time")
	private Date endTime;

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
