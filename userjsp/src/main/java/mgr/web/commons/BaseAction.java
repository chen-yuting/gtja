package mgr.web.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import commons.query.criterion.Page;

public abstract class BaseAction {

	/**
	 * 
	 * @Title: extractedPage @Description: 根据页码和每页记录数封装Page对象 @param @param page
	 *         页码 @param @param limit 每页记录数 @param @return 参数 @return Page
	 *         用于分页查询的Page对象 @throws
	 */
	protected Page extractedPage(Integer page, Integer limit) {
		Page pag = new Page();
		pag.setCapacity(limit);
		pag.setPageOffset(page - 1);
		pag.setCount(true);
		return pag;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// 转换日期
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
	}
}
