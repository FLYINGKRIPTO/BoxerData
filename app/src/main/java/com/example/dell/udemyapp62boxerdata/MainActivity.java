package com.example.dell.udemyapp62boxerdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First step for writing data to database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReferenceFromUrl("https://udemyapp62boxerdata-d28a6.firebaseio.com/");
        final EditText edtBoxerId = findViewById(R.id.boxerId);
        final EditText edtBoxerName = findViewById(R.id.boxerName);
        final EditText edtBoxerPunchPower  = findViewById(R.id.boxerPunchPower);
        final EditText edtBoxerPunchSpeed = findViewById(R.id.boxerPunchSpeed);
        final EditText edtBoxerStamina = findViewById(R.id.boxer_stamina);
        Button sendDataTOServer= findViewById(R.id.btnSendDataToServer);

        sendDataTOServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child(edtBoxerId.getText().toString()).child("Name").setValue(edtBoxerName.getText().toString());
                myRef.child(edtBoxerId.getText().toString()).child("Boxer Punch Power").setValue(edtBoxerPunchPower.getText().toString());
                myRef.child(edtBoxerId.getText().toString()).child("Boxer Punch Speed").setValue(edtBoxerPunchSpeed.getText().toString());
                myRef.child(edtBoxerId.getText().toString()).child("Boxer Stamina").setValue(edtBoxerStamina.getText().toString());
                
            }
        });

    }
}
