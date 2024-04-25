package com.augusto.revenda.service;


import com.augusto.revenda.model.Cliente;
import com.augusto.revenda.model.Veiculo;
import com.augusto.revenda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente addCliente(Cliente cliente){

        List<Cliente> clienteList = clienteRepository.findAll();
        for (Cliente _cliente : clienteList) {
            if (Objects.equals(cliente.getCPF(), _cliente.getCPF())){
                throw new IllegalArgumentException("Já existe um cliente cadastrado com este CPF!");
            }
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAllClientes(){
        return clienteRepository.findAll();
    }

    public Cliente updateCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
