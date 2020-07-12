package cn.edu.henu.analytics.entity;

import lombok.Data;
import lombok.val;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class PowerInstallation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public enum Type{
        REAL_ESTATE("realEstate"),
        FACTORY("factory"),
        WAREHOUSE("warehouse");
        Type(String type) {
        }
    }
    public enum Scale{
        LARGE("large"),
        MEDIUM("medium"),
        SMALL("small");
        Scale(String scale) {
        }
    }
    private Type type;
    private Scale scale;
    private String govDept;
    private String office;
    private String relatedDept;
    private String contact;
    private String contactTel;
    @OneToMany
    private List<InstallationProcess> installationProcesses;
    @OneToOne
    private PowerExpenditure expenditure;
    @OneToOne
    private PowerReliability reliability;
    public InstallationProcess findProcessByName(String name){
        for (val process:
             installationProcesses) {
            if(process.getName().equals(name)) return process;
        }
        return null;
    }
}
