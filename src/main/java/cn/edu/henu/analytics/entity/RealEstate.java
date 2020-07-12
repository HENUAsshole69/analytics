package cn.edu.henu.analytics.entity;

import cn.edu.henu.analytics.entity.RealEstateProcess;
import cn.edu.henu.analytics.entity.auth.Subject;
import lombok.Data;

import javax.persistence.*;
import java.lang.String;
import java.util.List;
@Entity
@Data
public class RealEstate {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @OneToOne
  public Subject submitter;

  public String office;

  public String govDept;

  public String name;

  public String relatedDept;

  public String contactTel;

  public String contact;

  public String time;

  public double value;
  @OneToMany
  public List<RealEstateProcess> realEstateProcesses;
}
