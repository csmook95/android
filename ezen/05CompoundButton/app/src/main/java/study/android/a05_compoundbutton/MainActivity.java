package study.android.a05_compoundbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    CheckBox checkBox1, checkBox2;
    Switch switch1;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        switch1 = (Switch) findViewById(R.id.switch1);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        checkBox2.setChecked(true);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ToggleButton t = (ToggleButton) buttonView;
                String msg = isChecked ? t.getTextOn().toString() : t.getTextOff().toString();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = buttonView.getText().toString();
                msg += isChecked ? "ON" : "OFF";
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = buttonView.getText().toString();
                msg += isChecked ? "ON" : "OFF";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = isChecked ? "Switch 켜짐" : "Switch 꺼짐";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String msg = "<strong>[선택된 항목]</strong><br/>\n";

                if (toggleButton.isChecked()) {
                    msg += "<font color = 'red'>ToggleButton</font><br/>\n";
                }
                if (checkBox1.isChecked()) {
                    msg += "<font color = 'green'>CheckBox1</font><br/>\n";
                }
                if (checkBox2.isChecked()) {
                    msg += "<font color = 'blue'>CheckBox2</font><br/>\n";
                }
                if (switch1.isChecked()) {
                    msg += "<font color = '#ff6600'>Switch</font><br/>";
                }

                Spanned spanned = Html.fromHtml(msg, Html.FROM_HTML_MODE_LEGACY);
                textView.setText(spanned);
            }
        });
    }
}