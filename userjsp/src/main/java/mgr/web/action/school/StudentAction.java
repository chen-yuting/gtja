package mgr.web.action.school;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/list.mvc")
	public ModelAndView List() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("mgr/school/student/list");
		return mv;
	}
	
	@RequestMapping("/add.mvc")
	public ModelAndView Add() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("mgr/school/student/add");
		return mv;
	}
	
	@RequestMapping("/edit.mvc")
	public ModelAndView Edit(Student student) {
		ModelAndView mv=new ModelAndView();
		StudentCond cond=new StudentCond();
		cond.setIstudent(student.getIstudent());
		mv.addObject("student", studentService.findFirstCond(cond));
		mv.setViewName("mgr/school/student/edit");
		return mv;
	}
	
	@RequestMapping("/detail.mvc")
	public ModelAndView detail(Student student) {
		ModelAndView mv=new ModelAndView();
		StudentCond cond=new StudentCond();
		cond.setIstudent(student.getIstudent());
		mv.addObject("student", studentService.findFirstCond(cond));
		mv.setViewName("mgr/school/student/detail");
		return mv;
	}
	
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
	
	@RequestMapping("/add.ajax")
	@ResponseBody
	public Result add(Student student) {
		studentService.add(student);
		Result ret=new Result();
		ret.setCode(0);
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
	
	@RequestMapping("/edit.ajax")
	@ResponseBody
	public Result edit(Student student) {
		studentService.update(student);
		Result ret=new Result();
		ret.setCode(0);
		ret.setMsg("修改成功");
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
