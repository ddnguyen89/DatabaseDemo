package nguyen.databasedemo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import nguyen.databasedemo.data.MyDBHandler;

public class DisplayListActivity extends AppCompatActivity {

    //define widget variable layout
    private TableLayout tableLayout;

    //define SQL controller variable
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        //navigate up to the parent class
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tableLayout = (TableLayout) findViewById(R.id.tableLayout);

        //instantiate the handler constructor
        dbHandler = new MyDBHandler(this);

        //call the build table method
        buildTable();
    }

    //responsible for building the table
    private void buildTable() {

        dbHandler.open();
        Cursor c = dbHandler.readEntry();

        int rows = c.getCount();
        int cols = c.getColumnCount();

        c.moveToFirst();

        //outer for loop
        for(int i = 0; i < rows; i++) {

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            //inner for lop
            for(int j = 0; j < cols; j++) {

                TextView tv = new TextView(this);

                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(13);
                tv.setPadding(0, 5, 0, 5);

                tv.setText(c.getString(j));

                row.addView(tv);
            }

            c.moveToNext();

            tableLayout.addView(row);
        }

        //close the database
        dbHandler.close();
    }
}
