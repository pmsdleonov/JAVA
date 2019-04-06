package by.gsu.mslab;

public class Tribe {
    private String name;
    private int number;
    private String fire;


    public Tribe(String name, int number, String fire) {
        this.name = name;
        this.number = number;
        this.fire = fire;
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

    public String getFire() {
        return fire;
    }

    public void setFire(String fire) {
        this.fire = fire;
    }

    @Override
    public String toString() {
        return name + ";" + number + ";" + fire;
    }
}



