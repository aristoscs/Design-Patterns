// Product interface
interface Product {
    void create();
}

// Concrete product
class ConcreteProductA implements Product {
    @Override
    public void create() {
        System.out.println("Product A created");
    }
}

// Concrete product
class ConcreteProductB implements Product {
    @Override
    public void create() {
        System.out.println("Product B created");
    }
}

// Creator interface
interface Creator {
    Product factoryMethod();
}

// Concrete creator
class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

// Concrete creator
class ConcreteCreatorB implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Main class to demonstrate the Factory Method pattern
public class Main {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();
        productA.create();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();
        productB.create();
    }
}
