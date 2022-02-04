package comp3350.winSport.presentation.Adapters;

import android.content.Context;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import comp3350.winSport.R;
import comp3350.winSport.objects.Channel;
import de.hdodenhof.circleimageview.CircleImageView;


public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.MyViewHolder> {
    List<Channel> ls;
    Context c;

    public ChannelAdapter(List<Channel> ls, Context c) {
        this.c = c;
        this.ls = ls;
    }

    @NonNull
    @Override
    public ChannelAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow = LayoutInflater.from(c).inflate(R.layout.channel_item_row, parent, false);
        return new ChannelAdapter.MyViewHolder(itemrow);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ChannelAdapter.MyViewHolder holder, final int position) {
        holder.name.setText(ls.get(position).getName());
        holder.name.setMovementMethod(LinkMovementMethod.getInstance());
        holder.ivPic.setImageDrawable(c.getDrawable(ls.get(position).getPic()));
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RelativeLayout row;
        CircleImageView ivPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            row = itemView.findViewById(R.id.row);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }
}