package com.example.xmlprocessing.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    public List<UserWithProductsDto> getUserSoldProductsDtos() {
        return userSoldProductsDtos;
    }

    public void setUserSoldProductsDtos(List<UserWithProductsDto> userSoldProductsDtos) {
        this.userSoldProductsDtos = userSoldProductsDtos;
    }

    @XmlElement(name = "user")
    private List<UserWithProductsDto> userSoldProductsDtos;
}
