package br.com.jailsonliberato.helpdesk.services;

import br.com.jailsonliberato.helpdesk.domain.Cliente;
import br.com.jailsonliberato.helpdesk.domain.Pessoa;
import br.com.jailsonliberato.helpdesk.domain.dtos.ClienteDTO;
import br.com.jailsonliberato.helpdesk.repositories.ClienteRepository;
import br.com.jailsonliberato.helpdesk.repositories.PessoaRepository;
import br.com.jailsonliberato.helpdesk.services.exceptions.DataIntegrityViolationException;
import br.com.jailsonliberato.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        this.validaPorCpfEEmail(clienteDTO);
        return repository.save(cliente);
    }

    public Cliente update(Integer id, ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        validaPorCpfEEmail(clienteDTO);
        Cliente cliente = new Cliente(clienteDTO);
        return repository.save(cliente);
    }

    public void delete(Integer id) {
        Cliente cliente = findById(id);
        if(cliente.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
        }
        this.repository.deleteById(id);
    }



    private void validaPorCpfEEmail(ClienteDTO clienteDTO){
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(clienteDTO.getCpf());
        if(pessoa.isPresent() && !pessoa.get().getId().equals(clienteDTO.getId()) ){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        pessoa = pessoaRepository.findByEmail(clienteDTO.getEmail());
        if(pessoa.isPresent() && !pessoa.get().getId().equals(clienteDTO.getId())){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }



}
