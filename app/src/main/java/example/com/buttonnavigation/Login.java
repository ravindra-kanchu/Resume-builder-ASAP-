package example.com.buttonnavigation;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Login extends AppCompatActivity {
    EditText textusername,textpassword;
    Button login;
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView btn=findViewById(R.id.tvsignup);
        textusername=findViewById(R.id.inputemail);
        textpassword=findViewById(R.id.inputname);
        login=findViewById(R.id.login);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Registrations:");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=textusername.getText().toString();
                String password=textpassword.getText().toString();
                DataSnapshot dataSnapshot;
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // Data retrieved successfully
                        String p1="";
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            if(dataSnapshot.hasChild(username)){
                                HashMap<String, String> userData2 = (HashMap<String,String>) snapshot.getValue();
                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(username);
                                p1=userData2.get("password1");
                                if(password.equals(p1)){
                                    //tv.setText("user exists");
                                    // tv.setVisibility(View.VISIBLE);
                                    Intent ab=new Intent(Login.this,MainActivity.class);
                                    ab.putExtra("username",userData2.get("name"));
                                    ab.putExtra("password",userData2.get("password1"));
                                    //ab.putExtra("phno",userData2.get("phno"));
                                    startActivity(ab);
                                }
                                else{
                                    Toast.makeText(Login.this, "Password incorrect", Toast.LENGTH_SHORT).show();
//                                    tv.setText(Password "incorrect");
                                }

                            }
                            else {
                                //Toast.makeText(Login.this, "Email doesn't exits", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this,MainActivity.class));

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });


    }
}