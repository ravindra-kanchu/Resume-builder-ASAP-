package example.com.resumearchitect.Coursework_details;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import example.com.resumearchitect.R;

public class Coursework extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CwAdapter achAdapter;
    private final List<String> inputList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursework);

        recyclerView = findViewById(R.id.cw_recycler_view);
        achAdapter = new CwAdapter(inputList);
        recyclerView.setAdapter(achAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(v -> {
            inputList.add("");
            achAdapter.notifyItemInserted(inputList.size() - 1);
        });

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<String> data = new ArrayList<>();
                for (int i = 0; i < achAdapter.getItemCount(); i++) {
                    TextInputEditText name_of_experience = recyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.name_of_experience);
                    TextInputEditText type_of_experience = recyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.type_of_experience);
                    TextInputEditText timeline = recyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.timeline);
                    TextInputEditText description = recyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.description);
                    String name = name_of_experience.getText().toString().trim();
                    String type = type_of_experience.getText().toString().trim();
                    String time = timeline.getText().toString().trim();
                    String desc = description.getText().toString().trim();
                    if(TextUtils.isEmpty(name_of_experience.getText().toString())) {
                        // Text input is empty
                        Toast.makeText(Coursework.this, "fill the details", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        // transfer the strings to pdf........
                    }
                }
                // do something with the data (e.g. save it to a database)
            }
        });
    }
}
