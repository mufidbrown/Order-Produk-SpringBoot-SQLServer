package restorder.orderproduk.service.role;

import restorder.orderproduk.entity.Enum.ERole;
import restorder.orderproduk.entity.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(ERole name);

}
