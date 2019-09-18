package by.gsu.mslab;

import java.io.Serializable;

public class Tribe implements Serializable {

    private String name;
    private int number;
    private String doFire;


    public Tribe(String name, int number, String doFire){
        this.name = name;
        this.number = number;
        this.doFire = doFire;

    }

    public  Tribe(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDoFire() {
        return doFire;
    }

    public void setDoFire(String doFire) {
        this.doFire = doFire;
    }

    public String toString(){
        return "Name: "+name+"; Number: "+number+"; doFire?: "+doFire;
    }
}