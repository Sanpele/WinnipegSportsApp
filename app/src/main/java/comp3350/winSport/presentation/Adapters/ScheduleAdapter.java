package comp3350.winSport.presentation.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Game;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>{

    private String teamName; // team name, allows us to differenciate which team is opponent
    private List<Game> games; // declare games List

    public ScheduleAdapter(List<Game> g, String t) {
        this.games = g;
        this.teamName = t;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_card, parent, false);
        return new ScheduleAdapter.ScheduleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        Game game = games.get(position);
        holder.gameDate.setText(game.getGameDate());
        // Opponent name set to the team not equal to the global teamName.
        if (this.teamName.equals(game.getTeam2()))
            holder.gameOpponent.setText(game.getTeam1());
        else
            holder.gameOpponent.setText(game.getTeam2());
        holder.gameScore.setText(game.getGameScore());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView gameDate;
        TextView gameOpponent;
        TextView gameScore;

        ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.schedule_card);
            gameDate = itemView.findViewById(R.id.game_date);
            gameOpponent = itemView.findViewById(R.id.game_opponent);
            gameScore = itemView.findViewById(R.id.game_result);
        }
    }
}
