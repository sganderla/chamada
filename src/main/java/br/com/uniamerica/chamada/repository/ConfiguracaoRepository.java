package br.com.uniamerica.chamada.repository;

import br.com.uniamerica.chamada.entity.Configuracao;
import br.com.uniamerica.chamada.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {

    /**
     *
     * @param turma
     * @return
     */
    public Configuracao findByTurma(Turma turma);
}
