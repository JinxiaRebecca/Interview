package com.test.util;

import java.math.BigDecimal;

/**
 * @author:Rebecca Jin
 * @date: 2020/5/30,10:36
 * @version: 1.0
 *
 */
public class DoubleUtil {
    //加
    public static double add(double num1,double num2){
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        BigDecimal res = decimal1.add(decimal2);
        return res.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double add(double num1,double num2,double num3){
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        BigDecimal decimal3 = new BigDecimal(num3);
        BigDecimal res1 = decimal1.add(decimal2);
        BigDecimal res = res1.add(decimal3);
        return res.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    //减
    public static double subtarct(double num1,double num2){
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        BigDecimal res = decimal1.subtract(decimal2);
        return res.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    //乘
    public static double multiply(double num1,double num2){
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        BigDecimal res = decimal1.multiply(decimal2);
        return res.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double multiply(double num1,double num2,double num3){
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        BigDecimal decimal3 = new BigDecimal(num3);
        BigDecimal res1 = decimal1.multiply(decimal2);
        BigDecimal res  = res1.multiply(decimal3);
        return res.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    //除
    public static double divide(double num1,double num2){
        BigDecimal decimal1 = new BigDecimal(num1);
        BigDecimal decimal2 = new BigDecimal(num2);
        BigDecimal res = decimal1.divide(decimal2);
        return res.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }



}
