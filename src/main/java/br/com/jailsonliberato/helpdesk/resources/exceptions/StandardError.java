package br.com.jailsonliberato.helpdesk.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
