package br.com.jailsonliberato.helpdesk.services;

import br.com.jailsonliberato.helpdesk.domain.Pessoa;
import br.com.jailsonliberato.helpdesk.domain.Tecnico;
import br.com.jailsonliberato.helpdesk.domain.dtos.TecnicoDTO;
import br.com.jailsonliberato.helpdesk.repositories.PessoaRepository;
import br.com.jailsonliberato.helpdesk.repositories.TecnicoRepository;
import br.com.jailsonliberato.helpdesk.services.exceptions.DataIntegrityViolationException;
import br.com.jailsonliberato.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> tecnico = repository.findById(id);
        return tecnico.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = new Tecnico(tecnicoDTO);
        this.validaPorCpfEEmail(tecnicoDTO);
        return repository.save(tecnico);
    }

    public Tecnico update(Integer id, TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(id);
        Tecnico tecnico = findById(id);
        validaPorCpfEEmail(tecnicoDTO);
        tecnico = new Tecnico(tecnicoDTO);
        return repository.save(tecnico);
    }

    public void delete(Integer id) {
        Tecnico tecnico = findById(id);
        if(tecnico.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
        }
        this.repository.deleteById(id);
    }



    private void validaPorCpfEEmail(TecnicoDTO tecnicoDTO){
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if(pessoa.isPresent() && !pessoa.get().getId().equals(tecnicoDTO.getId()) ){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        pessoa = pessoaRepository.findByEmail(tecnicoDTO.getEmail());
        if(pessoa.isPresent() && !pessoa.get().getId().equals(tecnicoDTO.getId())){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }



}
