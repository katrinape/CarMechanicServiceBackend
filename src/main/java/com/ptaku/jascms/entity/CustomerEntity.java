package com.ptaku.jascms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customerEntity")
@Table(name = "customerEntity")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String telNumber;

    @NotNull
    private String email;

    @JsonIgnoreProperties("customerEntity")
    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservations;

    @JsonIgnoreProperties("customerEntity")
    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private List<CarEntity> cars;

    public CustomerEntity() {
    }

    public CustomerEntity(@NotNull String name, @NotNull String surname, @NotNull String telNumber, @NotNull String email) {
        this.name = name;
        this.surname = surname;
        this.telNumber = telNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void addReservation(ReservationEntity reservationEntity) {
        if (this.reservations == null) {
            this.reservations = new ArrayList<>();
        }
        this.reservations.add(reservationEntity);
        reservationEntity.setCustomerEntity(this);
    }

    public List<CarEntity> getCars() {
        return cars;
    }

    public void addCar(CarEntity carEntity) {
        if (this.cars == null) {
            this.cars = new ArrayList<>();
        }
        this.cars.add(carEntity);
        carEntity.setCustomerEntity(this);
    }
}
