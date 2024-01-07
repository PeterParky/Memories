package com.example.memories;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.ZoneId;

public class MainActivity extends AppCompatActivity {

    // initializing variables
    TextView tv_Hint;
    Button btn_year, btn_month, btn_day;
    Button btn_Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variables
        tv_Hint = findViewById(R.id.HINT);
        btn_year = findViewById(R.id.bt_year);
        btn_month = findViewById(R.id.bt_month);
        btn_day = findViewById(R.id.bt_day);
        btn_Calc = findViewById(R.id.btn_calculate);

        // Get today's date using LocalDate Library
        LocalDate today = LocalDate.now(ZoneId.of("JST"));

        // for year
        int year = today.getYear();

        // for month
        int month = today.getMonthValue();

        // for date
        int day = today.getDayOfMonth();

        // to set the current date as by default
        String year_str = String.valueOf(year);
        String month_str = String.valueOf(month);
        String day_str = String.valueOf(day);

        // set text Style
        String str;
        str = getResources().getString(R.string.Start_butt);
        SpannableString content = new SpannableString(str);
        content.setSpan(new UnderlineSpan(), 0, 5, 0);
        btn_Calc.setText(content);


        // set value
        btn_year.setText(year_str);
        btn_month.setText(month_str);
        btn_day.setText(day_str);
    }
}
        // action to be performed when button Start is clicked
       /* btn_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // date picker dialog is used
                // and its style and color are also passed
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener1, year, month, day);
                // to set background for date-picker
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });*/
/*

        // it is used to set the date which user selects
        dateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // here month+1 is used so that
                // actual month number can be displayed
                // otherwise it starts from 0 and it shows
                // 1 number less for every month
                // example- for january month=0
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                btn_birth.setText(date);
            }
        };

        // action to be performed when button 2 is clicked
        btn_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // date picker dialog is used
                // and its style and color are also passed
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener2, year, month, day);
                // to set background for datepicker
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
*/

       /* // it is used to set the date which user selects
        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // here month+1 is used so that
                // actual month number can be displayed
                // otherwise it starts from 0 and it shows
                // 1 number less for every month
                // example- for january month=0
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                btn_today.setText(date);
            }
        };

        // action to be performed when calculate button is clicked
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // converting the inputted date to string
                String sDate = btn_birth.getText().toString();
                String eDate = btn_today.getText().toString();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    // converting it to date format
                    Date date1 = simpleDateFormat1.parse(sDate);
                    Date date2 = simpleDateFormat1.parse(eDate);

                    long startdate = date1.getTime();
                    long endDate = date2.getTime();

                    // condition
                    if (startdate <= endDate) {
                        org.joda.time.Period period = new Period(startdate, endDate, PeriodType.yearMonthDay());
                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();

                        // show the final output
                        tvResult.setText(years + " Years |" + months + "Months |" + days + "Days");
                    } else {
                        // show message
                        Toast.makeText(MainActivity.this, "BirthDate should not be larger than today's date!",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}*/