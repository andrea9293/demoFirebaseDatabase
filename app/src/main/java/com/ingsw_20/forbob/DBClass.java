package com.ingsw_20.forbob;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by andre on 10/01/2018.
 */

public class DBClass {
    private String TAG = "DBClassLOG";
    private DatabaseReference myRef;

    DBClass() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Location");
    }


    void insert(String name, List<PostiSettori> settori_posti, String indirizzo) {
        String id = myRef.push().getKey();

        LocationDBClass locationDBClass = new LocationDBClass(id, name, settori_posti, indirizzo);

        myRef.child(id).setValue(locationDBClass);
    }


    private String ris;

    void risultatoQuery(String string) {
        ris = "";
        Query query = myRef.orderByChild("name").equalTo(string);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ris = dataSnapshot.getValue().toString();
                Log.d(TAG, dataSnapshot.getValue().toString());
                ModelPezzotto.getInstance().setRisultato(ris);
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
                ris = "Elemento non trovato";
                ModelPezzotto.getInstance().setRisultato(ris);
            }
        });

        query.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    ris = "Elemento non trovato nel secondo listener";
                    ModelPezzotto.getInstance().setRisultato(ris);                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
