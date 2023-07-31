package com.choi0tae.portfolio.entity;

import lombok.Getter;

@Getter
public enum Authority {
    ROLE_ADMIN("Admin"),
    ROLE_MANAGER("Manager"),
    ROLE_COMMON("common"),
    ROLE_GUEST("Guest");

    private final String role;
    Authority(String role){
        this.role=role;
    }
}
