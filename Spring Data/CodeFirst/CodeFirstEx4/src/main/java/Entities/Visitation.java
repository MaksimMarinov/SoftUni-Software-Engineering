package Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Visitation")
public class Visitation extends BaseEntity{
    private Patient patient;
    private Diagnose diagnose;
    private Medicament medicament;
    private Date visitDate;
    private Set<VisitationComment> comments;

    @ManyToOne(targetEntity = Patient.class,cascade = CascadeType.ALL )
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne(targetEntity = Diagnose.class, cascade = CascadeType.ALL)
    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    @ManyToOne(targetEntity = Medicament.class, cascade = CascadeType.ALL)
    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    @Column(name = "visit_date", nullable = false)
    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
    @OneToMany( mappedBy = "visitation")
    public Set<VisitationComment> getComments() {
        return comments;
    }

    public void setComments(Set<VisitationComment> comments) {
        this.comments = comments;
    }

    public Visitation() {
        this.comments = new HashSet<>();
    }
}
