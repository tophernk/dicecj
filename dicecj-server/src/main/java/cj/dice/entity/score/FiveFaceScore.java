package cj.dice.entity.score;

import javax.persistence.Entity;

@Entity
public class FiveFaceScore extends FaceValueOfAKindScore {

    public FiveFaceScore() {
        super("Fives");
    }

    @Override
    public int getFaceValue() {
        return 5;
    }
}
