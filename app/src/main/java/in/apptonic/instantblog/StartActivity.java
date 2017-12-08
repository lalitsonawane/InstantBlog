package in.apptonic.instantblog;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.apptonic.instantblog.model.Post;

public class StartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DetailPostAdapter recyclerAdapter;

    List<Post> posts = new ArrayList<>();


    public FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        recyclerView = findViewById(R.id.myRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerAdapter = new DetailPostAdapter();
        recyclerView.setLayoutManager(layoutManager);


        dbRef = firebaseDatabase.getReference();
        dbRef.addValueEventListener(new ValueEventListener() {
            public static final String TAG = "StartActivity.class";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Post> map = (Map<String, Post>) dataSnapshot.getValue(Post.class);


          //          Post post = dataSnapshot.getValue(Post.class);
                    posts.add((Post) map);

                adapter = new DetailPostAdapter(StartActivity.this, posts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.d(TAG, "Database error" + databaseError);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, NewPostSubmission.class));
            }
        });

    }
}
