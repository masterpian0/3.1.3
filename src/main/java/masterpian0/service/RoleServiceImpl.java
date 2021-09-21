package masterpian0.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import masterpian0.model.Role;
import masterpian0.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role>  iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(role -> set.add(role));
        return set;
    }

    @Override
    public void addRole(Role role) {
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        roleRepository.saveAll(roles);
    }
}
