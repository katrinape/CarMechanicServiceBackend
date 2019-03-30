package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.RepairElement;
import com.ptaku.jascms.entity.RepairEntity;
import com.ptaku.jascms.repository.ElementRepository;
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
    private ElementRepository elementRepository;

    @Autowired
    public RepairResource(RepairRepository repairRepository, ElementRepository elementRepository) {
        this.repairRepository = repairRepository;
        this.elementRepository = elementRepository;
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

    @PostMapping("/{repairId}/elements")
    public ResponseEntity<RepairEntity> addElement(@PathVariable Long repairId, @RequestBody RepairElement element) {
        RepairEntity repairEntity = repairRepository.findById(repairId).orElse(null);
        if(repairEntity != null) {
            repairEntity.addElement(element);
            repairRepository.save(repairEntity);
        }
        return new ResponseEntity<>(repairEntity, HttpStatus.OK);
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

    @GetMapping("/elements")
    public ResponseEntity<Iterable<RepairElement>> getAllElements() {
        return new ResponseEntity<>(elementRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/elements/{elementId}")
    public ResponseEntity deleteRepairElement(@PathVariable Long elementId) {
        elementRepository.deleteById(elementId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
