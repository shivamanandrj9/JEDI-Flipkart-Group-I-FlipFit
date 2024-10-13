package com.flipkart.bean;

public class Role {
    private String roleId;
    private String roleName;


    public Role(String roleID, String roleType) {
        this.roleId = roleID;
        this.roleName = roleType;
    }


    public String getRoleID() {
        return roleId;
    }


    public void setRoleID(String roleID) {
        this.roleId = roleID;
    }


    public String getRoleType() {
        return roleName;
    }


    public void setRoleType(String roleType) {
        this.roleName = roleType;
    }
}
