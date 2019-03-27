package com.ptaku.jascms.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "repairElement")
@Table(name = "repairElement")
public class RepairElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @JsonIgnoreProperties("elements")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "repairEntity_id")
    private RepairEntity repairEntity;

    public RepairElement() {
    }

    public RepairElement(String name, Double price) {
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RepairEntity getRepairEntity() {
        return repairEntity;
    }

    public void setRepairEntity(RepairEntity repairEntity) {
        this.repairEntity = repairEntity;
    }
}
