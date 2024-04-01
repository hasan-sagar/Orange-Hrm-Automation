package config;

public class UserModel {
    private String firstName;
    private String lastName;
    private String employeeId;
    private String userName;
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserModel(String firstName, String lastName, String employeeId, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.userName = userName;
        this.password = password;
    }

    public UserModel() {

    }
}
