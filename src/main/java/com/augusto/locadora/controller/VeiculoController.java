package com.augusto.locadora.controller;

import com.augusto.locadora.model.Veiculo;
import com.augusto.locadora.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Object> addVeiculo(@RequestBody Veiculo veiculo){
        try {
            veiculoService.addVeiculo(veiculo);
            return ResponseEntity.ok(veiculo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public List<Veiculo> getAllVeiculos(){
        return veiculoService.findAllVeiculos();
    }

    @PutMapping
    public Veiculo updateVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.updateVeiculo(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable Long id){
        veiculoService.deleteVeiculo(id);
    }
}
