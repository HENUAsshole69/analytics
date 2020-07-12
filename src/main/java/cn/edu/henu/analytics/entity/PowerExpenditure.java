package cn.edu.henu.analytics.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class PowerExpenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String govDept;
    private String office;
    private String relatedDept;
    private String contact;
    private String contactTel;
    private Long powerUsageKWh;
    private Long avgPowerPrice;
    private Long powerExpenditure;
    private Long revenue;
    private Double expenditureRevenueRatio;
}
