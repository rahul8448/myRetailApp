package com.rahul.restexample.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rsharma on 3/27/2017.
 */
@ControllerAdvice
public class ExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = { InvalidParamException.class})
    public void handleInvalidParamException(Exception ex, HttpServletResponse response) throws IOException
    {
        logger.error("The input params provided does not seem to be correct.", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = { NoDataFoundException.class})
    public void handleNoDataFoundException(Exception ex, HttpServletResponse response) throws IOException
    {
        logger.error("No data was found for the specified param", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason="Param passed does not seem to be of correct format")
    @org.springframework.web.bind.annotation.ExceptionHandler(value = { MethodArgumentTypeMismatchException.class})
    public void handleArgumentMismatchException(Exception ex, HttpServletResponse response) throws IOException
    {
        logger.error("An unknown error occured while serving the request. Please contact the system admin.", ex);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = { ServerException.class})
    public void handleServerException(Exception ex, HttpServletResponse response) throws IOException
    {
        logger.error("An internal error occured while serving the request. Please contact the system admin.", ex);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = { Exception.class})
    public void handleGeneralException(Exception ex, HttpServletResponse response) throws IOException
    {
        logger.error("An unknown error occured while serving the request. Please contact the system admin.", ex);

    }
}
