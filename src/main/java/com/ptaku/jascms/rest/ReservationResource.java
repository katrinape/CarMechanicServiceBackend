package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.ReservationEntity;
import com.ptaku.jascms.repository.ReservationRepository;
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
public class ReservationResource {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationResource(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("reservations")
    public ResponseEntity<Iterable<ReservationEntity>> getAllReservations() {
        return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
    }
}
