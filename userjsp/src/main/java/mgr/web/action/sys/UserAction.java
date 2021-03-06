package mgr.web.action.sys;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;

import commons.query.criterion.Page;
import mgr.web.commons.BaseAction;
import mgr.web.commons.Result;
import newland.gtja.sys.user.cond.UserCond;
import newland.gtja.sys.user.model.User;
import newland.gtja.sys.user.service.UserService;

@Controller
@RequestMapping("/mgr/sys/user")
public class UserAction extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger(UserAction.class);

	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * 跳转list界面
	 * 
	 * @return
	 */
	@RequestMapping("/list.mvc")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mgr/sys/user/list");
		return mv;
	}

	/**
	 * 请求用户列表详情
	 * 
	 * @param page  当前页码
	 * @param limit 每页记录数
	 * @param cond  用户列表搜索条件
	 * @return
	 */
	@RequestMapping("/list.ajax")
	@ResponseBody
	public Result getList(Integer page, Integer limit, UserCond cond) {
		Page pag = extractedPage(page, limit);
		Result ret = new Result();
		List<User> list = userService.findByPage(cond, pag);
		ret.setCode(0);
		ret.setMsg("查询列表成功");
		ret.setData(list);
		ret.setCount(pag.getRecAmt());
		return ret;
	}

	/**
	 * 跳转查看详情界面
	 * @param user,只传递iuser
	 * @return
	 */
	@RequestMapping("/detail.mvc")
	public ModelAndView detail(User user) {
		UserCond userCond = new UserCond();
		userCond.setIuser(user.getIuser());
		User findUser = userService.findFirstCond(userCond);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",findUser);
		mv.setViewName("mgr/sys/user/detail");
		return mv;
	}

	
//	/**
//	 * 获取选中用户详情
//	 * 
//	 * @param userCond 前端只要传来accounts
//	 * @return
//	 */
//	@RequestMapping("/getUser.ajax")
//	@ResponseBody
//	public Result getUser(UserCond userCond) {
//		Result ret = new Result();
//		User user = userService.findFirstCond(userCond);
//		ret.setCode(0);
//		ret.setMsg("查询成功");
//		ret.setData(user);
//		return ret;
//	}
	
	/**
	 * 跳转新增界面
	 * 
	 * @return
	 */
	@RequestMapping("/add.mvc")
	public ModelAndView toAdd() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mgr/sys/user/add");
		return mv;
	}
	
	/**
	 * 新增用户信息
	 * 
	 * @param User 系统用户
	 * @return
	 */
	@RequestMapping("/add.ajax")
	@ResponseBody
	public Result addUser(User user) {
		Result ret = new Result();
		String verifyUser = verifyAdd(user);// 基本信息校验结果
		if (StringUtils.equals("", verifyUser)) {
			userService.save(user);
			ret.setMsg("添加成功");
			logger.debug("添加用户基本信息和详细信息ID [{}],用户姓名 [{}]。",user.getIuser(),user.getName());
			ret.setCode(0);
		} else {
			ret.setCode(1);
			ret.setMsg(verifyUser);
		}
		
		return ret;
	}

	/**
	 * 删除用户
	 * 
	 * @param User 系统用户，里面只要有iuser值就行
	 * @return
	 */
	@RequestMapping("/delete.ajax")
	@ResponseBody
	public Result delete(User user) {
		Result ret = new Result();
		userService.delete(user);
		ret.setCode(0);
		ret.setMsg("删除成功");
		logger.debug("删除用户基本信息ID [{}],用户姓名 [{}]。",user.getIuser(),user.getName());
		return ret;
	}
	
	/**
	 * 跳转修改界面
	 * 
	 * @param user 角色 //role里面只要有iuser就好了
	 * 
	 * @return
	 */
	@RequestMapping("/edit.mvc")
	public ModelAndView Edit(User user) {
		UserCond userCond = new UserCond();
		userCond.setIuser(user.getIuser());
		User findUser = userService.findFirstCond(userCond);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", findUser);
		mv.setViewName("mgr/sys/user/edit");
		return mv;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/edit.ajax")
	@ResponseBody
	public Result edit(User user) {

		Result ret = new Result();
		userService.update(user);
		ret.setCode(0);
		ret.setMsg("修改成功");
		logger.debug("修改用户基本信息,原用户姓名 [{}]。",user.getName());
		return ret;
	}

	/**
	 * 查询用户账号是否存在
	 * 
	 * @param accounts 用户账号
	 * @return
	 */
	@RequestMapping("/check_accounts.ajax")
	@ResponseBody
	public Result checkAccount(String accounts) {

		Result ret = new Result();
		User user = userService.findByAccounts(accounts);
		if (user != null) {
			// 账号已经存在
			ret.setCode(1);
			ret.setMsg("账号已存在");
		} else {
			// 账号不存在
			ret.setCode(0);
			ret.setMsg("账号不存在");
		}

		return ret;
	}

	/**
	 * 批量删除
	 * 
	 * @param json String类型用户id的json串
	 * @return
	 */
	@RequestMapping("/batchDelete.ajax")
	@ResponseBody
	public Result batchDelete(String json) {

		List<User> users = JSONArray.parseArray(json, User.class);
		userService.batchdel(users);
		Result ret = new Result();
		ret.setCode(0);
		ret.setMsg("批量删除成功");
		return ret;
	}

	private String verifyAdd(User user) {
		String verifyResult = "";
		User us = userService.findByAccounts(user.getAccounts());
		if (us != null) {
			String msg = "用户已存在，添加失败";
			verifyResult += msg + ";";
			return verifyResult;
		}
		return verifyResult;
	}

}
