package com.test.ioc;


import com.test.strategy.*;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.lang.reflect.Field;
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
        HashMap<Employee,Integer> employeesMap = new HashMap<Employee,Integer>();
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
                //从工厂获取实例
                EmployeeType employeeType = EmployeeType.valueOf(type);
                Employee employee = EmployeeFactory.getEmployee(employeeType);
                employee.name = name;
                employee.birthday = birthday;
                Class<?> clazz = Class.forName(employeeType.getValue());
                Field[] fields = clazz.getDeclaredFields();
                //为私有属性赋值
                List<Attribute> attributes = employElement.attributes();
                for (Attribute attribute : attributes) {
                    for (Field field : fields) {
                        field.setAccessible(true);
                        int modifiers = field.getModifiers();
                        if(field.getName().equals(attribute.getName())&&modifiers==2){
                            field.set(employee,Double.parseDouble(attribute.getValue()));
                            continue;
                        }

                    }
                }
                employeesMap.put(employee,month);


            }

        }


        return employeesMap;
    }



}
