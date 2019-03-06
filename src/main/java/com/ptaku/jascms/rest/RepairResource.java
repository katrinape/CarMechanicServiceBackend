package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.RepairEntity;
import com.ptaku.jascms.repository.RepairRepository;
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
public class RepairResource {

    private RepairRepository repairRepository;

    @Autowired
    public RepairResource(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    @GetMapping("repairs")
    public ResponseEntity<Iterable<RepairEntity>> getAllRepairs() {
        return new ResponseEntity<>(repairRepository.findAll(), HttpStatus.OK);
    }
}
