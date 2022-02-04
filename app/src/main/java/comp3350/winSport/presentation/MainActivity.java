package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import comp3350.winSport.R;
import comp3350.winSport.application.Main;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private HashMap<Integer,Class<?>> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyDatabaseToDevice();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Winnipeg Sports");

        initIDs();

        // Create a button for each of our ID's and set an onClickListener.
        for (Integer i : ids.keySet()) {
            Button button = findViewById(i);
            button.setOnClickListener(this);
        }
    }

    // Initialize our hashmap with ID value Class value.
    // Will allow for clean onclick method below.
    private void initIDs() {
        ids = new HashMap<>();
        ids.put(R.id.currentlyPlayingMenu,CurrentlyPlayingActivity.class);
        ids.put(R.id.teamRostersMenu,TeamsActivity.class);
        ids.put(R.id.player_stat_layout,PlayersActivity.class);
        ids.put(R.id.schedule_layout,ScheduleActivity.class);
        ids.put(R.id.channel_layout,ChannelActivity.class);
        ids.put(R.id.newsFeedMenu,NewsFeedActivity.class);
        ids.put(R.id.buy_tickets_menu,TicketsActivity.class);
        ids.put(R.id.standings_menu,StandingsActivity.class);
        ids.put(R.id.nearby_bars,NearestBarActivity.class);
    }

    // Can simply get matching key of the on clicked id.
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,ids.get(v.getId()));
        MainActivity.this.startActivity(intent);
    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
            Log.e("SplashScreenActivity",ioe.toString());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }

}