package com.example.xmlprocessing.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSeedRootDto {

    @XmlElement(name = "user")
    private List<UsersSeedDto> users;


    public List<UsersSeedDto> getUsers() {
        return users;
    }

    public void setUsers(List<UsersSeedDto> users) {
        this.users = users;
    }
}
