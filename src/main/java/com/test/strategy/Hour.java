package com.test.strategy;


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

    public Hour() {
        super();
    }

    public Hour(String name, Date birthday) {
        super(name, birthday);

    }

    public Hour(String name, Date birthday, Double salary) {
        super(name, birthday, salary);

    }

    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public double getSalary() {
        String path ="basicSalary";
        String key = "hour.basic";
        double basicSalPerHour = PropertiesParseUtil.getBasicSalary(path,key);
        if(workingHours>160.00){
            double moreHours = DoubleUtil.subtarct(workingHours,160.0);
            double moreSal = DoubleUtil.multiply(moreHours,basicSalPerHour,1.3);
            double basic = DoubleUtil.multiply(basicSalPerHour,160.0);
            salary = DoubleUtil.add(moreSal,basic,salary);
        }else{
            double basic = DoubleUtil.multiply(basicSalPerHour,workingHours);
            salary =DoubleUtil.add(basic,salary);
        }
        return salary;
    }
}
