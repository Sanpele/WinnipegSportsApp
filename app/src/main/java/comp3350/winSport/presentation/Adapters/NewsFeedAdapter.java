package comp3350.winSport.presentation.Adapters;



import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import comp3350.winSport.R;

import comp3350.winSport.business.AccessComments;
import comp3350.winSport.business.AccessNewsFeed;
import comp3350.winSport.objects.Comment;
import comp3350.winSport.objects.NewsPost;
import comp3350.winSport.presentation.interfaces.RecyclerViewEventListener;

public class NewsFeedAdapter extends RecyclerView.Adapter <NewsFeedAdapter.NewsFeedHolder> {

    List<NewsPost> newsPosts;
    List<Comment> commentList;
    AccessComments accessComments;
    AccessNewsFeed accessNewsFeed;
    CommentsAdapter commentsAdapter;
    final String PEOPLE_LIKE_THIS=" people like this";
    final String PEOPLE_DISLIKE_LIKE_THIS=" people dislike this";
    private RecyclerViewEventListener listener;

    public NewsFeedAdapter(List<NewsPost> newsPosts, RecyclerViewEventListener listener)
    {
        this.newsPosts=newsPosts;
        this.listener=listener;
        accessComments=new AccessComments();
        accessNewsFeed = new AccessNewsFeed();
    }
    @NonNull
    @Override
    public NewsFeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_feed_card, parent, false);
        return new NewsFeedHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedHolder holder, int position) {
        holder.photo.setImageResource(newsPosts.get(position).getImage());
        holder.postTitle.setText(newsPosts.get(position).getTitle());
        holder.caption.setText(newsPosts.get(position).getCaption());
        holder.datePosted.setText(newsPosts.get(position).getDatePosted());
        holder.likeCounter.setText(String.format("%s%s", newsPosts.get(position).getLikes(), PEOPLE_LIKE_THIS));
        holder.dislikeCounter.setText(String.format("%s%s", newsPosts.get(position).getDislikes(), PEOPLE_DISLIKE_LIKE_THIS));
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.commentSection.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );

        holder.commentSection.setLayoutManager(layoutManager);
        commentList= accessComments.getComments(newsPosts.get(position).getPostID());
        commentsAdapter=new CommentsAdapter(commentList);
        holder.commentSection.setAdapter(commentsAdapter);
    }

    @Override
    public int getItemCount() {
        return newsPosts.size();
    }


    public class NewsFeedHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView postTitle;
        TextView caption;
        TextView datePosted;
        Button likeButton;
        Button dislikeButton;
        TextView likeCounter;
        TextView dislikeCounter;
        Button commentButton;
        RecyclerView commentSection;
        AccessComments accessComments;
        EditText commentInput;
        public  NewsFeedHolder(@NonNull View itemView) {
            super(itemView);
            photo=itemView.findViewById(R.id.post_image);
            postTitle=itemView.findViewById(R.id.post_title);
            caption=itemView.findViewById(R.id.caption);
            datePosted=itemView.findViewById(R.id.date_posted);
            likeButton=itemView.findViewById(R.id.like_button);
            dislikeButton=itemView.findViewById(R.id.dislike_button);
            likeCounter=itemView.findViewById(R.id.numLikes);
            dislikeCounter=itemView.findViewById(R.id.numDislikes);
            commentInput=itemView.findViewById(R.id.commentTxt);
            commentButton=itemView.findViewById(R.id.comment_button);
            commentSection=itemView.findViewById(R.id.commentsRV);
            accessComments=new AccessComments();
          //  shareButton=itemView.findViewById(R.id.share_button);
//            itemView.setOnClickListener(this);

            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    NewsPost post;
                    Log.v("NewsFeedAdapter","user clicked like or dislike button");

                    post= newsPosts.get(getAdapterPosition());
                    //   currLikes=post.getLikes()+1;
                    //    post.setLikes(currLikes);

                    post.likePost(true);
                    accessNewsFeed.updateLike(post);
                    accessNewsFeed.updateDislike(post);

                    dislikeCounter.setText(String.format("%s%s", post.getDislikes(), PEOPLE_DISLIKE_LIKE_THIS));
                    likeCounter.setText(String.format("%s%s", post.getLikes(), PEOPLE_LIKE_THIS));

                    // likeCounter.setText(Integer.toString(currLikes)+PEOPLE_LIKE_THIS);

                    boolean currLike = likeButton.getText().equals("Like");
                    if (currLike)
                        likeButton.setText("Liked");
                    else
                        likeButton.setText("Like");
                    dislikeButton.setText("dislike");


                }
            });
            dislikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsPost post;
                    int currLikes;
                    post= newsPosts.get(getAdapterPosition());
                    post.likePost(false);
                    accessNewsFeed.updateLike(post);
                    accessNewsFeed.updateDislike(post);
                  //  currLikes=post.getLikes()+1;
                //    post.setLikes(currLikes);


                    likeCounter.setText(String.format(Locale.CANADA,"%d%s", post.getLikes(), PEOPLE_LIKE_THIS));
                    dislikeCounter.setText(String.format(Locale.CANADA,"%d%s", post.getDislikes(), PEOPLE_DISLIKE_LIKE_THIS));

                  //  likeButton.setEnabled(false);
                    if(dislikeButton.getText().equals("dislike")  && post.isDisliked())
                        dislikeButton.setText("disliked");
                    else
                        dislikeButton.setText("dislike");
                    likeButton.setText("Like");

                }
            });
            commentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Get Current post.
                    NewsPost post= newsPosts.get(getAdapterPosition());
                    // Get user input, then create and add comment to DB.
                    String comment=commentInput.getText().toString();
                    Comment addMe = new Comment(post.getPostID(),post.getTitle(),comment);

                    accessComments.addComment(addMe);
                 //   commentList.add(addMe);
                  //  commentList=accessComments.getComments(post.getPostID());

                    commentsAdapter.notifyDataSetChanged();
                    notifyDataSetChanged();
                    commentInput.setText("");

                }
            });

        }


//        @Override
//        public void onClick(View v) {
//            listener.onClick(v,getAdapterPosition());
//        }
    }

}
