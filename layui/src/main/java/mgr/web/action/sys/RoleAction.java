package mgr.web.action.sys;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import commons.query.criterion.Page;
import mgr.web.commons.BaseAction;
import mgr.web.commons.Result;
import newland.gtja.sys.role.cond.RoleCond;
import newland.gtja.sys.role.model.Role;
import newland.gtja.sys.role.service.RoleService;

@Controller
@RequestMapping("/mgr/sys/role")
public class RoleAction extends BaseAction {

	@Resource(name = "roleService")
	private RoleService roleService;

	/**
	 * 请求角色列表详情
	 * 
	 * @param page     当前页码
	 * @param limit    每页记录数
	 * @param roleCond 用户列表搜索条件，注意传来的beginCrtTime和endCrtTime格式不能为时间戳，最好是yyyy-MM-dd
	 * @return
	 */
	@RequestMapping("/list.ajax")
	@ResponseBody
	public Result getList(Integer page, Integer limit, RoleCond roleCond) {
		Result ret = new Result();
		Page pag = extractedPage(page, limit);
		List<Role> roles = roleService.findRoleByPage(roleCond, pag);
		ret.setCode(0);
		ret.setMsg("查询成功");
		ret.setData(roles);
		ret.setCount(pag.getRecAmt());
		return ret;
	}

	/**
	 * 获取选中角色详情
	 * 
	 * @param roleCond 前端只要传来irole
	 * @return
	 */
	@RequestMapping("/getRole.ajax")
	@ResponseBody
	public Result getRole(RoleCond roleCond) {
		Result ret = new Result();
		Role role = roleService.findFirstCond(roleCond);
		ret.setCode(0);
		ret.setMsg("查询成功");
		ret.setData(role);
		return ret;
	}

	
	/**
	 * 新增角色
	 * 
	 * @param role 角色
	 * @return
	 */
	@RequestMapping("/add.ajax")
	@ResponseBody
	public Result add(Role role) {
		Result ret = new Result();
		// 为初次创建的用户设置当前时间为创建时间已经修改时间
		role.setCrtTime(new Date());
		role.setUpdTime(new Date());
		roleService.addRole(role);
		ret.setCode(0);
		ret.setMsg("创建用户[" + role.getRoleName() + "]成功！");
		return ret;
	}

	/**
	 * 修改角色
	 * 
	 * @param role 角色
	 * @return
	 */
	@RequestMapping("/edit.ajax")
	@ResponseBody
	public Result edit(Role role) {
		Result ret = new Result();
		// 获取到数据库中的role
		RoleCond roleCond = new RoleCond();
		roleCond.setIrole(role.getIrole());
		Role findRole = roleService.findFirstCond(roleCond);
		// 将数据库查询到的findRole的创建时间赋给修改的role
		role.setCrtTime(findRole.getCrtTime());
		// 设置当前时间为修改时间
		role.setUpdTime(new Date());
		roleService.updateRole(role);
		ret.setCode(0);
		ret.setMsg("修改原用户名["+findRole.getRoleName()+"]成功！");
		return ret;
	}

	/**
	 * 删除角色
	 * 
	 * @param role 角色
	 * @return
	 */
	@RequestMapping("/delete.ajax")
	@ResponseBody
	public Result delete(Role role) {
		Result ret = new Result();
		RoleCond cond=new RoleCond();
		cond.setIrole(role.getIrole());
		String roleName=roleService.findRoleByCond(cond).get(0).getRoleName();
		roleService.deleteRole(role);
		ret.setCode(0);
		ret.setMsg("删除用户["+roleName+"]成功！");
		return ret;
	}
	
	/**
	 * 批量删除角色
	 * 
	 * @param json String类型用户id的json串
	 * @return
	 */
	@RequestMapping("/batchDelete.ajax")
	@ResponseBody
	public Result batchDelete(String json) {
		List<Role> roles = JSONArray.parseArray(json, Role.class);
		roleService.batchDelRole(roles);
		Result ret = new Result();
		ret.setCode(0);
		ret.setMsg("批量删除成功");
		return ret;
	}
	


}
