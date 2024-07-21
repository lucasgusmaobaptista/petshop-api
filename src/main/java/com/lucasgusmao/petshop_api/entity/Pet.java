package com.lucasgusmao.petshop_api.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nome", nullable = false)
    private String name;
    @Column(name = "especie")
    private String especie;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "horarioReserva", unique = true)
    private String horarioReserva;

}
