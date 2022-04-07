package com.evolution.food.api.controller;

import com.evolution.food.api.domain.model.Estado;
import com.evolution.food.api.domain.repository.EstadoRepository;
import com.evolution.food.api.domain.service.EstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public Estado buscar(@PathVariable Long estadoId) {
        return estadoService.buscarOuFalhar(estadoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado) {
        return estadoService.salvar(estado);
    }

    @PutMapping("/{estadoId}")
    public Estado atualizar(@PathVariable Long estadoId,
                            @RequestBody Estado estado) {
        Estado estadoAtual = estadoService.buscarOuFalhar(estadoId);

        BeanUtils.copyProperties(estado, estadoAtual, "id");

        return estadoService.salvar(estadoAtual);
    }

    @DeleteMapping("/{estadoId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long estadoId) {
        estadoService.excluir(estadoId);
    }

}
