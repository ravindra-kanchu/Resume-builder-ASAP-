package example.com.resumearchitect.Education_details;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import example.com.resumearchitect.Options;
import example.com.resumearchitect.R;

public class Education extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EduAdapter eduAdapter;
    private List<String> inputList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        recyclerView = findViewById(R.id.recycler_view);
        eduAdapter = new EduAdapter(inputList);
        recyclerView.setAdapter(eduAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(v -> {
            inputList.add("");
            eduAdapter.notifyItemInserted(inputList.size() - 1);
        });

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    List<String> data = new ArrayList<>();
                    for (int i = 0; i < eduAdapter.getItemCount(); i++) {
                        EditText editText1 = recyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.input_edit_text1);
                        EditText editText2 = recyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.input_edit_text2);
                        String text1 = editText1.getText().toString().trim();
                        String text2 = editText2.getText().toString().trim();
                        if (!text1.isEmpty() && !text2.isEmpty()) {
                            Toast.makeText(Education.this, text1, Toast.LENGTH_SHORT).show();
                            Toast.makeText(Education.this, text2, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Options.class);

                        }
                    }
                    // do something with the data (e.g. save it to a database)
            }
        });
    }
}

//package example.com.resumearchitect;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class Education extends AppCompatActivity {
//    private ArrayList<EducationData> educationDataList = new ArrayList<>();
//    private RecyclerView recyclerView;
//    private EduAdapter eduAdapter;
//    private Button addButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_education);
//
//        recyclerView = findViewById(R.id.recycler_view);
//        addButton = findViewById(R.id.add_button);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        eduAdapter = new EduAdapter(educationDataList);
//        recyclerView.setAdapter(eduAdapter);
//
//        addButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addEducationData();
//            }
//        });
//    }
//
//    private void addEducationData() {
//        EducationData educationData = new EducationData("", "", "", "");
//        educationDataList.add(educationData);
//        eduAdapter.notifyDataSetChanged();
//    }
//}