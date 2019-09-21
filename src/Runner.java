import by.gsu.mslab.Type;
import by.gsu.mslab.BusinessTrip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {

    private static final String FILE_PATH = "src/in.txt";
    private static final String ACCOUNT= "account";
    private static final String TRANSPORT= "transport";
    private static final String DAYS = "days";

    public static void main(String[] args) throws FileNotFoundException {

        int dailyRate = 0;
        String[] indexes = null;
        List<BusinessTrip> businessTrips = new ArrayList<>();
        String[] line = null;

        Scanner scanner = new Scanner(new File(FILE_PATH));

        line = scanner.nextLine().split("=");
        dailyRate = Integer.parseInt(line[1].trim());
        line = scanner.nextLine().split("=");
        indexes = line[1].trim().split(";");

        for (String item : indexes){

            BusinessTrip Trip = new BusinessTrip();
            Trip.setDailyRate(dailyRate);

            Scanner scan = new Scanner(new File(FILE_PATH));
            scan.nextLine();scan.nextLine();

            while (scan.hasNextLine()){

                line = scan.nextLine().split("=");
                String leftPart = line[0].trim();

                int currIndex = Integer.parseInt(leftPart.substring(leftPart.length()-2));
                String field = leftPart.substring(0, leftPart.length()-2);
                String value = line[1].trim();

                if (Integer.parseInt(item.trim()) == currIndex){

                    Trip.setId(currIndex);
                    switch (field){
                        case ACCOUNT:{
                            if (args.length == 2){
                                if (value.contains(args[0])){
                                    value = args[1];
                                }
                            }
                            Trip.setAccount(Type.valueOf(value.toUpperCase()));
                            break;
                        }
                        case TRANSPORT: Trip.setTransportExpences(Integer.parseInt(value));
                        break;
                        case DAYS: Trip.setDays(Integer.parseInt(value));
                        break;
                    }
                }
            }

            businessTrips.add(Trip);

        }

        System.out.println("\tStart information:");
        for (BusinessTrip item : businessTrips){
            System.out.println(item);
        }
        Collections.sort(businessTrips, new Comparator<BusinessTrip>() {
            @Override
            public int compare(BusinessTrip o1, BusinessTrip o2) {
                return o2.getTotalCost() - o1.getTotalCost();
            }
        });
        System.out.println("\tSorted information:");
        for (BusinessTrip item : businessTrips){
            System.out.println(item);
        }

    }
}
