package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4, tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        btnEx3 = findViewById(R.id.buttonEx3);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvEx3 = findViewById(R.id.textViewEx3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set dialog details
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show(); */

                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set dialog details
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below.");
                myBuilder.setCancelable(false);

                //Configure the positive button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                //Configure the negative button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                //Configure the neutral button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inflate the layout input.xml
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //Obtain the UI component in the input.xml layout
                //Needs to be defined as final, so that it can be used in the onclick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inflate the layout input.xml
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);

                //Obtain the UI component in the input.xml layout
                //Needs to be defined as final, so that it can be used in the onclick() method later
                final EditText etInput1 = viewDialog.findViewById(R.id.editText);
                final EditText etInput2 = viewDialog.findViewById(R.id.editText2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer total = Integer.parseInt(etInput1.getText().toString()) + Integer.parseInt(etInput2.getText().toString());
                        String message = total.toString();
                        tvEx3.setText("The sum is " + message);
                    }
                });
                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                };
                final  Calendar c = Calendar.getInstance();

                //create date picker dialog
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };
                final  Calendar c = Calendar.getInstance();
                //Create time picker dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true);
                myTimeDialog.show();
            }
        });
    }
}
