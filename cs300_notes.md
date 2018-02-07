### **Debugging techniques**

Visual inspection

Print statements: check important values

Compartmentalize your code: test pieces independently

Test methods

Tracing: draw out paper what the code is doing

Eclipse debugging suggestions

Eclipse debug mode

Java visualizer 

### **Getting input**

##### User Input via Scanner

```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
sc.next()
```

Don't make more than one scanner

##### .delimitor()

```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.println(sc.delimitor());
sc.useDelimitor("a");
String userIn = sc.next();
System.out.println(userIn);
```

-------

### Storing Java Variables

Stack: variables

Heap: store anything where we don't know its size and anything with "new"

Primitive types: stored entirely in the stack

### Passing Arguments

java passess arguments to methods by value

Primitive types: The value is all the data

Arrays: Value is the reference to some data. The reference is copied. The called method can change the variable in the parent method.

Strings: String in Java are immutable. we can still pass a reference, but we cannot modify that data.

--------

### Object-oriented Programmming

A collection of objects with their stated and behaviors

#####Example: erase the chalkboard

Objects Involved:

- Me:

  dominant hand, location, am I holding an eraser?

  pick up something, move something, swipe something

- Eraser:

  is it already covered in chalk, size, location

  erase chalk

- Chalkboard:

  ​is it clean, size, location

##### Principles:

- Abstraction

  You can use an object without knowing its implementation (details inside)

- Encapsulation

  Code outside of an object cannot interfere with the object's implementation

- Modularity

  Reuse useful behaviors and object patterns (classes)

An object is an instance of a class.

A class is a blueprint for its instances.

### Parts of an Object

##### Identity

Each object has a unique id.

##### Type

Says which class the object is an instance of.

##### State (Properties / Fields)

Persistent data associated with the object.

Things that the object has.

##### Behaviors (Methods)

Things the object can do.

---

### Explore Array List

```java
import java.util.ArrayList;
import java.util.Random;

public class ExploreArrayList{
  public static void main(String[] args){
	Integer[] b = new Integer[10];
	ArrayList a = new ArrayList<Integer>();
	a.add(new Integer(7));
    Random randGen = new Random();
	for(int i = 0; i < 100; i++) {
		a.add(new Integer(randGen.nextInt(10)));
	}
	System.out.println(a.toString());
	System.out.println(a);
    for(int i = 99; i >= 0; i--){
      if(a.get(i).equals(4)){
        a.remove(i);
      }
    }
  }
}
```

---

###Class

```java
public class Main {
	public static void main(String[] args) {
		//Get something onto the board that we can erase.
		Chalkboard board = new Chalkboard();
		board.write("Now that there is text on the board, it should be DIRTY.");
		System.out.println("Is the board dirty?"+board.isDirty());
		System.out.println(board);
		
		//Create person and eraser objects
		Eraser e = new Eraser(6); //What size is the eraser?
		Person alexi = new Person("alexi","instructor");
		alexi.pickUp(e);
		alexi.useOn(e,board);
		
		//What have we changed about each object?
		//TODO check properties of alexi, e, and board.
		//TODO make a new eraser and compare them.
		
		// ending block comment tag to make partial compilation easier */
	}
}
```

```java
public class Chalkboard{
  //Fields (properties)
  //ALMOST any field you make should be private. 
  //Otherwise anyone can modify it, and we cannot control.
  //Static or not? Think about whether two objects of this type MUST have the same value of the property.
  private String location;
  private boolean does_it_have_chalk_on_it;
  private int size = 10; //number of characters that our board can hold
  private String contents; //text that is on out chalkboard
  //Constructor (a way to make new Chalkboard type objects)
  //looks like a method
  public Chalkboard(){
    //any initial values for fields should be assigned here
    size = 100;
    does_it_have_chalk_on_it = false;
    contents = "";
  }
  //CAN havea second constructor that take a different set of params
  public Chalkboard(String location, int size){
    this.location = location;
    this.size = size;
    contents = "";
  }
  //Methods (behaviors)
  //For non_static methods, there is an addtional secret parameter called "this". "this" refers to the chalkboard that we're working with
  //call with: objectName.methodName()
  //static methods are called with ClassName.methodName()
  public void write(String s){
    contents += s;
    if (contents.length()>size){
      contents = contents.substring(0,size);
    }
    does_it_have_chalk_on_it = true;
  }
  public boolean isDirty(){
    return does_it_chalk_on_it;
  }
  //Should return what we want to have printed out when someone tries to print out object of this type
  public String toString(){
    return contents;
  }
}
```

```
public class Eraser{
  private int size;
  private String location;
  public Eraser(int size){
    this.size = size;
    this.location = "105 Psychology";
  }
}
```

```
public class Person{
  private String name;
  private String occupation;
  private Eraser eraser;
  private String location;
  public person(String name, String occupation){
    this.name;
    this.occupation = occipation;
    eraser = null; //For any field of reference type that does not have an object to refer to
    //initially, null is a good choice
    location = "105 Psychology";
  }
  // Mutator / setter
  public void pickUp(Erasor erasor){
    this.erasor = erasor;
  }
  //when a method needs input/resourses, need to decide whether to get that input as a parameter, or from a field, or from user input via Scanner
  public useOn(Chalkboard board){
    //...
  }
}
```

---



