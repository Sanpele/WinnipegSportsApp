package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.business.AccessPlayers;
import comp3350.winSport.objects.Player;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.presentation.Adapters.RosterAdapter;

public class RosterActivity extends AppCompatActivity {

    private AccessPlayers accessPlayers;
    private List<Player> team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_list);

        Intent intent = getIntent();
        String value = (intent).getStringExtra("TeamName");

        // ENABLE ACTION BAR
        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Roster");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        // RECYCLER VIEW DATA
        accessPlayers = new AccessPlayers();

        try {
            team = accessPlayers.getPlayersByTeam(value);
        } catch (InvalidNameException e) {
            team = null;
            Log.e("Roster Name ER",e.toString());
        }

        // Initialize Recycler view and Linear layout Manager
        RecyclerView rv = findViewById(R.id.player_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        // A Dev task for the future should be to develop a screen to display if teams is null.
        if (team != null) {
            // Activate Layout manager and RecyclerView
            rv.setLayoutManager(llm);
            RosterAdapter adapter = new RosterAdapter(team);
            rv.setAdapter(adapter);
        }
        else {
            // should log a error message, or display some dumb data.
            Log.e("Roster Error","THIS SHOULD DISPLAY SOME DATA TO THE USER TO LET THEM KNOW THAT IT DIED");
        }
    }
}