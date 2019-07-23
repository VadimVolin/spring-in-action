package app.beanknowledge;

public class Student {

    private String firstname;
    private String lastname;
//    private String

    public Student() {
        firstname = "std";
        lastname = "std";
    }

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "student - [" + firstname + " " + lastname + "]";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
