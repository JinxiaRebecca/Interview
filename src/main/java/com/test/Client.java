package com.test;


import com.test.ioc.ClassPathXmlBeanContext;
import com.test.strategy.Employee;
import com.test.strategy.PayContext;

import java.util.Map;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,16:11
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) throws Exception {
        String xmlPath = "Beans.xml";
        ClassPathXmlBeanContext beanContext = new ClassPathXmlBeanContext(xmlPath);
        Map<Employee,Integer> employees = beanContext.getEmployees();
        for(Map.Entry<Employee,Integer> entry:employees.entrySet()){
            Employee employee = entry.getKey();
            PayContext context = new PayContext(employee);
            int month = entry.getValue();
            System.out.println("员工"+employee.name+",月份"+month+"的工资为："+context.getSalary(month));
        }

    }
}
