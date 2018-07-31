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

        Button btnDemo1;
        Button btnDemo2;
        TextView tvDemo2;
        Button btnDemo3;
        TextView tvDemo3;
        Button btnExercise;
        TextView tvExercise;
        Button btnDemo4;
        TextView tvDemo4;
        Button btnDemo5;
        TextView tvDemo5;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btnDemo1 = findViewById(R.id.buttonDemo1);
            btnDemo2 = findViewById(R.id.buttonDemo2);
            tvDemo2 = findViewById(R.id.textViewDemo2);
            btnDemo3 = findViewById(R.id.buttonDemo3);
            tvDemo3 = findViewById(R.id.textViewDemo3);
            btnExercise = findViewById(R.id.buttonExercise);
            tvExercise = findViewById(R.id.textViewSum);
            btnDemo4 = findViewById(R.id.buttonDemo4);
            tvDemo4 = findViewById(R.id.textViewDemo4);
            btnDemo5 = findViewById(R.id.buttonDemo5);
            tvDemo5 = findViewById(R.id.textViewDemo5);

            btnDemo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                    //Set Dialog Details

                /*myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);*/

                    myBuilder.setTitle("Congratulation");
                    myBuilder.setMessage("You have completed a simple Dialog Box");
                    myBuilder.setCancelable(true);
                    myBuilder.setPositiveButton("DISMISS", null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }
            });
            btnDemo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //create Dialog Builder
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                    myBuilder.setTitle("Demo 2 Buttons Dialog");
                    myBuilder.setMessage("Select one of the button below.");
                    myBuilder.setCancelable(false);
                    //Configure the "Positive" button
                    myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            tvDemo2.setText("You have selected Positive.");
                        }
                    });
                    myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            tvDemo2.setText("You have selected Negative.");
                        }
                    });
                    //Configure the 'neutral' button
                    myBuilder.setNeutralButton("Cancel",null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }
            });

            btnDemo3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Inflate the input.xml layout file
                    LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View viewDialog = inflater.inflate(R.layout.input,null);
                    //Obtain the UI component in the input.xml layout
                    //It needs to be defined as "final", so that it can used in the onClick() method later
                    final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                    myBuilder.setView(viewDialog); //Set the view of the dialog
                    myBuilder.setTitle("Demo 3-Text Input Dialog");
                    myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Extract the text entered by the user
                            String message = etInput.getText().toString();
                            //Set the text to the TextView
                            tvDemo3.setText(message);
                        }
                    });
                    myBuilder.setNegativeButton("CANCEL",null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }
            });

            btnExercise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View viewDialog = inflater.inflate(R.layout.exercise,null);

                    final EditText etInput1 = viewDialog.findViewById(R.id.editTextNo1);
                    final EditText etInput2 = viewDialog.findViewById(R.id.editTextNo2);

                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                    myBuilder.setView(viewDialog);
                    myBuilder.setTitle("Exercise 3");
                    myBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            int num1 = Integer.parseInt(etInput1.getText().toString());
                            int num2 = Integer.parseInt(etInput2.getText().toString());
                            int sum = num1 + num2;
                            tvExercise.setText("The sum is " + Integer.toString(sum));
                        }
                    });
                    myBuilder.setNegativeButton("CANCEL", null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }
            });

            btnDemo4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Create the listener to set the date
                    DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                        }
                    };

                    //Create the Date Picker Dialog
                /*DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener,2014,11,31);
                myDateDialog.show();*/
                    Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int monthOfYear = c.get(Calendar.MONTH);
                    int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener,year,monthOfYear,dayOfMonth);
                    myDateDialog.show();
                }
            });
            btnDemo5.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    //Create the Listener to set the time
                    TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            tvDemo5.setText("Time: "+hourOfDay+":"+minute);

                        }
                    };

                    Calendar currentTime = Calendar.getInstance();
                    int currenthour = currentTime.get(Calendar.HOUR_OF_DAY);
                    int currentminute = currentTime.get(Calendar.MINUTE);

                    TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,currenthour,currentminute,true);
                    myTimeDialog.show();
                }
            });
        }
    }