package nguyen.databasedemo.data;

/**
 * Created by 660253185 on 11/29/2017.
 */

public class Contacts {

    //define variables for the columns
    private int _id;    //primary key
    private String firstName;
    private String lastName;

    //default constructor
    public Contacts() {
    }

    public Contacts(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

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
}
