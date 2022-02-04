package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import comp3350.winSport.R;
import comp3350.winSport.application.Main;
import comp3350.winSport.business.AccessPlayers;
import comp3350.winSport.business.AccessTeams;
import comp3350.winSport.objects.Player;
import comp3350.winSport.objects.Team;

import android.content.Context;

import android.content.res.AssetManager;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SplashScreenActivity extends AppCompatActivity {

    private List<String> teamNames = new ArrayList<>();

    final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Handler handler=new Handler();

        handler.postDelayed(
                () -> {
                    Intent intent=new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                },2000);

    }




}