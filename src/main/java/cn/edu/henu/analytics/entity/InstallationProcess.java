package cn.edu.henu.analytics.entity;

import lombok.Data;
import lombok.val;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class InstallationProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean hasHappened;
    private Boolean isAvailableOnline;
    private Integer daysTaken;
    private Integer promisedDaysTaken;
    private Long cost;
    private Integer requestDocuments;
    private Integer tripsTaken;
    @ElementCollection
    private List<String> concurrentProcesses;
}
