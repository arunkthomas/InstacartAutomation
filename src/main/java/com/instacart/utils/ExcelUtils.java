package com.instacart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.instacart.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getData(String sheetName) {
		FileInputStream file=null;
		XSSFWorkbook workbook=null;
		List<Map<String,String>> list =null;
		try {
			file =new FileInputStream(FrameworkConstants.getExcelFilePath());
			workbook= new XSSFWorkbook(file);
			XSSFSheet sheet= workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			list =new ArrayList<Map<String,String>>();
			Map<String,String> map;
			for(int i=1; i<=rowCount;i++) {
				map= new HashMap<String,String>();
				for(int j=0; j<columnCount;j++) {
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);

			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Excel file you trying to read is not found");
		} catch (IOException e) {
			throw new RuntimeException("IO Exceprion happened while reading excel file ");

		}
		finally {
			if (Objects.nonNull(file)) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return list;

	}

}
