package fr.ipme.devops.runtime_exception;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException(Long id) {
        super("No song found for the id : " + id);
    }
}

