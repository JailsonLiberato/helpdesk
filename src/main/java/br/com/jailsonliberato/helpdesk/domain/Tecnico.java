package br.com.jailsonliberato.helpdesk.domain;

import br.com.jailsonliberato.helpdesk.domain.dtos.TecnicoDTO;
import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
public class Tecnico extends Pessoa{

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados;

    public Tecnico(){
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(TecnicoDTO tecnico){
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.email = tecnico.getEmail();
        this.senha = tecnico.getSenha();
        this.perfis = tecnico.getPerfis().stream().map(Perfil::getCodigo).collect(Collectors.toSet());
        this.dataCriacao = tecnico.getDataCriacao();
    }

}
