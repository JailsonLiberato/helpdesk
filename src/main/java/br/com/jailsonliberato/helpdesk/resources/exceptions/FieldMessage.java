package br.com.jailsonliberato.helpdesk.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FieldMessage implements Serializable {

    private String fieldName;
    private String message;
}
