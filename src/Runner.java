import by.gsu.mslab.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        File file = new File("src/in.txt");
        Scanner scan = null;
        Purchase[] purchases = new Purchase[6];

        boolean equalCheck = true;

        try {

            scan = new Scanner(file);
            double maxCost = 0;

            for (int i = 0; i < purchases.length; i++) {

                purchases[i] = PurchasesFactory.getClassFromFactory(scan);
                System.out.println(purchases[i]);

                if (purchases[i].getCost() > maxCost) {
                    maxCost = purchases[i].getCost();
                }

                equalCheck = purchases[i].equals(purchases[0]);
            }

            System.out.println("\nPurchase with maximum cost - " + Converter.convert(maxCost,100,2));
            System.out.println("Are equal? - " +equalCheck);

        }catch (FileNotFoundException exception) {
            System.out.println("404 file not found");
        }finally {
            if (scan != null){
                scan.close();
            }
         }
    }
}