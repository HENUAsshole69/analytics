package cn.edu.henu.analytics.entity;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "sec_indicators_power", schema = "bigdata", catalog = "")
public class SecIndicatorsPowerEntity {
    private int powerId;
    private String linkScore;
    private String powerLinkActual;
    private String powerLinkPbest;
    private String powerLinkCbest;
    private String powerLinkWorst;
    private String timeScore;
    private String powerTimeActual;
    private String powerTimePbest;
    private String powerTimeCbest;
    private String powerTimeWorst;
    private String costScore;
    private String powerCostActual;
    private String powerCostPbest;
    private String powerCostCbest;
    private String powerCostWorst;
    private String reliabilityScore;
    private String powerReliabilityActual;
    private String powerReliabilityPbest;
    private String powerReliabilityCbest;
    private String powerReliabilityWorst;
    private String powerPostTime;

    @Id
    @Column(name = "power_id")
    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    @Basic
    @Column(name = "link_score")
    public String getLinkScore() {
        return linkScore;
    }

    public void setLinkScore(String linkScore) {
        this.linkScore = linkScore;
    }

    @Basic
    @Column(name = "power_link_ actual")
    public String getPowerLinkActual() {
        return powerLinkActual;
    }

    public void setPowerLinkActual(String powerLinkActual) {
        this.powerLinkActual = powerLinkActual;
    }

    @Basic
    @Column(name = "power_link_pbest")
    public String getPowerLinkPbest() {
        return powerLinkPbest;
    }

    public void setPowerLinkPbest(String powerLinkPbest) {
        this.powerLinkPbest = powerLinkPbest;
    }

    @Basic
    @Column(name = "power_link_cbest")
    public String getPowerLinkCbest() {
        return powerLinkCbest;
    }

    public void setPowerLinkCbest(String powerLinkCbest) {
        this.powerLinkCbest = powerLinkCbest;
    }

    @Basic
    @Column(name = "power_link_worst")
    public String getPowerLinkWorst() {
        return powerLinkWorst;
    }

    public void setPowerLinkWorst(String powerLinkWorst) {
        this.powerLinkWorst = powerLinkWorst;
    }

    @Basic
    @Column(name = "time_score")
    public String getTimeScore() {
        return timeScore;
    }

    public void setTimeScore(String timeScore) {
        this.timeScore = timeScore;
    }

    @Basic
    @Column(name = "power_time_actual")
    public String getPowerTimeActual() {
        return powerTimeActual;
    }

    public void setPowerTimeActual(String powerTimeActual) {
        this.powerTimeActual = powerTimeActual;
    }

    @Basic
    @Column(name = "power_time_pbest")
    public String getPowerTimePbest() {
        return powerTimePbest;
    }

    public void setPowerTimePbest(String powerTimePbest) {
        this.powerTimePbest = powerTimePbest;
    }

    @Basic
    @Column(name = "power_time_cbest")
    public String getPowerTimeCbest() {
        return powerTimeCbest;
    }

    public void setPowerTimeCbest(String powerTimeCbest) {
        this.powerTimeCbest = powerTimeCbest;
    }

    @Basic
    @Column(name = "power_time_worst")
    public String getPowerTimeWorst() {
        return powerTimeWorst;
    }

    public void setPowerTimeWorst(String powerTimeWorst) {
        this.powerTimeWorst = powerTimeWorst;
    }

    @Basic
    @Column(name = "cost_score")
    public String getCostScore() {
        return costScore;
    }

    public void setCostScore(String costScore) {
        this.costScore = costScore;
    }

    @Basic
    @Column(name = "power_cost_actual")
    public String getPowerCostActual() {
        return powerCostActual;
    }

    public void setPowerCostActual(String powerCostActual) {
        this.powerCostActual = powerCostActual;
    }

    @Basic
    @Column(name = "power_cost_pbest")
    public String getPowerCostPbest() {
        return powerCostPbest;
    }

    public void setPowerCostPbest(String powerCostPbest) {
        this.powerCostPbest = powerCostPbest;
    }

    @Basic
    @Column(name = "power_cost_cbest")
    public String getPowerCostCbest() {
        return powerCostCbest;
    }

    public void setPowerCostCbest(String powerCostCbest) {
        this.powerCostCbest = powerCostCbest;
    }

    @Basic
    @Column(name = "power_cost_worst")
    public String getPowerCostWorst() {
        return powerCostWorst;
    }

    public void setPowerCostWorst(String powerCostWorst) {
        this.powerCostWorst = powerCostWorst;
    }

    @Basic
    @Column(name = "reliability_score")
    public String getReliabilityScore() {
        return reliabilityScore;
    }

    public void setReliabilityScore(String reliabilityScore) {
        this.reliabilityScore = reliabilityScore;
    }

    @Basic
    @Column(name = "power_reliability_actual")
    public String getPowerReliabilityActual() {
        return powerReliabilityActual;
    }

    public void setPowerReliabilityActual(String powerReliabilityActual) {
        this.powerReliabilityActual = powerReliabilityActual;
    }

    @Basic
    @Column(name = "power_reliability_pbest")
    public String getPowerReliabilityPbest() {
        return powerReliabilityPbest;
    }

    public void setPowerReliabilityPbest(String powerReliabilityPbest) {
        this.powerReliabilityPbest = powerReliabilityPbest;
    }

    @Basic
    @Column(name = "power_reliability_cbest")
    public String getPowerReliabilityCbest() {
        return powerReliabilityCbest;
    }

    public void setPowerReliabilityCbest(String powerReliabilityCbest) {
        this.powerReliabilityCbest = powerReliabilityCbest;
    }

    @Basic
    @Column(name = "power_reliability_worst")
    public String getPowerReliabilityWorst() {
        return powerReliabilityWorst;
    }

    public void setPowerReliabilityWorst(String powerReliabilityWorst) {
        this.powerReliabilityWorst = powerReliabilityWorst;
    }

    @Basic
    @Column(name = "power_post_time")
    public String getPowerPostTime() {
        return powerPostTime;
    }

    public void setPowerPostTime(String powerPostTime) {
        this.powerPostTime = powerPostTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecIndicatorsPowerEntity that = (SecIndicatorsPowerEntity) o;
        return powerId == that.powerId &&
                Objects.equals(linkScore, that.linkScore) &&
                Objects.equals(powerLinkActual, that.powerLinkActual) &&
                Objects.equals(powerLinkPbest, that.powerLinkPbest) &&
                Objects.equals(powerLinkCbest, that.powerLinkCbest) &&
                Objects.equals(powerLinkWorst, that.powerLinkWorst) &&
                Objects.equals(timeScore, that.timeScore) &&
                Objects.equals(powerTimeActual, that.powerTimeActual) &&
                Objects.equals(powerTimePbest, that.powerTimePbest) &&
                Objects.equals(powerTimeCbest, that.powerTimeCbest) &&
                Objects.equals(powerTimeWorst, that.powerTimeWorst) &&
                Objects.equals(costScore, that.costScore) &&
                Objects.equals(powerCostActual, that.powerCostActual) &&
                Objects.equals(powerCostPbest, that.powerCostPbest) &&
                Objects.equals(powerCostCbest, that.powerCostCbest) &&
                Objects.equals(powerCostWorst, that.powerCostWorst) &&
                Objects.equals(reliabilityScore, that.reliabilityScore) &&
                Objects.equals(powerReliabilityActual, that.powerReliabilityActual) &&
                Objects.equals(powerReliabilityPbest, that.powerReliabilityPbest) &&
                Objects.equals(powerReliabilityCbest, that.powerReliabilityCbest) &&
                Objects.equals(powerReliabilityWorst, that.powerReliabilityWorst) &&
                Objects.equals(powerPostTime, that.powerPostTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerId, linkScore, powerLinkActual, powerLinkPbest, powerLinkCbest, powerLinkWorst, timeScore, powerTimeActual, powerTimePbest, powerTimeCbest, powerTimeWorst, costScore, powerCostActual, powerCostPbest, powerCostCbest, powerCostWorst, reliabilityScore, powerReliabilityActual, powerReliabilityPbest, powerReliabilityCbest, powerReliabilityWorst, powerPostTime);
    }
}
