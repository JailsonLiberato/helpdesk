package br.com.jailsonliberato.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Prioridade {

    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");
    private final Integer codigo;

    private final String descricao;

    public static Prioridade toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for(Prioridade prioridade: Prioridade.values()){
            if(codigo.equals(prioridade.getCodigo())){
                return prioridade;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida");
    }


}
