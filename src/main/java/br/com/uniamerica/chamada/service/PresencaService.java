package br.com.uniamerica.chamada.service;

import br.com.uniamerica.chamada.conf.HttpUtils;
import br.com.uniamerica.chamada.entity.Aluno;
import br.com.uniamerica.chamada.entity.Presenca;
import br.com.uniamerica.chamada.repository.AlunoRepository;
import br.com.uniamerica.chamada.repository.PresencaRepository;
import br.com.uniamerica.chamada.repository.ProjetoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.UnknownHostException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Service
public class PresencaService {

    @Autowired
    private PresencaRepository presencaRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProjetoRepository projetoRepository;

    /**
     *
     * @param httpServletRequest
     * @param presenca
     * @return
     */
    @Transactional( rollbackFor = Exception.class)
    public Presenca cadastrar(
            final HttpServletRequest httpServletRequest,
            @RequestBody final Presenca presenca
    ) throws UnknownHostException {

        Assert.isTrue(presenca.getAluno().getRa() >= 100000, "Ra não Informado.");

        final Aluno aluno = this.alunoRepository.findByRaAndAtivoTrue(presenca.getAluno().getRa());

        Assert.isTrue(aluno != null, "Ra informado é invalido.");

        final Presenca presencaControle = this.presencaRepository.findByAluno(aluno.getId());

        if (presencaControle != null) {
            Assert.isTrue(presencaControle.getCadastro()
                    .plusMinutes(30)
                    .compareTo(LocalDateTime.now()) != 1,
                        "Presença já realizada. " +
                                        "Aluno: " + presencaControle.getAluno().getNome() + " " +
                                        "Registro: " + presencaControle.getCadastro());
        }

        Assert.isTrue(aluno.getTurma().isAtivo() == true, "Turma inválida.");

        presenca.setAluno(aluno);
        presenca.setTurma(aluno.getTurma());
        presenca.setProjeto(
                LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY
                    ? this.projetoRepository.getReferenceById(1L)
                    : this.projetoRepository.getReferenceById(2L));
        presenca.setIdentificacao(HttpUtils.getRequestIP(httpServletRequest));

        Assert.isTrue(presenca.getProjeto().isAtivo() == true, "Projeto inválido.");

        return this.presencaRepository.save(presenca);
    }

}
