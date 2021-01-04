package com.example.projectSecurity.security;


import org.assertj.core.util.Sets;

import java.util.Set;


// Class that defines the roles that exist in this system
public enum ApplicaationUserRole {

    CITIZEN(Sets.newHashSet()),
    EMPLOYEE(Sets.newHashSet()),
    ADMIN(Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicaationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
