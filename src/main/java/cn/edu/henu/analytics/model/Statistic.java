package cn.edu.henu.analytics.model;

import cn.edu.henu.analytics.entity.PowerInstallation;
import lombok.Data;
import lombok.val;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
public class Statistic {
    private PowerInstallation sample;
    private Integer totalCost = 0;
    private Integer processCount = 0;
    private Integer timeTaken = 0;
    public Statistic(PowerInstallation sample){
        this.setSample(sample);
        sample.getInstallationProcesses().forEach((it)->{
            totalCost += it.getCost().intValue();
            processCount++;
            timeTaken+=it.getDaysTaken();
        });
    }
}
