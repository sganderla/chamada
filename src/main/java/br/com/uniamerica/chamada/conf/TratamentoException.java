package br.com.uniamerica.chamada.conf;

import org.hibernate.NonUniqueResultException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@ControllerAdvice
public class TratamentoException {

    /**
     *
     * @param exception
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String exception(
            Exception exception
    ) {
        return exception.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentException(
            IllegalArgumentException illegalArgumentException
    ) {
        return illegalArgumentException.getMessage();
    }

    /**
     *
     * @param nonUniqueResultException
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(NonUniqueResultException.class)
    public String handleNonUniqueResultException(
            NonUniqueResultException nonUniqueResultException
    ) {
        return nonUniqueResultException.getMessage();
    }

    /**
     *
     * @param dataIntegrityViolationException
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(
            DataIntegrityViolationException dataIntegrityViolationException
    ) {
        return dataIntegrityViolationException.getMessage();
    }

    /**
     *
     * @param jpaSystemException
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JpaSystemException.class)
    public String handleJpaSystemException(
            JpaSystemException jpaSystemException
    ) {
        return jpaSystemException.getMessage();
    }
}
