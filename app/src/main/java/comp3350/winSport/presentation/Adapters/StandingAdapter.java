package comp3350.winSport.presentation.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import comp3350.winSport.R;
import comp3350.winSport.objects.Standing;

public class StandingAdapter extends RecyclerView.Adapter<StandingAdapter.StandingViewHolder>{

    // constants that allow implementation of Header.
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<Standing> standings;

    public StandingAdapter(List<Standing> s) {
        this.standings = s;
    }

    @NonNull
    @Override
    public StandingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings_card, parent, false);
        return new StandingAdapter.StandingViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull StandingViewHolder holder, int position) {

        // If first element of list, Load our header values
        if (position == 0) {
            holder.teamPic.setImageResource(R.drawable.nhl);
            holder.teamName.setText(R.string.Teams_Standing);
            holder.wins.setText("W ");
            holder.losses.setText("L ");
            holder.ot_losses.setText(R.string.OT_standing);
            holder.points.setText(R.string.Pts_standing);
            holder.win_streak.setText(R.string.STK_standing);
        }
        // Otherwise, load values from List of standings.
        else {
            Standing s = standings.get(position-1);

            holder.teamPic.setImageResource(s.getTeamPic());
            holder.teamName.setText(s.getTeamName());
            holder.wins.setText(String.valueOf(s.getWins()));
            holder.losses.setText(String.format(Locale.CANADA,"%02d", s.getLosses()));
            holder.ot_losses.setText(String.valueOf(s.getOt_losses()));
            holder.points.setText(String.format("  %s", s.getPts()));
            holder.win_streak.setText(String.format("  %s", s.getWin_streak()));
        }
    }


    // Increment list by 1 to account for header.
    @Override
    public int getItemCount() {
        return standings.size()+1;
    }

    public static class StandingViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView teamPic;
        TextView teamName;
        TextView wins;
        TextView losses;
        TextView ot_losses;
        TextView points;
        TextView win_streak;

        public StandingViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.standing_cardview);
            teamPic = itemView.findViewById(R.id.team_pic_standingss);
            teamName = itemView.findViewById(R.id.standing_team_name);
            wins = itemView.findViewById(R.id.standing_wins);
            losses = itemView.findViewById(R.id.standing_losses);
            ot_losses = itemView.findViewById(R.id.standing_overtime_losses);
            points = itemView.findViewById(R.id.standing_points);
            win_streak = itemView.findViewById(R.id.standing_winstreak);

        }
    }
}
