package br.com.uniamerica.chamada.repository;

import br.com.uniamerica.chamada.entity.Aluno;
import br.com.uniamerica.chamada.entity.Chamada;
import br.com.uniamerica.chamada.entity.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {

    /**
     * Buscar a lista de presenças de um aluno.
     *
     * @param ra do aluno
     * @param data de registro
     * @return
     */
    @Query("from Presenca where aluno.ra = :ra and date(cadastro) = :data")
    public List<Presenca> findByRaAndData(
            @Param("ra") final int ra,
            @Param("data") final LocalDate data);

    /**
     *
     * @param aluno
     * @param chamada
     * @return
     */
    public List<Presenca> findByAlunoAndChamadaAndAtivoTrue(Aluno aluno, Chamada chamada);

    /**
     * Lista de Identificados que estão com Defeito
     *
     * @param data de controle
     * @return
     */
    @Query( value = "" +
            " select b.identificacao from ( " +
            "       select count(1) as qtde, a.identificacao from presencas a " +
            "       where 1 = 1 " +
            "           and a.identificacao != '0:0:0:0:0:0:0:1' " +
            "           and date(a.cadastro) = :data " +
            "           and professor != true " +
            "       group by a.identificacao, a.aluno_id " +
            " ) b group by b.identificacao " +
            " having count(1) > 1 ", nativeQuery = true)
    public List<String> listPresencasComDefeito(
            @Param("data") final LocalDate data);

    /**
     * Buscar as presenças que estão com Defeito
     *
     * @param identificadores
     * @param date
     * @return
     */
    @Query(value = "from Presenca where identificacao in (:identificadores) and date(cadastro) = :data")
    public List<Presenca> findByIdentificador(
            @Param("identificadores") final List<String> identificadores,
            @Param("data") final LocalDate date);
}
