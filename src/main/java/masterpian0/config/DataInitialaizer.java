package masterpian0.config;

import org.springframework.stereotype.Component;
import masterpian0.model.Role;
import masterpian0.model.User;
import masterpian0.service.RoleService;
import masterpian0.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInitialaizer {
    private UserService userService;
    private RoleService roleService;

    public DataInitialaizer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void Init() {
        roleService.addRole(new Role("ADMIN"));
        roleService.addRole(new Role("USER"));

        User admin = new User();
        admin.setName("admin");
        admin.setLastName("admin");
        admin.setAge(35);
        admin.setEmail("admin@mail.ru");
        admin.setPassword("admin");
        admin.setRoles(Set.of(new Role("ADMIN")));
        userService.createUser(admin);

        User user = new User();
        user.setName("user");
        user.setLastName("user");
        user.setAge(30);
        user.setEmail("user@mail.ru");
        user.setPassword("user");
        user.setRoles(Set.of(new Role("USER")));
        userService.createUser(user);
    }
}
