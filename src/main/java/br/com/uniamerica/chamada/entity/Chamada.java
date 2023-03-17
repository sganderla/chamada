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
 * @version 1.0.0, 15/03/2023
 * @since 1.0.0
 */
@Entity
@NoArgsConstructor
@Table(name = "chamadas", schema = "public")
public class Chamada extends AbstractEntity {

    @Getter @Setter
    @JoinColumn(name = "projeto_id", nullable = false)
    @ManyToOne(optional = false)
    private Projeto projeto;

    @Getter @Setter
    @JoinColumn(name = "turma_id", nullable = false)
    @ManyToOne(optional = false)
    private Turma turma;

}
