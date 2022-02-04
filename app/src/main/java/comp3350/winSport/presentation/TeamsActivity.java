package comp3350.winSport.presentation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import comp3350.winSport.R;
import comp3350.winSport.business.AccessTeams;
import comp3350.winSport.objects.Team;

public class TeamsActivity extends AppCompatActivity {

    AccessTeams accessTeams = new AccessTeams();
    List<Team> teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        teams = accessTeams.getTeams();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Teams");

        CustomListViewAdapter adapter = new CustomListViewAdapter(this,R.layout.team_item,teams);
        //ArrayAdapter adapter = new ArrayAdapter<>(this,R.layout.team_item,teams);
        //MyAdapter adapter = new MyAdapter(this, teams, images);
        ListView listView = findViewById(R.id.list_view);
        listView.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team o = (Team)listView.getItemAtPosition(position);
                String val = o.getName();
                System.out.println(val);

                Intent myIntent = new Intent(TeamsActivity.this,RosterActivity.class);
                myIntent.putExtra("TeamName", o.getName()); //Optional parameters
                TeamsActivity.this.startActivity(myIntent);
            }
        }));
        listView.setAdapter(adapter);
    }

    public class CustomListViewAdapter extends ArrayAdapter<Team> {
        Context context;

        public CustomListViewAdapter(Context context, int resourceId,List<Team> items) {
            super(context, resourceId, items);
            this.context = context;
        }

        /*private view holder class*/
        private class ViewHolder {
            ImageView imageView;
            TextView txtTitle;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            Team rowItem = getItem(position);

            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.team_item, null);
                holder = new ViewHolder();
                holder.txtTitle = convertView.findViewById(R.id.teamName);
                holder.imageView = convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();

            holder.txtTitle.setText(rowItem.getName());
            holder.imageView.setImageResource(rowItem.getTeamPic());

            return convertView;
        }
    }




//    class MyAdapter extends ArrayAdapter<List<Team>> {
//
//        Context context;
//        List<Team> teams;
//        int rImgs[];
//
//        MyAdapter (Context c, List<Team> teams, int imgs[]) {
//            super(c, R.layout.team_item, R.id.list_view, Collections.singletonList(teams));
//            this.context = c;
//            this.teams = teams;
//            this.rImgs = imgs;
//
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = layoutInflater.inflate(R.layout.team_item, parent, false);
//            ImageView images = row.findViewById(R.id.image);
//            TextView teamName = row.findViewById(R.id.text1);
//
//            // now set our resources on views
//            images.setImageResource(rImgs[position]);
//            teamName.setText(teams.get(position).getName());
//
//
//            return row;
//        }
//    }


}