package br.com.uniamerica.chamada.repository;

import br.com.uniamerica.chamada.entity.Chamada;
import br.com.uniamerica.chamada.entity.Projeto;
import br.com.uniamerica.chamada.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {

    /**
     *
     * @return
     */
    public List<Chamada> findByAtivoTrue();

    /**
     *
     * @param turma
     * @param localDate
     * @return
     */
    @Query("from Chamada " +
            "   where turma = :turma " +
            "       and date(cadastro) = :localDate " +
            "       and ativo = true")
    public Chamada findByTurmaAndCadastroAndAtivo(
            @Param("turma") final Turma turma,
            @Param("localDate") final LocalDate localDate);

    /**
     *
     * @param turma
     * @param projeto
     * @return
     */
    @Query("from Chamada " +
            "   where turma = :turma " +
            "       and projeto = :projeto " +
            "       and ativo = true")
    List<Chamada> findByTurmaAndProjetoAndAtivo(
            @Param("turma") final Turma turma,
            @Param("projeto") final Projeto projeto);
}
