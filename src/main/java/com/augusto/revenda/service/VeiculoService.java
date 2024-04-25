package com.augusto.revenda.service;

import com.augusto.revenda.model.Veiculo;
import com.augusto.revenda.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo addVeiculo(Veiculo veiculo){

        List<Veiculo> veiculoList = veiculoRepository.findAll();
        for (Veiculo _veiculo : veiculoList) {
            if (Objects.equals(veiculo.getPlaca(), _veiculo.getPlaca())){
                throw new IllegalArgumentException("Já existe um veiculo cadastrado com esta placa!");
            }
        }

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findAllVeiculos(){
        return veiculoRepository.findAll();
    }

    public Veiculo updateVeiculo(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public void deleteVeiculo(Long id){
        veiculoRepository.deleteById(id);
    }
}
