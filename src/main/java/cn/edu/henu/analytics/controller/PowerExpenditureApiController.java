package cn.edu.henu.analytics.controller;

import cn.edu.henu.analytics.entity.PowerExpenditure;
import cn.edu.henu.analytics.entity.PowerReliability;
import cn.edu.henu.analytics.repo.PowerExpenditureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PowerExpenditureApiController {
    private PowerExpenditureRepo powerExpenditureRepo;
    @Autowired
    public PowerExpenditureApiController(PowerExpenditureRepo powerExpenditureRepo) {
        this.powerExpenditureRepo = powerExpenditureRepo;
    }

    @PostMapping("/expenditure")
    public ResponseEntity<PowerExpenditure> postExpenditure(@RequestBody PowerExpenditure powerExpenditure){
        return ResponseEntity.ok(powerExpenditureRepo.save(powerExpenditure));
    }
    @DeleteMapping("/expenditure/{id}")
    public ResponseEntity<Void> delExpenditure(@PathVariable Long id){
        powerExpenditureRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
