package exceptions;

public class TribeDOFireException extends Exception {

    public TribeDOFireException(){
        System.out.println("Error: incorrect tribe doFire. It can be only yes/no");
    }
}
