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

​	is it clean, size, location

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

