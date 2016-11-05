package pl.projektowa.btcbankex.database.models;

/**
 * Created by Kamil on 2016-11-01.
 */
public class User {
    private String id;
    private String login;
    private String password;
    private String email;
    private String address;
    private String firstName;
    private String surname;

    public User(String id, String login, String password, String email, String address, String firstName, String surname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.address = address;
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
