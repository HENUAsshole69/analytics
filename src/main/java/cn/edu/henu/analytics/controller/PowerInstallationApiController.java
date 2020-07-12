package cn.edu.henu.analytics.controller;

import cn.edu.henu.analytics.entity.PowerInstallation;
import cn.edu.henu.analytics.entity.PowerReliability;
import cn.edu.henu.analytics.repo.InstallationProcessRepo;
import cn.edu.henu.analytics.repo.PowerExpenditureRepo;
import cn.edu.henu.analytics.repo.PowerInstallationRepo;
import cn.edu.henu.analytics.repo.PowerReliabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PowerInstallationApiController {
    private final PowerInstallationRepo powerInstallationRepo;
    private final InstallationProcessRepo installationProcessRepo;
    private final PowerExpenditureRepo powerExpenditureRepo;
    private final PowerReliabilityRepo powerReliabilityRepo;
    @Autowired
    public PowerInstallationApiController(PowerInstallationRepo powerInstallationRepo, InstallationProcessRepo installationProcessRepo, InstallationProcessRepo installationProcessRepo1, PowerExpenditureRepo powerExpenditureRepo, PowerReliabilityRepo powerReliabilityRepo) {
        this.powerInstallationRepo = powerInstallationRepo;
        this.installationProcessRepo = installationProcessRepo1;
        this.powerExpenditureRepo = powerExpenditureRepo;
        this.powerReliabilityRepo = powerReliabilityRepo;
    }
    @PostMapping("/powerInstallation")
    public ResponseEntity<PowerInstallation> post(@RequestBody PowerInstallation powerInstallation){
        powerInstallation.setInstallationProcesses(installationProcessRepo.saveAll(powerInstallation.getInstallationProcesses()));
        powerInstallation.setExpenditure(powerExpenditureRepo.save(powerInstallation.getExpenditure()));
        powerInstallation.setReliability(powerReliabilityRepo.save(powerInstallation.getReliability()));
        return ResponseEntity.ok(powerInstallationRepo.save(powerInstallation));
    }
    @DeleteMapping("/powerInstallation/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        powerInstallationRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/powerInstallation")
    public ResponseEntity<Page<PowerInstallation>> getInstallationItemPage(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(powerInstallationRepo.findAll(PageRequest.of(page,size)));
    }
}

