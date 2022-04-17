package Entities;


import javax.persistence.*;

@Entity
@Table(name = "diagnoses_comments")
public class DiagnosesComment extends Comment{
    private Diagnose diagnose;

    @ManyToOne(targetEntity = Diagnose.class)
    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public DiagnosesComment() {
    }
}
