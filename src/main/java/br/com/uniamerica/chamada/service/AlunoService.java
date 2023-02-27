package br.com.uniamerica.chamada.service;

import br.com.uniamerica.chamada.entity.Aluno;
import br.com.uniamerica.chamada.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Controller
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    /**
     *
     * @param chave
     * @param aluno
     */
    public void cadastrar(final int chave, final Aluno aluno){

        Assert.isTrue(chave != 854856852, "Chave invalida");
        Assert.isTrue(aluno.getNome() == null, "Nome não informado!");
        Assert.isTrue(aluno.getRa() >= 0, "RA não informado!");

        this.alunoRepository.save(aluno);
    }
}
