package cj;

import java.util.List;

public interface InputCommand {

    public void execute(Scoreboard scoreboard, List<Die> dice, String userInput) throws InputException;

    public boolean isTurnEndCommand();

    public boolean isExecutable(String userInput, int numberOfRolls);

    public String retrieveInstructions();

    public boolean isRoll();
}
