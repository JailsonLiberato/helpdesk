package br.com.jailsonliberato.helpdesk.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Tecnico extends Pessoa{

    private List<Chamado> chamados;

    public Tecnico(Integer id, String nome, String cpf, String email, String senha, Set<Integer> perfis, LocalDate dataCriacao) {
        super(id, nome, cpf, email, senha, perfis, dataCriacao);
    }
}
