package br.com.uniamerica.chamada.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Entity
@Table(name = "configuracao", schema = "public")
public class Configuracao extends AbstractEntity {

}
