package newland.gtja.web.action.login;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import newland.gtja.sys.user.model.User;
import newland.gtja.sys.user.service.UserService;

@Controller
@RequestMapping("/manage")
public class LoginAction {
	private static Logger logger = LoggerFactory.getLogger(LoginAction.class);

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/index.mvc")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manage/index");
		return mv;
	}

	@RequestMapping("/login.mvc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manage/login");
		return mv;
	}

	@RequestMapping("/checklogin.ajax")
	@ResponseBody
	public JSONObject getLogin(String accounts, String password, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotBlank(accounts) && StringUtils.isNotBlank(password)) {
			logger.info("用户[{}]登录,登录密码为[{}]。", accounts, password);
			User user = userService.checkUserLogin(accounts, password);
			if (user != null) {
				// 去除密码信息
				user.setPassword("");
				request.getSession().setAttribute("user", user);
				jsonObject.put("status", "1");
				logger.info("用户[{}]登录成功，登录时间：{}", accounts, new Date());
			} else {
				jsonObject.put("status", "0");
			}
		} else {
			jsonObject.put("status", "0");
		}

		return jsonObject;

	}

	@RequestMapping("/welcome.html")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manage/welcome");
		return mv;
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
