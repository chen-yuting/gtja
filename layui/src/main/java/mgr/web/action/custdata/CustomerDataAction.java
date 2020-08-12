package mgr.web.action.custdata;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import commons.query.criterion.Page;
import mgr.web.commons.BaseAction;
import mgr.web.commons.Result;
import newland.gtja.custdata.cond.CustomerDataCond;
import newland.gtja.custdata.model.CustomerData;
import newland.gtja.custdata.service.CustomerDataService;
import newland.gtja.sys.user.model.User;

@Controller
@RequestMapping(value = "/mgr/custdata")
public class CustomerDataAction extends BaseAction{


	@Resource(name = "customerDataService")
	private CustomerDataService customerDataService;

	// 系统当前登陆用户
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * 获取选中客群数据详情
	 * 
	 * @param customerDataCond 
	 * @return
	 */
	@RequestMapping("/getCustomerData.ajax")
	@ResponseBody
	public Result getCustomerData(CustomerDataCond customerDataCond) {
		Result ret = new Result();
		List<CustomerData> customerDatas = customerDataService.findByCond(customerDataCond);
		//由于前端只能点击一条信息查询，所以只会查到一条数据。
		CustomerData customerData = customerDatas.get(0);
		ret.setCode(0);
		ret.setMsg("查询成功");
		ret.setData(customerData);
		return ret;
	}
	


	/**
	 * 批量删除
	 * 
	 * @param json String类型客户id的json串
	 * @return
	 */
	@RequestMapping("/batchDelete.ajax")
	@ResponseBody
	public Result batchDelete(String json) {

		List<CustomerData> customerDatas = JSONArray.parseArray(json, CustomerData.class);
		customerDataService.batchdel(customerDatas);
		Result ret = new Result();
		ret.setCode(0);
		ret.setMsg("批量删除成功");
		return ret;
	}

	/**
	 * 请求资金账号验证
	 * 
	 */
	@RequestMapping("/check_capitalAccount.ajax")
	@ResponseBody
	public Result findBycapitalAccount(Integer capitalAccount) {
		Result ret = new Result();
		CustomerDataCond cond=new CustomerDataCond();
		cond.setCapitalAccount(capitalAccount);
		List<CustomerData> list = customerDataService.findByCond(cond);
		if(list.size()>0) {
			//账号已经存在
			ret.setCode(0);
			ret.setMsg("账号已存在");
			}
		else {
			//账号不存在
			ret.setCode(1);
			ret.setMsg("账号不存在");
			}
		
		return ret;
	}
	
	/**
	 * 请求基本信息查询操作
	 * 
	 * @return
	 */
	@RequestMapping("/list.ajax")
	@ResponseBody
	public Result getList(Integer page, int limit, CustomerDataCond cond) {

		Page pag = extractedPage(page, limit);
		Result ret = new Result();
		List<CustomerData> list = customerDataService.findByPage(cond, pag);
		ret.setCode(0);
		ret.setMsg("查询列表成功");
		ret.setData(list);
		ret.setCount(pag.getRecAmt());
		return ret;
	}


	/**
	 * 请求保存客群数据信息
	 * 
	 * @param customerData 客群数据基本信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add.ajax")
	@ResponseBody
	public Result save(CustomerData customerData){

		Result ret = new Result();
		String verifyCustomerData = verify(customerData);// 基本信息校验结果
		String verify = verifyCustomerData;
		CustomerDataCond cond = new CustomerDataCond();
		cond.setCapitalAccount(customerData.getCapitalAccount());
		List<CustomerData> customerDatas = customerDataService.findByCond(cond);
		if (customerDatas.size() > 0) {
			CustomerData oldCustomerData = customerDatas.get(0);

			if (oldCustomerData != null) {
				int isCover = JOptionPane.showConfirmDialog(null, "添加失败，该客群数据已存在，是否覆盖？", "提示",
						JOptionPane.YES_NO_OPTION);
				if (isCover == JOptionPane.YES_OPTION) {
					customerDataService.delete(oldCustomerData);
				} else {

					return ret;
				}
			}
		}
		if (StringUtils.equals("", verifyCustomerData)) {
			if (customerData.getYearOfBirth() == null) {
				customerData.setYearOfBirth(0);
			}
			if (customerData.getInternalAssets() == null) {
				customerData.setInternalAssets(0);
			}
			if (customerData.getExtradivisionalAssets() == null) {
				customerData.setExtradivisionalAssets(0);
			}
			customerData.setAccountOpeningDate(new Date());
			customerDataService.save(customerData);
		} else {
			ret.setMsg(verify);
			ret.setCode(-2);
			return ret;
		}
		ret.setCode(0);
		
		return ret;
	}

	/**
	 * 请求删除客群数据信息
	 * 
	 * @param icustomerData 客群数据主键
	 * @return
	 */
	@RequestMapping("/delete.ajax")
	@ResponseBody
	public Result delete(int icustomerData) {
		Result ret = new Result();
		CustomerData customerData = customerDataService.findById(icustomerData);
		customerDataService.delete(customerData);
		ret.setCode(0);
		ret.setMsg("删除成功");
		return ret;
	}

	/**
	 
	/**
	 * 请求修改客群数据信息
	 * 
	 * @return
	 */
	@RequestMapping("/edit.ajax")
	@ResponseBody
	public Result edit(CustomerData customerData) {

		Result ret = new Result();
		String verifyCustomerData = verifyEdit(customerData);// 基本信息校验结果
		String verify = verifyCustomerData;
		if (StringUtils.equals("", verifyCustomerData)) {
			if (customerData.getYearOfBirth() == null) {
				customerData.setYearOfBirth(0);
			}
			if (customerData.getInternalAssets() == null) {
				customerData.setInternalAssets(0);
			}
			if (customerData.getExtradivisionalAssets() == null) {
				customerData.setExtradivisionalAssets(0);
			}
			customerDataService.update(customerData);
			ret.setCode(0);
			ret.setMsg("修改成功");
			return ret;
		} else {
			ret.setCode(-2);
			ret.setMsg(verify);
			return ret;
		}
	}

	/**
	 * 确认导出客群数据信息
	 * 
	 * @param cond
	 * @return
	 */
	@RequestMapping("/confirmCustomerData_excel.ajax")
	@ResponseBody
	public JSONObject confirmGetExcelList(CustomerDataCond cond) {
		JSONObject jsonObject = new JSONObject();
		List<CustomerData> list = customerDataService.findByCond(cond);
		jsonObject.put("data", list);
		return jsonObject;
	}

	/**
	 * 导出客群数据信息
	 * 
	 * @param cond
	 * @return
	 */
	@RequestMapping("/customerData_excel.ajax")
	@ResponseBody
	public JSONObject getExcelList(CustomerDataCond cond) {
		JSONObject jsonObject = new JSONObject();
		List<CustomerData> list = customerDataService.findByCond(cond);
		jsonObject.put("data", list);
		return jsonObject;
	}


	/**
	 * 请求确认导入客群数据信息
	 * 
	 * @return
	 */
	@RequestMapping("/confirmImportCustomerData.ajax")
	@ResponseBody
	public JSONObject confirmImportCustomerData(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		String filePath = "";
		JSONObject jsonObject = new JSONObject();
		if (file != null) {
			filePath = request.getServletContext().getRealPath("/") + "/files/";
			filePath = filePath.replace("\\", "/");
			Map<String, Integer> result = customerDataService.confirmImportCustomerData(file, filePath);
			jsonObject.put("code", result.get("code"));
			jsonObject.put("saveNum", result.get("saveNum"));
			jsonObject.put("updateNum", result.get("updateNum"));
		}
		return jsonObject;
	}

	/**
	 * 请求导入客群数据信息
	 * 
	 * @return
	 */
	@RequestMapping("/importCustomerData.ajax")
	@ResponseBody
	public JSONObject importCustomerData(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		String filePath = "";
		JSONObject jsonObject = new JSONObject();
		if (file != null) {
			filePath = request.getServletContext().getRealPath("/") + "/files/";
			filePath = filePath.replace("\\", "/");
			Map<String, Integer> result = customerDataService.importCustomerData(file, filePath);
			jsonObject.put("code", result.get("code"));
			jsonObject.put("saveNum", result.get("saveNum"));
			jsonObject.put("updateNum", result.get("updateNum"));
		}

		
		return jsonObject;
	}

	/**
	 * 
	 * 对customerData信息进行save正确性验证
	 * 
	 * @param customerData
	 * @return
	 */
	private String verify(CustomerData customerData) {

		String customerName = customerData.getCustomerName().trim();
		String businessDepartment = customerData.getBusinessDepartment().trim();
		Integer capitalAccount = customerData.getCapitalAccount();
		String verifyResult = "";
		if (StringUtils.isEmpty(customerName) || StringUtils.isEmpty(businessDepartment) || capitalAccount == null) {

			String msg = "必填信息不可以为空";
			
			verifyResult += msg + ";";
			return verifyResult;
		}

		return verifyResult;
	}

	/**
	 * 
	 * 对customerData信息进行edit正确性验证
	 * 
	 * @param customerData
	 * @return
	 */
	private String verifyEdit(CustomerData customerData) {

		String businessDepartment = customerData.getBusinessDepartment();
		String verifyResult = "";
		if (StringUtils.isEmpty(businessDepartment)) {

			String msg = "必填信息不可以为空";
			
			verifyResult += msg + ";";
			return verifyResult;
		}

		return verifyResult;
	}

}
