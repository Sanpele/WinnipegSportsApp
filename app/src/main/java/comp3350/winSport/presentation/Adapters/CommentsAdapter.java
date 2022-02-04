package comp3350.winSport.presentation.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Comment;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>  {
    private List<Comment> comments;

    public CommentsAdapter(List<Comment> comments)
    {
        this.comments=comments;
    }
    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card, parent, false);
        return new CommentsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        holder.userName.setText(comments.get(position).getUserNickName());
        holder.userComment.setText(comments.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public  class CommentsViewHolder extends RecyclerView.ViewHolder  {
        TextView userName;
        TextView userComment;


        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            userName= itemView.findViewById(R.id.user_name);
            userComment= itemView.findViewById(R.id.user_comment);

        }
    }
}
