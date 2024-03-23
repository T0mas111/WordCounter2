package com.example.wordcounter2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spSelection);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.selection_option,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        this.edUserInput = findViewById(R.id.edUserInput);
        this.tvResults = findViewById(R.id.tvResults);
    }

    public void btnCountClick(View view) {
        String phrase = edUserInput.getText().toString().trim(); // Trim to remove any leading or trailing spaces

        // Check if the input text is empty
        if(phrase.isEmpty()) {
            // If the input field is empty, display a toast message and don't proceed further
            Toast.makeText(this, "Please enter some text to count the characters.", Toast.LENGTH_SHORT).show();
        } else {
            // If the input field is not empty, proceed with counting the characters
            int charsCount = TextCounter.getCharsCount(phrase);
            this.tvResults.setText(String.valueOf(charsCount));

            // Optionally, you can also show a toast message for the character count
            // Toast.makeText(this, "Character count: " + charsCount, Toast.LENGTH_SHORT).show();
        }
    }
}
