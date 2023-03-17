package br.com.uniamerica.chamada.controller;

import br.com.uniamerica.chamada.entity.Presenca;
import br.com.uniamerica.chamada.repository.PresencaRepository;
import br.com.uniamerica.chamada.service.PresencaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/api/presencas")
public class PresencaController {

    @Autowired
    private PresencaService presencaService;
    @Autowired
    private PresencaRepository presencaRepository;

    /**
     * Lista de presenças de um determinado aluno
     *
     * @param ra do aluno
     * @param data da presença
     * @return
     */
    @GetMapping("/aluno")
    private ResponseEntity<?> findByRaAndData(
            @RequestParam("ra") final int ra,
            @RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate data
    ){
        final List<Presenca> presencas = this.presencaRepository.findByRaAndData(ra, data);
        return new ResponseEntity<>(presencas, HttpStatus.OK);
    }

    /**
     * Lista de presenças com Defeiro, Presenças de dois alunos para o mesmo ip no mesmo dia
     *
     * @param data de controle. (Agrupador)
     * @return
     */
    @GetMapping
    private ResponseEntity<?> listPresencasComDefeito(
            @RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate data
    ){
        final List<Presenca> presencas = this.presencaService.listPresencasComDefeito(data);
        return new ResponseEntity<>(presencas, HttpStatus.OK);
    }

    /**
     * Registrar a presença do aluno.
     *
     * @param httpServletRequest controlar a requesição do cliente
     * @param presenca objeto de presença
     * @return
     */
    @PostMapping
    private ResponseEntity<?> cadastrar(
            final HttpServletRequest httpServletRequest,
            @RequestBody final Presenca presenca
    ) {
        final Presenca newPresenca = this.presencaService.cadastrar(httpServletRequest, presenca);
        return new ResponseEntity<>(
                "Presença realizada com sucesso. Hora do registro: " +
                        newPresenca.getCadastro(), HttpStatus.OK);
    }
}
