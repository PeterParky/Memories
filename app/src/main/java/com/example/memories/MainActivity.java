package com.example.memories;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.ZoneId;

public class MainActivity extends AppCompatActivity {

    // initializing variables
    TextView tv_Hint;
    NumberPicker np_year, np_month, np_day;
    Button btn_skip, btn_Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variables
        tv_Hint = findViewById(R.id.HINT);
        np_year = findViewById(R.id.bt_year);
        np_month = findViewById(R.id.bt_month);
        np_day = findViewById(R.id.bt_day);
        btn_skip = findViewById(R.id.btn_Skip);
        btn_Calc = findViewById(R.id.btn_calculate);

        // set textSize for tv_hint
        float scale = getResources().getDisplayMetrics().density;
        tv_Hint.setTextSize(TypedValue.COMPLEX_UNIT_SP, tv_Hint.getTextSize() / scale);

        // Get today's date using LocalDate Library
        LocalDate today = LocalDate.now(ZoneId.of("JST"));

        // for year
        int year = today.getYear();

        // for month
        int month = today.getMonthValue();

        // for date
        int day = today.getDayOfMonth();

        // set text Style for Skip_butt
        Underline(btn_skip, getResources().getString(R.string.Skip_butt));

        // set text Style for Start_butt
        Underline(btn_Calc, getResources().getString(R.string.Start_butt));

        // set value for year
        np_year.setMinValue(1980);
        np_year.setMaxValue(year);
        np_year.setValue(year);
        SetColor(np_year,Color.BLACK);
        np_year.setTextSize(50); // Needs updating to be compatible with the device's screen size

        // set value for month
        np_month.setMinValue(1);
        np_month.setMaxValue(12);
        np_month.setValue(month);
        SetColor(np_month,Color.BLACK);
        np_month.setTextSize(50); // Needs updating to be compatible with the device's screen size

        // set value for day
        np_day.setMinValue(1);
        np_day.setMaxValue(31);
        np_day.setValue(day);
        SetColor(np_day,Color.BLACK);
        np_day.setTextSize(50); // Needs updating to be compatible with the device's screen size

        // Set up the listener to check and reset the value when the condition is not met
        //for month
        np_month.setOnValueChangedListener((picker, oldVal, newVal) -> {
            // Check conditions
            int selectedYear = np_year.getValue();
            int selectedDay = np_day.getValue();

            if ((selectedYear == year && newVal > month) ||
                    !isValidDate(selectedYear, newVal, selectedDay)) {
                // If the date is invalid, set to default
                Toast.makeText(this, "Please pick a valid month.", Toast.LENGTH_SHORT).show();
                np_month.setValue(month);
            }
        });

        // for day
        np_day.setOnValueChangedListener((picker, oldVal, newVal) -> {
            // Check conditions
            int selectedYear = np_year.getValue();
            int selectedMonth = np_month.getValue();

            if ((selectedYear == year && selectedMonth == month && newVal > day) ||
                    !isValidDate(selectedYear, selectedMonth, newVal)) {
                // If the date is invalid, set to default
                Toast.makeText(this, "Please pick a valid day.", Toast.LENGTH_SHORT).show();
                np_day.setValue(day);
            }
        });
    }

    // The function checks whether the date is valid or not
    private boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    // The function underlines selected word
    protected void Underline(Button button, String str_tmp) {
        try {
            SpannableString content = new SpannableString(str_tmp);
            content.setSpan(new UnderlineSpan(), 0, str_tmp.length(), 0);
            button.setText(content);
            float scale = getResources().getDisplayMetrics().density;
            button.setTextSize(TypedValue.COMPLEX_UNIT_SP, btn_skip.getTextSize() / scale);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Set color for day-picker
    protected void SetColor(NumberPicker np, int text_color) {
        // Set color for text
        np.setTextColor(text_color);
        // Set color of the line separating the values
        /*Still in the progress*/

    }

}