package com.ptaku.jascms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "repairEntity")
@Table(name = "repairEntity")
public class RepairEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private Long mileage;

    @NotNull
    private String date;

    private Double totalPrice;

    @JsonIgnoreProperties("repairEntity")
    @OneToMany(mappedBy = "repairEntity", cascade = CascadeType.ALL)
    private List<RepairElement> elements;

    @JsonIgnoreProperties("repairs")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "carEntity_id")
    private CarEntity carEntity;

    public RepairEntity() {
        this.totalPrice = 0.0;
    }

    public RepairEntity(@NotNull String title, @NotNull Long mileage, @NotNull String date) {
        this.title = title;
        this.mileage = mileage;
        this.date = date;
        this.totalPrice = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public List<RepairElement> getElements() {
        return elements;
    }

    public void addElements(RepairElement repairElement) {
        if (this.elements == null) {
            this.elements = new ArrayList<>();
        }
        this.elements.add(repairElement);
        this.totalPrice += repairElement.getPrice();
        repairElement.setRepairEntity(this);
    }

    public void removeElement(RepairElement repairElement) {
        this.elements.remove(repairElement);
        this.totalPrice -= repairElement.getPrice();
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }
}

