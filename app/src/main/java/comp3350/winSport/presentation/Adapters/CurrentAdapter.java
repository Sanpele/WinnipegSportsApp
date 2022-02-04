package comp3350.winSport.presentation.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Game;

public class CurrentAdapter extends RecyclerView.Adapter<CurrentAdapter.GameViewHolder> {

    List<Game> games; // declare games List
    Context c;

    public CurrentAdapter(List<Game> games, Context c) { // constructor initalizing games list.
        this.games = games;
        this.c = c;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.current_card, parent, false);
        return new GameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
//        holder.gameTeam.setText(games.get(position).getTeam1() + " Vs.\n" +
//                games.get(position).getTeam2());
        Game game = games.get(position);
        holder.team1.setText(game.getTeam1());
        holder.team2.setText(game.getTeam2());
        holder.date.setText(game.getGameDate());
        holder.leagueName.setText(game.getGameLeague());
        holder.gameScore.setText(game.getGameScore());
        holder.team1Logo.setImageResource(game.getTeam1Pic());
        holder.team2Logo.setImageResource(game.getTeam2Pic());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class GameViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView team1, team2, leagueName;
        TextView date;
        TextView gameScore;
        ImageView team1Logo, team2Logo;

        GameViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.current_playing_card);

            team1 = itemView.findViewById(R.id.team1);
            team2 = itemView.findViewById(R.id.team2);
            leagueName = itemView.findViewById(R.id.leagueName);
            date = itemView.findViewById(R.id.date);
            gameScore = itemView.findViewById(R.id.game_score);
            team1Logo = itemView.findViewById(R.id.team1Logo);
            team2Logo = itemView.findViewById(R.id.team2Logo);
        }
    }

}
