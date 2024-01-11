import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete subject
class ConcreteSubject implements Subject {
    private int state;
    private List<Observer> observers = new ArrayList<>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Observer interface
interface Observer {
    void update();
}

// Concrete observer
class ConcreteObserver implements Observer {
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("State updated: " + subject.getState());
    }
}

// Main class to demonstrate the Observer pattern
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        // Initial state
        System.out.println("Initial state: " + subject.getState());

        // Update the state, and observers will be notified
        subject.setState(10);
    }
}
