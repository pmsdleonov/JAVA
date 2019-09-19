package by.gsu.mslab;

import java.util.Scanner;

public class DiscountPurchase extends Purchase {

    private int discount;

    public DiscountPurchase(){
        super();
    }

    public DiscountPurchase(String commodityName, int price, int purchasedNum, int discount) {
        super(commodityName, price, purchasedNum);
        this.discount = discount;
    }

    public DiscountPurchase(Scanner sc){
        super(sc.next(), sc.nextInt(), sc.nextInt());
        this.discount = sc.nextInt();
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double getCost(){
        return (getPrice() - discount) * getPurchasedNum();
    }

    @Override
    public String toString(){
        return super.toString() +";" + Converter.convert(discount,100,2);
    }
}