package com.example.course.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Embeddable
@NoArgsConstructor
public class Role implements GrantedAuthority {
    private String name;

    public Role(String roleName){
        this.name = roleName;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
