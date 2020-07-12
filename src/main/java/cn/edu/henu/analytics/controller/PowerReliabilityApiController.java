package cn.edu.henu.analytics.controller;

import cn.edu.henu.analytics.entity.PowerExpenditure;
import cn.edu.henu.analytics.entity.PowerReliability;
import cn.edu.henu.analytics.repo.PowerReliabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PowerReliabilityApiController {
    private PowerReliabilityRepo powerReliabilityRepo;
    @Autowired
    public PowerReliabilityApiController(PowerReliabilityRepo powerReliabilityRepo) {
        this.powerReliabilityRepo = powerReliabilityRepo;
    }
    @PostMapping("/reliability")
    public ResponseEntity<PowerReliability> postReliability(@RequestBody PowerReliability powerReliability){
        return ResponseEntity.ok(powerReliabilityRepo.save(powerReliability));
    }
    @DeleteMapping("/reliability/{id}")
    public ResponseEntity<Void> delReliability(@PathVariable Long id){
        powerReliabilityRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/reliability")
    public ResponseEntity<Page<PowerReliability>> getReliabilityItemPage(@RequestParam int page,@RequestParam int size){
        return ResponseEntity.ok(powerReliabilityRepo.findAll(PageRequest.of(page,size)));
    }
}
