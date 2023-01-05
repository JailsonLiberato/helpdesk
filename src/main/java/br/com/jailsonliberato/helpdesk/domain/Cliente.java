package br.com.jailsonliberato.helpdesk.domain;

import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
public class Cliente extends Pessoa {
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados;

    public Cliente(){
        super();
        addPerfil(Perfil.CLIENTE);
    }
}
