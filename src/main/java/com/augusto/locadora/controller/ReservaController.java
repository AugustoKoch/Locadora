package com.augusto.locadora.controller;

import com.augusto.locadora.model.Reserva;
import com.augusto.locadora.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Object> addReserva(@RequestBody Reserva reserva){
        try {
            reservaService.addReserva(reserva);
            return ResponseEntity.ok(reserva);
        } catch (IndexOutOfBoundsException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public List<Reserva> getAllReservas(){
        return reservaService.findAllReservas();
    }

    @PutMapping
    public Reserva updateReserva(@RequestBody Reserva reserva) {
        return reservaService.updateReserva(reserva);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id){
        reservaService.deleteReserva(id);
    }
}