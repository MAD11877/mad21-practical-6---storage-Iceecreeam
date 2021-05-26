package sg.edu.np.mad.madpractical;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterUserList  extends RecyclerView.Adapter<ViewHolderUserList> {

    ArrayList<User> data;

    public AdapterUserList(ArrayList<User> input){
        data = input;
    }

    public ViewHolderUserList onCreateViewHolder(ViewGroup parent, int viewType) {
        View item;
        if (viewType == 0){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activitylist_seven,parent,false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activitylist,parent,false);
        }
        return new ViewHolderUserList(item);
    }

    public void onBindViewHolder(ViewHolderUserList holder, int position){
        User listObjects = data.get(position);
        holder.nameView.setText(listObjects.getName());
        holder.descView.setText(listObjects.getDescription());
    }

    public int getItemCount(){
        return data.size();
    }

    @Override
    public int getItemViewType(int position){
        User u = data.get(position);
        if (u.getName().charAt(u.getName().length() - 1) == '7'){
            return 0;
        }
        else {
            return 1;
        }
    }



}
