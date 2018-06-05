package co.shrey.fireapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;



public class submit extends AppCompatActivity {
    private static final String TAG = "submit";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();;
    private DatabaseReference rootref = database.getReference();
    private DatabaseReference childref = rootref.getRef();
    /*List<UserInformation> list;*/
    ArrayList<UserInformation> list;
    /*ArrayAdapter <UserInformation> adapter;*/
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutmanager;
    DividerItemDecoration dividerItemDecoration;
    Adapter madapter;
    UserInformation userInfo;
    TextView name_tv,address_tv,age_tv;
    TextView name_text,address_text,age_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_layout);

       /* RecyclerView recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(new Adapter());*/
         name_tv = (TextView) findViewById(R.id.name);
         address_tv = (TextView) findViewById(R.id.address);
         age_tv = (TextView) findViewById(R.id.age);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
      /*  name_text = (TextView) findViewById(R.id.);
        address_text = (TextView) findViewById(R.id.address);
        age_text = (TextView) findViewById(R.id.age);*/
    }
    @Override
    protected void onStart() {
        super.onStart();
        list =new ArrayList<>();
        childref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                /*uinfo=new UserInformation();*/
                    userInfo = data.getValue(UserInformation.class);
                    Log.e("TAG", userInfo.getAddress() + userInfo.getAge() + userInfo.getName());
                    list.add(userInfo);

                }
                madapter = new Adapter(list);
                mLayoutmanager = new LinearLayoutManager(submit.this);
                dividerItemDecoration = new DividerItemDecoration(submit.this, mLayoutmanager.getOrientation());
                recyclerView.setLayoutManager(mLayoutmanager);
                recyclerView.addItemDecoration(dividerItemDecoration);
                recyclerView.setAdapter(madapter);


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void updateui() {
        address_tv.setText(userInfo.getAddress());
        age_tv.setText(userInfo.getAge());
        name_tv.setText(userInfo.getName());
    }
}
