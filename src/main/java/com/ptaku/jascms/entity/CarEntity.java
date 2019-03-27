package com.ptaku.jascms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "carEntity")
@Table(name = "carEntity")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String brand;

    @NotNull
    private String regNumber;

    @NotNull
    private String vin;

    @JsonIgnoreProperties({"cars", "reservations"})
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "customerEntity_id")
    private CustomerEntity customerEntity;

    @JsonIgnoreProperties("carEntity")
    @OneToMany(mappedBy = "carEntity", cascade = CascadeType.ALL)
    private List<RepairEntity> repairs;

    public CarEntity() {
    }

    public CarEntity(@NotNull String brand, @NotNull String regNumber, @NotNull String vin) {
        this.brand = brand;
        this.regNumber = regNumber;
        this.vin = vin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public List<RepairEntity> getRepairs() {
        return repairs;
    }

    public void addRepair(RepairEntity repairEntity) {
        if (this.repairs == null) {
            this.repairs = new ArrayList<>();
        }
        this.repairs.add(repairEntity);
        repairEntity.setCarEntity(this);
    }
}
