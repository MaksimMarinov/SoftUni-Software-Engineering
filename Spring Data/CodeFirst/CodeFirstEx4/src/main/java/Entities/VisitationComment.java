package Entities;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="visitation_comments")
public class VisitationComment extends Comment {
    Visitation visitation;

    @ManyToOne(targetEntity = Visitation.class)
    @JoinColumn(name = "visitation_id", referencedColumnName = "id")
    public Visitation getVisitation() {
        return visitation;
    }

    public void setVisitation(Visitation visitation) {
        this.visitation = visitation;
    }

    public VisitationComment() {
    }
}
