package br.com.uniamerica.chamada.controller;

import br.com.uniamerica.chamada.entity.Presenca;
import br.com.uniamerica.chamada.service.PresencaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.UnknownHostException;

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
    private PresencaService chamadaService;

    @PostMapping
    private ResponseEntity<?> cadastrar(
            final HttpServletRequest httpServletRequest,
            @RequestBody final Presenca presenca
    ) throws UnknownHostException {

        final Presenca newPresenca = this.chamadaService
                .cadastrar(httpServletRequest, presenca);

        return new ResponseEntity<>(
                "Presença realizada com sucesso. Hora do registro: "
                        + newPresenca.getDtCadastro(), HttpStatus.OK);
    }
}
