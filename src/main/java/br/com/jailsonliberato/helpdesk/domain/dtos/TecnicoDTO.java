package br.com.jailsonliberato.helpdesk.domain.dtos;

import br.com.jailsonliberato.helpdesk.domain.Tecnico;
import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoDTO implements Serializable {

    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
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
        this.perfis = tecnico.getPerfis().stream().map(perfil -> Perfil.toEnum(perfil.getCodigo())).collect(Collectors.toSet());
        this.dataCriacao = tecnico.getDataCriacao();
    }
}
