package com.test.strategy;


import com.test.util.DoubleUtil;
import com.test.util.PropertiesParseUtil;

import java.util.Date;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,16:03
 * @version: 1.0
 * 固定工资的员工
 */
public class Salary extends Employee {
    public Salary() {
    }

    public Salary(String name, Date birthday) {
        super(name, birthday);
    }

    public Salary(String name, Date birthday, Double salary) {
        super(name, birthday, salary);
    }

    @Override
    public double getSalary(int month) {
        String path ="basicSalary";
        String key = "work.basic";
        //从配置文件读取员工的固定工资
        double birBonus = getBirBonus(month);
        double basicSal = PropertiesParseUtil.getBasicSalary(path,key);
        salary = DoubleUtil.add(basicSal,birBonus);
        return salary;
    }
}
