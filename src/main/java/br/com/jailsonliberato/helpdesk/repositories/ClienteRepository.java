package br.com.jailsonliberato.helpdesk.repositories;

import br.com.jailsonliberato.helpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
