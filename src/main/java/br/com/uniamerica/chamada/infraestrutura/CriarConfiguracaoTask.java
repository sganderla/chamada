package br.com.uniamerica.chamada.infraestrutura;

import br.com.uniamerica.chamada.entity.Configuracao;
import br.com.uniamerica.chamada.entity.Turma;
import br.com.uniamerica.chamada.repository.ConfiguracaoRepository;
import br.com.uniamerica.chamada.repository.ProjetoRepository;
import br.com.uniamerica.chamada.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 15/03/2023
 * @since 1.0.0
 */
@Order(4)
@Component
public class CriarConfiguracaoTask implements InitialTask {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    /**
     *
     */
    @Override
    public void perform() {

        if(this.configuracaoRepository.findAll().isEmpty()) {

            final Configuracao configuracao = new Configuracao(
                    this.turmaRepository.getReferenceById(1L),
                    this.projetoRepository.getReferenceById(1L),
                    this.projetoRepository.getReferenceById(3L)
            );

            this.configuracaoRepository.save(configuracao);
        }
    }
}
