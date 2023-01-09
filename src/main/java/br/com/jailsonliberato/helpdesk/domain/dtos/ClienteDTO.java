package br.com.jailsonliberato.helpdesk.domain.dtos;

import br.com.jailsonliberato.helpdesk.domain.Cliente;
import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ClienteDTO implements Serializable {
    protected Integer id;
    @NotNull(message = "O campo NOME é requerido")
    protected String nome;
    @NotNull(message = "O campo CPF é requerido")
    @CPF
    protected String cpf;
    @NotNull(message = "O campo EMAIL é requerido")
    protected String email;
    @NotNull(message = "O campo SENHA é requerido")
    protected String senha;
    protected Set<Perfil> perfis;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao;


    public ClienteDTO(Cliente cliente) {
        super();
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        if(cliente.getPerfis() != null){
            this.perfis = cliente.getPerfis();
        }
        this.dataCriacao = cliente.getDataCriacao() == null ? LocalDate.now() : cliente.getDataCriacao();
        addPerfil(Perfil.CLIENTE);
    }

    public void addPerfil(Perfil perfil){
        if(this.perfis == null){
            this.perfis = new HashSet<>();
        }
        this.perfis.add(perfil);
    }

}
