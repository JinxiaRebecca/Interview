package com.test.strategy;


import com.test.constant.SalaryConst;
import com.test.util.DoubleUtil;
import com.test.util.PropertiesParseUtil;


import java.util.Date;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/29,16:33
 * @version: 1.0
 */
public class Hour extends Employee {
    private Double workingHours;

    public Hour(){
        super();
    }
    public Hour(Double workingHours) {
        this.workingHours = workingHours;
    }

    public Hour(String name, Date birthday, Double workingHours) {
        super(name, birthday);
        this.workingHours = workingHours;
    }

    public Hour(String name, Date birthday, Double salary, Double workingHours) {
        super(name, birthday, salary);
        this.workingHours = workingHours;
    }

    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public double getSalary(int month) {
        String path ="basicSalary";
        String key = "hour.basic";
        double basicSalPerHour = PropertiesParseUtil.getBasicSalary(path,key);
        double rate = PropertiesParseUtil.getBasicSalary(path,"hour.rate");
        double birBonus = getBirBonus(month);
        if(workingHours> SalaryConst.BASIC_WOKING_HOUR){
            double moreHours = DoubleUtil.subtarct(workingHours,SalaryConst.BASIC_WOKING_HOUR);
            double moreSal = DoubleUtil.multiply(moreHours,basicSalPerHour,rate);
            double basic = DoubleUtil.multiply(basicSalPerHour,SalaryConst.BASIC_WOKING_HOUR);
            salary = DoubleUtil.add(moreSal,basic);
        }else{
            double basic = DoubleUtil.multiply(basicSalPerHour,workingHours);
            salary =DoubleUtil.add(basic,salary);
        }
            salary =DoubleUtil.add(salary,birBonus);
        return salary;
    }
}
