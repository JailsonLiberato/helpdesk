package br.com.jailsonliberato.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");
    private final Integer codigo;

    private final String descricao;

    public static Perfil toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for(Perfil perfil: Perfil.values()){
            if(codigo.equals(perfil.getCodigo())){
                return perfil;
            }
        }
        throw new IllegalArgumentException("Perfil inválido");
    }


}
