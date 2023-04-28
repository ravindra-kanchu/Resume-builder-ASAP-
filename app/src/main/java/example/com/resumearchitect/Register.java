package example.com.resumearchitect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register extends AppCompatActivity {
    EditText textusername,textemail,textpassword,textconfirmpassword;
    Button register;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView btn=findViewById(R.id.haveaccount);
        textusername=findViewById(R.id.inputname);
        textemail=findViewById(R.id.inputemail);
        textpassword=findViewById(R.id.inputpw);
        textconfirmpassword=findViewById(R.id.inputcpw);
        register=findViewById(R.id.buttonreg);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Registrations:");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = textpassword.getText().toString();
                String s2 = textconfirmpassword.getText().toString();

                if (s1.equals(s2)) {
                    HashMap<String, String> userData = new HashMap<>();
                    userData.put("name", textusername.getText().toString());
                    userData.put("email", textemail.getText().toString());
                    userData.put("password1", textpassword.getText().toString());

                    myRef.child(textusername.getText().toString()).setValue(userData).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Register.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Register.this, "Data insertion failed", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Toast.makeText(Register.this, "Enter Same password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}