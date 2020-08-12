package newland.gtja.school.student.service;

import java.util.List;

import commons.query.criterion.Page;
import newland.gtja.school.student.cond.StudentCond;
import newland.gtja.school.student.model.Student;

public interface StudentService {
	public void add(Student student);
	public void update(Student student);
	public void delete(Student student);
	public void batchDelete(List<Student> students);
	public List<Student> findByPage(StudentCond cond,Page page);
	public List<Student> findByCond(StudentCond cond);
	public Student findFirstCond(StudentCond cond);
}
