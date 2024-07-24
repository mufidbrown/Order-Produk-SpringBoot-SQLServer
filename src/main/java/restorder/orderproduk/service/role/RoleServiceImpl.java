package restorder.orderproduk.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restorder.orderproduk.entity.Enum.ERole;
import restorder.orderproduk.entity.Role;
import restorder.orderproduk.repositories.RoleRepository;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public void saveRoles(Set<Role> roles){
        roleRepository.saveAll(roles);
    }

}
