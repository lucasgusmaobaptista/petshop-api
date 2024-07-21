package com.lucasgusmao.petshop_api.controller;

import com.lucasgusmao.petshop_api.entity.Pet;
import com.lucasgusmao.petshop_api.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping("/find/{id}")
    public String findPetById(@PathVariable Long id) {
        if (!service.encontrarReservaID(id).isPresent()) {
            return "Reserva não encontrada!";
        }
        return service.encontrarReservaID(id).toString();
    }

    @GetMapping("/find")
    public String findAllPets() {
        if (service.listarTodos().isEmpty()) {
            return "Nenhum pet encontrado!";
        }
        return service.listarTodos().toString();
    }

    @GetMapping("/find/horario/{horario}")
    public ResponseEntity<String> findPetByHorario(@PathVariable String horario) {
        Optional<Pet> petOptional = service.encontrarReservaPorHorario(horario);
        if (petOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum pet com o horário " + horario + "reservado");
        } else {
            return ResponseEntity.ok(petOptional.get().toString());
        }
    }

    @GetMapping("/find/nome/{nome}")
    public ResponseEntity<String> findPetByNome(@PathVariable String nome) {
        Optional<Pet> petOptional = service.encontrarReservaPorNome(nome);
        if (petOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet com o nome " + nome + " não encontrado!");
        } else {
            return ResponseEntity.ok(petOptional.get().toString());
        }
    }

    @PostMapping("/create")
    public Pet createPet(@Validated @RequestBody Pet pet) {
        return service.criarReserva(pet);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        Optional<Pet> novoPet= service.encontrarReservaID(id);
        if (!novoPet.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada!");
        }
        Pet petAtualizado = novoPet.get();
        petAtualizado.setName(pet.getName());
        petAtualizado.setEspecie(pet.getEspecie());
        petAtualizado.setIdade(pet.getIdade());
        petAtualizado.setHorarioReserva(pet.getHorarioReserva());
        Pet updatedPet = service.criarReserva(petAtualizado);
        return ResponseEntity.ok(updatedPet.toString());
    }

    @DeleteMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        if (service.encontrarReservaID(id).isEmpty()) {
            return "Reserva não encontrada!";
        }
        service.deletarReserva(id);
        return "Reserva deletada com sucesso!";
    }
}
