package br.com.jailsonliberato.helpdesk.services;

import br.com.jailsonliberato.helpdesk.domain.Chamado;
import br.com.jailsonliberato.helpdesk.domain.Cliente;
import br.com.jailsonliberato.helpdesk.domain.Tecnico;
import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import br.com.jailsonliberato.helpdesk.domain.enums.Prioridade;
import br.com.jailsonliberato.helpdesk.domain.enums.Status;
import br.com.jailsonliberato.helpdesk.repositories.ChamadoRepository;
import br.com.jailsonliberato.helpdesk.repositories.ClienteRepository;
import br.com.jailsonliberato.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void instanciaDB(){
        Tecnico t1 = Tecnico.builder().nome("Jailson Liberato").cpf("00000000000").email("jailson@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        t1.addPerfil(Perfil.ADMIN);

        tecnicoRepository.save(t1);

        Cliente cli1 = Cliente.builder().nome("Linus Torvalds").cpf("11111111111").email("torvalds@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        clienteRepository.save(cli1);


        Chamado cha1 = Chamado.builder().dataAbertura(LocalDate.now()).dataFechamento(LocalDate.now()).prioridade(Prioridade.MEDIA).status(Status.ANDAMENTO).titulo("Chamado 01").observacoes("Primeiro chamado").tecnico(t1).cliente(cli1).build();
        chamadoRepository.save(cha1);
    }
}
