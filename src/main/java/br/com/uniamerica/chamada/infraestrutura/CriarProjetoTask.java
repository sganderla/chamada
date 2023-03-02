package br.com.uniamerica.chamada.infraestrutura;

import br.com.uniamerica.chamada.entity.Projeto;
import br.com.uniamerica.chamada.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 28/02/2023
 * @since 1.0.0
 */
@Order(1)
@Component
public class CriarProjetoTask implements InitialTask {

    @Autowired
    private ProjetoRepository projetoRepository;

    /**
     *
     */
    @Override
    public void perform() {

        if(this.projetoRepository.findAll().isEmpty()) {

            final List<Projeto> projetos = new ArrayList<Projeto>();

            projetos.add(new Projeto(1L, "Projeto Integrador"));
            projetos.add(new Projeto(2L, "Primeiro Projeto"));
            projetos.add(new Projeto(3L, "Segundo Projeto"));
            projetos.add(new Projeto(4L, "Terceiro Projeto"));
            projetos.add(new Projeto(5L, "Quarto Projeto"));

            this.projetoRepository.saveAll(projetos);
        }
    }
}
