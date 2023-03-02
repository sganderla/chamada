package br.com.uniamerica.chamada.repository;

import br.com.uniamerica.chamada.entity.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {

    @Query("from Presenca where aluno.id = :alunoId order by id desc limit 1")
    public Presenca findByAluno(@Param("alunoId") Long alunoId);

}
