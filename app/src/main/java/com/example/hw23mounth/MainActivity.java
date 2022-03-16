package com.example.hw23mounth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText addresses;
    private EditText subject;
    private EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn_send);
        addresses = findViewById(R.id.gmail);
        subject = findViewById(R.id.et_message);
        message = findViewById(R.id.editext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",addresses.getText().toString(), null));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, addresses.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                startActivity(Intent.createChooser(emailIntent, "send"));
            }
    });

    }
}