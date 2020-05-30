package com.test.strategy;

import java.util.Calendar;
import java.util.Date;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,15:59
 * @version: 1.0
 */
public abstract class Employee {
    public String name;
    public Date birthday;
    public Double salary = 0.00;

    public Employee(){
        this.salary = getBirBonus();
    }

    public Employee(String name,Date birthday){
        this.name = name;
        this.birthday = birthday;
        this.salary = getBirBonus();
    }

    public Employee(String name,Date birthday,Double salary){
        this.name = name;
        this.birthday = birthday;
        this.salary = salary+getBirBonus();

    }



    public abstract double getSalary();

    //获取生日奖金
    public Double getBirBonus(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        calendar.setTime(birthday);
        int birMonth = calendar.get(Calendar.MONTH)+1;
        return month==birMonth?this.salary+100.00:this.salary;
    }

    public void dispaly(){
        System.out.println("员工"+name+"的工资为："+salary);
    }


}
