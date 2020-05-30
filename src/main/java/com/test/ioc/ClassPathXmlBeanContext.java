package com.test.ioc;

import com.test.strategy.Employee;
import com.test.strategy.EmployeeType;
import com.test.strategy.Hour;
import com.test.strategy.Sale;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,17:30
 * @version: 1.0
 * 解析xml，创建bean
 */
public class ClassPathXmlBeanContext {
    private String xmlPath =null;

    public ClassPathXmlBeanContext(String xmlPath){
        this.xmlPath = xmlPath ;
    }

    public  Map<Employee,Integer> getEmployees() throws Exception{
        HashMap<Employee,Integer> employeesMap = new HashMap<>();
        SAXReader reader = new SAXReader();
        Document document = reader.read(this.getClass().getClassLoader().getResource(xmlPath));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        Integer month = null;
        for (Element element : elements) {
            String value = element.attributeValue("value");
            if(StringUtils.isEmpty(value)){
                continue;
            }
            month = Integer.parseInt(value);
            List<Element> employElements = element.elements();
            for (Element employElement : employElements) {
                String name = employElement.attributeValue("name");
                String type = employElement.attributeValue("type");
                String birStr =employElement.attributeValue("birthday");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = sdf.parse(birStr);
                //利用反射创建实例
                Class<?> clazz = Class.forName(EmployeeType.valueOf(type). getValue());
                Constructor<?> constructor = clazz.getConstructor(String.class, Date.class);
                Employee employee =(Employee) constructor.newInstance(name, birthday);
                double workingHour = 0.00;
                if(type.equals("hour")){
                    Hour hour = (Hour) employee;
                    double workingHours = Double.parseDouble(employElement.attributeValue("workingHours"));
                    hour.setWorkingHours(workingHours);
                    employeesMap.put(hour,month);
                    continue;
                }else if(type.equals("sale")){
                    Sale sale = (Sale) employee;
                    double amount = Double.parseDouble(employElement.attributeValue("amount"));
                    sale.setAmount(amount);
                    employeesMap.put(sale,month);
                    continue;
                }else if(type.equals("salary")){
                    employeesMap.put(employee,month);
                }

            }

        }


        return employeesMap;
    }



}
