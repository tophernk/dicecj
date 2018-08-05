package cj.dice.command;

import cj.dice.InputException;
import cj.dice.service.TurnState;

public class CancelCommand implements InputCommand {

    private Promptable baseCommand;

    public CancelCommand(Promptable baseCommand) {
        this.baseCommand = baseCommand;
    }
    @Override
    public void execute(String userInput, TurnState turnState) throws InputException {
        String userInputFromPrompt = baseCommand.prompt(turnState.getScoreboard(), turnState.getDice());
        if (userInputFromPrompt.equals("c")) {
            throw new InputException("command has been canceled");
        }
        baseCommand.execute(userInputFromPrompt, turnState);
    }

    @Override
    public boolean isTurnEndCommand() {
        return baseCommand.isTurnEndCommand();
    }

    @Override
    public boolean isTrigger(String userInput) {
        return baseCommand.isTrigger(userInput);
    }

    @Override
    public String retrieveInstructions() {
        return baseCommand.retrieveInstructions() + " [cancelable]";
    }

    @Override
    public boolean isRoll() {
        return baseCommand.isRoll();
    }

}
