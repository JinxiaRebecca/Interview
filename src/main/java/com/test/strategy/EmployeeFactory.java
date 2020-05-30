package com.test.strategy;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,17:21
 * @version: 1.0
 * 具体的策略工厂：即生成具体的员工的工厂类,因为要初始化birthday,所以舍弃
 */
public class EmployeeFactory {
    public static Employee getEmployee(EmployeeType employeeType){
        Employee employee = null;
        try {
            employee = (Employee) Class.forName(employeeType.getValue()).newInstance();
        } catch (Exception e) {
            System.out.println("新建员工失败");
            e.printStackTrace();
        }
        return employee;

    }
}
