package br.com.uniamerica.chamada.service;

import br.com.uniamerica.chamada.conf.HttpUtils;
import br.com.uniamerica.chamada.entity.Aluno;
import br.com.uniamerica.chamada.entity.Chamada;
import br.com.uniamerica.chamada.entity.Configuracao;
import br.com.uniamerica.chamada.entity.Presenca;
import br.com.uniamerica.chamada.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

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
    @Autowired
    private ChamadaRepository chamadaRepository;
    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    /**
     *
     * @param httpServletRequest
     * @param presenca
     * @return
     */
    @Transactional( rollbackFor = Exception.class)
    public Presenca cadastrar(
            final HttpServletRequest httpServletRequest,
            final Presenca presenca
    ) {

        Assert.isTrue(presenca.getAluno().getRa() >= 500000, "Ra informado é inválido.");

        final Aluno aluno = this.alunoRepository.findByRaAndAtivoTrue(presenca.getAluno().getRa());

        Assert.isTrue(aluno != null, "Ra informado não está cadastrado.");

        final Chamada chamada = this.chamadaRepository.findByTurmaAndCadastroAndAtivo(aluno.getTurma(), LocalDate.now());

        Assert.isTrue(chamada != null, "Nenhuma chamada disponivel. Solicite a liberação da chamada com o professor.");

        final List<Presenca> presencaControle = this.presencaRepository.findByAlunoAndChamadaAndAtivoTrue(aluno, chamada);

        Assert.isTrue((presencaControle.isEmpty()),"Ops. Presença já realizada. "
                + "\n -> Aluno: " + aluno.getNome()
                + "\n -> Registro: " + (presencaControle.isEmpty() ? null : presencaControle.get(0).getCadastro()));

        Assert.isTrue(aluno.getTurma().isAtivo() == true, "Turma inválida.");

        final Configuracao configuracao = this.configuracaoRepository.findByTurma(chamada.getTurma());

        Assert.isTrue(configuracao != null, "Nenhuma configuração encontrada para a turma.");

        presenca.setAluno(aluno);
        presenca.setTurma(chamada.getTurma());
        presenca.setChamada(chamada);
        presenca.setProjeto(
                LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY
                    ? configuracao.getProjetoIntegrador()
                    : configuracao.getProjeto());
        presenca.setIdentificacao(HttpUtils.getRequestIP(httpServletRequest));
        presenca.setProfessor(presenca.getIdentificacao().equals("0:0:0:0:0:0:0:1") ? true : false);

        Assert.isTrue(presenca.getProjeto().isAtivo() == true, "Projeto inválido.");

        return this.presencaRepository.save(presenca);
    }

    /**
     * Buscar a lista de presenças com defeito
     *
     * @param data
     * @return
     */
    public List<Presenca> listPresencasComDefeito(final LocalDate data) {

        final List<String> identificadores = this.presencaRepository.listPresencasComDefeito(data);

        Assert.isTrue(!identificadores.isEmpty(), "Nenhum registro com defeito para a data : " + data);

        return this.presencaRepository.findByIdentificador(identificadores, data);
    }
}
