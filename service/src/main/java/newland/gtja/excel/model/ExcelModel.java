package newland.gtja.excel.model;

import java.io.Serializable;
import java.util.List;

/**
 * excel导入的表的model
 * @author Administrator
 *
 */
public class ExcelModel implements Serializable {

	private static final long serialVersionUID = -3229974876795056330L;

	private String title; // 表题

	private String sheetName; // 工作表名称

	private String[] headers; // 表格头部标题集合

	@SuppressWarnings("rawtypes")
	private List<List> dataList; // 要导入或者导出的数据集合

	public String getSheetName() {
		return sheetName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	@SuppressWarnings("rawtypes")
	public List<List> getDataList() {
		return dataList;
	}

	@SuppressWarnings("rawtypes")
	public void setDataList(List<List> dataList) {
		this.dataList = dataList;
	}

}
