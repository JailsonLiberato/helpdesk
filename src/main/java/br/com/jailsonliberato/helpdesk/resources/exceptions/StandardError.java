package br.com.jailsonliberato.helpdesk.resources.exceptions;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class StandardError implements Serializable {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
