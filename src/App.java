import military.Military;
import military.MilitaryMan;
import military.Rank;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Military general = new MilitaryMan(Rank.GENERAL);

        for (int i = 0; i < 2; i++) {
            Military colonel = new MilitaryMan(Rank.COLONEL);
            general.receiveSubordinate(colonel);
            for (int j = 0; j < 2; j++) {
                Military major = new MilitaryMan(Rank.MAJOR);
                colonel.receiveSubordinate(major);
                for (int k = 0; k < 2; k++) {
                    Military sergeant = new MilitaryMan(Rank.SERGEANT);
                    major.receiveSubordinate(sergeant);
                    for (int m = 0; m < 2; m++) {
                        Military soldier = new MilitaryMan(Rank.SOLDIER);
                        sergeant.receiveSubordinate(soldier);
                    }
                }
            }
        }

        System.out.println("\ngeneral orders Go to War");
        general.order("GO TO WAR!!!");
        System.out.println("");

        Military colonel = general.getSubject(1);
        if (colonel != null) {
            System.out.println("\ncolonel receive order from colonel: Let's go drink!");
            colonel.perform(Rank.COLONEL, "Let's go drink!");
            System.out.println("\ncolonel receive order from major: Get out from my band!");
            colonel.perform(Rank.MAJOR, "Get out from my band!");

            Military major = colonel.getSubject(0);
            if (major != null) {
                Military sergeant = major.getSubject(0);
                if (sergeant != null) {
                    System.out.println("\nsergeant receive order from major: Beat your dumb head to wall!");
                    sergeant.perform(Rank.COLONEL, "Beat your dumb head to wall!");
                }
            }
        }

        List<Military> all = getAllSubj(general);
        System.out.println("all.size() = " + all.size());
        for (Military military : all) {
            System.out.println(military);
        }

        System.out.println("general.bandSize() = " + general.bandSize());

    }

    private static List<Military> getAllSubj(Military first) {
        List<Military> result = new ArrayList<>();
        result.add(first);
        for (Military m : first.getBand()) {
            result.addAll(getAllSubj(m));
        }
        return result;
    }
}
