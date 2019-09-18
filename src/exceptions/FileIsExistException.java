package exceptions;

public class FileIsExistException extends Exception {

    public FileIsExistException(){
        System.out.println("File already exist");
    }
}
