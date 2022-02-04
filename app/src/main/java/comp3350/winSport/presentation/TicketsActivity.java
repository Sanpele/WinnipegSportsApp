package comp3350.winSport.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.winSport.R;
import comp3350.winSport.objects.Ticket;
import comp3350.winSport.presentation.Adapters.BuyTicketAdapter;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TicketsActivity extends AppCompatActivity {

    RecyclerView rv;
    //Button add;
    List<Ticket> Items;
    BuyTicketAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_tickets);

        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Buy Tickets");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        initItems();

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        adapter = new BuyTicketAdapter(Items, this);
        rv.setAdapter(adapter);
    }

    void initItems() {
        Items = new ArrayList<>();

        Items.add(new Ticket("Calgary Flames"       , R.string.CalgaryFlames, R.drawable.flames));
        Items.add(new Ticket("Edmonton Oilers"      , R.string.EdmontonOilers, R.drawable.oilers));
        Items.add(new Ticket("Montréal Canadiens"   , R.string.MontréalCanadiens, R.drawable.montreal));
        Items.add(new Ticket("Ottawa Senators"      , R.string.OttawaSenators, R.drawable.ottawa));
        Items.add(new Ticket("Toronto Maple Leafs"  , R.string.TorontoMapleLeafs, R.drawable.leafs));
        Items.add(new Ticket("Vancouver Canucks"    , R.string.VancouverCanucks, R.drawable.vancouver));
        Items.add(new Ticket("Winnipeg Jets"        , R.string.WinnipegJets, R.drawable.jets));
    }


}