package com.test.strategy;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,17:12
 * @version: 1.0
 */
public class PayContext {
    private Employee employee =null;
    public PayContext(Employee employee){
        this.employee=employee;
    }

    public double getSalary(int month){
        return this.employee.getSalary(month);
    }
}
