package in.apptonic.instantblog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.apptonic.instantblog.model.Post;

public class NewPostSubmission extends AppCompatActivity {

    private static final String TAG = "NewPostSubmission";
    private static final String REQUIRED = "Required";

    private EditText title;
    private EditText short_desc;
    private EditText detail_post;
    private Button submit_post;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbRef;

    List<Post> post_model = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post_submission);

        title = findViewById(R.id.title_edit);
        short_desc = findViewById(R.id.short_description_edit);
        detail_post = findViewById(R.id.detail_post_edit);

        firebaseDatabase = FirebaseDatabase.getInstance();
        dbRef = firebaseDatabase.getReference();
        submit_post = findViewById(R.id.submit_post);
        submit_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String mTitle = title.getText().toString();
                final String mShortDesc = short_desc.getText().toString();
                final String mDetailPost = detail_post.getText().toString();

                if (TextUtils.isEmpty( mTitle)

                        || (TextUtils.isEmpty((mShortDesc))
                        || (TextUtils.isEmpty((mDetailPost))))) {

                    title.setError(REQUIRED);
                    short_desc.setError(REQUIRED);
                    detail_post.setError(REQUIRED);

                } else {
                    submit_post(mTitle, mShortDesc, mDetailPost);
                }


            }
        });

    }

    public void submit_post(String title, String short_desc, String detail_post) {

        Post post = new Post(title, short_desc, detail_post);
        String key = dbRef.child("post").push().getKey();
        Map<String, Object> postValues = post.toMap();
        Map<String, Object> childUpdate = new HashMap<>();

        childUpdate.put("/post/"+ key, postValues);
        dbRef.updateChildren(childUpdate);

    }
}
