package by.gsu.mslab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase implements Comparable<Purchase> {

    private String name;
    private int price;
    private int units;

    public Purchase(){}

    public Purchase(String name, int price, int units){
        this.name = name;
        this.price = price;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }


    public int getCost() {
        return price * units;
    }

    protected String fieldsToString() {
        return  name + ";" + price + ";" + units;
    }

    @Override
    public String toString(){
        return fieldsToString()+";"+getCost();
    }

    public Purchase(Scanner sc){
        this(sc.next(), (sc.nextInt()), sc.nextInt());
    }
    public Purchase(String[] csvSplit){
        this(csvSplit[0], (Integer.parseInt(csvSplit[1])), Integer.parseInt(csvSplit[2]));
    }


    @Override
    public int compareTo(Purchase purchase) {
        return this.getCost() - purchase.getCost();
    }
}
