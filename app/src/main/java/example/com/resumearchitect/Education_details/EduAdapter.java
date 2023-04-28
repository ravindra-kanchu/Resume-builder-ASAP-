package example.com.resumearchitect.Education_details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import example.com.resumearchitect.R;

public class EduAdapter extends RecyclerView.Adapter<EduAdapter.InputViewHolder> {

    private List<String> inputList;

    public EduAdapter(List<String> inputList) {
        this.inputList = inputList;
    }

    @NonNull
    @Override
    public InputViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item, parent, false);
        return new InputViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InputViewHolder holder, int position) {
        String inputText = inputList.get(position);
        holder.inputEditText1.setText(inputText);
        holder.inputEditText2.setText(inputText);
        holder.deleteButton.setOnClickListener(v -> {
            inputList.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return inputList.size();
    }

    public static class InputViewHolder extends RecyclerView.ViewHolder {

        EditText inputEditText1,inputEditText2;
        ImageButton deleteButton;

        public InputViewHolder(@NonNull View itemView) {
            super(itemView);
            inputEditText1 = itemView.findViewById(R.id.input_edit_text1);
            inputEditText2 = itemView.findViewById(R.id.input_edit_text2);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }

}


//package example.com.resumearchitect;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.material.textfield.TextInputEditText;
//
//import java.util.ArrayList;
//
//public class EduAdapter extends RecyclerView.Adapter<EduAdapter.MyViewHolder> {
//    private ArrayList<EducationData> EducationDataList;
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextInputEditText courseInput, universityInput, gradeInput, passoutYearInput;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            courseInput = itemView.findViewById(R.id.input_course);
//            universityInput = itemView.findViewById(R.id.input_university);
//            gradeInput = itemView.findViewById(R.id.input_grade);
//            passoutYearInput = itemView.findViewById(R.id.input_passout_year);
//        }
//    }
//
//    public EduAdapter(ArrayList<EducationData> EducationDataList) {
//        this.EducationDataList = EducationDataList;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.activity_education, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        EducationData educationData = EducationDataList.get(position);
//        holder.courseInput.setText(educationData.getCourse());
//        holder.universityInput.setText(educationData.getUniversity());
//        holder.gradeInput.setText(educationData.getGrade());
//        holder.passoutYearInput.setText(educationData.getPassoutYear());
//    }
//
//    @Override
//    public int getItemCount() {
//        return EducationDataList.size();
//    }
//}