package br.com.jailsonliberato.helpdesk.repositories;

import br.com.jailsonliberato.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
