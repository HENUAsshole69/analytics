package cn.edu.henu.analytics.service;

import cn.edu.henu.analytics.entity.PowerInstallation;
import cn.edu.henu.analytics.model.Statistic;
import cn.edu.henu.analytics.repo.PowerInstallationRepo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {
 private PowerInstallationRepo powerInstallationRepo;
    @Autowired
    public StatisticService(PowerInstallationRepo powerInstallationRepo) {
        this.powerInstallationRepo = powerInstallationRepo;
    }
    public List<Statistic> query(){
        val list = new ArrayList<Statistic>();
        for(val power : powerInstallationRepo.findAll()){
            list.add(new Statistic(power));
        }
        return list;
    }
}
