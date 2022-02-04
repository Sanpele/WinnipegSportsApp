package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.business.AccessPlayers;
import comp3350.winSport.business.AccessTeams;
import comp3350.winSport.objects.Player;
import comp3350.winSport.objects.Team;
import comp3350.winSport.presentation.Adapters.PlayersAdapter;

public class PlayersActivity extends AppCompatActivity {

    private AccessPlayers accessPlayers;
    private List<Player> players;

    private PlayersAdapter adapter;
    private PlayersAdapter.RecyclerViewEventListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Player Statistics");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        EditText searchBox= findViewById(R.id.searchTxt);
        searchBox.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        filter(s.toString());
                    }
                }
        );

        accessPlayers= new AccessPlayers();
        players = accessPlayers.getAllPlayers();

        // Initialize Recycler view and Linear layout Manager
        RecyclerView rv = findViewById(R.id.player_rv_stats);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        // A Dev task for the future should be to develop a screen to display if teams is null.
        // Activate Layout manager and RecyclerView

        rv.setLayoutManager(llm);
        setOnClickListner();
        adapter = new PlayersAdapter(players,listener);
        rv.setAdapter(adapter);
    }

    private void setOnClickListner() {
        listener = new PlayersAdapter.RecyclerViewEventListener() {
            @Override
            public void onClick(View view, int pos) {
                Intent intent =new Intent(getApplicationContext(),PlayerStatsActivity.class);
                intent.putExtra("playerName",players.get(pos).getTeam());
                startActivity(intent);
            }
        };
    }

    private  void filter(String searchedItem)
    {
        List<Player> searchResults=new ArrayList<>();
        for (Player item : players) {
            if (item.getName().toLowerCase().contains(searchedItem.toLowerCase())) {
                searchResults.add(item);
            }
        }
        adapter.filterList(searchResults);
    }

    }
