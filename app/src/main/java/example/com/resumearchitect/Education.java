package example.com.resumearchitect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Education extends AppCompatActivity {
    private ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        container = findViewById(R.id.container);
        Button addButton = findViewById(R.id.add_btn);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate a new layout for the item
                View newItemView = LayoutInflater.from(Education.this).inflate(R.layout.education_item, container, false);

                // Modify the new layout as needed
                EditText course = newItemView.findViewById(R.id.courseEditText);
                EditText uni = newItemView.findViewById(R.id.universityEditText);
                EditText grade = newItemView.findViewById(R.id.gradeEditText);
                EditText year = newItemView.findViewById(R.id.yearEditText);

                // Add the new layout to the parent container
                container.addView(newItemView);

            }
        });

    }
}