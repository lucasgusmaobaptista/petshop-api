package com.lucasgusmao.petshop_api.service;

import com.lucasgusmao.petshop_api.entity.Pet;
import com.lucasgusmao.petshop_api.repository.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public Pet criarReserva(Pet pet) {
        return repository.save(pet);
    }

    public void deletarReserva(Long id) {
        repository.deleteById(id);
    }

    public List<Pet> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pet> encontrarReservaID(Long id) {
        return repository.findById(id);
    }

    public Optional<Pet> encontrarReservaPorHorario(String Horario){
        return repository.findByHorarioReserva(Horario);
    }

    public Optional<Pet> encontrarReservaPorNome(String nome){
        return repository.findByName(nome);
    }

    public ResponseEntity<Pet> atualizarReserva(Pet pet) {
        Optional<Pet> petOptional = repository.findById((pet.getId()));
        if (petOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Pet petAtualizado = petOptional.get();
        petAtualizado.setName(pet.getName());
        petAtualizado.setEspecie(pet.getEspecie());
        petAtualizado.setIdade(pet.getIdade());
        petAtualizado.setHorarioReserva(pet.getHorarioReserva());
        return ResponseEntity.of(Optional.of(repository.save(petAtualizado)));
    }

}
