package br.com.uniamerica.chamada.controller;

import br.com.uniamerica.chamada.entity.Aluno;
import br.com.uniamerica.chamada.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    /**
     * Chamada Post
     *      Cadastrar Alunos
     *      Solicitação de chave de acesso (generica)
     *
     * @param chave
     * @param aluno
     * @return
     */
    @PostMapping("/{chave}")
    public ResponseEntity<?> cadastrar(
            @PathVariable final int chave,
            @RequestBody final Aluno aluno
    ){
        this.alunoService.cadastrar(chave, aluno);
        return new ResponseEntity<>("Aluno cadastrado com sucesso;", HttpStatus.OK);
    }

}
