package br.com.uniamerica.chamada.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@Table(name = "alunos", schema = "public")
public class Aluno extends AbstractEntity {

    @Getter @Setter
    @Column(name = "ra", nullable = false, unique = true)
    private int ra;

    @Getter @Setter
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Getter @Setter
    @JoinColumn(name = "turma_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Turma turma;

    /**
     *
     * @param ra
     * @param nome
     * @param turma
     */
    public Aluno(int ra, String nome, Turma turma) {
        this.ra = ra;
        this.nome = nome;
        this.turma = turma;
    }
}
