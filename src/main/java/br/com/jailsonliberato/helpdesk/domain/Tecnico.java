package br.com.jailsonliberato.helpdesk.domain;

import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Tecnico extends Pessoa{

    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados;

    public Tecnico(){
        super();
        addPerfil(Perfil.CLIENTE);
    }

}
