package com.example.gannys.crimealert;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText title, content;
    Button btn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FireBaseDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.edt_title);
        content = findViewById(R.id.edt_content);
        btn = findViewById(R.id.btn_post);

//        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("CrimeAlert");

        db = new FireBaseDB();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                postComment();
//                updateComment(Double.valueOf(title.getText().toString()), Double.valueOf(content.getText().toString()));
                db.updateLoc(Double.valueOf(title.getText().toString()), Double.valueOf(content.getText().toString()));
            }
        });

    }

    private void postComment(){
        String title_str = title.getText().toString();
        String content_str = content.getText().toString();
        Post post = new Post(title_str, content_str);
        databaseReference.push().setValue(post);

//        double lati = 38.0;
//        double longi = -118.0;
//        LocationInfo loc = new LocationInfo(lati, longi);
//        databaseReference.push().setValue(loc);
    }

    private void updateComment(double lati, double longi){
        LocationInfo loc = new LocationInfo(lati, longi);
        databaseReference.child("-LXkFxiBD9HG_ph0SWZt").setValue(loc);
    }
}
