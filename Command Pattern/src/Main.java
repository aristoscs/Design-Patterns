// Command interface
interface Command {
    void execute();
}

// Concrete command
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete command
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Receiver
        Light light = new Light();

        // Concrete commands
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // Invoker
        RemoteControl remoteControl = new RemoteControl();

        // Set and execute the ON command
        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();

        // Set and execute the OFF command
        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();
    }
}
