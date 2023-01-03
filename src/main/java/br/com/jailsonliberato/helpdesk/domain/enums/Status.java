package br.com.jailsonliberato.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {

    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");
    private final Integer codigo;

    private final String descricao;

    public static Status toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for(Status status: Status.values()){
            if(codigo.equals(status.getCodigo())){
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }


}
