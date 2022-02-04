package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Channel;
import comp3350.winSport.presentation.Adapters.ChannelAdapter;

public class ChannelActivity extends AppCompatActivity {
    RecyclerView rv;
    //Button add;
    List<Channel> Items;
    ChannelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Channels");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        Items = new ArrayList<>();

        Items.add(new Channel(R.string.CBCSports  , R.drawable.cbc_sports));
        Items.add(new Channel(R.string.Sportsnet  , R.drawable.sportnets_logo));
        Items.add(new Channel(R.string.TSN        , R.drawable.tsn_logo));

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        adapter = new ChannelAdapter(Items, this);
        rv.setAdapter(adapter);
    }
}