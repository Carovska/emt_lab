package mk.ukim.finki.wp.lab.model.exception;

public class AccommodationNotFoundException extends RuntimeException{
    public AccommodationNotFoundException(Long id){
        super("A accommodation with id %d does not exist.".formatted(id));
    }
}
