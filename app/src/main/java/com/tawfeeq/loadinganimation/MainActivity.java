package com.tawfeeq.loadinganimation;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private LoadingDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnStart);

        loading = new LoadingDialog(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loading.show(); // an inherited function from the androidx Dialog Class.
                Handler handler = new Handler();

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        loading.cancel();
                    }
                };
                handler.postDelayed(runnable,3000); // after 3000 milliseconds the Dialog dismisses/cancels itself..........

            }
        });

    }
}