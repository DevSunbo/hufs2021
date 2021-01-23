package hufs2021.jeongbo.exceptions;

public class LoginNotExistIdException extends Exception{


    public LoginNotExistIdException(String data) {
        if(data == "id") {
            System.out.println("Not Exist Id");
            return;
        }
        else if(data == "pw") {
            System.out.println("Not Exist Pw");
            return;
        }
        return;
    }
}
