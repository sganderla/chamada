package br.com.uniamerica.chamada.service;

import br.com.uniamerica.chamada.conf.HttpUtils;
import br.com.uniamerica.chamada.entity.Chamada;
import br.com.uniamerica.chamada.repository.ChamadaRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 27/02/2023
 * @since 1.0.0
 */
@Service
public class ChamadaService {

    @Autowired
    private ChamadaRepository chamadaRepository;

    /**
     *
     * @param httpServletRequest
     * @param chamada
     * @return
     */
    @Transactional(readOnly = true,
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRES_NEW)
    public Chamada cadastrar(
            final HttpServletRequest httpServletRequest,
            @RequestBody final Chamada chamada
    ){
        

        return chamada;
    }

}
