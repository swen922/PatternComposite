package military;

import java.util.ArrayList;
import java.util.List;

public class MilitaryMan implements Military {

    private Rank myRank;
    private List<Military> band = new ArrayList<>();


    public MilitaryMan(Rank rank) {
        this.myRank = rank;
        System.out.println("My rank = " + myRank + ", my ordinal = " + myRank.ordinal());

    }


    @Override
    public void order(String order) {
        for (Military m : band) {
            m.perform(myRank, order);
        }
    }

    @Override
    public void perform(Rank orderedRank, String order) {

        if (orderedRank.compareTo(myRank) < 0) {
            StringBuilder sb = new StringBuilder("");
            for (int z = 0; z < myRank.ordinal(); z++) {
                sb.append("-");
            }
            System.out.println(sb.toString() + " Yes! Perform You Order, Sir! Order = " + order + "\nI'm " + myRank + "\n");
            order(order);
        }
        else if (orderedRank.compareTo(myRank) == 0) {
            System.out.println("Please show Your authority, Sir! You can't order me Yourself!\n");
        }
        else {
            System.out.println("You are crazy! 10 squeezings right now!\n");
        }
    }

    @Override
    public void receiveSubordinate(Military subordinate) {
        band.add(subordinate);
    }

    @Override
    public Military getSubject(int number) {
        if (number < band.size()) {
            return band.get(number);
        }
        return null;
    }

}
