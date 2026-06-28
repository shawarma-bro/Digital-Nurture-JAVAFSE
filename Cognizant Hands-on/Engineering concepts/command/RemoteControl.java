package command;

public class RemoteControl {
    Command lastCommand;

    public void pressButton(Command command) {
        command.execute();
        lastCommand = command;
    }

    public void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}
