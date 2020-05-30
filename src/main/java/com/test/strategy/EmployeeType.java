package com.test.strategy;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,17:14
 * @version: 1.0
 * 枚举所有的员工类型
 */
public enum EmployeeType {
    salary("com.test.strategy.Salary"),
    hour("com.test.strategy.Hour"),
    sale("com.test.strategy.Sale");

    String value = "";
    private EmployeeType(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
