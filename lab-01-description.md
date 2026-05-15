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
    class Pet(val name: String, var age: Int) 
    ```
   
    > Use Alt + Enter (Windows) or Option + Return (Mac) to import any packages

    > [!IMPORTANT]
    > Access modifiers:
    > - `public` : universal access
    > - `private` : class-only access
    > - `protected` : package and inheritance access
    > - `No modifier` : public by default in Kotlin
    >
    > Variable declaration:
    > - `val` : read-only
    > - `var` : read-write  

5. Instantiate a `Pet` in MainActivity by passing in `String name` and `Int age` arguments:

    > For example:
    ```kotlin
    val pet = Pet("Coco", 6)
    ```

6. Make a `Cat` subclass of `Pet`
    - Add the keyword `open` to the `Pet` class to allow inheritance and overriding
    ```kotlin
    open class Pet(name: String, age: Int)
    ```

    - Create a new `Cat` class by navigating to File > New > Kotlin Class/File
    - Create a `Cat` child class that extends the `Pet` class, defining the superclass constructor for `Cat`
    ```kotlin
    class Cat(name: String, age: Int): Pet(name, age) 
    ```

8. Make the Pet Class Abstract
    - Change the `Pet` class declaration to the following:
    ```kotlin
    abstract class Pet(val name: String, var age: Int)
    ```

    > [!NOTE]
    > Abstract classes cannot be instantiated directly - they can only be used as base classes for inheritance. You must create concrete subclasses to create objects.

    - Change the `Pet` to a `Cat` in MainActivity
    ```kotlin
    val pet = Cat("Coco", 6)
    ```

    - Add an abstract method for speaking in the `Pet` class. It has no implementation and must be overridden by a child class to add functionality
    ```kotlin
    abstract class Pet(val name: String, var age: Int) {
        abstract fun speak(): String
    }
    ```

    > [!NOTE]
    > Abstract methods have no implementation and cannot be called directly. They must be overridden by concrete subclasses before they can be used through objects of those subclasses.

9. Method Overriding
    - `Cat` must override the abstract `speak()` method from the `Pet` class, using the `override` keyword
    - Each child class can implement `speak()` differently based on its needs

    ```kotlin
    class Cat(name: String, age: Int): Pet(name, age) {
        override fun speak(): String {
            return "Meow"
        }
    }
    ```

10. Make a `Dog` subclass of `Pet`
    - This will be similar to what we did for the `Cat` subclass
    - `speak()` method should return `"bark"`
   
    ```kotlin
    class Dog(name: String, age: Int): Pet(name, age) {
        override fun speak(): String {
            return "bark"
        }
    }
    ```

    - Add an instantiation of `Dog` in MainActivity
    ```kotlin
    val dog = Dog("Mochi", 6)
    ```
    
    - How can we create a list of these pets in MainActivity? (Hint - implicit upcasting)
    ```kotlin
    val pets = mutableListOf<Pet>()
    pets.add(cat)
    pets.add(dog)
    ```
    OR
    ```kotlin
    val pets = mutableListOf(cat, dog)
    ```

11. Make a `Scorpion` subclass of `Pet`
    - `speak()` method should return `"hiss"`
    ```kotlin
    class Scorpion(name: String, age: Int): Pet(name, age) {
        override fun speak(): String {
            return "hiss"
        }
    }
    ```
    
    - Add scorpion to our list of Pets in MainActivity:
    - Add the following to `MainActivity`:
    ```kotlin
    pets.add(scorpion)
    ```

12. Interface Implementation
    - Abstract method and base class so all the classes have the `speak()` method
    - An interface can also be used to force the use of some methods
    ```kotlin
    interface Pettable {
        fun pet()
    }
    ```
   
    - `Pet` should not implement `Pettable` because `Scorpion` should not be pettable
    - Make `Cat` and `Dog` classes implement `Pettable` class
<br></br>
    > For example, for `Cat`:
    ```kotlin
    class Cat(name: String, age: Int): Pet(name, age), Pettable {
        ...
    }
    ```
    - All classes that implement this interface must provide implementations for these methods
<br></br>
    > For example, for `Cat`:
    ```kotlin
    override fun pet() {
        println("The cat $name is being petted")
    }
    ```

    - Let's create a list of our pettable pets in MainActivity
    ```kotlin
    val pettablePets = mutableListOf<Pettable>()
    pettablePets.add(cat)
    pettablePets.add(dog)
    pettablePets.add(scorpion) // should raise an error
    ```

## 3. Lab 1 Participation Exercise

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
