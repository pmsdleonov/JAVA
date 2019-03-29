import by.gsu.pmslab.BusinessTrip;
import by.gsu.pmslab.Converter;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip [] businessTrips = {
                new BusinessTrip("Leonov Daniil", 2550 , 10),
                new BusinessTrip("Socolov Evgeniy", 3820, 12),
                new BusinessTrip(null,0,0),
                new BusinessTrip("Vinogradov Pavel",5500,4),
                new BusinessTrip("Kiselev Aleksei",4230,19),
                new BusinessTrip("Petrov Petr", 1300,21),
                new BusinessTrip()
        };

        for(BusinessTrip item : businessTrips){
            item.show();
            System.out.println();
        }

        businessTrips[6].setTransport(1000);

        System.out.println("Duration = "+ (businessTrips[0].getDays()+businessTrips[1].getDays()));
        System.out.println();

        for (BusinessTrip item : businessTrips) {
            System.out.println(item);
            System.out.println();
        }

        int total_sum = 0;
        for(BusinessTrip item : businessTrips){
            total_sum += item.getTotal();
        }
        System.out.println("Total expenses = "+Converter.convert(total_sum,100,2));

        BusinessTrip max_total = businessTrips[0];
        for(BusinessTrip item : businessTrips){
            if(item.getTotal() > max_total.getTotal())
                max_total = item;
        }
        System.out.println("Max total account - " + max_total.getAccount());



    }
}