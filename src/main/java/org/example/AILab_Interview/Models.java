package org.example.AILab_Interview;

// Step 1: Interface for all vehicles
interface Vehicle {
    void start();
    void stop();
    String getFuelType();  // Diesel, Gasoline, Electric
}

// Step 2: Abstract class for common car properties
abstract class AbstractCar implements Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public AbstractCar(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println(brand + " " + model + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(brand + " " + model + " is stopping...");
    }

    // Abstract method forces subclasses to define their own fuel type
    public abstract String getFuelType();
}

// Step 3: Concrete class for normal Car (extends AbstractCar)
class Car extends AbstractCar {
    public Car(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public String getFuelType() {
        return "Gasoline";
    }
}

// Step 4: Concrete class for ElectricCar (extends AbstractCar)
class ElectricCar extends AbstractCar {
    public ElectricCar(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public String getFuelType() {
        return "Electric";
    }
}

// Step 5: Concrete class for Truck (directly implements Vehicle, because it's not a car)
class Truck implements Vehicle {
    private String brand;
    private String model;
    private int capacity;

    public Truck(String brand, String model, int capacity) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println(brand + " " + model + " Truck is starting...");
    }

    @Override
    public void stop() {
        System.out.println(brand + " " + model + " Truck is stopping...");
    }

    @Override
    public String getFuelType() {
        return "Diesel";
    }
}

// Step 6: Concrete class for Motorcycle (directly implements Vehicle)
class Motorcycle implements Vehicle {
    private String brand;
    private String model;

    public Motorcycle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(brand + " " + model + " Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println(brand + " " + model + " Motorcycle is stopping...");
    }

    @Override
    public String getFuelType() {
        return "Gasoline";
    }
}

// Step 7: Test class
public class Models {
    public static void main(String[] args) {
        Vehicle myCar = new Car("Toyota", "Camry", 2023);
        Vehicle myElectricCar = new ElectricCar("Tesla", "Model S", 2023);
        Vehicle myTruck = new Truck("Volvo", "FH16", 30000);
        Vehicle myMotorcycle = new Motorcycle("Yamaha", "YZF-R1");

        myCar.start();
        System.out.println("Fuel Type: " + myCar.getFuelType());

        myElectricCar.start();
        System.out.println("Fuel Type: " + myElectricCar.getFuelType());

        myTruck.start();
        System.out.println("Fuel Type: " + myTruck.getFuelType());

        myMotorcycle.start();
        System.out.println("Fuel Type: " + myMotorcycle.getFuelType());


        // ### **SOLID & OOP Principles Used**
        //
        //1️⃣ **Single Responsibility Principle (SRP)**
        //   - Each class has **one responsibility** (e.g., `Car`, `Truck`, `Motorcycle` each define a specific vehicle type).
        //
        //2️⃣ **Open/Closed Principle (OCP)**
        //   - New vehicle types (e.g., `Bus`, `SUV`) can be added **without modifying existing code**—just implement `Vehicle` or extend `AbstractCar`.
        //
        //3️⃣ **Liskov Substitution Principle (LSP)**
        //   - Any `AbstractCar` (like `Car`, `ElectricCar`) or `Vehicle` (like `Truck`, `Motorcycle`) **can be replaced** by their subclasses without breaking functionality.
        //
        //4️⃣ **Interface Segregation Principle (ISP)**
        //   - `Vehicle` interface contains only **essential methods** (`start()`, `stop()`, `getFuelType()`), ensuring **no unnecessary methods** for any class.
        //
        //5️⃣ **Dependency Inversion Principle (DIP)**
        //   - High-level code (`VehicleTest`) depends on **abstraction (`Vehicle`)**, not concrete implementations (`Car`, `Truck`).
        //
        //### **OOP Principles Used**
        //
        //✔ **Encapsulation**
        //   - Private fields (`brand`, `model`, `year`) protect data, and behavior is provided via public methods.
        //
        //✔ **Abstraction**
        //   - `AbstractCar` provides **common functionality** while allowing subclasses to define their own `getFuelType()`.
        //
        //✔ **Polymorphism**
        //   - `Vehicle myCar = new Car("Toyota", "Camry", 2023);`
        //   - The same interface (`Vehicle`) is used for different objects (`Car`, `ElectricCar`, `Truck`, etc.).
        //
        //✔ **Inheritance**
        //   - `Car` and `ElectricCar` inherit from `AbstractCar`, reusing shared logic.
        //
        //This design follows **clean, scalable, and maintainable** OOP architecture! 🚀
    }
}

