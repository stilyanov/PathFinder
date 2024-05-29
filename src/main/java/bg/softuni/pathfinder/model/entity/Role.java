package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
