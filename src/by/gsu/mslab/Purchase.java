package by.gsu.mslab;

import java.util.Scanner;

public class Purchase {

    private String commodityName;
    private int price;
    private int purchasedNum;

    public Purchase(){
        super();
    }

    public Purchase(String commodityName, int price, int purchasedNum) {
        this.commodityName = commodityName;
        this.price = price;
        this.purchasedNum = purchasedNum;
    }

    public Purchase(Scanner sc){
        this(sc.next(), sc.nextInt(), sc.nextInt());
    }

    public String getCommodityName() {
        return commodityName;
    }

    public int getPrice() {
        return price;
    }

    public int getPurchasedNum() {
        return purchasedNum;
    }
    public double getCost(){
        return price*purchasedNum;
    }

    public String toString(){
        return commodityName + ";" + Converter.convert(price,100,2) + ";" + purchasedNum + ";" + Converter.convert(getCost(),100,2);
    }

    public boolean equals(Purchase obj){
        boolean flag;
        if (obj.commodityName.equals(commodityName) && obj.price == price)
            flag = true;
        else
            flag = false;
        return flag;
    }



}
