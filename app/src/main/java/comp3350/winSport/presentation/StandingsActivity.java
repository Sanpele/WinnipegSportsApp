package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.business.AccessStanding;
import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.Standing;
import comp3350.winSport.presentation.Adapters.RosterAdapter;
import comp3350.winSport.presentation.Adapters.StandingAdapter;

public class StandingsActivity extends AppCompatActivity {

    // declare our Access variable.
    private AccessStanding accessStanding;
    // declare list of Standing Objects to pass to adapter.
    private List<Standing> standingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        accessStanding = new AccessStanding();

        // try catch for persistance exception
        try {
            standingList = accessStanding.getStandingInOrder();
        }
        catch (PersistenceException e) {
            e.printStackTrace();
        }


        // Initialze toolbar, check for Null if disabled.
        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Standings");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        RecyclerView rv = findViewById(R.id.standins_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);


        if (standingList != null) {
            rv.setLayoutManager(llm);
            StandingAdapter adapter = new StandingAdapter(standingList);
            rv.setAdapter(adapter);
        }
        else {
            Log.v("StandingACtivity","standingList not constructed correctly");
        }

    }
}