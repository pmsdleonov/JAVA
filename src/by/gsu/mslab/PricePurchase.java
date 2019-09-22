package by.gsu.mslab;

import java.util.Scanner;

public class PricePurchase extends Purchase {
    private int discount;

    public PricePurchase(String name, int price, int units, int discount){
        super(name, price, units);
        this.discount = discount;
    }
    public PricePurchase(Scanner sc){
        super(sc.next(), (sc.nextInt()), sc.nextInt());
        this.discount = (sc.nextInt()) ;
    }
    public PricePurchase(String[] csvSplit){
        super(csvSplit[0], (Integer.parseInt(csvSplit[1])), Integer.parseInt(csvSplit[2]));
        this.discount = (Integer.parseInt(csvSplit[3]));
    }
    public int getDiscount() {
        return discount;
    }

    @Override
    public int getCost(){
        return (getPrice())*discount*(getUnits());
    }
    protected String fieldsToString() {
        return  super.fieldsToString() + ";" + discount;
    }

    @Override
    public String toString(){
        return fieldsToString()+";"+getCost();
    }

}
