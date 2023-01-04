package br.com.jailsonliberato.helpdesk.repositories;

import br.com.jailsonliberato.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
