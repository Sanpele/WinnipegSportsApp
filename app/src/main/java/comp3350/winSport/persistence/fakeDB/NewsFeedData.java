package comp3350.winSport.persistence.fakeDB;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.NewsPost;
import comp3350.winSport.persistence.INewsFeed;

public class NewsFeedData implements INewsFeed {
    private List<NewsPost> newsPosts;
    public NewsFeedData()
    {
        newsPosts=new ArrayList<>();
        initData();
    }
    public  void  initData()
    {
        NewsPost post1= new NewsPost(1,"Jets Trade deadline","22/03/21",
                "Is cheveldayoff willing to spend on big target",60,8, R.drawable.trade_deadline);
        NewsPost post2= new NewsPost(2,"Jets top guns fire blanks","20/03/21",
                "Jets lose to Edmonton Oliers",30,5,R.drawable.oilers_jets);
        NewsPost post3= new NewsPost(3,"Its awards season for Cole Caufield","21/03/21",
                "Caufied become the first unanimous winner of big the ten player of the year's award",
                20,90,R.drawable.cole);
        newsPosts.add(post2);
        newsPosts.add(post3);
        newsPosts.add(post1);

    }


    @Override
    public List<NewsPost> getNewsPosts() {
        return newsPosts;
    }

    @Override
    public void updateLike(int id,int val) {
        for(NewsPost curr : newsPosts)
            if (curr.getPostID() == id)
                curr.setLikes(val);
    }

    @Override
    public void updateDislike(int id,int val) {
        for(NewsPost curr : newsPosts)
            if (curr.getPostID() == id)
                curr.setDislikes(val);
    }
}
