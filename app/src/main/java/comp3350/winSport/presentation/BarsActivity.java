package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.winSport.R;
import comp3350.winSport.business.AccessLocations;
import comp3350.winSport.objects.Location;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.presentation.Adapters.NearestBarAdapter;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class BarsActivity extends AppCompatActivity {
    AccessLocations accessBars;
    NearestBarAdapter adapter;
    NearestBarAdapter.RecyclerViewEventListener listener;
    List<Location> bars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);
        String venueName="";
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            venueName=extras.getString("venueName");
        }
        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("bars near "+venueName);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        accessBars=new AccessLocations();
        try {
            bars=accessBars.getBars(venueName);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        RecyclerView rv = findViewById(R.id.venuesRV);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        setOnClickListner();
        adapter = new NearestBarAdapter(bars, listener);
        rv.setAdapter(adapter);
    }

    private void setOnClickListner() {
        listener = new NearestBarAdapter.RecyclerViewEventListener() {
            @Override
            public void onClick(View view, int pos) {
                //this is because we reuse the NearestBar adapter ,do not remove this method.

            }
        };
    }
}