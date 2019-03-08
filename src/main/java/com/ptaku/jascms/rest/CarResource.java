package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.CarEntity;
import com.ptaku.jascms.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarResource {

    private CarRepository carRepository;

    @Autowired
    public CarResource(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<CarEntity>> getAllCars() {
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable Long carId) {
        return new ResponseEntity<>(carRepository.findById(carId).orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarEntity> createCar(@RequestBody CarEntity carEntity) {
        CarEntity entity = carRepository.save(carEntity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CarEntity> updateCar(@RequestBody CarEntity carEntity) {
        CarEntity entity = carRepository.save(carEntity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity deleteCar(@PathVariable Long carId) {
        carRepository.deleteById(carId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllCars() {
        carRepository.deleteAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
