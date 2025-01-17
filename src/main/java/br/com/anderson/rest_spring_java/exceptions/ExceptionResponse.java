package br.com.anderson.rest_spring_java.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{

    private Date timestamp;
    private String message;
    private String dateils;

    public ExceptionResponse(String dateils, String message, Date timestamp) {
        this.dateils = dateils;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateils() {
        return dateils;
    }

    public void setDateils(String dateils) {
        this.dateils = dateils;
    }

}