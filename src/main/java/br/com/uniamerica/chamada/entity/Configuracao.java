package br.com.uniamerica.chamada.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Entity
@NoArgsConstructor
@Table(name = "configuracao", schema = "public")
public class Configuracao extends AbstractEntity {

    @Getter
    @Setter
    @JoinColumn(name = "turma_id", nullable = false)
    @ManyToOne(optional = false)
    private Turma turma;

    @Getter @Setter
    @JoinColumn(name = "projeto_integrador_id", nullable = false)
    @ManyToOne(optional = false)
    private Projeto projetoIntegrador;

    @Getter @Setter
    @JoinColumn(name = "projeto_id", nullable = false)
    @ManyToOne(optional = false)
    private Projeto projeto;

    /**
     *
     * @param turma
     * @param projetoIntegrador
     * @param projeto
     */
    public Configuracao(final Turma turma, final Projeto projetoIntegrador, final Projeto projeto){
        this.turma = turma;
        this.projetoIntegrador = projetoIntegrador;
        this.projeto = projeto;
    }

}
