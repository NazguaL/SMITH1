package Lab04.Exeptions;


public class NoFreePlacesExeption extends Exception {
    public NoFreePlacesExeption (String message) {
        super(message);
    }
}