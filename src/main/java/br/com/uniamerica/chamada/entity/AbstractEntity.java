package br.com.uniamerica.chamada.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity {

    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "cadastro", nullable = false)
    private LocalDateTime cadastro;

    @Getter
    @Column(name = "edicao")
    private LocalDateTime edicao;

    @Getter @Setter
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    /**
     *
     * @param id
     */
    public AbstractEntity(Long id) {
        this.id = id;
    }

    /**
     * Método automatico, executado no pré-cadastro dos dados
     */
    @PrePersist
    public void prePersist(){
        this.cadastro = LocalDateTime.now();
        this.ativo = true;
    }

    /**
     * Método automatico, executado no pré-edição dos dados
     */
    @PreUpdate
    public void preUpdate(){
        this.edicao = LocalDateTime.now();
    }
}
