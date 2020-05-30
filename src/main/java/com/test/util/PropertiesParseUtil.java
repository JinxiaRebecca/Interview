package com.test.util;

import java.util.ResourceBundle;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/30,10:00
 * @version: 1.0
 */
public class PropertiesParseUtil {

    public static double getBasicSalary(String path,String key) {
        ResourceBundle resource = ResourceBundle.getBundle(path);
        return Double.parseDouble(resource.getString(key));
    }

}
