package sg.edu.rp.c346.id22016635.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
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
Button D1, D2, D3, ex3, D4, D5;
TextView tvDemo2, tvDemo3, tvEx3, tvDemo4,tvDemo5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        D1 = findViewById(R.id.buttonDemo1);
        D2 = findViewById(R.id.buttonDemo2);
        D3 = findViewById(R.id.buttonDemo3);
        tvDemo2 = findViewById(R.id.tvDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvEx3 = findViewById(R.id.tvEX3);
        ex3 = findViewById(R.id.buttonEx3);
        D4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.tvdatePicker);
        D5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textView5);
    D1.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {

                                  //initialize Dialog
                                  AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

            /*myBuilder.setTitle("Demo 1 - Simple Dialog");
            myBuilder.setMessage("I can develop Android app. ");
            myBuilder.setCancelable(false);
            myBuilder.setPositiveButton("Close",null);*/

            myBuilder.setTitle("Congratulations");
            myBuilder.setMessage("You have completed a simple Dialog Box. ");
            myBuilder.setCancelable(false);
            myBuilder.setPositiveButton("Dismiss",null);

                                  AlertDialog myDialog = myBuilder.create();
                                  myDialog.show();
                              }
                          });


        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //initialize Dialog
                AlertDialog.Builder myBuilder =  new AlertDialog.Builder(MainActivity.this);

            /*myBuilder.setTitle("Demo 1 - Simple Dialog");
            myBuilder.setMessage("I can develop Android app. ");
            myBuilder.setCancelable(false);
            myBuilder.setPositiveButton("Close",null);*/

            /*myBuilder.setTitle("Congratulations");
            myBuilder.setMessage("You have completed a simple Dialog Box. ");
            myBuilder.setCancelable(false);
            myBuilder.setPositiveButton("Dismiss",null);

            AlertDialog myDialog = myBuilder.create();
            myDialog.show(); */

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below ");
                myBuilder.setCancelable(false);


                myBuilder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tvDemo2.setText("You have selected Positive");
                    }
                });

                myBuilder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tvDemo2.setText("You have selected Negative");
                    }
                });

                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }

        });


        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        ex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etNum1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etNum2 = viewDialog.findViewById(R.id.editTextNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String num1 = etNum1.getText().toString();
                        String num2 = etNum2.getText().toString();
                        int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
                        // Set the text to the TextView
                        tvEx3.setText("The sum is "+ sum);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    }

                };
                Calendar currentDate = Calendar.getInstance();
                currentDate.get(Calendar.DATE);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH));
                myDateDialog.show();
            }

        });

        D5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };
                Calendar date = Calendar.getInstance();
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,date.get(Calendar.HOUR_OF_DAY),date.get(Calendar.MINUTE),false);
                myTimeDialog.show();
            }
        });


        }



}

