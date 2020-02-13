import military.Military;
import military.MilitaryMan;
import military.Rank;

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

        general.order("GO TO WAR!!!");
        System.out.println("");

        Military colonel = general.getSubject(1);
        if (colonel != null) {
            colonel.perform(Rank.COLONEL, "Let's go drink!");
            colonel.perform(Rank.MAJOR, "Get out from my band!");

            Military major = colonel.getSubject(0);
            if (major != null) {
                Military sergeant = major.getSubject(0);
                if (sergeant != null) {
                    sergeant.perform(Rank.COLONEL, "Beat your dumb head to wall!");
                }
            }
        }

    }
}
