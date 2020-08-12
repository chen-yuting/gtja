package mgr.web.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import mgr.web.commons.Result;
import newland.gtja.sys.user.model.User;
import newland.gtja.sys.user.service.UserService;

@Controller
@RequestMapping("/mgr")
public class LoginAction {
	private static Logger logger = LoggerFactory.getLogger(LoginAction.class);

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/login.ajax")
	@ResponseBody
	public Result getLogin(String username, String password, HttpServletRequest request) {
		Result ret = new Result();
		//判断账号密码是否为空
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			ret.setCode(1);
			ret.setMsg("账号或密码不能为空");
			return ret;
		}

		logger.info("用户[{}]登录,登录密码为[{}]。", username, password);
		
		//检查用户密码是否正确
		User user = userService.checkUserLogin(username, password);
		if (user == null) {
			ret.setCode(1);
			ret.setMsg("用户或者密码错误");
			return ret;
		}

		// 去除密码信息
		user.setPassword("");
		request.getSession().setAttribute("user", user);
		ret.setCode(0);
		ret.setMsg("登入成功");
		JSONObject data = new JSONObject();
		data.put("access_tokendddd", "c262e61cd13ad99fc650e6908c7e5e65b63d2f32185ecfed6b801ee3fbdd5c0a");
		ret.setData(data);
		logger.info("用户[{}]登录成功，登录时间：{}", username, new Date());

		return ret;

	}

	@RequestMapping(value = "/logout.ajax")
	public void logout(HttpServletRequest request) {
		try {
			request.getSession().removeAttribute("employee");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		// return "redirect:/manage/login.html";
	}
}
