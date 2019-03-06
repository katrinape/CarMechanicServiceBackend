package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.CarEntity;
import com.ptaku.jascms.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin
public class CarResource {

    private CarRepository carRepository;

    @Autowired
    public CarResource(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("cars")
    public ResponseEntity<Iterable<CarEntity>> getAllCars() {
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }
}
