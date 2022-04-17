package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Diagnose extends BaseEntity{
    private String name;
    private Set<DiagnosesComment> comments;
    private Set<Visitation> visits;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = DiagnosesComment.class)
    public Set<DiagnosesComment> getComments() {
        return comments;
    }

    public void setComments(Set<DiagnosesComment> comments) {
        this.comments = comments;
    }

    @OneToMany(targetEntity = Visitation.class, mappedBy = "diagnose", cascade = CascadeType.ALL)
    public Set<Visitation> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visitation> visits) {
        this.visits = visits;
    }

    public Diagnose() {
        this.comments = new HashSet<>();
        this.visits = new HashSet<>();
    }
}
