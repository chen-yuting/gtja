package newland.gtja.custdata.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import commons.query.criterion.Page;
import newland.gtja.custdata.cond.CustomerDataCond;
import newland.gtja.custdata.model.CustomerData;

public interface CustomerDataService {

	// 增加
	public void save(CustomerData customerData);

	// 删除
	public void delete(CustomerData customerData);

	// 修改
	public void update(CustomerData customerData);

	// 分页查找
	public List<CustomerData> findByPage(CustomerDataCond cond, Page page);

	// 根据条件查询客群数据信息
	public List<CustomerData> findByCond(CustomerDataCond cond);

	// 根据id查找
	public CustomerData findById(int icustomerData);

	// 根据客户姓名查找
	public CustomerData findByCustomerName(String customerName);

	//批量删除
	public void batchdel(List<CustomerData> customerDatas);
	
	// 导入客群数据信息
	public Map<String, Integer> importCustomerData(MultipartFile file, String filePath);
	
	// 确认导入客群数据信息
	public Map<String, Integer> confirmImportCustomerData(MultipartFile file, String filePath);

}
