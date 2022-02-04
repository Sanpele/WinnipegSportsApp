package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import androidx.transition.Scene;
import comp3350.winSport.R;
import comp3350.winSport.business.AccessTeams;
import comp3350.winSport.objects.Team;

public class ScheduleActivity extends AppCompatActivity {

    /*
        Method to initialize a layout of teams that lead to the teams schedules.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        AccessTeams accessTeams = new AccessTeams();
        List<Team> teams = accessTeams.getTeams();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Schedule");

        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.team_item, teams);

        ListView listView = findViewById(R.id.team_items_schedule);

        listView.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team o = (Team)listView.getItemAtPosition(position);
                Intent myIntent = new Intent(ScheduleActivity.this,TeamScheduleActivity.class);
                myIntent.putExtra("TeamName", o.getName()); //Optional parameters
                ScheduleActivity.this.startActivity(myIntent);
            }
        }));
        listView.setAdapter(adapter);

    }

    public static class CustomListViewAdapter extends ArrayAdapter<Team> {
        Context context;

        public CustomListViewAdapter(Context context, int resourceId,List<Team> items) {
            super(context, resourceId, items);
            this.context = context;
        }

        /*private view holder class*/
        private static class ViewHolder {
            ImageView imageView;
            TextView txtTitle;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ScheduleActivity.CustomListViewAdapter.ViewHolder holder;
            Team rowItem = getItem(position);

            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.team_item, null);
                holder = new ViewHolder();
                holder.txtTitle =  convertView.findViewById(R.id.teamName);
                holder.imageView =  convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            } else
                holder = (ScheduleActivity.CustomListViewAdapter.ViewHolder) convertView.getTag();

            holder.txtTitle.setText(rowItem.getName());
            holder.imageView.setImageResource(rowItem.getTeamPic());

            return convertView;
        }
    }


}