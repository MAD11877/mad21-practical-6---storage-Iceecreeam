package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User u;
    MyDatabaseHandler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Debug", "create");



        Intent intent = getIntent();
        String name = intent.getStringExtra("nameUser");
        String desc = intent.getStringExtra("descUser");

        TextView nameview = findViewById(R.id.txtName);
        nameview.setText(name);
        TextView description = findViewById(R.id.txtDescription);
        description.setText(desc);

        myDB = new MyDatabaseHandler(MainActivity.this);

        for (int i=0; i < myDB.getUsers().size(); i++){
            User us = myDB.getUsers().get(i);
            if (us.getName().equals(name)){
                u=us;
            }
        }

        setFollowBtn(false);


    }


    private void setFollowBtn(boolean toast) {


        Button b = findViewById(R.id.btnFollow);
        if(u.followed) {
            b.setText("Unfollow");
            Context context = getApplicationContext();
            if(toast){
                Toast.makeText(context, "Followed", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            b.setText("Follow");
            Context context = getApplicationContext();
            if(toast) {
                Toast.makeText(context, "Unfollowed", Toast.LENGTH_SHORT).show();
            }
        }

//        for (int i=0; i < UserListSingleton.getInstance().userList.size(); i++){
//            User us = UserListSingleton.getInstance().userList.get(i);
//            if (us.getName().equals(u.getName())){
//                UserListSingleton.getInstance().userList.set(i, u);
//            }
//        }

    }
    public void onFollowClick(View v) {
        u.followed = !u.followed;
        myDB.updateUser(u);
        setFollowBtn(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Debug", "start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Debug", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Debug", "pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Debug", "resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Debug", "restart");
    }

}