package com.jimd.Security01.persistencia.entities.login;



import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum reloEnum;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "role_permissions",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<PermissionEntity> permissionEntitySet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getReloEnum() {
        return reloEnum;
    }

    public void setReloEnum(RoleEnum reloEnum) {
        this.reloEnum = reloEnum;
    }

    public Set<PermissionEntity> getPermissionEntitySet() {
        return permissionEntitySet;
    }

    public void setPermissionEntitySet(Set<PermissionEntity> permissionEntitySet) {
        this.permissionEntitySet = permissionEntitySet;
    }
}
