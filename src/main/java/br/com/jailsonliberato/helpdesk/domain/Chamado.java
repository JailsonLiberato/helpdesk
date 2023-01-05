package br.com.jailsonliberato.helpdesk.domain;

import br.com.jailsonliberato.helpdesk.domain.enums.Prioridade;
import br.com.jailsonliberato.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Chamado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_abertura")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;
    @Column(name = "data_fechamento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
