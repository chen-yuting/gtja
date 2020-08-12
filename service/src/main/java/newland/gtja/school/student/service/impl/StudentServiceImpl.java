package newland.gtja.school.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import commons.query.criterion.Page;
import newland.gtja.school.student.cond.StudentCond;
import newland.gtja.school.student.dao.StudentDao;
import newland.gtja.school.student.model.Student;
import newland.gtja.school.student.service.StudentService;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;
	
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentDao.save(student);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		studentDao.delete(student);
	}

	@Override
	public void batchDelete(List<Student> students) {
		// TODO Auto-generated method stub
		studentDao.getHibernateTemplate().deleteAll(students);
	}

	@Override
	public List<Student> findByPage(StudentCond cond, Page page) {
		// TODO Auto-generated method stub
		return studentDao.findByCond(cond, page);
	}

	@Override
	public List<Student> findByCond(StudentCond cond) {
		// TODO Auto-generated method stub
		return studentDao.findByCond(cond);
	}

	@Override
	public Student findFirstCond(StudentCond cond) {
		// TODO Auto-generated method stub
		return studentDao.getFirstByCond(cond);
	}
	

}
