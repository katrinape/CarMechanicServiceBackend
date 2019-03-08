package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.RepairEntity;
import com.ptaku.jascms.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repairs")
@CrossOrigin
public class RepairResource {

    private RepairRepository repairRepository;

    @Autowired
    public RepairResource(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<RepairEntity>> getAllRepairs() {
        return new ResponseEntity<>(repairRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{repairId}")
    public ResponseEntity<RepairEntity> getRepairById(@PathVariable Long repairId) {
        return new ResponseEntity<>(repairRepository.findById(repairId).orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RepairEntity> createRepair(@RequestBody RepairEntity repairEntity) {
        RepairEntity entity = repairRepository.save(repairEntity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RepairEntity> updateRepair(@RequestBody RepairEntity repairEntity) {
        RepairEntity entity = repairRepository.save(repairEntity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{repairId}")
    public ResponseEntity deleteRepair(@PathVariable Long repairId) {
        repairRepository.deleteById(repairId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllRepairs() {
        repairRepository.deleteAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
