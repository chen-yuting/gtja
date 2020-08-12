package newland.gtja.web.util;

import commons.query.criterion.Page;

public class ExtractedPage {
	public static Page getPage(Integer page, Integer limit) {
		Page paged = new Page();
		paged.setCapacity(limit);
		paged.setPageOffset(page - 1);
		paged.setCount(true);
		return paged;
	}
}
