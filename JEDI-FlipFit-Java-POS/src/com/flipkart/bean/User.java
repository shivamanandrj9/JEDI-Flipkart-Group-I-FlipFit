package com.flipkart.bean;

/**
 * Represents a User with personal details and credentials.
 */
public class User {
    private String userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private int age;
    private String roleId;

    /**
     * @return The password (should be encrypted when used in practice).
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user.
     * @param password The password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return The unique user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     * @param userId The unique identifier to be set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return The username used for login.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the user.
     * @param username The username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The full name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the full name of the user.
     * @param name The name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user
     * @param email The email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
         * @return The phone number of the user.
    */
    public String getPhone() {
        return phone;
    }

    /**
    * Sets the phone number of the user.
    * @param phone The phone number to be set.
    */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
    * @return The age of the user.
    */
    public int getAge() {
        return age;
    }

    /**
    * Sets the age of the user
    * @param age The age to be set.
    */
    public void setAge(int age) {
        this.age = age;
    }

    /**
    * @return The role ID assigned to the user.
    */
    public String getRoleId() {
        return roleId;
    }

    /**
    * Sets the role ID for the user.
    *
    * @param roleId The role ID to be set.
    */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
    * Constructs a User with the specified details.
    *
    * @param userId   The unique identifier for the user.
    * @param username The username used for login.
    * @param password The user's password (should be encrypted when used in practice).
    * @param name     The full name of the user.
    * @param phone    The phone number of the user.
    * @param email    The email address of the user.
    * @param age      The age of the user.
    * @param roleId   The role ID assigned to the user.
    */
    public User(String userId, String username, String password, String name, String phone, String email, int age, String roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.roleId = roleId;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", roleId='" + roleId + '\'' +
                '}';
    }


}
