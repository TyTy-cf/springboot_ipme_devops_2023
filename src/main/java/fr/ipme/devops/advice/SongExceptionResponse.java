package fr.ipme.devops.advice;

import fr.ipme.devops.runtime_exception.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SongExceptionResponse {

    @ResponseBody
    @ExceptionHandler(SongNotFoundException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    String songNotFoundHandler(SongNotFoundException songNotFoundException) {
        return HttpStatus.I_AM_A_TEAPOT + " : " + songNotFoundException.getMessage();
    }

}
