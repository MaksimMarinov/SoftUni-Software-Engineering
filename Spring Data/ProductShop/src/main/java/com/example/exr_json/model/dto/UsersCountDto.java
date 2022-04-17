package com.example.exr_json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UsersCountDto {
    @Expose
    private Long usersCount;
    @Expose
    private Set<UserNamesAgeSoldProductsDto> users;

    public UsersCountDto() {
    }

    public Long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Long usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserNamesAgeSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserNamesAgeSoldProductsDto> users) {
        this.users = users;
    }
}
