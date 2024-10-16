package com.flipkart.bean;

/**
 *
 * class representing roles in the FlipFit system.
 * Roles include ADMIN, GYM_OWNER, and CUSTOMER.
 * @author shubham dash
 */
public class Role {
    private String roleId;
    private String roleName;

    /**
     * Parameterized constructor to create a new role.
     * @param roleID ID pf the role
     * @param roleType type pf the role associated with the roleID
     */
    public Role(String roleID, String roleType) {
        this.roleId = roleID;
        this.roleName = roleType;
    }

    /**
     * Retrieves role ID for a particular role
     * @return role for the particular role
     */
    public String getRoleID() {
        return roleId;
    }

    /**
     * Sets roleID for a role
     * @param roleID ID of the role
     */
    public void setRoleID(String roleID) {
        this.roleId = roleID;
    }

    /**
     * Retrieves role name for a particular role
     * @return name for the particular role
     */
    public String getRoleType() {
        return roleName;
    }

    /**
     * Sets role name for a particular role
     * @param roleType name for the particular role
     */
    public void setRoleType(String roleType) {
        this.roleName = roleType;
    }
}
