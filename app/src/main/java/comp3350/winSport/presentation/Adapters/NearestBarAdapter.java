package comp3350.winSport.presentation.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Location;

public class NearestBarAdapter extends RecyclerView.Adapter<NearestBarAdapter.NearestBarViewHolder> {
    private List<Location> venues;
    private RecyclerViewEventListener listener;

    public NearestBarAdapter(List<Location> venues,RecyclerViewEventListener listener)
    {
        this.venues=venues;
        this.listener=listener;
    }
    @NonNull
    @Override
    public NearestBarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_card, parent, false);
        return new NearestBarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NearestBarViewHolder holder, int position) {
        Location venue= venues.get(position);
        holder.venueName.setText(venue.getName());
        holder.venueAddress.setText(venue.getAddress());
        holder.venueDescription.setText(venue.getDescription());

    }

    @Override
    public int getItemCount() {
        return venues.size();
    }

    public interface RecyclerViewEventListener{
        void onClick(View view,int pos);
    }

    public  class NearestBarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView venueName;
        TextView venueAddress;
        TextView venueDescription;
        ImageView venuePic;
        public NearestBarViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            venueName= itemView.findViewById(R.id.sportsVenueText1);
            venueAddress=itemView.findViewById(R.id.sportsVenueAddress);
            venueDescription=itemView.findViewById(R.id.sportsVenueDescription);

        }


        @Override
        public void onClick(View v) {

            listener.onClick(itemView,getAdapterPosition());
        }
    }
}

