package mk.ukim.finki.wp.lab.model.exception;

public class HostNotFound extends RuntimeException{
    public HostNotFound(String message){
        super(message);
    }
}
