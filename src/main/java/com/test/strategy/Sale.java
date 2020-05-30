package com.test.strategy;

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
        super();
    }
    public Sale(Double amount) {
        this.amount = amount;
    }

    public Sale(String name, Date birthday) {
        super(name, birthday);

    }

    public Sale(String name, Date birthday, Double salary) {
        super(name, birthday, salary);

    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public double getSalary() {
        String path ="basicSalary";
        String key = "sale.basic";
        double basicSal = PropertiesParseUtil.getBasicSalary(path,key);
        double salBonus = 0.00;
        double moreAmount = moreAmount = DoubleUtil.subtarct(amount,20000.0);;
        if(amount>=30000.00){
            salBonus = DoubleUtil.multiply(moreAmount,0.08);
        }else if(amount>20000.00){
            salBonus = DoubleUtil.multiply(moreAmount,0.05);
        }
        double bonus = DoubleUtil.add(basicSal,salBonus);
        return DoubleUtil.add(bonus,salary);
    }
}
