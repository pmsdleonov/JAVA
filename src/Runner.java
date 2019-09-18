import by.gsu.mslab.Tribe;
import exceptions.FileIsExistException;
import exceptions.TribeDOFireException;
import exceptions.TribeNameException;
import exceptions.TribeNumberException;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FilenameFilter;

public class Runner {
    public static void main(String[] args) {

        char answer = 0;
        final int TRIBES_NUMBER = 5;
        Tribe[] tribes = new Tribe[TRIBES_NUMBER];
        String filename;

        int summNumber = 0;
        int doFireCount = 0;
        
        System.out.println("Write to new file(w) or Read info from file(r)?");

        try {
            answer = (char) System.in.read();
        } catch (IOException e) {
            System.out.println("Data entered incorrectly");
            System.exit(0);
        }

        Scanner scan = new Scanner(System.in);

        if (answer == 'w') {
            System.out.println("---------------------------");
            System.out.println("Directory, where file will be created: /home/alwayswannafly/lab4/src/");
            System.out.print("Enter filename: ");
            filename = scan.next();
            System.out.println("---------------------------");

            File file = new File("src/" + filename + ".txt");

            try {
                if(file.createNewFile() == false){
                    throw new FileIsExistException();
                }
                System.out.println("File Succesfully created");
            } catch (FileIsExistException | IOException e) {
            }

            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream("src/" + filename + ".txt");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                System.exit(0);
            }

            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                for (int i = 0; i < TRIBES_NUMBER; i++) {
                    Tribe tribe = new Tribe();
                    try {
                    System.out.println("---------------------------");
                    System.out.println("Enter information about TRIBES");
                    System.out.println("---------------------------");

                    System.out.print("Enter name: ");
                    tribe.setName(scan.next());

                    System.out.print("Enter number: ");
                    tribe.setNumber(scan.nextInt());

                    System.out.print("Enter doFire?: ");
                    tribe.setDoFire(scan.next());

                    } catch (InputMismatchException e) {
                        System.err.println("Wrong type of tribe's info");
                    }

                    try {
                        if (tribe.getName().charAt(0) < 65 || tribe.getName().charAt(0) > 90)
                            throw new TribeNameException();

                        if (tribe.getNumber() < 0 || tribe.getNumber() > 1000000)
                            throw new TribeNumberException();

                        if (!tribe.getDoFire().equals("yes") && !tribe.getDoFire().equals("no"))
                            throw new TribeDOFireException();
                    } catch (TribeNameException exc) {
                        System.exit(0);
                    }
                    catch (TribeNumberException exc) {
                        System.exit(0);
                    }
                    catch (TribeDOFireException exc) {
                        System.exit(0);
                    }

                    objectOutputStream.writeObject(tribe);

                    System.out.println("---------------------------");
                    System.out.println("Info has been written into " + "src/" + filename + ".txt");
                    System.out.println("---------------------------");
                }
            } catch (IOException e) {
                System.out.println("IO error");
                System.exit(0);
            }
        }


        if (answer == 'r') {

            System.out.println("---------------------------");
            System.out.println("Directory where files are saved: /home/alwayswannafly/lab4/src/");
            System.out.println("We found these .txt files here: \n");

            File folder = new File("/home/alwayswannafly/lab4/src/");

            String[] files = folder.list(new FilenameFilter() {

                @Override
                public boolean accept(File folder, String name) {
                    return name.endsWith(".txt");
                }

            });

            for (String fileName : files) {
                System.out.println(fileName);
            }

            System.out.println("\n---------------------------");
            System.out.print("Enter filename: ");

            filename = scan.next();

            if (!(new File("src/" + filename + ".txt").exists())) {
                System.out.println("No such file in dir");
                System.exit(1);

            }

            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("src/" + filename + ".txt");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                System.exit(0);
            }
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);


                System.out.println("\n---------------------------");
                System.out.println("Acquired information: ");
                System.out.println("---------------------------");


                try {
                    for (int i = 0; i < TRIBES_NUMBER; i++) {
                        tribes[i] = (Tribe) objectInputStream.readObject();

                        System.out.println(tribes[i].toString());

                        summNumber += tribes[i].getNumber();

                        if (tribes[i].getDoFire().equals("yes")) {
                            doFireCount++;
                        }
                    }  }catch(ClassNotFoundException e){
                    System.out.println("Class not found");
                    System.exit(0);
                    }

                    System.out.println("\nTotal people in tribes: " + summNumber);
                    System.out.println("Number of tribes familiar with fire: " + doFireCount);

                } catch (IOException e) {
                    System.out.println("IO error");
                    System.exit(0);
                }

                scan.close();

            }
        }
    }
