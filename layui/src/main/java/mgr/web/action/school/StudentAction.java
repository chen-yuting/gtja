package mgr.web.action.school;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import commons.query.criterion.Page;
import mgr.web.commons.BaseAction;
import mgr.web.commons.Result;
import newland.gtja.school.student.cond.StudentCond;
import newland.gtja.school.student.model.Student;
import newland.gtja.school.student.service.StudentService;

@Controller
@RequestMapping("/mgr/school/student")
public class StudentAction extends BaseAction{
	@Resource
	private StudentService studentService;
	
	@RequestMapping("/list.ajax")
	@ResponseBody
	public Result list(Integer limit,Integer page,StudentCond cond) {
		Page page2=extractedPage(page, limit);
		Result ret=new Result();
		ret.setCode(0);
		ret.setCount(page2.getRecAmt());
		ret.setData(studentService.findByPage(cond, page2));
		return ret;
	}
	
	@RequestMapping("/getStudent.ajax")
	@ResponseBody
	public Result getStudent(StudentCond cond) {

		Result ret=new Result();
		ret.setCode(0);
		ret.setData(studentService.findByCond(cond).get(0));
		return ret;
	}
	
	@RequestMapping("/add.ajax")
	@ResponseBody
	public Result add(Student student) {

		studentService.add(student);
		Result ret=new Result();
		ret.setCode(0);
		return ret;
	}
	
	@RequestMapping("/edit.ajax")
	@ResponseBody
	public Result edit(Student student) {

		studentService.update(student);
		Result ret=new Result();
		ret.setCode(0);
		ret.setMsg("修改成功");
		return ret;
	}
	
	@RequestMapping("/delete.ajax")
	@ResponseBody
	public Result delete(Student student) {

		studentService.delete(student);
		Result ret=new Result();
		ret.setCode(0);
		return ret;
	}
	
	@RequestMapping("/batchDelete.ajax")
	@ResponseBody
	public Result batchDelete(String json) {

		studentService.batchDelete(JSONArray.parseArray(json, Student.class));
		Result ret=new Result();
		ret.setCode(0);
		return ret;
	}
}
