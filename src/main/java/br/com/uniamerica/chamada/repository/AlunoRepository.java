package br.com.uniamerica.chamada.repository;

import br.com.uniamerica.chamada.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    /**
     * Busca o Aluno pelo RA que estão ativos
     *
     * @param ra do aluno
     * @return
     */
    public Aluno findByRaAndAtivoTrue(final int ra);

}
