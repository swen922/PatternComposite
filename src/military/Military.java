package military;

import java.util.List;

public interface Military {
    public void order(String order);
    public void perform(Rank orderedRank, String order);
    public void receiveSubordinate(Military subordinate);
    public Military getSubject(int number);
}
