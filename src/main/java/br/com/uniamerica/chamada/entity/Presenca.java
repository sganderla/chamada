package br.com.uniamerica.chamada.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Entity
@Table(name = "presencas", schema = "public")
public class Presenca extends AbstractEntity {

    @Getter @Setter
    @JoinColumn(name = "aluno_id", nullable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;

    @Getter @Setter
    @JoinColumn(name = "turma_id", nullable = false)
    @ManyToOne(optional = false)
    private Turma turma;

    @Getter @Setter
    @JoinColumn(name = "projeto_id", nullable = false)
    @ManyToOne(optional = false)
    private Projeto projeto;

    @Getter @Setter
    @JoinColumn(name = "chamada_id", nullable = false)
    @ManyToOne(optional = false)
    private Chamada chamada;

    @Getter @Setter
    @Column(name = "identificacao", nullable = false, length = 255)
    private String identificacao;

    @Getter @Setter
    @Column(name = "professor", nullable = false)
    private boolean professor;

}
