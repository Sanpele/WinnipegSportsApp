package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import comp3350.winSport.R;
import comp3350.winSport.business.AccessNewsFeed;
import comp3350.winSport.objects.NewsPost;
import comp3350.winSport.presentation.Adapters.NewsFeedAdapter;
import comp3350.winSport.presentation.interfaces.RecyclerViewEventListener;

public class NewsFeedActivity extends AppCompatActivity {
    private AccessNewsFeed accessNewsFeed;
    private List<NewsPost> newsPosts;
    private RecyclerViewEventListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setTitle("News Feed");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        accessNewsFeed = new AccessNewsFeed();
        newsPosts=new ArrayList<>();
        newsPosts.addAll( accessNewsFeed.getNewsPosts());
    //    ArrayList<NewsPost> posts;
       // posts=new ArrayList<NewsPost>();
      //  for (int i = 0; i < 6; i++) {
       //     posts.add(new NewsPost());
     //   }
        RecyclerView rv = findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.setLayoutManager(llm);
     //   commentSection.setLayoutManager(llm);
//        setOnClickListner();
        NewsFeedAdapter adapter = new NewsFeedAdapter(newsPosts,listener);
        rv.setAdapter(adapter);

    }

    // COLIN : not sure if we need this, i commented it out and the code runs without it.
//    private  void setOnClickListner()
//    {
//        listener=new RecyclerViewEventListener() {
//            @Override
//            public void onClick(View view, int pos) {
//                //do stuff
//            }
//        };
//    }
}