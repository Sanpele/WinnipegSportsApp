package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import comp3350.winSport.R;
import comp3350.winSport.business.AccessGames;
import comp3350.winSport.objects.Game;
import comp3350.winSport.presentation.Adapters.CurrentAdapter;

public class CurrentlyPlayingActivity extends AppCompatActivity {

    private AccessGames accessGames;
    private List<Game> games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_playing);

        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Currently Playing");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        accessGames = new AccessGames();
        games = accessGames.getGames();

        for (int i=0;i<games.size();i++){
            Log.d("currently",games.get(i).getGameName());
        }


        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.setLayoutManager(llm);
        CurrentAdapter adapter = new CurrentAdapter(games,this);
        rv.setAdapter(adapter);

    }
}