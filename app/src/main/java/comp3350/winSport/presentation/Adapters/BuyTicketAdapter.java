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
import comp3350.winSport.objects.Ticket;
import de.hdodenhof.circleimageview.CircleImageView;

public class BuyTicketAdapter extends RecyclerView.Adapter<BuyTicketAdapter.MyViewHolder>{

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    List<Ticket> ls;
    Context c;

    public BuyTicketAdapter(List<Ticket> ls, Context c) {
        this.c = c;
        this.ls = ls;
    }

    @NonNull
    @Override
    public BuyTicketAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow = LayoutInflater.from(c).inflate(R.layout.ticket_row, parent, false);
        return new BuyTicketAdapter.MyViewHolder(itemrow);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull BuyTicketAdapter.MyViewHolder holder, final int position) {

        if (position == 0) {
            holder.name.setText(R.string.team_name_ticket);
            holder.teamLink.setText(R.string.ticket_link_text);
            holder.ivPic.setImageResource(R.drawable.nhl);
        }
        else {
            Ticket t = ls.get(position - 1);
            holder.name.setText(t.getName());
            holder.teamLink.setText(t.getLink());
            holder.teamLink.setMovementMethod(LinkMovementMethod.getInstance());
            holder.ivPic.setImageDrawable(c.getDrawable(t.getPic()));
        }
    }

    @Override
    public int getItemCount() {
        return ls.size()+1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,teamLink;
        RelativeLayout row;
        CircleImageView ivPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            teamLink = itemView.findViewById(R.id.teamLink);
            row = itemView.findViewById(R.id.row);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }
}
