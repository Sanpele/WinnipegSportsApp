package comp3350.winSport.presentation.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Game;
import comp3350.winSport.objects.Player;
import comp3350.winSport.objects.Team;

public class RosterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<Player> players; // declare games List

    public RosterAdapter(List<Player> players) { // constructor initalizing games list.
        this.players = players;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_header, parent, false);
            return new PlayerHeaderViewHolder(v);
        }
        else if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_card, parent, false);
            return new PlayerViewHolder(v);
        }
        else return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof PlayerViewHolder) {

            final PlayerViewHolder itemViewHolder = (PlayerViewHolder) holder;
            final Player data = players.get(position-1);

            itemViewHolder.player_name.setText(data.getName());
            itemViewHolder.player_num.setText(String.format("%d", data.getNumber()));
            itemViewHolder.position.setText(data.getPosition());
            itemViewHolder.shot.setText(data.getShot());
            itemViewHolder.player_pic.setImageResource(data.getTeamPic());
        }
        else if (holder instanceof PlayerHeaderViewHolder) {

            PlayerHeaderViewHolder itemViewHolder = (PlayerHeaderViewHolder) holder;

            itemViewHolder.team_name.setText(players.get(position+1).getTeam());
            itemViewHolder.team_pic.setImageResource(players.get(position+1).getTeamPic());
        }
    }

    @Override
    public int getItemCount() {
        return players.size()+1;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        else
            return TYPE_ITEM;
    }

    public static class PlayerHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView team_name;
        ImageView team_pic;

        public PlayerHeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            team_name = itemView.findViewById(R.id.teamName_roster);
            team_pic = itemView.findViewById(R.id.team_pic);

        }
    }

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView player_name;
        TextView player_num;
        TextView position;
        TextView shot;
        ImageView player_pic;

        PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.current_playing_card);
            player_name = itemView.findViewById(R.id.player_name);
            player_num = itemView.findViewById(R.id.player_num);
            position = itemView.findViewById(R.id.position);
            shot = itemView.findViewById(R.id.shot);
            player_pic = itemView.findViewById(R.id.player_pic);
        }
    }

}
