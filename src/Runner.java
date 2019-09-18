import by.gsu.mslab.Tribe;

import java.io.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        char answer;
        final int TRIBES_NUMBER = 1;
        Tribe[] tribes = new Tribe[TRIBES_NUMBER];
        String filename;


        System.out.println("Write to new file(w) or Read info from file(r)?");
        answer = (char)System.in.read();

        Scanner scan = new Scanner(System.in);

        if (answer == 'w'){
            System.out.println("---------------------------");
            System.out.println("Directory, where file will be created: /src/example.txt");
            System.out.println("Enter filename: ");
            filename = scan.next();
            System.out.println("---------------------------");

            File file = new File("src/"+filename+".txt");
            if (file.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");

            FileOutputStream fileOutputStream = new FileOutputStream("src/"+filename+".txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Tribe tribe = new Tribe();

            System.out.println("---------------------------");
            System.out.println("Enter information about TRIBES");
            System.out.println("---------------------------");

            System.out.print("Enter name: ");
            tribe.setName(scan.next());

            System.out.print("Enter number: ");
            tribe.setNumber(scan.nextInt());

            System.out.print("Enter doFire?: ");
            tribe.setDoFire(scan.next());

            objectOutputStream.writeObject(tribe);

            System.out.println("---------------------------");
            System.out.println("Info has been written into "+"src/"+filename+".txt");
            System.out.println("---------------------------");

        }


        if (answer == 'r'){

            System.out.println("---------------------------");
            System.out.println("Directory where files are saved: /src/example.txt");
            System.out.println("Enter filename: ");

            filename = scan.next();

            if (new File(filename).exists() == true) {
                System.out.println("No such file in dir");
                System.exit(1);

            }

            FileInputStream fileInputStream = new FileInputStream("src/"+filename+".txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            for (int i = 0; i < TRIBES_NUMBER; i++){
                tribes[i] = (Tribe) objectInputStream.readObject();
                System.out.println(tribes[i].toString());
            }

        }

        scan.close();

    }
}
