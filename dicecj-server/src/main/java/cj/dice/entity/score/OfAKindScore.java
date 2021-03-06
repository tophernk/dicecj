package cj.dice.entity.score;

import cj.dice.entity.Die;

import javax.persistence.Entity;
import java.util.List;

@Entity
public abstract class OfAKindScore extends Score {

    public abstract int calculateValue(List<Die> dice);

    public abstract int getCount();

    @Override
    public int evaluate(List<Die> dice) {
        for (Die die : dice) {
            if(count(dice, die.getValue()) >= getCount()) {
                return calculateValue(dice);
            }
        }
        return 0;
    }

    private long count(List<Die> dice, int value) {
        return dice.stream().filter(d -> d.getValue() == value).count();
    }
}
