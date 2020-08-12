package newland.gtja.custdata.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import commons.query.criterion.Page;
import newland.gtja.custdata.cond.CustomerDataCond;
import newland.gtja.custdata.dao.CustomerDataDao;
import newland.gtja.custdata.model.CustomerData;
import newland.gtja.custdata.service.CustomerDataService;
import newland.gtja.excel.model.ExcelModel;
import newland.gtja.excel.utils.imExcelUtil;

@Service("customerDataService")
@Transactional
public class CustomerDataServiceImpl implements CustomerDataService {

	@Resource(name = "customerDataDao")
	private CustomerDataDao customerDataDao;

	@Override
	public void save(CustomerData customerData) {
		// TODO Auto-generated method stub
		customerDataDao.save(customerData);
	}

	@Override
	public void delete(CustomerData customerData) {
		// TODO Auto-generated method stub
		customerDataDao.delete(customerData);
	}

	@Override
	public void update(CustomerData customerData) {
		// TODO Auto-generated method stub
		customerDataDao.update(customerData);
	}

	@Override
	public List<CustomerData> findByPage(CustomerDataCond cond, Page page) {
		// TODO Auto-generated method stub
		return customerDataDao.findByCond(cond, page);
	}

	@Override
	public List<CustomerData> findByCond(CustomerDataCond cond) {
		// TODO Auto-generated method stub
		return customerDataDao.findByCond(cond);
	}

	@Override
	public CustomerData findById(int icustomerData) {
		// TODO Auto-generated method stub
		return customerDataDao.getHibernateTemplate().get(CustomerData.class, icustomerData);
	}

	@Override
	public CustomerData findByCustomerName(String customerName) {
		// TODO Auto-generated method stub
		CustomerDataCond cond = new CustomerDataCond();
    	cond.setCustomerName(customerName);
    	List<CustomerData> list = this.findByCond(cond);
    	if(list != null && list.size() > 0){
    		return list.get(0);
    	}else{
    		return null;
    	}
	}

	@Override
	public void batchdel(List<CustomerData> customerDatas) {
		// TODO Auto-generated method stub
		customerDataDao.getHibernateTemplate().deleteAll(customerDatas);
	}

	@Override
	public Map<String, Integer> importCustomerData(MultipartFile file, String filePath) {
		// TODO Auto-generated method stub
		Map<String, Integer> result = new HashMap<String, Integer>();
		// logger.info("*********导入excel数据**********");
		// 获取上传文件的原本名称
		String orginalName = file.getOriginalFilename();
		// 获取文件的拓展名
		String ext = orginalName.substring(orginalName.lastIndexOf("."), orginalName.length());
		// 判断文件类型是否正确
		if (!(ext.equals(".xls") || ext.equals(".xlsx"))) {
			result.put("code", -2);
			return result;
		}
		// 为文件设置新名称 格式为UUID的前8位 加上 当前日期的datetime
		String newFileName = UUID.randomUUID().toString().substring(0, 8) + new Date().getTime() + ext;
		// 进行文件的保存
		File dir = new File(filePath, newFileName);
		try {
			file.transferTo(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 获取上传好的文件
		File uploadedFile = new File(filePath + newFileName);
		// 获取文件的数据
		ExcelModel excelModel = null;
		try {
			excelModel = imExcelUtil.readExcel(uploadedFile, null, 23);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (excelModel != null) {

			// 进行数据的转换
			@SuppressWarnings("rawtypes")

			List<List> dataList = excelModel.getDataList();
			// 检测excel表头是否正确
			if (!dataList.get(0).get(0).equals("客户姓名")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(1).equals("营业部")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(2).equals("资金账号")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(3).equals("性别")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(4).equals("出生年份")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(5).equals("职业")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(6).equals("开户时间")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(7).equals("司内资产")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(8).equals("司外资产")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(9).equals("司内资产类别")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(10).equals("用户画像")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(11).equals("投资偏好")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(12).equals("流动性要求")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(13).equals("外部资源")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(14).equals("其他备注")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(15).equals("子女情况")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(16).equals("子女年龄")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(17).equals("前次营销内容")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(18).equals("前次营销时间")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(19).equals("客户反馈及需求")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(20).equals("下次次营销目标")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(21).equals("下次营销时间")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(22).equals("营销内容")) {
				result.put("code", -3);
				return result;
			}
			int saveNum=0;
			int updateNum=0;
			// 判断数据是否有标题 通过第一行有的值来判断
			if (dataList.get(0).size() >= 1) {
				// 则获取数据要从第二行开始
				for (int i = 1; i < dataList.size(); i++) {
					String customerName = (String) dataList.get(i).get(0);
					String businessDepartment = (String) dataList.get(i).get(1);
					String capitalAccount=(String) dataList.get(i).get(2);
					if(capitalAccount=="") break;
					String gender = (String) dataList.get(i).get(3);
					String yearOfBirth = (String) dataList.get(i).get(4);
					String occupation = (String) dataList.get(i).get(5);
					String accountOpeningDate = (String) dataList.get(i).get(6);
					String internalAssets=(String) dataList.get(i).get(7);	
					String extradivisionalAssets=(String) dataList.get(i).get(8);
					String internalAssetsType = (String) dataList.get(i).get(9);
					String userProtrait = (String) dataList.get(i).get(10);
					String investmentPreference = (String) dataList.get(i).get(11);
					String liquidityRequirements = (String) dataList.get(i).get(12);
					String externalResources = (String) dataList.get(i).get(13);
					String otherRemarks = (String) dataList.get(i).get(14);
					String childrenSituation = (String) dataList.get(i).get(15);
					String childrenAge = (String) dataList.get(i).get(16);
					String previousMarketingContent = (String) dataList.get(i).get(17);
					String previousMarketingDate=(String) dataList.get(i).get(18);
					String customerFeedback = (String) dataList.get(i).get(19);
					String nextMarketingTarget =(String)  dataList.get(i).get(20);
					String nextMarketingDate = (String) dataList.get(i).get(21);
					String marketingContent =  (String) dataList.get(i).get(22);

					
					//处理非String类型的属性
					Date accountOpeningDate1 = new Date(accountOpeningDate);
					previousMarketingDate=previousMarketingDate.replaceAll("[^\\d]", "");
					Date previousMarketingDate1;
					if(previousMarketingDate.length()==0) {
						previousMarketingDate1=null;
					}
					else {
						String py=previousMarketingDate.substring(0, 4);
						String pm=previousMarketingDate.substring(4, 6);
						String pd=previousMarketingDate.substring(6, 8);
						previousMarketingDate1 = new Date(Integer.parseInt(py)-1900, Integer.parseInt(pm)-1,
								Integer.parseInt(pd));
					}
					
					
					nextMarketingDate=nextMarketingDate.replaceAll("[^\\d]", "");
					Date nextMarketingDate1;
					if(nextMarketingDate.length()==0) {
						nextMarketingDate1=null;
					}
					else {
						String ny=nextMarketingDate.substring(0, 4);
						String nm=nextMarketingDate.substring(4, 6);
						String nd=nextMarketingDate.substring(6, 8);
						nextMarketingDate1 = new Date(Integer.parseInt(ny)-1900, Integer.parseInt(nm)-1,
								Integer.parseInt(nd));
					}
					
					double capitalAccount1=Double.parseDouble(capitalAccount);
					int capitalAccount2=(int)capitalAccount1;
					
					double yearOfBirth1=Double.parseDouble(yearOfBirth);
					int yearOfBirth2=(int)yearOfBirth1;	
					
					double internalAssets1=Double.parseDouble(internalAssets);
					int internalAssets2=(int)internalAssets1;	
					
					double extradivisionalAssets1=Double.parseDouble(extradivisionalAssets);
					int extradivisionalAssets2=(int)extradivisionalAssets1;	
					
					CustomerDataCond cond = new CustomerDataCond();
					cond.setCapitalAccount(capitalAccount2);
					List<CustomerData> customerDatas = customerDataDao.findByCond(cond);
					
									
					if (customerDatas.size() < 1) {
						saveNum++;
						CustomerData customerData = new CustomerData();
						customerData.setCustomerName(customerName);
						customerData.setBusinessDepartment(businessDepartment);
						customerData.setCapitalAccount(capitalAccount2);
						customerData.setGender(gender);
						customerData.setYearOfBirth(yearOfBirth2);
						customerData.setOccupation(occupation);
						customerData.setAccountOpeningDate(accountOpeningDate1);
						customerData.setInternalAssets(internalAssets2);
						customerData.setExtradivisionalAssets(extradivisionalAssets2);
						customerData.setInternalAssetsType(internalAssetsType);
						customerData.setUserProtrait(userProtrait);
						customerData.setInvestmentPreference(investmentPreference);
						customerData.setLiquidityRequirements(liquidityRequirements);
						customerData.setExternalResources(externalResources);
						customerData.setOtherRemarks(otherRemarks);
						customerData.setChildrenSituation(childrenSituation);
						customerData.setChildrenAge(childrenAge);
						customerData.setPreviousMarketingContent(previousMarketingContent);
						customerData.setPreviousMarketingDate(previousMarketingDate1);
						customerData.setCustomerFeedback(customerFeedback);
						customerData.setNextMarketingTarget(nextMarketingTarget);
						customerData.setNextMarketingDate(nextMarketingDate1);
						customerData.setMarketingContent(marketingContent);
						customerDataDao.save(customerData);
					} else {
						updateNum++;
						customerDatas.get(0).setCustomerName(customerName);
						customerDatas.get(0).setBusinessDepartment(businessDepartment);
						customerDatas.get(0).setGender(gender);
						customerDatas.get(0).setYearOfBirth(yearOfBirth2);
						customerDatas.get(0).setOccupation(occupation);
						customerDatas.get(0).setAccountOpeningDate(accountOpeningDate1);
						customerDatas.get(0).setInternalAssets(internalAssets2);
						customerDatas.get(0).setExtradivisionalAssets(extradivisionalAssets2);
						customerDatas.get(0).setInternalAssetsType(internalAssetsType);
						customerDatas.get(0).setUserProtrait(userProtrait);
						customerDatas.get(0).setInvestmentPreference(investmentPreference);
						customerDatas.get(0).setLiquidityRequirements(liquidityRequirements);
						customerDatas.get(0).setExternalResources(externalResources);
						customerDatas.get(0).setOtherRemarks(otherRemarks);
						customerDatas.get(0).setChildrenSituation(childrenSituation);
						customerDatas.get(0).setChildrenAge(childrenAge);
						customerDatas.get(0).setPreviousMarketingContent(previousMarketingContent);
						customerDatas.get(0).setPreviousMarketingDate(previousMarketingDate1);
						customerDatas.get(0).setCustomerFeedback(customerFeedback);
						customerDatas.get(0).setNextMarketingTarget(nextMarketingTarget);
						customerDatas.get(0).setNextMarketingDate(nextMarketingDate1);
						customerDatas.get(0).setMarketingContent(marketingContent);
						customerDataDao.update(customerDatas.get(0));
					}
				}
			}
			result.put("code", 1);
			result.put("saveNum", saveNum);
			result.put("updateNum", updateNum);
			return result;
		}
		result.put("code", -2);
		return result;
	}
	
	@Override
	public Map<String, Integer> confirmImportCustomerData(MultipartFile file, String filePath) {
		// TODO Auto-generated method stub
		Map<String, Integer> result = new HashMap<String, Integer>();
		// logger.info("*********导入excel数据**********");
		// 获取上传文件的原本名称
		String orginalName = file.getOriginalFilename();
		// 获取文件的拓展名
		String ext = orginalName.substring(orginalName.lastIndexOf("."), orginalName.length());
		// 判断文件类型是否正确
		if (!(ext.equals(".xls") || ext.equals(".xlsx"))) {
			result.put("code", -2);
			return result;
		}
		// 为文件设置新名称 格式为UUID的前8位 加上 当前日期的datetime
		String newFileName = UUID.randomUUID().toString().substring(0, 8) + new Date().getTime() + ext;
		// 进行文件的保存
		File dir = new File(filePath, newFileName);
		try {
			file.transferTo(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 获取上传好的文件
		File uploadedFile = new File(filePath + newFileName);
		// 获取文件的数据
		ExcelModel excelModel = null;
		try {
			excelModel = imExcelUtil.readExcel(uploadedFile, null, 23);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (excelModel != null) {

			// 进行数据的转换
			@SuppressWarnings("rawtypes")

			List<List> dataList = excelModel.getDataList();
			// 检测excel表头是否正确
			if (!dataList.get(0).get(0).equals("客户姓名")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(1).equals("营业部")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(2).equals("资金账号")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(3).equals("性别")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(4).equals("出生年份")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(5).equals("职业")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(6).equals("开户时间")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(7).equals("司内资产")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(8).equals("司外资产")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(9).equals("司内资产类别")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(10).equals("用户画像")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(11).equals("投资偏好")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(12).equals("流动性要求")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(13).equals("外部资源")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(14).equals("其他备注")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(15).equals("子女情况")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(16).equals("子女年龄")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(17).equals("前次营销内容")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(18).equals("前次营销时间")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(19).equals("客户反馈及需求")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(20).equals("下次次营销目标")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(21).equals("下次营销时间")) {
				result.put("code", -3);
				return result;
			}
			if (!dataList.get(0).get(22).equals("营销内容")) {
				result.put("code", -3);
				return result;
			}
			int saveNum=0;
			int updateNum=0;
			// 判断数据是否有标题 通过第一行有的值来判断
			if (dataList.get(0).size() >= 1) {
				// 则获取数据要从第二行开始
				for (int i = 1; i < dataList.size(); i++) {
					String capitalAccount = (String) dataList.get(i).get(2);
					if(capitalAccount=="") break;
					double capitalAccount1=Double.parseDouble(capitalAccount);
					int capitalAccount2=(int)capitalAccount1;
					CustomerDataCond cond = new CustomerDataCond();
					cond.setCapitalAccount(capitalAccount2);
					List<CustomerData> customerDatas = customerDataDao.findByCond(cond);
					
					if (customerDatas.size() < 1) {
						saveNum++;						
					} 
					else {
						updateNum++;				
					}
				}
			}
			result.put("code", 1);
			result.put("saveNum", saveNum);
			result.put("updateNum", updateNum);
			return result;
		}
		result.put("code", -2);
		return result;
	}

}
