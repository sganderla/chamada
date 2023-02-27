package br.com.uniamerica.chamada.controller;

import br.com.uniamerica.chamada.entity.Chamada;
import br.com.uniamerica.chamada.service.ChamadaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/api/chamadas")
public class ChamadaController {

    @Autowired
    private ChamadaService chamadaService;


    @PostMapping
    private ResponseEntity<?> cadastrar(
            final HttpServletRequest httpServletRequest,
            @RequestBody final Chamada chamada
    ){
        final Chamada newChamada = this.chamadaService.cadastrar(httpServletRequest, chamada);
        return new ResponseEntity<>("Chamada realizada com sucesso. Hora do registro: "
                + newChamada.getDtCadastro(), HttpStatus.OK);
    }
}
