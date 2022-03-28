package com.evolution.food.api.controller;

import com.evolution.food.api.domain.model.Cozinha;
import com.evolution.food.api.domain.repository.CozinhaRepository;
import com.evolution.food.api.model.CozinhasXmlWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml() {
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> listarPorId(@PathVariable Long id) {
        Cozinha cozinha = cozinhaRepository.buscar(id);

//        return ResponseEntity.status(HttpStatus.OK).build();
//        return ResponseEntity.ok(cozinha);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas");
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .headers(httpHeaders)
                .build();
    }
}
