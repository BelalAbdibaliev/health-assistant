package com.sunday.health_assistant.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunday.health_assistant.R;
import com.sunday.health_assistant.config.MyApp;
import com.sunday.health_assistant.domain.interfaces.ICalculateBmiUseCase;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    public ICalculateBmiUseCase calculateBmiUseCase;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MyApp.getAppComponent().inject(this);
        myTextView = findViewById(R.id.bmistatus);
        myTextView.setText(calculateBmiUseCase.getStatus(40).toString());
    }
}