package sg.edu.np.mad.madpractical;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    static ArrayList<User> userList;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        userList = new ArrayList<>();

        dbHandler = new DBHandler(ListActivity.this);


        for (int i=0; i <20; i++){

            User use = new User();
            use.setName("Name" + new Random().nextInt());
            use.setDescription("Description " +new Random().nextInt());
            use.setId(new Random().nextInt());
            use.setFollowed(new Random().nextBoolean());

            dbHandler.addUser(use);
            //UserListSingleton.getInstance().userList.add(use);
        }

        userList = dbHandler.getUsers();

        RecyclerView rv = findViewById(R.id.rv);
        ItemsAdapter itemsAdapter = new ItemsAdapter(userList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(itemsAdapter);
    }
}