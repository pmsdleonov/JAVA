package by.gsu.mslab;

import java.util.Scanner;
import java.lang.String;

public class PurchasesFactory {

    private enum kindsOfPurchases{
        GENERAL_PURCHASE,DISCOUNT_PURCHASE,PERCENT_PURCHASE
    }
    public static Purchase getClassFromFactory(Scanner scan) {

        String id = scan.next();
        kindsOfPurchases kind = kindsOfPurchases.valueOf(id);

        switch (kind) {

            case GENERAL_PURCHASE:
                return new Purchase(scan);
            case DISCOUNT_PURCHASE:
                return new DiscountPurchase(scan);
            case PERCENT_PURCHASE:
                return new PercentPurchase(scan);
            default:
                throw new IllegalArgumentException("Error!");
        }
    }
}