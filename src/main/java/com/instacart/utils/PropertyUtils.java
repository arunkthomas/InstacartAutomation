package com.instacart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.instacart.constants.FrameworkConstants;

public final class PropertyUtils {
	
	private PropertyUtils() {
		
	}
	
	private static Properties property = new Properties();
	
	static {
		FileInputStream file = null;
		try {
			file = new FileInputStream(FrameworkConstants.getPropertyFilePath());
			property.load(file);
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Excel file you trying to read is not found");
		}
		catch (IOException e) {
			throw new RuntimeException("IO Exception happedned while reading excel file");
		}
		finally {
			try {
				if (Objects.nonNull(file)) {
					file.close();
				}
				
			} catch (IOException e) {
				throw new RuntimeException("Excel file you trying to read is not found");
			}
		}
	}
	

	
	public static String getValue(String key) {
		String value="";
		value = property.getProperty(key).trim();
		if (Objects.isNull(value) || Objects.isNull(key)){
			throw new RuntimeException(String.format("Property name %s is not found.Please check config.property file", key));
		}
		return value;
	} 

}
