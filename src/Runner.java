import by.gsu.mslab.Tribe;
import java.util.*;

public class Runner{
    public static void main(String[] args){
        Tribe [] tribes = {
                new Tribe("Krivichi", 2100, "yes"),
                new Tribe("Radzimichi", 3800, "no"),
                new Tribe("Chervyane", 1800, "no"),
                new Tribe("White Horvats", 5000, "yes"),
                new Tribe("Volinyane", 4300, "no"),
                new Tribe("Drevlyane", 8100, "yes"),
                new Tribe("Polyane", 900, "no"),
                new Tribe("Dregovichi", 10000, "yes"),
                new Tribe("Severyane", 1100, "no"),
                new Tribe("Bolohovchy", 300, "no"),
        };
        System.out.println("\n\tStart array\n");
        for (Tribe item : tribes){
            System.out.println(item);
        }

        //Sorting array in ascending order(number)
        Arrays.sort(tribes, new Comparator<Tribe>() {
            @Override
            public int compare(Tribe o1, Tribe o2){
                return o1.getNumber() - o2.getNumber();
            }
        });
        System.out.println("\n\tSort by number:\n");
        for (Tribe item : tribes){
            System.out.println(item);
        }
        // Sort alphabetically
        Arrays.sort(tribes, new Comparator<Tribe>() {
            @Override
            public int compare(Tribe o1, Tribe o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("\n\tSort by name:\n");
        for (Tribe item : tribes){
            System.out.println(item);
        }

        int summNumber = 0;
        for (Tribe item : tribes){
            summNumber += item.getNumber();
        }
        System.out.println("\nTotal people in tribes: "+summNumber);

        int yesFire_count = 0;
        for (Tribe item : tribes){
            if(item.getFire() == "yes"){
                yesFire_count++;
            }
        }
        System.out.println("\nNumber of tribes familiar with fire: "+yesFire_count);
    }
}

