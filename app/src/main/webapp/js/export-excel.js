//param:excel文件名，工作簿名，导出的数据集合，字段名集合，表头样式，表体样式
function toExcel(FileName, SheetName, JSONData, ShowLabel, StyleThead, StyleTbody) {  
    //先转化json  
    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;  
      
    var excel = '<table>';      
      
    if (ShowLabel[0][0] == null) {
    	//设置表头  
    	var row = "<tr align='center'>";//设置Excel的左居中
	    for (var i = 0, l = ShowLabel.length; i < l; i++) {  
	        for (var key in ShowLabel[i]) {
	            row += "<td style='" + StyleThead + "'>" + ShowLabel[i][key] + '</td>';  
	        }
	    }
	    //换行  
	    excel += row + "</tr>";
    	//设置数据  
	    for (var i = 0; i < arrData.length; i++) {
    		var rowData = "<tr align='center'>";
    		var tdData = showData(i, ShowLabel, arrData, StyleTbody);
    		excel += rowData + tdData + "</tr>";
    	}
    } else {
    	//设置表头  
    	var tableTitle = "<tr align='center'>";
    	tableTitle += "<td colspan='" + (ShowLabel[1].length + 1)  + "' style='font-size:20px;font-weight:bold;text-align:center;'>" + ShowLabel[0][0] + '</td>';
    	excel += tableTitle + "</tr>";
    	var row = "<tr align='center'>";//设置Excel的左居中
	    row += "<td rowspan='2' style='" + StyleThead + "'></td>";
	    for (var i = 0, l = ShowLabel[1].length; i < l; i++) {  
	        for (var key in ShowLabel[1][i]) {
	            row += "<td rowspan='2' style='" + StyleThead + "'>" + ShowLabel[1][i][key] + '</td>';  
	        }
	    }
	    //换行  
	    excel += row + "</tr><tr></tr>";
    	//设置数据  
    	for (var i = 0; i < arrData.length; i++) {
    		var rowData = "<tr align='center'>";
    		rowData += "<td style='vnd.ms-excel.numberformat:@;" + StyleTbody + "'>" + (i + 1) + "</td>";
    		var tdData = showData(i, ShowLabel[1], arrData, StyleTbody);
    		excel += rowData + tdData + "</tr>";
    	}
    }

    excel += "</table>";  

    var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";  
    excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';  
    excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel';  
    excelFile += '; charset=UTF-8">';  
    excelFile += "<head>";  
    excelFile += "<!--[if gte mso 9]>";  
    excelFile += "<xml>";  
    excelFile += "<x:ExcelWorkbook>";  
    excelFile += "<x:ExcelWorksheets>";  
    excelFile += "<x:ExcelWorksheet>";  
    excelFile += "<x:Name>";  
    excelFile += SheetName;  
    excelFile += "</x:Name>";  
    excelFile += "<x:WorksheetOptions>";  
 	excelFile += "<x:DisplayGridlines/>";
    excelFile += "</x:WorksheetOptions>";  
    excelFile += "</x:ExcelWorksheet>";  
    excelFile += "</x:ExcelWorksheets>";  
    excelFile += "</x:ExcelWorkbook>";  
    excelFile += "</xml>";  
    excelFile += "<![endif]-->";  
    excelFile += "</head>";  
    excelFile += "<body>";  
    excelFile += excel;  
    excelFile += "</body>";  
    excelFile += "</html>";  

      
    var uri = 'data:application/vnd.ms-excel;charset=utf-8,' + encodeURIComponent(excelFile);  
      
    var link = document.createElement("a");
    link.href = uri;  
      
    link.style = "visibility:hidden";  
    link.download = FileName + ".xls";  
      
    document.body.appendChild(link);  
    link.click();  
    document.body.removeChild(link);  
}
function showData(i, ShowLabel, arrData, StyleTbody) {
	var rowData = "";
		
    for (var y = 0; y < ShowLabel.length; y++) {
        for(var k in ShowLabel[y]){
            if (ShowLabel[y].hasOwnProperty(k)) {
            	rowData += "<td style='vnd.ms-excel.numberformat:@;" + StyleTbody + "'>";
            	if (arrData[i][k]===null) {
            		//值为空
            		rowData += "";
            	} else if ((typeof arrData[i][k]) == 'object') {
            		//值为时间对象
            		var time = arrData[i][k];
            		rowData += (time.year + 1900) + "年" + (time.month + 1) + "月" + time.date + "日";
            	} else if (k == "sex") {
            		//性别
            		if (arrData[i][k] == 1) {
            			rowData += "男";
            		} else {
            			rowData += "女";
            		}
            	} else {
            		rowData += arrData[i][k];
            	}
            	if (k == "schedule") {
            		//需要加上百分比的字段
            		rowData += "%";
            	}
            	rowData += "</td>";
 //vnd.ms-excel.numberformat:@ 输出为文本
            }
        }
    }
    return rowData;
}
