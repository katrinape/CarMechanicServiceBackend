package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.ReservationEntity;
import com.ptaku.jascms.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationResource {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationResource(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<ReservationEntity>> getAllReservations() {
        return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationEntity> getReservation(@PathVariable Long reservationId) {
        return new ResponseEntity<>(reservationRepository.findById(reservationId).orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationEntity reservationEntity) {
        ReservationEntity entity = reservationRepository.save(reservationEntity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReservationEntity> updateReservation(@RequestBody ReservationEntity reservationEntity) {
        ReservationEntity entity = reservationRepository.save(reservationEntity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity deleteReservation(@PathVariable Long reservationId) {
        reservationRepository.deleteById(reservationId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllReservations() {
        reservationRepository.deleteAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
