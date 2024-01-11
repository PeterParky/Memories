package app.main.memories.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memories.R;

import app.main.memories.fragment.SetAva_Fragment;

public class MainActivity extends AppCompatActivity {

    // initializing variables
    TextView tv_year, tv_month, tv_day;
    TextView tv_ld, tv_totaldays, tv_info;
    Button btn_Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variables
        tv_ld = findViewById(R.id.tv_ld);
        tv_totaldays = findViewById(R.id.tv_show);
        tv_info = findViewById(R.id.tv_info);

        // Get data from user
        Intent data_intent = getIntent();
        Bundle info_bun = data_intent.getBundleExtra("DayBundle");
        long totaldays = info_bun.getLong("DatedDay");
        int year = info_bun.getInt("year");
        int month = info_bun.getInt("month");
        int day = info_bun.getInt("day");

        // Set data
        tv_ld.setText("Love Days");
        tv_totaldays.setText("" + totaldays);
        tv_info.setText("From " + year + "/" + month + "/" + day);

        // Underline text
        SpannableString content = new SpannableString(tv_info.getText());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tv_info.setText(content);

        // Set ava and name
        changeFragment(R.id.fr_set_ava, R.drawable.ic_sunset, "sex");
        changeFragment(R.id.fr_set_ava_2, R.drawable.ic_sunset, "concac");

    }

    // Change Fragment method
    public void changeFragment(int tmp, int img_src, String name) {
        SetAva_Fragment anotherFragment = SetAva_Fragment.newInstance(img_src, name);
        getSupportFragmentManager().beginTransaction()
                .replace(tmp, anotherFragment)
                .addToBackStack(null)
                .commit();
    }
}