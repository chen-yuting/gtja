package newland.gtja.excel.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import newland.gtja.excel.model.ExcelModel;

/**
 * 表格工具excel
 * 
 * @author Administrator
 *
 */
public class imExcelUtil { 
	/**
	 * 读取文件内容
	 * 
	 * @param file
	 *            目标文件
	 * @param rowCount
	 *            要读取的行数
	 * @param columnCount
	 *            要读取的列数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ExcelModel readExcel(File file, Integer rowCount, Integer columnCount) {
		Workbook wb = null;
		String path = file.getAbsolutePath();
		String ext = path.substring(path.lastIndexOf(".") + 1, path.length());
		ExcelModel excelModel = new ExcelModel();
		List<List> dataList = new ArrayList<List>();
		InputStream is;
		try {
			is = new FileInputStream(file);
			if (ext.equals("csv") || ext.equals("xls")) {
				wb = new HSSFWorkbook(is);
			} else {
				wb = new XSSFWorkbook(is);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 开始读取数据
		// 解析sheet
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = wb.getSheetAt(i);
			excelModel.setSheetName(sheet.getSheetName());
			int readRowCount = 0;
			if (rowCount == null || rowCount > sheet.getPhysicalNumberOfRows()) {
				readRowCount = sheet.getPhysicalNumberOfRows();
			} else {
				readRowCount = rowCount;
			}
			// 解析sheet 的行
			for (int j = sheet.getFirstRowNum(); j < readRowCount; j++) {
				Row row = sheet.getRow(j);
				if (row == null) {
					continue;
				}
				if (row.getFirstCellNum() < 0) {
					continue;
				}
				int readColumnCount = 0;
				if (columnCount == null || columnCount > row.getLastCellNum()) {
					readColumnCount = (int) row.getLastCellNum();
				} else {
					readColumnCount = columnCount;
				}
				List<Object> rowValue = new LinkedList<Object>();
				// 解析sheet 的列
				for (int k = 0; k < readColumnCount; k++) {
					Cell cell = row.getCell(k);
					rowValue.add(getCellValue(wb, cell));
				}
				dataList.add(rowValue);
			}

		}
		excelModel.setDataList(dataList);
		String title = null;
		if (excelModel.getDataList() != null && excelModel.getDataList().size() > 0) {
			title = (String) excelModel.getDataList().get(0).get(0);
		}
		excelModel.setTitle(title);
		return excelModel.getDataList().size() == 0 ? null : excelModel;
	}

	/**
	 * 读取每个单元格的内容
	 * 
	 * @param wb
	 *            工作表
	 * @param cell
	 *            单元格
	 */
	@SuppressWarnings("deprecation")
	private static Object getCellValue(Workbook wb, Cell cell) {
		Object columnValue = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_FORMULA:
				try {
					columnValue = String.valueOf(cell.getStringCellValue());
				} catch (IllegalStateException e) {
					try {
						columnValue = String.valueOf(cell.getNumericCellValue());
					} catch (IllegalStateException e1) {
						columnValue = "#VALUE!";
					}
				}
				break;
			case Cell.CELL_TYPE_ERROR:
				columnValue = "非法字符";
				break;

			case Cell.CELL_TYPE_NUMERIC:
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					columnValue = HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString();
				} else {
					columnValue = cell.toString();
				}
				break;
			default:
				columnValue = cell.toString();
			}
		} else {
			columnValue = "";
		}
		return columnValue;
	}

	@SuppressWarnings("rawtypes")
	public static List<List> readCsv(File file) {
		List<List> list = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		String everyLine = "";
		List<String> allString = new ArrayList<>();
		
		try {
			
			while ((line = br.readLine()) != null) // 读取到的内容给line变量
			{
				if(line.contains("|")){
					everyLine = line;
					System.out.println(everyLine);
					allString.add(everyLine);
				}
			}
			System.out.println("csv表格中所有行数：" + allString.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String oneData:allString){
			List<String> oneString = new ArrayList<>();
			String[] oneStrings ;
			oneStrings = oneData.split("\\|");
			for(String countData:oneStrings){
				oneString.add(countData);
			}
			list.add(oneString);
		}
		
		return list;
	}
}

