package com.test.strategy;


import org.apache.commons.lang3.StringUtils;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,17:38
 * @version: 1.0
 * 封装最终的月薪计算方法
 */
public class SalaryCalculation {
    public static double getSalary(String type){
        //获得员工类型
        EmployeeType employeeType = getEmployeeType(type);
        //初始化一个员工
        Employee employee = StrategyFactory.getEmployee(employeeType);
        PayContext payContext = new PayContext(employee);
        double salary = payContext.getSalary();
        return salary;
    }

    private static EmployeeType getEmployeeType(String type){
        if(StringUtils.isEmpty(type)){
            return null;
        }
        if(type.equals("salary")){
            return EmployeeType.salary;
        }else if(type.equals("hour")){
            return EmployeeType.hour;
        }else{
            return EmployeeType.sale;
        }
    }
}
