package masterpian0.service;

import masterpian0.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    void addRole(Role role);
}
