package com.example.prm_project;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SavingsActivity extends AppCompatActivity {

    private TextView savingsAmount, goalProgressText, goalTotalText;
    private ProgressBar progressBar, goalProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);

        // Initialize views
        savingsAmount = findViewById(R.id.savings_amount);
        progressBar = findViewById(R.id.progress_bar);
        goalProgressText = findViewById(R.id.goal_progress);
        goalProgressBar = findViewById(R.id.goal_progress_bar);
        goalTotalText = findViewById(R.id.goal_total);

        // Set initial values
        savingsAmount.setText("$800");
        progressBar.setProgress(200);
        goalProgressText.setText("$300");
        goalProgressBar.setProgress(300);
        goalTotalText.setText("$600");

        // Back button action using OnBackPressedDispatcher
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> finish()); // Close the activity

        // Handle the system back button
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish(); // Close the activity
            }
        });

        // Initialize and handle BottomNavigationView using if-else
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                Toast.makeText(SavingsActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_savings) {
                Toast.makeText(SavingsActivity.this, "Savings clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_notifications) {
                Toast.makeText(SavingsActivity.this, "Notifications clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_settings) {
                Toast.makeText(SavingsActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        // Initialize and handle FloatingActionButton (Add button)
        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(view -> Toast.makeText(SavingsActivity.this, "Add clicked", Toast.LENGTH_SHORT).show());
    }
}
