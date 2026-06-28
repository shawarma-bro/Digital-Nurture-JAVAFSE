package command;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.pressButton(lightOn);
        remote.pressButton(lightOff);

        System.out.println("Pressing undo:");
        remote.pressUndo();
    }
}
