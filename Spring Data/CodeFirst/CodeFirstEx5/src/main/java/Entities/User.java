package Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Set<BillingDetail> billingDetail;

    public User() {
    }
    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    @Column(name = "last_name", nullable = false, length = 60)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    @Column(name = "email", unique = true, length = 50, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "password", nullable = false, length = 50 )
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @OneToMany(targetEntity = BillingDetail.class, mappedBy = "user" )
    public Set<BillingDetail> getBillingDetail() {
        return billingDetail;
    }

    public void setBillingDetail(Set<BillingDetail> billingDetail) {
        this.billingDetail = billingDetail;
    }
}
