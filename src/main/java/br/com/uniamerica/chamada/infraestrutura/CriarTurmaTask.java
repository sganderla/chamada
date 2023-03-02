package br.com.uniamerica.chamada.infraestrutura;

import br.com.uniamerica.chamada.entity.Turma;
import br.com.uniamerica.chamada.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 28/02/2023
 * @since 1.0.0
 */
@Order(2)
@Component
public class CriarTurmaTask implements InitialTask {

    @Autowired
    private TurmaRepository turmaRepository;

    /**
     *
     */
    @Override
    public void perform() {

        if(this.turmaRepository.findAll().isEmpty()) {
            final Turma turma = new Turma(1L, "Terceiro Periodo", 2023, 1);

            this.turmaRepository.save(turma);
        }
    }
}
