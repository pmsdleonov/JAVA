package by.gsu.mslab;

import java.math.BigDecimal;

public class Converter {

    public static BigDecimal convert(double amount, int devider, int scale) {
        BigDecimal currensy = new BigDecimal(amount);
        BigDecimal devideIndex = new BigDecimal(devider);
        currensy = currensy.divide(devideIndex);
        currensy.setScale(scale);
        return currensy;
    }
}