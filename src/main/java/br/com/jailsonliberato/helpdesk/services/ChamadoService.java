package br.com.jailsonliberato.helpdesk.services;

import br.com.jailsonliberato.helpdesk.domain.Chamado;
import br.com.jailsonliberato.helpdesk.domain.Cliente;
import br.com.jailsonliberato.helpdesk.domain.Tecnico;
import br.com.jailsonliberato.helpdesk.domain.dtos.ChamadoDTO;
import br.com.jailsonliberato.helpdesk.domain.enums.Prioridade;
import br.com.jailsonliberato.helpdesk.domain.enums.Status;
import br.com.jailsonliberato.helpdesk.repositories.ChamadoRepository;
import br.com.jailsonliberato.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado create(ChamadoDTO chamadoDTO) {
        return repository.save(newChamado(chamadoDTO));
    }

    public Chamado update(Integer id, ChamadoDTO chamadoDTO) {
        chamadoDTO.setId(id);
        Chamado chamado = findById(id);
        chamado = newChamado(chamadoDTO);
        return repository.save(chamado);
    }

    private Chamado newChamado(ChamadoDTO chamadoDTO) {
        Tecnico tecnico = tecnicoService.findById(chamadoDTO.getTecnico());
        Cliente cliente = clienteService.findById(chamadoDTO.getCliente());

        Chamado chamado = new Chamado();
        if(chamadoDTO.getId() != null) {
            chamado.setId(chamadoDTO.getId());
        }

        if(chamadoDTO.getStatus().equals(2)) {
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(chamadoDTO.getPrioridade()));
        chamado.setStatus(Status.toEnum(chamadoDTO.getStatus()));
        chamado.setTitulo(chamadoDTO.getTitulo());
        chamado.setObservacoes(chamadoDTO.getObservacoes());
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        chamado.setDataAbertura(LocalDate.parse(chamadoDTO.getDataAbertura(), dtf));
        if(chamado.getDataFechamento() != null){
            chamado.setDataFechamento(LocalDate.parse(chamadoDTO.getDataFechamento(), dtf));
        }
        return chamado;
    }


}
