package br.com.uniamerica.chamada.controller;

import br.com.uniamerica.chamada.entity.Chamada;
import br.com.uniamerica.chamada.repository.ChamadaRepository;
import br.com.uniamerica.chamada.repository.PresencaRepository;
import br.com.uniamerica.chamada.service.ChamadaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private ChamadaRepository chamadaRepository;
    @Autowired
    private ChamadaService chamadaService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping
    public ResponseEntity<?> findById(@RequestParam("id") final Long id){
        return new ResponseEntity<>(this.chamadaRepository.findById(id), HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/lista")
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(this.chamadaRepository.findByAtivoTrue(), HttpStatus.OK);
    }

    /**
     *
     * @param chamada
     * @return
     */
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Chamada chamada){
        return new ResponseEntity<>(this.chamadaService.cadastrar(chamada), HttpStatus.OK);
    }

    /**
     *
     * @param chamada
     * @return
     */
    @PutMapping
    public ResponseEntity<?> editar(@RequestBody final Chamada chamada){
        return new ResponseEntity<>(this.chamadaRepository.save(chamada), HttpStatus.OK);
    }
}
