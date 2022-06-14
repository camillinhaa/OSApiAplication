/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eti.kge.OSApiApplication.api.controller;

import br.eti.kge.OSApiApplication.domain.model.Cliente;
import br.eti.kge.OSApiApplication.domain.model.OrdemServico;
import br.eti.kge.OSApiApplication.domain.repository.ClienteRepository;
import br.eti.kge.OSApiApplication.domain.repository.OrdemServicoRepository;
import br.eti.kge.OSApiApplication.domain.service.OrdemServicoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author devsys-a
 */
@RestController
@RequestMapping ("/ordem-servico")
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico){
        return ordemServicoService.criar(ordemServico);
    }
    
    @GetMapping("{/ordemid}") 
    public ResponseEntity<OrdemServico> buscar(@PathVariable Long ordemId){
       Optional<OrdemServico> ordem = ordemServicoRepository.findById(ordemId);
       
        if (ordem.isPresent()){
           return ResponseEntity.ok(ordem.get());
       }else{
           return ResponseEntity.notFound().build();
       }    
    }
    
}
