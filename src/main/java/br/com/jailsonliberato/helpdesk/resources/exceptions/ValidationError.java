package br.com.jailsonliberato.helpdesk.resources.exceptions;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }


    public void addError(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
