package br.com.jailsonliberato.helpdesk.domain.dtos;

import br.com.jailsonliberato.helpdesk.domain.Tecnico;
import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TecnicoDTO implements Serializable {

    protected Integer id;
    @NotNull(message = "O campo NOME é requerido")
    protected String nome;

    @NotNull(message = "O campo CPF é requerido")
    protected String cpf;
    @NotNull(message = "O campo E-MAIL é requerido")
    protected String email;
    @NotNull(message = "O campo SENHA é requerido")
    protected String senha;
    protected Set<Perfil> perfis;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao;


    public TecnicoDTO(Tecnico tecnico){
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.email = tecnico.getEmail();
        this.senha = tecnico.getSenha();
        this.addPerfil(Perfil.CLIENTE);
        addPerfil(Perfil.CLIENTE);
        if(tecnico.getPerfis() != null){
            this.perfis = tecnico.getPerfis();
        }
        this.dataCriacao = tecnico.getDataCriacao() == null ? LocalDate.now() : tecnico.getDataCriacao();
    }

    public void addPerfil(Perfil perfil){
        if(this.perfis == null){
            this.perfis = new HashSet<>();
        }
        this.perfis.add(perfil);
    }
}
