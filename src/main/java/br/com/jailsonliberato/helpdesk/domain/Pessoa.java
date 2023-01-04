package br.com.jailsonliberato.helpdesk.domain;

import br.com.jailsonliberato.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Entity
public abstract class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;
    @Column(unique = true)
    protected String cpf;
    @Column(unique = true)
    protected String email;
    protected String senha;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    protected Set<Integer> perfis;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao;

    public Pessoa(){
        super();
        this.addPerfil(Perfil.CLIENTE);
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(Perfil::toEnum).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

}