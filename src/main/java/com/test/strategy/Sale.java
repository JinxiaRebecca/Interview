package com.test.strategy;

import com.test.constant.SalaryConst;
import com.test.util.DoubleUtil;
import com.test.util.PropertiesParseUtil;


import java.util.Date;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,16:51
 * @version: 1.0
 */
public class Sale extends Employee {
    private Double amount;

    public Sale(){

    }

    public Sale(Double amount) {
        this.amount = amount;
    }

    public Sale(String name, Date birthday, Double amount) {
        super(name, birthday);
        this.amount = amount;
    }

    public Sale(String name, Date birthday, Double salary, Double amount) {
        super(name, birthday, salary);
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public double getSalary(int month) {
        double birBonus = getBirBonus(month);
        String path ="basicSalary";
        String key = "sale.basic";
        double basicSal = PropertiesParseUtil.getBasicSalary(path,key);
        double lowRate = PropertiesParseUtil.getBasicSalary(path,"sale.lowRate");
        double highRate = PropertiesParseUtil.getBasicSalary(path,"sale.highRate");
        double salBonus = 0.00;
        double moreAmount = DoubleUtil.subtarct(amount, SalaryConst.BASIC_SALE_AMOUNT);;
        if(amount>=SalaryConst.TOP_SALE_AMOUNT){
            salBonus = DoubleUtil.multiply(moreAmount,highRate);
        }else if(amount>SalaryConst.BASIC_SALE_AMOUNT){
            salBonus = DoubleUtil.multiply(moreAmount,lowRate);
        }
        salary = DoubleUtil.add(basicSal,salBonus,birBonus);
        return salary;
    }
}
