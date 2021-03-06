package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.CarEntity;
import com.ptaku.jascms.entity.CustomerEntity;
import com.ptaku.jascms.entity.ReservationEntity;
import com.ptaku.jascms.repository.CarRepository;
import com.ptaku.jascms.repository.CustomerRepository;
import com.ptaku.jascms.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerResource {

    private CustomerRepository customerRepository;
    private ReservationRepository reservationRepository;
    private CarRepository carRepository;

    @Autowired
    public CustomerResource(CustomerRepository customerRepository, ReservationRepository reservationRepository, CarRepository carRepository) {
        this.customerRepository = customerRepository;
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<CustomerEntity>> getAllCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerRepository.findById(customerId).orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity entity = customerRepository.save(customerEntity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PostMapping("/{customerId}/reservations")
    public ResponseEntity<CustomerEntity> addReservationToCustomer(@PathVariable Long customerId, @RequestBody ReservationEntity reservationEntity) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElse(null);
        if(customerEntity != null) {
            customerEntity.addReservation(reservationEntity);
            customerRepository.save(customerEntity);
        }
        return new ResponseEntity<>(customerEntity, HttpStatus.OK);
    }

    @PostMapping("/{customerId}/cars")
    public ResponseEntity<CustomerEntity> addCarToCustomer(@PathVariable Long customerId, @RequestBody CarEntity carEntity) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElse(null);
        if(customerEntity != null) {
            customerEntity.addCar(carEntity);
            customerRepository.save(customerEntity);
        }
        return new ResponseEntity<>(customerEntity, HttpStatus.OK);
    }

    @GetMapping("/{customerId}/reservations")
    public ResponseEntity<Iterable<ReservationEntity>> getCustomerReservations(@PathVariable Long customerId) {
        return new ResponseEntity<>(reservationRepository.findReservationEntitiesByCustomerEntityId(customerId), HttpStatus.OK);
    }

    @GetMapping("/{customerId}/cars")
    public ResponseEntity<Iterable<CarEntity>> getCustomerCars(@PathVariable Long customerId) {
        return new ResponseEntity<>(carRepository.findCarEntitiesByCustomerEntityId(customerId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity entity = customerRepository.save(customerEntity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<CustomerEntity> updatesCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity entity = customerRepository.save(customerEntity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable Long customerId) {
        customerRepository.deleteById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllCustomers() {
        customerRepository.deleteAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
