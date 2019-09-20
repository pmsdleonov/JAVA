import by.gsu.mslab.User;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Set users = new TreeSet();

        final String FILEPATH = "src/info.txt";
        final String SORTED_FILEPATH = "src/sorted.txt";
        int linesCount = 0;



        FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(new User("Kristallik", "Kristallik@gmail.com", "zwZcdmAZ", "men", "12.03.2019", 24));
            objectOutputStream.writeObject(new User("Nikeron", "Nikeron@gmail.com", "iiwuZVhe", "men", "09.05.2018",117));
            objectOutputStream.writeObject(new User("Prizrak", "Prizrak@mail.ru", "uqjWwPex", "women", "11.03.2016",24));
            objectOutputStream.writeObject(new User("MrSmileGod", "MrSmileGod@mail.ru", "DWJXqPOv", "men", "29.03.2016",36));
            objectOutputStream.writeObject(new User("MISTIK31", "MISTIK31@gmail.com", "gHGNZdeE", "women", "29.03.2016",55));
            objectOutputStream.writeObject(new User("Joker", "Joker@gmail.com", "yh6ZgM84", "men", "26.03.2016",0));
            objectOutputStream.writeObject(new User("VimeR", "imeR@gmail.com", "7gHQ96va", "men", "29.03.2016",17));
            objectOutputStream.writeObject(new User("ReDoS", "ReDoS@mail.ru", "h7G5GU3p", "women", "29.03.2016",1));
            objectOutputStream.writeObject(new User("Sanchez", "Sanchez@mail.ru", "r1w7I9gI", "women", "14.03.2016",147));
            objectOutputStream.writeObject(new User("Neytron", "Neytron@gmail.com", "9Bw78vmk", "men", "29.03.2016",10));


        final LineNumberReader lnr = new LineNumberReader(new FileReader(FILEPATH));
        while(null != lnr.readLine()) {
            linesCount++;
            }
        System.out.println(linesCount);

        FileInputStream fileInputStream = new FileInputStream(FILEPATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for( int i = 0; i<linesCount-1; i++) {
            Object kesh;
            kesh = objectInputStream.readObject();
            users.add(kesh);
        }

        FileOutputStream fileOutputStream1 = new FileOutputStream(SORTED_FILEPATH);
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);

        objectOutputStream1.writeObject("Sorted by nickname");


        for (Object o: users){
            System.out.println(o);
            objectOutputStream1.writeObject(o);
        }
    }
}
