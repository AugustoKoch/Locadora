package com.augusto.locadora.service;

import com.augusto.locadora.model.Cliente;
import com.augusto.locadora.model.Reserva;
import com.augusto.locadora.model.Veiculo;
import com.augusto.locadora.repository.ClienteRepository;
import com.augusto.locadora.repository.ReservaRepository;
import com.augusto.locadora.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Reserva addReserva(Reserva reserva){

        //Busca id de cliente e veiculo no banco de dados
        Optional<Cliente> optionalCliente = clienteRepository.findById(reserva.getCliente().getId());
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(reserva.getVeiculo().getId());

        //Verifica se cliente e veiculo exitem
        if (optionalCliente.isPresent() && optionalVeiculo.isPresent()){

            //Adiciona a reserva o cliente e veiculo encontrados
            reserva.setCliente(optionalCliente.get());
            reserva.setVeiculo(optionalVeiculo.get());

            //Adiciona a reserva a lista de reservas em cliente e veiculo
            reserva.getCliente().getReservas().add(reserva);
            reserva.getVeiculo().getReservas().add(reserva);

            return reservaRepository.save(reserva);

        } else {
            throw new IndexOutOfBoundsException("Cliente ou veículo não encontrados.");
        }
    }

    public List<Reserva> findAllReservas(){
        return reservaRepository.findAll();
    }

    public Reserva updateReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Long id){
        reservaRepository.deleteById(id);
    }
}
