package br.com.uniamerica.chamada.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turmas", schema = "public")
public class Turma extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "ano", nullable = false, unique = true)
    private int ano;

    @Getter @Setter
    @Column(name = "semestre", nullable = false, unique = true)
    private int semestre;

    /**
     *
     * @param id
     * @param nome
     * @param ano
     * @param semestre
     */
    public Turma(Long id, String nome, int ano, int semestre) {
        super(id);
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
    }
}
