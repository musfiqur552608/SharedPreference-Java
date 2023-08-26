package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        DisplaySavedText();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                DisplayAndSaveText(text);
            }
        });
    }

    private void DisplaySavedText() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharePref", MODE_PRIVATE);
        String s1 = sharedPreferences.getString("name", " ");

        textView.setText(s1);
    }

    private void DisplayAndSaveText(String text) {
        textView.setText(text);
//        Save data
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        Write data on shared preference
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", text);
        editor.commit();
    }
}