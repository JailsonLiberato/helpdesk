package br.com.jailsonliberato.helpdesk.services;

import br.com.jailsonliberato.helpdesk.domain.Chamado;
import br.com.jailsonliberato.helpdesk.domain.Cliente;
import br.com.jailsonliberato.helpdesk.domain.Tecnico;
import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import br.com.jailsonliberato.helpdesk.domain.enums.Prioridade;
import br.com.jailsonliberato.helpdesk.domain.enums.Status;
import br.com.jailsonliberato.helpdesk.repositories.ChamadoRepository;
import br.com.jailsonliberato.helpdesk.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public void instanciaDB(){
        Tecnico tec1 = Tecnico.builder().nome("Jailson Liberato").cpf("55048215095").email("jailson@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = Tecnico.builder().nome("Richard Stallman").cpf("90334707056").email("stallman@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        Tecnico tec3 = Tecnico.builder().nome("Claude Elwood Shannon").cpf("27106847054").email("shannon@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        Tecnico tec4 = Tecnico.builder().nome("Tim Berners-Lee").cpf("16272012039").email("lee@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        Tecnico tec5 = Tecnico.builder().nome("Linus Torvalds").cpf("77855617027").email("linus@mail.com").senha("123").dataCriacao(LocalDate.now()).build();

        Cliente cli1 = Cliente.builder().nome("Albert Einstein").cpf("11166189074").email("einstein@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        Cliente cli2 = Cliente.builder().nome("Marie Curie").cpf("32242914006").email("curie@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        Cliente cli3 = Cliente.builder().nome("Charles Darwin").cpf("79204383062").email("darwin@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        Cliente cli4 = Cliente.builder().nome("Stephen Hawking").cpf("17740968030").email("hawking@mail.com").senha("123").dataCriacao(LocalDate.now()).build();
        Cliente cli5 = Cliente.builder().nome("Max Planck").cpf("08139930083").email("planck@mail.com").senha("123").dataCriacao(LocalDate.now()).build();

        Chamado c1 = Chamado.builder().dataAbertura(LocalDate.now()).dataFechamento(LocalDate.now()).prioridade(Prioridade.MEDIA).status(Status.ANDAMENTO).titulo("Chamado 01").observacoes("Teste chamado 1").tecnico(tec1).cliente(cli1).build();
        Chamado c2 = Chamado.builder().dataAbertura(LocalDate.now()).dataFechamento(LocalDate.now()).prioridade(Prioridade.ALTA).status(Status.ABERTO).titulo("Chamado 02").observacoes("Teste chamado 2").tecnico(tec1).cliente(cli2).build();
        Chamado c3 = Chamado.builder().dataAbertura(LocalDate.now()).dataFechamento(LocalDate.now()).prioridade(Prioridade.BAIXA).status(Status.ENCERRADO).titulo("Chamado 03").observacoes("Teste chamado 3").tecnico(tec2).cliente(cli3).build();
        Chamado c4 = Chamado.builder().dataAbertura(LocalDate.now()).dataFechamento(LocalDate.now()).prioridade(Prioridade.ALTA).status(Status.ABERTO).titulo("Chamado 04").observacoes("Teste chamado 4").tecnico(tec3).cliente(cli3).build();
        Chamado c5 = Chamado.builder().dataAbertura(LocalDate.now()).dataFechamento(LocalDate.now()).prioridade(Prioridade.MEDIA).status(Status.ANDAMENTO).titulo("Chamado 05").observacoes("Teste chamado 5").tecnico(tec2).cliente(cli1).build();
        Chamado c6 = Chamado.builder().dataAbertura(LocalDate.now()).dataFechamento(LocalDate.now()).prioridade(Prioridade.BAIXA).status(Status.ENCERRADO).titulo("Chamado 06").observacoes("Teste chamado 6").tecnico(tec1).cliente(cli5).build();

        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
    }
}
