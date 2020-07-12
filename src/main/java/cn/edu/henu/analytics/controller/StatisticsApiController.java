package cn.edu.henu.analytics.controller;

import cn.edu.henu.analytics.model.Statistic;
import cn.edu.henu.analytics.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsApiController {
    private StatisticService statisticService;
    @Autowired
    public StatisticsApiController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }
    @GetMapping("/statistic")
    public ResponseEntity<List<Statistic>> getStatistics(){
        return ResponseEntity.ok(this.statisticService.query());
    }
}
