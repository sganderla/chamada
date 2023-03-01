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
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Aluno aluno;

    @Getter @Setter
    @JoinColumn(name = "turma_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Turma turma;

    @Getter @Setter
    @JoinColumn(name = "projeto_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Projeto projeto;

    @Getter @Setter
    @Column(name = "identificacao", nullable = false, length = 255)
    private String identificacao;

}
