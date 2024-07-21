package com.lucasgusmao.petshop_api.repository;

import com.lucasgusmao.petshop_api.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByHorarioReserva(String horario);
    Optional<Pet> findByName(String name);
}
