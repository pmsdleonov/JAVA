package by.gsu.mslab;

import java.util.Scanner;

public class PercentPurchase extends Purchase {

    private double percent;
    private final int NUMBER_PRODUCT = 8;
    private double result;

    public PercentPurchase(){
        super();
    }

    public PercentPurchase(String commodityName, int price, int purchasedNum, double percent) {
        super(commodityName, price, purchasedNum);
        this.percent = percent;
    }

    public PercentPurchase(Scanner sc){
        super(sc.next(), sc.nextInt(), sc.nextInt());
        this.percent = sc.nextDouble();
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public double getCost(){
        if (getPurchasedNum() >= NUMBER_PRODUCT)
            result = Math.round((getPrice() * NUMBER_PRODUCT * (1 - percent/100)) * 100)/100;
        else
            result = getPrice() * getPurchasedNum();
        return result;
    }

    @Override
    public String toString(){
        return super.toString() + ";" + percent + ";" + NUMBER_PRODUCT;
    }
}