public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck(new NoQuack());
        duck.quack();
    }
}

interface IQuack {
    void quack();
}

class Quack implements IQuack {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}

class NoQuack implements IQuack {

    @Override
    public void quack() {
        System.out.println("No Quack");
    }
}

class Duck implements IQuack{

     IQuack qb;

    @Override
    public void quack() {
        this.qb.quack();
    }

    public Duck(IQuack qb) {
        this.qb = qb;
     }

}
