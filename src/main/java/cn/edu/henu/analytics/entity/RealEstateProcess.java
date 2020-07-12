package cn.edu.henu.analytics.entity;

import lombok.Data;
import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.lang.String;
import java.util.List;
@Entity
@Data
public class RealEstateProcess {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  public boolean happened;

  public double promisedTime;

  public String process;

  public String dept;

  public double requestedDocument;

  @ElementCollection
  public List<String> concurrent;

  public double timeTaken;

  public double cost;

  public boolean online;
}
