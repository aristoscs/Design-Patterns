// Component interface
interface Coffee {
    double cost();
    String description();
}

// Concrete component
class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

// Decorator abstract class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}

// Concrete decorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        return super.description() + ", with Milk";
    }
}

// Another concrete decorator
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.2;
    }

    @Override
    public String description() {
        return super.description() + ", with Sugar";
    }
}

// Main class to demonstrate the Decorator pattern
public class Main {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: " + simpleCoffee.cost() + ", Description: " + simpleCoffee.description());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: " + milkCoffee.cost() + ", Description: " + milkCoffee.description());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: " + sugarMilkCoffee.cost() + ", Description: " + sugarMilkCoffee.description());
    }
}
