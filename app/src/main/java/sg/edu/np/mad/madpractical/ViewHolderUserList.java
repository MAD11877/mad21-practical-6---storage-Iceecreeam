package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ViewHolderUserList extends RecyclerView.ViewHolder {
    TextView nameView;
    TextView descView;
    public ViewHolderUserList(View itemView){
        super(itemView);
        nameView = itemView.findViewById(R.id.NameUser);
        descView = itemView.findViewById(R.id.DescriptionUser);
    }
}
