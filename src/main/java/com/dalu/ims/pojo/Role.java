package com.dalu.ims.pojo;

import org.apache.commons.collections.functors.InstantiateTransformer;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "role")
public class Role implements Serializable{
    private static final long serialVersionUID = -3623635094007764878L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
