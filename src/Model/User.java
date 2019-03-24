package Model;

import java.util.Date;

public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String company;
    private String telephone;
    private Date dateCreation;
    private Constant.STATUS status;
    private Constant.USERTYPE type;

    public User(String email,String password,String firstName,String lastName,String company,String telephone){
        this.email=email;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.company=company;
        this.telephone=telephone;
    }
    public User(Integer id,String email,String password,String firstName,String lastName,String company,String telephone,Date dateCreation,
                Constant.STATUS status,Constant.USERTYPE type){
        this.id=id;
        this.email=email;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.company=company;
        this.telephone=telephone;
        this.dateCreation=dateCreation;
        this.status=status;
        this.type=type;
    }

    public Integer getId() {
        return id;
    }

    public String getTelephone() {
        return telephone;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Constant.STATUS getStatus() {
        return status;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Constant.USERTYPE getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Constant.STATUS status) {
        this.status = status;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setType(Constant.USERTYPE type) {
        this.type = type;
    }
}
