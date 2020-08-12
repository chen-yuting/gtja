package newland.gtja.school.student.dao;

import org.springframework.stereotype.Repository;

import newland.gtja.base.dao.GenericBaseDao;
import newland.gtja.school.student.model.Student;

@Repository("studentDao")
public class StudentDao extends GenericBaseDao<Student>{

}
