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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Presenca cadastrar(
            final HttpServletRequest httpServletRequest,
            @RequestBody final Presenca presenca
    ) throws UnknownHostException {

        Assert.isTrue(presenca.getAluno().getRa() >= 0, "Ra não Informado.");

        final Aluno aluno = this.alunoRepository.findByRa(presenca.getAluno().getRa());

        Assert.isTrue(aluno != null, "Ra informado é invalido.");

        presenca.setAluno(aluno);
        presenca.setTurma(aluno.getTurma());
        presenca.setProjeto(
                LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY
                    ? this.projetoRepository.getReferenceById(1L)
                    : this.projetoRepository.getReferenceById(2L));
        presenca.setIdentificacao(HttpUtils.getRequestIP(httpServletRequest));

        return this.presencaRepository.save(presenca);
    }

}
