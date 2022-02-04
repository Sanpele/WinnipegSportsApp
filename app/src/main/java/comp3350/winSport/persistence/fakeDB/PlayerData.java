package comp3350.winSport.persistence.fakeDB;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Player;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.IPlayer;

public class PlayerData implements IPlayer {

    List<Player> players1;
    List<Player> players2;
    List<Player> players3;
    List<Player> players4;
    List<Player> players5;
    List<Player> players6;

    List<Player> allPlayer;
    List<List<Player>> allTeam;


    public PlayerData() {
        players1 = new ArrayList<>();
        players2 = new ArrayList<>();
        players3 = new ArrayList<>();
        players4 = new ArrayList<>();
        players5 = new ArrayList<>();
        players6 = new ArrayList<>();

        allPlayer = new ArrayList<>();
        allTeam = new ArrayList<>();
        initData();
    }

    public void initData() {

        Player p1 = new Player("Mark Scheifele", 55, "Centerman","Winnipeg Jets", R.drawable.jets);
        Player p2 = new Player("Kyle Connor", 81, "Left Wing","Winnipeg Jets", R.drawable.jets);
        Player p3 = new Player("Neal Pionk", 4, "Defenseman","Winnipeg Jets", R.drawable.jets);
        Player p4 = new Player("Blake Wheeler(C)", 26, "Right wing","Winnipeg Jets", R.drawable.jets);
        Player p5 = new Player("Mason Appleton", 22, "Right wing","Winnipeg Jets", R.drawable.jets);
        Player p6 = new Player("Nickolaj Ehlers", 27, "Right wing","Winnipeg Jets", R.drawable.jets);
        Player p7 = new Player("Adam Lowry", 17, "Centerman","Winnipeg Jets", R.drawable.jets);
        Player p8 = new Player("Josh Morrissey", 44, "Defenseman","Winnipeg Jets", R.drawable.jets);
        Player p9 = new Player("Mathieu Perreault", 85, "Left wing","Winnipeg Jets", R.drawable.jets);
        Player p10 = new Player("Paul Stastny", 25, "Centerman","Winnipeg Jets", R.drawable.jets);
        Player p11 = new Player("Nathan Beaulieu", 88, "Defensemen","Winnipeg Jets", R.drawable.jets);
        Player p12 = new Player("Andrew Copp", 9, "Left wing","Winnipeg Jets", R.drawable.jets);
        Player p13 = new Player("Dylan DeMelo", 2, "Defenseman","Winnipeg Jets", R.drawable.jets);
        Player p14 = new Player("Derek Forbort", 24, "Defenseman","Winnipeg Jets", R.drawable.jets);
        Player p15 = new Player("Jansen Harkins", 12, "Centerman","Winnipeg Jets", R.drawable.jets);
        Player p16 = new Player("Connor Hellebuyck", 1, "Goaltender","Winnipeg Jets", R.drawable.jets);
        Player p17 = new Player("Trevor Lewis", 23, "Right wing","Winnipeg Jets", R.drawable.jets);
        Player p18 = new Player("Tucker Poolman", 3, "Defenseman","Winnipeg Jets", R.drawable.jets);
        Player p19 = new Player("Kristian Vesalainen", 93, "Left wing","Winnipeg Jets", R.drawable.jets);


        players1 = new ArrayList<>();
        players1.add(p1);
        players1.add(p2);
        players1.add(p3);
        players1.add(p4);
        players1.add(p5);
        players1.add(p6);
        players1.add(p7);
        players1.add(p8);
        players1.add(p9);
        players1.add(p10);
        players1.add(p11);
        players1.add(p12);
        players1.add(p13);
        players1.add(p14);
        players1.add(p15);
        players1.add(p16);
        players1.add(p17);
        players1.add(p18);
        players1.add(p19);

        Player p20 = new Player("Auston Matthews", 34, "Centerman","Toronto Maple Leafs",R.drawable.leafs);
        Player p21 = new Player("Joe Thornton", 97, "Left wing","Toronto Maple Leafs",R.drawable.leafs);
        Player p22 = new Player("Travis Boyd", 72, "Right wing","Toronto Maple Leafs",R.drawable.leafs);
        Player p23 = new Player("T. J. Brodie", 78, "Defenseman","Toronto Maple Leafs",R.drawable.leafs);
        Player p24 = new Player("Pierre Engvall", 47, "Right wing","Toronto Maple Leafs",R.drawable.leafs);
        Player p25 = new Player("Alexander Kerfoot", 15, "Centerman","Toronto Maple Leafs",R.drawable.leafs);
        Player p26 = new Player("Mitch Marner", 16, "Right wing","Toronto Maple Leafs",R.drawable.leafs);
        Player p27 = new Player("Morgan Rielly", 44, "Defenseman","Toronto Maple Leafs",R.drawable.leafs);
        Player p28 = new Player("Jason Spezza", 19, "Centerman","Toronto Maple Leafs",R.drawable.leafs);
        Player p29 = new Player("John Tavares", 91, "Centerman","Toronto Maple Leafs",R.drawable.leafs);
        Player p30 = new Player("Frederik Andersen", 31, "Goaltender","Toronto Maple Leafs",R.drawable.leafs);
        Player p31 = new Player("Zach Bogosian", 22, "Defenseman","Toronto Maple Leafs",R.drawable.leafs);
        Player p32 = new Player("Travis Dermott", 23, "Defenseman","Toronto Maple Leafs",R.drawable.leafs);
        Player p33 = new Player("Justin Holl", 3, "Defenseman","Toronto Maple Leafs",R.drawable.leafs);
        Player p34 = new Player("Zach Hyman", 11, "Left wing","Toronto Maple Leafs",R.drawable.leafs);
        Player p35 = new Player("Jake Muzzin", 8, "Defenseman","Toronto Maple Leafs",R.drawable.leafs);
        Player p36 = new Player("William Nylander", 88, "Left wing","Toronto Maple Leafs",R.drawable.leafs);
        Player p37 = new Player("Jimmy Vesey", 26, "Right wing","Toronto Maple Leafs",R.drawable.leafs);


        players2 = new ArrayList<>();
        players2.add(p20);
        players2.add(p21);
        players2.add(p22);
        players2.add(p23);
        players2.add(p24);
        players2.add(p25);
        players2.add(p26);
        players2.add(p27);
        players2.add(p28);
        players2.add(p29);
        players2.add(p30);
        players2.add(p31);
        players2.add(p32);
        players2.add(p33);
        players2.add(p34);
        players2.add(p35);
        players2.add(p36);
        players2.add(p37);

        Player p39 = new Player("Connor Brown", 28, "Right wing","Ottawa Senators",R.drawable.ottawa);
        Player p40 = new Player("Thomas Chabot", 72, "Defenseman","Ottawa Senators",R.drawable.ottawa);
        Player p41 = new Player("Evgenii Dadonov", 63, "Right wing","Ottawa Senators",R.drawable.ottawa);
        Player p42 = new Player("Nick Paul", 13, "Left wing","Ottawa Senators",R.drawable.ottawa);
        Player p43 = new Player("Drake Batherson", 19, "Right wing","Ottawa Senators",R.drawable.ottawa);
        Player p44 = new Player("Josh Norris", 9, "Centerman","Ottawa Senators",R.drawable.ottawa);
        Player p45 = new Player("Tim Stützle", 18, "Left wing","Ottawa Senators",R.drawable.ottawa);
        Player p46 = new Player("Chris Tierney", 71, "Centerman","Ottawa Senators",R.drawable.ottawa);
        Player p47 = new Player("Brady Tkachuk", 7, "Left wing","Ottawa Senators",R.drawable.ottawa);
        Player p48 = new Player("Austin Watson", 16, "Right wing","Ottawa Senators",R.drawable.ottawa);
        Player p49 = new Player("Colin White", 36, "Centerman","Ottawa Senators",R.drawable.ottawa);
        Player p50 = new Player("Artyom Zub", 2, "Defenseman","Ottawa Senators",R.drawable.ottawa);
        Player p51 = new Player("Artem Anisimov", 51, "Centerman","Ottawa Senators",R.drawable.ottawa);
        Player p52 = new Player("Erik Gudbranson", 44, "Defenseman","Ottawa Senators",R.drawable.ottawa);
        Player p53 = new Player("Mark Högberg", 1, "Goaltender","Ottawa Senators",R.drawable.ottawa);
        Player p54 = new Player("Mike Reilly", 5, "Defenseman","Ottawa Senators",R.drawable.ottawa);
        Player p55 = new Player("Derek Stepan", 21, "Defenseman","Ottawa Senators",R.drawable.ottawa);
        Player p56 = new Player("Christian Wolanin", 24, "Defenseman","Ottawa Senators",R.drawable.ottawa);
        Player p57 = new Player("Nikita Zaitsev", 22, "Defenseman","Ottawa Senators",R.drawable.ottawa);


        players3 = new ArrayList<>();
        players3.add(p39);
        players3.add(p40);
        players3.add(p41);
        players3.add(p42);
        players3.add(p43);
        players3.add(p44);
        players3.add(p45);
        players3.add(p46);
        players3.add(p47);
        players3.add(p48);
        players3.add(p49);
        players3.add(p50);
        players3.add(p51);
        players3.add(p52);
        players3.add(p53);
        players3.add(p54);
        players3.add(p55);
        players3.add(p56);
        players3.add(p57);

        Player p58 = new Player("Tyson Barrie", 22, "Defenseman","Edmonton Oilers",R.drawable.oilers);
        Player p59 = new Player("Evan Bouchard", 75, "Defenseman","Edmonton Oilers",R.drawable.oilers);
        Player p60 = new Player("Alex Chiasson", 39, "Right wing","Edmonton Oilers",R.drawable.oilers);
        Player p61 = new Player("Connor McDavid", 97, "Centerman","Edmonton Oilers",R.drawable.oilers);
        Player p62 = new Player("Ryan Nugent-Hopkins", 93, "Left wing","Edmonton Oilers",R.drawable.oilers);
        Player p63 = new Player("Tyler Ennis", 63, "Left wing","Edmonton Oilers",R.drawable.oilers);
        Player p64 = new Player("Darnel Nurse", 25, "Defenseman","Edmonton Oilers",R.drawable.oilers);
        Player p65 = new Player("Jesse Puljujärvi", 13, "Right wing","Edmonton Oilers",R.drawable.oilers);
        Player p66 = new Player("Delvin Shore", 14, "Left wing","Edmonton Oilers",R.drawable.oilers);
        Player p67 = new Player("Kailer Yamamoto", 56, "Right wing","Edmonton Oilers",R.drawable.oilers);
        Player p68 = new Player("Josh Archibald", 15, "Right wing","Edmonton Oilers",R.drawable.oilers);
        Player p69 = new Player("Leon Draisaitl", 29, "Centerman","Edmonton Oilers",R.drawable.oilers);
        Player p70 = new Player("Dominik Kahun", 21, "Left wing","Edmonton Oilers",R.drawable.oilers);
        Player p71 = new Player("Jujhar Khaira", 16, "Centerman","Edmonton Oilers",R.drawable.oilers);
        Player p72 = new Player("Slater Koekkoek", 20, "Defenseman","Edmonton Oilers",R.drawable.oilers);
        Player p73 = new Player("Mikko Koskinen", 19, "Goaltender","Edmonton Oilers",R.drawable.oilers);
        Player p74 = new Player("William Lagesson", 84, "Goaltender","Edmonton Oilers",R.drawable.oilers);
        Player p75 = new Player("Adam Larson", 6, "Defenseman","Edmonton Oilers",R.drawable.oilers);
        Player p76 = new Player("Mike Smith", 41, "Goaltender","Edmonton Oilers",R.drawable.oilers);
        Player p77 = new Player("Kyle Turris", 8, "Centerman","Edmonton Oilers",R.drawable.oilers);

        players4 = new ArrayList<>();
        players4.add(p58);
        players4.add(p59);
        players4.add(p60);
        players4.add(p61);
        players4.add(p62);
        players4.add(p63);
        players4.add(p64);
        players4.add(p65);
        players4.add(p66);
        players4.add(p67);
        players4.add(p68);
        players4.add(p69);
        players4.add(p70);
        players4.add(p71);
        players4.add(p72);
        players4.add(p73);
        players4.add(p74);
        players4.add(p75);
        players4.add(p76);
        players4.add(p77);

        Player p78 = new Player("Rasmus Anderson", 4, "Defenseman","Calgary Flames",R.drawable.flames);
        Player p79 = new Player("Elias Lindholm", 28, "Centerman","Calgary Flames",R.drawable.flames);
        Player p80 = new Player("Dillon Dube", 29, "Centerman","Calgary Flames",R.drawable.flames);
        Player p81 = new Player("Johnny Gaudreau", 13, "Left wing","Calgary Flames",R.drawable.flames);
        Player p82 = new Player("Milan Lucic", 17, "Left wing","Calgary Flames",R.drawable.flames);
        Player p83 = new Player("Connor Mackey", 3, "Defenseman","Calgary Flames",R.drawable.flames);
        Player p84 = new Player("Sean Monahan", 23, "Centerman","Calgary Flames",R.drawable.flames);
        Player p85 = new Player("Sam Bennett", 93, "Left wing","Calgary Flames",R.drawable.flames);
        Player p86 = new Player("Byron Froese", 38, "Centerman","Calgary Flames",R.drawable.flames);
        Player p87 = new Player("Mark Giordano", 5, "Defenseman","Calgary Flames",R.drawable.flames);
        Player p88 = new Player("Noah Hanifin", 55, "Defenseman","Calgary Flames",R.drawable.flames);
        Player p89 = new Player("Andrew Mangiapane", 88, "Left wing","Calgary Flames",R.drawable.flames);
        Player p90 = new Player("Jacob Markström", 25, "Goaltender","Calgary Flames",R.drawable.flames);
        Player p91 = new Player("Jokaim Nordström", 20, "Left wing","Calgary Flames",R.drawable.flames);
        Player p92 = new Player("Buddy Robinson", 53, "Right wing","Calgary Flames",R.drawable.flames);
        Player p93 = new Player("Dominik Simon", 81, "Right wing","Calgary Flames",R.drawable.flames);
        Player p94 = new Player("Christopher Tanev", 8, "Defenseman","Calgary Flames",R.drawable.flames);
        Player p95 = new Player("Matthew Tkatchuk", 19, "Right wing","Calgary Flames",R.drawable.flames);
        Player p96 = new Player("Juuso Välimäki", 6, "Defenseman","Calgary Flames",R.drawable.flames);


        players5 = new ArrayList<>();
        players5.add(p78);
        players5.add(p79);
        players5.add(p80);
        players5.add(p81);
        players5.add(p82);
        players5.add(p83);
        players5.add(p84);
        players5.add(p85);
        players5.add(p86);
        players5.add(p87);
        players5.add(p88);
        players5.add(p89);
        players5.add(p90);
        players5.add(p91);
        players5.add(p92);
        players5.add(p93);
        players5.add(p94);
        players5.add(p95);
        players5.add(p96);

        Player p97 = new Player("Brendan Gallagher", 11, "Right wing","Montreal Canadiens",R.drawable.montreal);
        Player p98 = new Player("Tyler Toffoli", 73, "Left wing","Montreal Canadiens",R.drawable.montreal);
        Player p99 = new Player("Phillip Danault", 24, "Centerman","Montreal Canadiens",R.drawable.montreal);
        Player p100 = new Player("Jeff Petry", 26, "Defenseman","Montreal Canadiens",R.drawable.montreal);
        Player p101 = new Player("Josh Anderson", 17, "Right wing","Montreal Canadiens",R.drawable.montreal);
        Player p102 = new Player("Joel Armia", 40, "Left wing","Montreal Canadiens",R.drawable.montreal);
        Player p103= new Player("Paul Byron", 41, "Left wing","Montreal Canadiens",R.drawable.montreal);
        Player p104 = new Player("Ben Chiarot", 8, "Defenseman","Montreal Canadiens",R.drawable.montreal);
        Player p105 = new Player("Jonathan Drouin", 92, "Left wing","Montreal Canadiens",R.drawable.montreal);
        Player p106= new Player("Joel Edmundson", 44, "Defenseman","Montreal Canadiens",R.drawable.montreal);
        Player p107 = new Player("Jake Evans", 71, "Centerman","Montreal Canadiens",R.drawable.montreal);
        Player p108 = new Player("Jesperi Kotkaniemi", 15, "Centerman","Montreal Canadiens",R.drawable.montreal);
        Player p109 = new Player("Arturri Lehkonen", 62, "Left wing","Montreal Canadiens",R.drawable.montreal);
        Player p110 = new Player("Victor Mete", 53, "Defenseman","Montreal Canadiens",R.drawable.montreal);
        Player p111 = new Player("Corey Perry", 94, "Right wing","Montreal Canadiens",R.drawable.montreal);
        Player p112 = new Player("Carey Price", 81, "Goaltender","Montreal Canadiens",R.drawable.montreal);
        Player p113 = new Player("Alexander Romanov", 27, "Defenseman","Montreal Canadiens",R.drawable.montreal);
        Player p114 = new Player("Nick Suzuki", 14, "Centerman","Montreal Canadiens",R.drawable.montreal);
        Player p115 = new Player("Shea Weber", 6, "Defenseman","Montreal Canadiens",R.drawable.montreal);


        players6 = new ArrayList<>();
        players6.add(p97);
        players6.add(p98);
        players6.add(p99);
        players6.add(p100);
        players6.add(p101);
        players6.add(p102);
        players6.add(p103);
        players6.add(p104);
        players6.add(p105);
        players6.add(p106);
        players6.add(p107);
        players6.add(p108);
        players6.add(p109);
        players6.add(p110);
        players6.add(p111);
        players6.add(p112);
        players6.add(p113);
        players6.add(p114);
        players6.add(p115);

        allPlayer.addAll(players1);
        allPlayer.addAll(players2);
        allPlayer.addAll(players3);
        allPlayer.addAll(players4);
        allPlayer.addAll(players5);
        allPlayer.addAll(players6);

        allTeam.add(players1);
        allTeam.add(players2);
        allTeam.add(players3);
        allTeam.add(players4);
        allTeam.add(players5);
        allTeam.add(players6);

        for (Player curr : allPlayer)
            curr.setPlayerPic(R.drawable.headshot);

    }

    @Override
    public List<Player> getPlayers(String teamName) {
        List<Player> result=new ArrayList<>();

        for (List<Player> curr : allTeam) {
            if (curr.get(0).getTeam().equals(teamName))
                return curr;
        }

        return result;
    }

    @Override
    public List<Player> getAllPlayers() {
        return allPlayer;
    }

}
