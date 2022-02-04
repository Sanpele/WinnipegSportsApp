package comp3350.winSport.business;

import java.util.HashMap;

import comp3350.winSport.R;

public class PictureChecker {

    private HashMap<String, Integer> picIds;


    public PictureChecker() {
        picIds = new HashMap<>();
        initHash();
    }

    private void initHash() {

        picIds.put("Calgary Flames", R.drawable.flames);
        picIds.put("Winnipeg Jets", R.drawable.jets);
        picIds.put("Montreal Canadiens", R.drawable.montreal);
        picIds.put("Ottawa Senators", R.drawable.ottawa);
        picIds.put("Toronto Maple Leafs", R.drawable.leafs);
        picIds.put("Edmonton Oilers", R.drawable.oilers);

    }

    public int getPic(String name) {
        if (picIds.containsKey(name))
            return picIds.get(name);
        else
            return R.drawable.nhl;
    }



}
