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
    public ResponseEntity<ReservationEntity> getReservationById(@PathVariable Long reservationId) {
        return new ResponseEntity<>(reservationRepository.findById(reservationId).orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationEntity reservationEntity) {
        reservationRepository.save(reservationEntity);
        return new ResponseEntity<>(reservationEntity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReservationEntity> updateReservation(@RequestBody ReservationEntity reservationEntity) {
        reservationRepository.save(reservationEntity);
        return new ResponseEntity<>(reservationEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<ReservationEntity> deleteReservation(@PathVariable Long reservationId) {
        if (reservationRepository.findById(reservationId).isPresent())
            reservationRepository.deleteById(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<ReservationEntity> deleteAllReservations() {
        reservationRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
