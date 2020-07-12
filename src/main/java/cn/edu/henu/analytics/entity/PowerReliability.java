package cn.edu.henu.analytics.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class PowerReliability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String govDept;
    private String office;
    private String relatedDept;
    private String contact;
    private String contactTel;
    private Integer blackOutTimeSpan;
    private Integer blackOutFreq;
    private Boolean isPowerSupplierMonitoringToolAutomatic;
    private Boolean isPowerSupplierRestoringToolAutomatic;
    private Boolean externalWatchDogPresence;
    private Boolean budgetaryIntimidationPresence;
}
