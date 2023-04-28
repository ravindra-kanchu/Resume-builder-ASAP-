package example.com.resumearchitect.Experience_details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import example.com.resumearchitect.R;

public class ExpAdapter extends RecyclerView.Adapter<ExpAdapter.InputViewHolder> {

    private List<String> inputList;

    public ExpAdapter(List<String> inputList) {
        this.inputList = inputList;
    }

    @NonNull
    @Override
    public InputViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_item, parent, false);
        return new InputViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InputViewHolder holder, int position) {
        String inputText = inputList.get(position);
        holder.name.setText(inputText);
        holder.type.setText(inputText);
        holder.time.setText(inputText);
        holder.desc.setText(inputText);
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

        TextInputEditText name,type,time,desc;
        ImageButton deleteButton;

        public InputViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_of_experience);
            type = itemView.findViewById(R.id.type_of_experience);
            time = itemView.findViewById(R.id.timeline);
            desc = itemView.findViewById(R.id.description);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }

}