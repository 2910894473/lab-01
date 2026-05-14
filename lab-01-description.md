# CMPUT 301 F26 - Lab 1: Java, OOP, and Android Studio!

## 1. Setup Instructions

1. Download and install Android Studio from the [official Android website](https://developer.android.com/studio).

2. Refer to the [installation guide](https://developer.android.com/studio/install) unique to your Operating System.

3. Refer to the lab 1 slides for information about how the labs will work.

## 2. Walkthrough

1. Create a new `PetShop` project on Android Studio (File > New > New Project > Select "Empty Views Activity").

    > [!WARNING]
    > Make sure that the project language is **Kotlin**, not Java!

2. Create a new `Pet` class by navigating to File > New > Kotlin Class/File
3. Create a primary constructor for the `Pet` class, with the following attributes:
    - `String name`
    - `Int age`
<br></br>
   
    ```kotlin
    class Pet(name: String, age: Int) { }
    ```
   
    > Use Alt + Enter (Windows) or Option + Return (Mac) to import any packages

    > [!IMPORTANT]
    > Access modifiers:
    > - `public` : universal access
    > - `private` : class-only access
    > - `protected` : package and inheritance access
    > - `No modifier` : public by default in Kotlin

5. Instantiate a `Pet` in MainActivity by passing in `String name` and `Int age` arguments:

    > For example:
    ```kotlin
    val pet = Pet("Coco", 6)
    ```

6. Create a `Cat` child class that extends the `Pet` class.
    - Modify the ____
    - Include a `super()` call in Cat's constructors.
    - `Cat` inherits `Pet`'s methods and attributes, but requires its own constructors. Try to call `super()` in the child's constructor:

    ```java
    public Cat(String name) {
         super(name);
    }
    ```

    - `super()` calls the parent's constructor (there is a hidden call to Object's constructor).

8. Make the Pet Class Abstract

    - Change the `Pet` class declaration to the following:
    ```java
    public abstract class Pet { ... }
    ```

    > [!NOTE]
    > Abstract classes cannot be instantiated directly - they can only be used as base classes for inheritance. You must create concrete subclasses to create objects.

    - Change the `Pet` to a `Cat` in MainActivity.

    ```java
    Cat cat = new Cat("Lucy");
    ```

    - Add an abstract method for speaking in the `Pet` class. It has no implementation and must be overridden by a child classes to add functionality.

    ```java
    public abstract String speak();
    ```

    > [!NOTE]
    > Abstract methods have no implementation and cannot be called directly. They must be overridden by concrete subclasses before they can be used through objects of those subclasses.

9. Method Overriding

    - `Cat` must override the abstract `speak()` method from `Pet` class.
    - The `@Override` annotation ensures correct method overriding at compile-time.
    - Each child class can implement `speak()` differently based on its needs.

    ```java
    // In Cat class
    @Override
    public String speak() {
      return "meow"; // Cats meow
    }
    ```

10. Make a `Dog` subclass of `Pet`

    - call `super()` in both of Dog's constructors.
    - `speak()` method should return `"bark"`.
    - What if we want to use both in our list? (hint - implicit upcasting)
    - Add the following to `MainActivity`:

    ```java
    Dog dog = new Dog("Snoopy");
    ArrayList<Pet> petList = new ArrayList<Pet>();

    // Can store both Cat and Dog objects
    // since they both inherit from Pet
    petList.add(cat);
    petList.add(dog);
    ```

11. Make a `Scorpion` subclass of `Pet`

    - call `super()` in both of Scorpion's constructors.
    - `speak()` method should return `"hiss"`.
    - What if we want to use both in our list? (hint - implicit upcasting)
    - Add the following to `MainActivity`:

    ```java
    Scorpion scorpion = new Scorpion("Scorponok");
    petList.add(scorpion);
    ```

12. Interface Implementation

    - Abstract method and base class so all the classes have the `speak()` method.
    - An interface can also be used to force the use of some methods.

    ```java
    public interface Pettable {
      public void pet();
    }
    ```
   
    - `Pet` should not implement `Pettable` because `Scorpion` should not be pettable
    - Make `Cat` and `Dog` classes implement `Pettable` class.
    - All classes that implement this interface must provide implementations for these methods.

    ```java
    ArrayList<Pettable> pettablePets = new ArrayList<Pettable>();
    pettablePets.add(cat);
    pettablePets.add(dog);
    pettablePets.add(scorpion); // This should produce an error
    ```

## 3. Lab Participation Exercise

1. Add three new model classes to `PetShop`:
   - An abstract base class which represents the current `Mood`.
   - Two non-abstract classes which represent different moods (Ex: happy, sad, etc.) and inherit from the abstract class.
2. Each mood should have a date, and getters and setters to access the date.
3. Provide two constructors:
   - One that sets the date to a default
   - One that takes a date as an argument
4. Follow proper encapsulation principles.
5. Each mood should have a method which returns a string representing that mood.
6. Your new code should demonstrate:
   - Classes
   - Methods
   - Attributes
   - Access modifiers
   - Encapsulation
   - Constructors
   - Inheritance
   - Abstract base classes
7. Update the `README.md` file with your details and references/collaborators.
8. Update the `LICENSE.md` file with your full name.

> [!CAUTION]
> Make sure to commit **and** push your code to the GitHub repository before the deadline!
