package br.com.uniamerica.chamada.service;

import br.com.uniamerica.chamada.entity.Chamada;
import br.com.uniamerica.chamada.repository.ChamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 15/03/2023
 * @since 1.0.0
 */
@Service
public class ChamadaService {

    @Autowired
    private ChamadaRepository chamadaRepository;

    /**
     *
     * @param chamada
     * @return
     */
    @Transactional( rollbackFor = Exception.class)
    public Chamada cadastrar(final Chamada chamada){

        final List<Chamada> chamadas = this.chamadaRepository
                .findByTurmaAndProjetoAndAtivo(
                        chamada.getTurma(),
                        chamada.getProjeto()
                );

        Assert.isTrue(chamadas.isEmpty(), "Existe uma chamada em aberto para a turma e projeto informado.");

        return this.chamadaRepository.save(chamada);
    }
}
