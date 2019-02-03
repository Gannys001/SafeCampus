package com.example.gannys.crimealert;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseDB {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public FireBaseDB(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("CrimeAlert");
    }

    public void updateLoc(double lati, double longi){
        LocationInfo loc = new LocationInfo(lati, longi);
        databaseReference.child("-LXkFxiBD9HG_ph0SWZt").setValue(loc);
    }

}
