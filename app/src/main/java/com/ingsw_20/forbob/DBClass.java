package com.ingsw_20.forbob;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andre on 10/01/2018.
 */

public class DBClass {
    private String TAG = "DBClassLOG";
    private DatabaseReference myRef;

    public DBClass() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Location");
    }


    public void insert(String name, List<PostiSettori> settori_posti, String indirizzo){
        String id = myRef.push().getKey();

        LocationDBClass locationDBClass = new LocationDBClass(id, name, settori_posti, indirizzo);

        myRef.child(id).setValue(locationDBClass);
    }



    String ris;
    public String risultatoQuery(String string){

        Query query = myRef.orderByChild("name").equalTo(string);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ris = dataSnapshot.getValue().toString();
                Log.d(TAG,dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                ris= "Elemento non trovato";
            }
        });
        Log.d(TAG, "stampo il ris " + ris);
        return ris;
    }
}
