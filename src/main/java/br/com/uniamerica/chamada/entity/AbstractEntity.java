package br.com.uniamerica.chamada.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
public abstract class AbstractEntity {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter @Setter
    private LocalDateTime dtCadastro;

    @Getter @Setter
    private LocalDateTime dtEdicao;

    @Getter @Setter
    private boolean ativo;

    /**
     * Método automatico, executado no pré-cadastro dos dados
     */
    @PrePersist
    public void prePersist(){
        this.dtCadastro = LocalDateTime.now();
        this.ativo = true;
    }

    /**
     * Método automatico, executado no pré-edição dos dados
     */
    @PreUpdate
    public void preUpdate(){
        this.dtEdicao = LocalDateTime.now();
    }
}
