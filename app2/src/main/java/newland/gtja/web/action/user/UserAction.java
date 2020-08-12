package newland.gtja.web.action.user;




import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import commons.query.criterion.Page;
import newland.gtja.sys.user.cond.UserCond;
import newland.gtja.sys.user.model.User;
import newland.gtja.sys.user.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value="/user")
public class UserAction {
//	private static Logger logger = LoggerFactory.getLogger(UserAction.class);
//	@Resource(name="userService")
//	private UserService userService;
//	
//	/**
//	 * 请求首页页面
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/index.html")
//	public String inloadPage() {
//		return "manage/user/index";
//	}
//	
//	
//	
//	
//	/**
//	 * 请求用户列表页面
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/user_list.html")
//	public String listPage() {
//		return "manage/user/user_list";
//	}
//	
//	@RequestMapping("/user_add.html")
//	public String toAdd (){
//		return "manage/user/user_add";
//	}
//	
//	/**
//	 * 请求用户列表详情
//	 * 
//	 * @param page
//	 *            当前页码
//	 * @param limit
//	 *            每页记录数
//	 * @param cond
//	 *           用户列表搜索条件
//	 * @return
//	 */
//	@RequestMapping("/user_list.ajax")
//	@ResponseBody
//	public JSONObject getList(Integer page, Integer limit,UserCond cond) {
//		Page pag = extractedPage(page, limit);
//		JSONObject jsonObject = new JSONObject();
//		List<User> list = userService.findByPage(cond, pag);
//		jsonObject.put("code", 0);
//		jsonObject.put("data", list);
//		jsonObject.put("count",pag.getRecAmt());
//		return jsonObject;
//	}
//	
//
//	
//	/**
//	 * 
//	 * @Title: extractedPage @Description: 根据页码和每页记录数封装Page对象 @param @param page
//	 *         页码 @param @param limit 每页记录数 @param @return 参数 @return Page
//	 *         用于分页查询的Page对象 @throws
//	 */
//	private Page extractedPage(Integer page, Integer limit) {
//		Page pag = new Page();
//		pag.setCapacity(limit);
//		pag.setPageOffset(page - 1);
//		pag.setCount(true);
//		return pag;
//	}
//	
//	/**
//	 * 请求保存新用户信息
//	 * 
//	 * @param user
//	 *            新用户基本信息
//	 * @param userSub
//	 *            新用户详细信息
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/user_add.ajax")
//	@ResponseBody
//	public JSONObject save(User user) throws Exception {
//
//		JSONObject jsonObject = new JSONObject();
//        String verifyUser = verifyAdd(user);//基本信息校验结果
//
//        String verify  = verifyUser ;
//		if (StringUtils.equals("",verifyUser ) ){
//			userService.save(user);
//		} else { 
//			jsonObject.put("verify", verify);
//			jsonObject.put("code", -2);
//			return jsonObject;
//		}
//		
//		jsonObject.put("code", 0);
//		logger.info("添加用户基本信息和详细信息[ID:" + user.getIuser() + ",用户姓名:" + user.getName() + "]。");
//		return jsonObject;
//	}
//
//	/**
//	 * 请求删除用户信息
//	 * 
//	 * @param iuser
//	 *            用户信息主键
//	 * @return
//	 */
//	@RequestMapping("/user_delete.ajax")
//	@ResponseBody
//	public JSONObject delete(Integer iuser) {
//		JSONObject jsonObject = new JSONObject();
//		User user = userService.findById(iuser);
//		userService.delete(user);
//		jsonObject.put("code", 0);
//		logger.info("删除用户基本信息[ID:" + user.getIuser() + ",用户姓名:" + user.getName() + "]。");
//		return jsonObject;
//	}
//	/**
//	 * 请求用户账号验证
//	 * 
//	 
//	 */
//	@RequestMapping("/check_accounts.ajax")
//	@ResponseBody
//	public JSONObject findByUserAccounts(String accounts) {
//		JSONObject jsonObject = new JSONObject();
//		User user = userService.findByAccounts(accounts);
//		System.out.println("zhanghao");
//		System.out.println(user);
//		if(user != null) {
//			//账号已经存在
//			jsonObject.put("code", 0);
//			}
//		else {
//			//账号不存在
//			jsonObject.put("code", 1);
//			}
//		
//		return jsonObject;
//	}
//
//	
//	/**
//	 * 请求用户信息修改的页面
//	 * 
//	 * @return
//	 */
//
//	@RequestMapping("/user_edit.html")
//	public ModelAndView toModify(Integer iuser) {
//		ModelAndView modelAndView = new ModelAndView();
//		User user=userService.findById(iuser);
//		
//		modelAndView.addObject("user", user);
//		
//		modelAndView.setViewName("manage/user/user_edit");
//		
//		return modelAndView;
//	}
//
//    /**
//	 * 请求用户信息
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/useredit.ajax")
//	@ResponseBody
//	public JSONObject edit(Integer iuser) {
//	  JSONObject jsonObject = new JSONObject();
//	  User user=userService.findById(iuser);
//	  jsonObject.put("user",user);
//	  return jsonObject;
//	}
//
//	/**
//	 * 请求修改用户信息
//	 * 
//	 * @param user
//	 * @param userSub
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/user_edit.ajax")
//	@ResponseBody
//	public JSONObject modify(User user) throws Exception {
//
//		JSONObject jsonObject = new JSONObject();
//		 String verifyUser = verifyUser(user);//基本信息校验结果
//	        
//	        String verify  = verifyUser ;
//			if (StringUtils.equals("",verifyUser ) ) {
//			userService.update(user);
//		} else {
//			jsonObject.put("verify", verify);
//			jsonObject.put("code", -2);
//			return jsonObject;
//		}
//
//		jsonObject.put("code", 0);
//		logger.info("修改用户基本信息[用户姓名:" + user.getName() + "]。");
//		return jsonObject;
//	}
//
//	/**
//	 * 校验user
//	 * 
//	 * @param user
//	 * @return
//	 */
//	private String verifyUser(User user) {
//		Integer iuser=user.getIuser();
//		String userName = user.getName().trim();
//		String department =user.getDepartment().trim();
//		String position = user.getPosition().trim();
//		String userType = user.getUserType().trim();
//		String accounts = user.getAccounts().trim();
//		String role = user.getRole().trim();
//		String password = user.getPassword().trim();
//		
//		String verifyResult = "";
//		if (StringUtils.isEmpty(department) || StringUtils.isEmpty(userType) || StringUtils.isEmpty(role) || StringUtils.isEmpty(accounts)  ) {
//			String msg = "基本信息不能为空";
//			logger.info(msg);
//			verifyResult += msg + ";";
//            return verifyResult;
//		}
//		
//		return verifyResult;
//	}
//	
//	private String verifyAdd(User user) {
//		Integer iuser=user.getIuser();
//		String userName = user.getName().trim();
//		String department =user.getDepartment().trim();
//		String position = user.getPosition().trim();
//		String userType = user.getUserType().trim();
//		String accounts = user.getAccounts().trim();
//		String role = user.getRole().trim();
//		String password = user.getPassword().trim();
//		
//		String verifyResult = "";
//		if (StringUtils.isEmpty(department) || StringUtils.isEmpty(userType) || StringUtils.isEmpty(role) || StringUtils.isEmpty(accounts)  ) {
//			String msg = "基本信息不能为空";
//			logger.info(msg);
//			verifyResult += msg + ";";
//            return verifyResult;
//		}
//		User us = userService.findByAccounts(user.getAccounts());
//		if(us != null) {
//			String msg = "用户已存在，添加失败";
//			logger.info(msg);
//			verifyResult += msg + ";";
//            return verifyResult;
//		}
//		return verifyResult;
//	}
//	
//	
//	



}
