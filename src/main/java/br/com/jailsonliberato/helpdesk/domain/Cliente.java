package br.com.jailsonliberato.helpdesk.domain;

import br.com.jailsonliberato.helpdesk.domain.dtos.ClienteDTO;
import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@SuperBuilder
@Entity
public class Cliente extends Pessoa {
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados;

    public Cliente(){
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(ClienteDTO clienteDTO) {
        super();
        this.id = clienteDTO.getId();
        this.nome = clienteDTO.getNome();
        this.cpf = clienteDTO.getCpf();
        this.email = clienteDTO.getEmail();
        this.senha = clienteDTO.getSenha();
        addPerfil(Perfil.CLIENTE);
        if(clienteDTO.getPerfis() != null){
            this.perfis = clienteDTO.getPerfis().stream().map(Perfil::getCodigo).collect(Collectors.toSet());
        }
        this.dataCriacao = clienteDTO.getDataCriacao() == null ? LocalDate.now() : clienteDTO.getDataCriacao();
    }
}
