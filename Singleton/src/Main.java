class Main {
    
}

 class Singleton {

    // Private static instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside the class
    private Singleton() {
        // Initialization code, if needed
    }

    // Public method to provide the global point of access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            // Create the instance only if it doesn't exist yet
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods, if needed
    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }

    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singletonInstance = Singleton.getInstance();

        // Use the instance
        singletonInstance.doSomething();
    }
}
