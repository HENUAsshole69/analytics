package cn.edu.henu.analytics.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "area", schema = "bigdata", catalog = "")
public class AreaEntity {
    private int areaId;
    private String areaName;
    private Double areaScore;
    private Integer areaParentid;

    @Id
    @Column(name = "area_id")
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "area_name")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "area_score")
    public Double getAreaScore() {
        return areaScore;
    }

    public void setAreaScore(Double areaScore) {
        this.areaScore = areaScore;
    }

    @Basic
    @Column(name = "area_parentid")
    public Integer getAreaParentid() {
        return areaParentid;
    }

    public void setAreaParentid(Integer areaParentid) {
        this.areaParentid = areaParentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaEntity that = (AreaEntity) o;
        return areaId == that.areaId &&
                Objects.equals(areaName, that.areaName) &&
                Objects.equals(areaScore, that.areaScore) &&
                Objects.equals(areaParentid, that.areaParentid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, areaName, areaScore, areaParentid);
    }
}
