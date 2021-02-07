package hufs2021.jeongbo.exceptions;

public class NotExistDBException extends Exception{
    public NotExistDBException(String error) {
        if(error == "caRental"){
            System.out.println("caRental error");
        }
        if(error == "caKind"){
            System.out.println("caKind error");
        }
        if(error == "caName"){
            System.out.println("caName error");
        }
    }
}
