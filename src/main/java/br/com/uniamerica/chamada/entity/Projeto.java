package br.com.uniamerica.chamada.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "projetos", schema = "public")
public class Projeto extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    /**
     *
     * @param id
     * @param nome
     */
    public Projeto(Long id, String nome) {
        super(id);
        this.nome = nome;
    }
}
