package com.evolution.food.api.controller;

import com.evolution.food.api.domain.exception.CozinhaNaoEncontradaException;
import com.evolution.food.api.domain.exception.NegocioException;
import com.evolution.food.api.domain.model.Restaurante;
import com.evolution.food.api.domain.repository.RestauranteRepository;
import com.evolution.food.api.domain.service.RestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }

    @GetMapping("/{restauranteId}")
    public Restaurante buscar(@PathVariable Long restauranteId) {
        return restauranteService.buscarOuFalhar(restauranteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante adicionar(@RequestBody Restaurante restaurante) {
        try {
            return restauranteService.salvar(restaurante);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{restauranteId}")
    public Restaurante atualizar(@PathVariable Long restauranteId,
                                 @RequestBody Restaurante restaurante) {
        try {
            Restaurante restauranteAtual = restauranteService.buscarOuFalhar(restauranteId);

            BeanUtils.copyProperties(restaurante, restauranteAtual,
                    "id", "formasPagamento", "endereco", "dataCadastro", "produtos");

            return restauranteService.salvar(restauranteAtual);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PatchMapping("/{restauranteId}")
    public Restaurante atualizarParcial(@PathVariable Long restauranteId,
                                        @RequestBody Map<String, Object> campos) {
        Restaurante restauranteAtual = restauranteService.buscarOuFalhar(restauranteId);

        merge(campos, restauranteAtual);

        return atualizar(restauranteId, restauranteAtual);
    }

    private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);

        dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
            field.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

//			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);

            ReflectionUtils.setField(field, restauranteDestino, novoValor);
        });
    }

}
