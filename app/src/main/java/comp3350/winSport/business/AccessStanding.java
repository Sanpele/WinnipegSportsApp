package comp3350.winSport.business;

import java.util.List;

import comp3350.winSport.application.Services;
import comp3350.winSport.objects.Standing;
import comp3350.winSport.persistence.IStanding;

public class AccessStanding {

    /*
        Business class standing object.
        Not too much logic goes on here.
        The standing objects are returend in order, then assigned a logo if they don't have one.
     */

    private IStanding iStanding;
    private List<Standing> standingList;
    private PictureChecker pc;

    public AccessStanding() {
        this.iStanding = Services.getStandingPersistance();
        this.standingList = null;
        this.pc = new PictureChecker();
    }

    public AccessStanding(final IStanding standingInterface) {
        this.iStanding = standingInterface;
        this.standingList = null;
        this.pc = new PictureChecker();
    }

    public List<Standing> getStandingInOrder() {
        standingList = iStanding.getStandingsInOrder();
        setPics();
        return standingList;
    }

    private void setPics() {
        for (Standing curr : standingList)
            if (curr.getTeamPic() == 0)
                curr.setTeamPic(pc.getPic(curr.getTeamName()));
    }

}
