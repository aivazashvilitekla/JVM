package sample;

import java.util.Date;

public class Author {
    public int id;
    public String firstname;
    public Date birthday;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Author(int id, String firstname, Date birthday) {
        this.id = id;
        this.firstname = firstname;
        this.birthday = birthday;
    }
}
