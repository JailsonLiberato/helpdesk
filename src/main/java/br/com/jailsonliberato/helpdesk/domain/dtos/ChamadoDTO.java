package br.com.jailsonliberato.helpdesk.domain.dtos;

import br.com.jailsonliberato.helpdesk.domain.Chamado;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ChamadoDTO implements Serializable {

    private Integer id;
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dataAbertura;
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dataFechamento;
    @NotNull(message = "O campo PRIORIDADE é requerido")
    private Integer prioridade;
    @NotNull(message = "O campo STATUS é requerido")
    private Integer status;
    @NotNull(message = "O campo TITULO é requerido")
    private String titulo;
    @NotNull(message = "O campo OBSERVAÇÕES é requerido")
    private String observacoes;
    @NotNull(message = "O campo TECNICO é requerido")
    private Integer tecnico;
    @NotNull(message = "O campo CLIENTE é requerido")
    private Integer cliente;
    private String nomeTecnico;
    private String nomeCliente;

    public ChamadoDTO(Chamado chamado) {
        this.id = chamado.getId();
        this.dataAbertura = chamado.getDataAbertura() == null ? LocalDate.now().toString() : chamado.getDataAbertura().toString();
        this.dataFechamento = chamado.getDataFechamento() == null ? null : chamado.getDataFechamento().toString();
        this.prioridade = chamado.getPrioridade().getCodigo();
        this.status = chamado.getStatus().getCodigo();
        this.titulo = chamado.getTitulo();
        this.observacoes = chamado.getObservacoes();
        this.tecnico = chamado.getTecnico().getId();
        this.cliente = chamado.getCliente().getId();
        this.nomeCliente = chamado.getCliente().getNome();
        this.nomeTecnico = chamado.getTecnico().getNome();
    }
}
