package nguyen.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nguyen.databasedemo.data.Contacts;
import nguyen.databasedemo.data.MyDBHandler;

public class MainActivity extends AppCompatActivity {

    //define widget variables
    private EditText firstNameET, lastNameET;
    private Button addButton, deleteButton, showAllButton, deleteAllButton;

    //define our database handler
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate the MyDBHandler constructor
        dbHandler = new MyDBHandler(this);

        //get reference to the widgets
        firstNameET = (EditText) findViewById(R.id.firstNameET);
        lastNameET = (EditText) findViewById(R.id.lastNameET);
        addButton = (Button) findViewById(R.id.addButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        showAllButton = (Button) findViewById(R.id.showAllButton);
        deleteAllButton = (Button) findViewById(R.id.deleteAllButton);
    }

    //add a contact to the database
    public void addClick(View view) {

        Contacts contacts = new Contacts(firstNameET.getText().toString(), lastNameET.getText().toString());

        dbHandler.addContact(contacts);

        //clear the text fields
        firstNameET.setText("");
        lastNameET.setText("");

        //request focus on the firstName;
        firstNameET.requestFocus();
    }

    //delete a contact to the database
    public void deleteClick(View view) {

        String firstName = firstNameET.getText().toString();
        String lastName = lastNameET.getText().toString();

        dbHandler.deleteContact(firstName, lastName);

        //clear the text fields
        firstNameET.setText("");
        lastNameET.setText("");

        //request focus on the firstName;
        firstNameET.requestFocus();
    }

    //show all contacts in the database
    public void showAllClick(View view) {

        //open up a new screen
        Intent i = new Intent(this, DisplayListActivity.class);
        startActivity(i);
    }

    //delete all contacts in the database
    public void deleteAllClick(View view) {

        dbHandler.deleteAllContacts();

        //clear the text fields
        firstNameET.setText("");
        lastNameET.setText("");

        //request focus on the firstName;
        firstNameET.requestFocus();
    }
}
