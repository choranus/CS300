### **Debugging techniques**

Visual inspection

Print statements: check important values

Compartmentalize your code: test pieces independently

Test methods

Tracing: draw out paper what the code is doing

Eclipse debugging suggestions

Eclipse debug mode

Java visualizer 

---

### **Getting input**

##### User Input via Scanner

```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
sc.next()
```

Don't make more than one scanner!

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

##### Example: erase the chalkboard

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

### Class

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

### Interfaces

##### Object

Instantiation

##### Class (aka Data Structure)

Implementation

Tell you how it is done

##### Interface (aka Abstract Data Type)

Tells you what the type can do.

NO CODE!

### Parts of an Abstract Data Type (ADT)

Set of method declarations.

Contract that says any class implementing me can do ...

### Collections

What's a collection?

- A group of items that share properties.

Related terms:

- Set, array, list, ArrayList

What operations can you do on a collection? (Which are fundamental?)

- **Add**, isEmpty, get/set an item's value, sort, **remove**

---

### Example: The "Bag"

##### Concept:

Simpest possible collection 

You can add, remove items

Ideally, because it's so simple. it is also fast!

##### Operations:

void add(Object item);

Object remove();

boolean isEmpty();

##### What problems might occur when doing Bag operations?

Remove from empty bag

Run out of space

Add null item

### Designing an Integer Bag ADT

##### Concept

A bag of Integers

##### Public Interface:

```java
Public interface IntegerBagADT{
  void add(Integer item);	//item may not be null
  Integer remove;	//Make sure to check for emptiness before removing
  boolean isEmpty();
}
```

### Using an Integer Bag ADT

```java
//Put 0-99 into a bag named "bag"
//print out bag's contents. (in any order)
IntegerBagADT bag = new IntegerBagADT(); //creates a nre instance of some IntBagADT implementation
for(int i = 0; i < 100; i++){
  bag.add(i);
}
```

---

### File Input

To read text from files in Java, We must import:

- `java.util.Scanner`
- `java.io.File`
- `java.io.FileNotFoundException`

A main method that reads lines of text from a file and prints them to System.out looks like:

```java
public static void main(String args[]){
  File f = new File("filename.txt");
  Scanner s = new Scanner(f);
  while(s.hasNextLine()){
    System.out.println(s.nextLine());
  }
  s.close();
}
// Alternative: use FileReader class
```

### What Can Go Wrong?

##### To read the contents of a file...

1, Create a File object from the file name.

​	Permission?	

2, Create a Scanner object from the File object.

​	Might overwrite an existing file or try to read a file that doesn't exist.

​	Non-text files which might interact weirdly with the Scanner.

3, Use Scanner method to read the contents of the file

​	Different data types

​	 `next()` when the file (Scanner) is empty

### The "Throws" Statement

##### We use this statement to...

Alert Java, also other users of our code that a piece of code is unsafe. It may cause an Exception.

##### It goes...

At the end of the method header.

### Avoiding Exception

We can avoid some exceptions with careful coding.

```java
if (f.exists()){
  Scanner s = new Scanner(f); 
}
//f might not be a real file
//still need the "throws"
```

```java
if (f.exists()){
  Scanner s = new Scanner(f); 
}


import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ceasar {
	public static void main(String args[]) {
		//set up a File
		File myFile = new File("hiddenHaiku.txt");
		//Scanner object from file
		Scanner scan = new Scanner(myFile);
		//loop through the scanner
		//make sure there IS a nextLine
		//get and print the nextLine
		while(scan.hasNextLine()){
    		System.out.println(scan.nextLine());
		}
	}
  private static String decrypt(String s){
    //Take in a string, and decrypt it
    String answer = "";
    for (char c : s.toCharArray()){
      String answer = "";
      if (!Character.isAlphabetic(c)){
        answer += c;
      } else {
        //There IS an edge case we didn't handle
        answer += (char)(c-1);
      }
    }
    return answer;
  }
}

```

---

### File Output

To write text files using Java, we must  import:

- `java.io.File`

- `java.io.PrintWriter`

- `java.io.FileNotFoundException`

  ```java
  File outFile = new File("...");
  PrintWriter pw = new PrintWriter(outFile);
  pw.println("some text"); //System.out.println()
  pw.close();
  // Alternative: use FileWriter class
  ```

---

### Exception Handling

1) Try block: wraps around, code that might cause exception

2) Catch block(s): code that runs if exception occurs. one per type of exception we handle

3) Finally block: always runs

##### Java syntax

```java
try{
  //try block
  //"dangerous" code goes here
}catch (Exception e){
  //handle this exception type
}catch (AnotherExceptionType e2){
  //handle this other exception type
}finally{
  //run code which should happen whether or not an exception occurs
}
```

```java
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
 
public class Encoder {
 
	public static void main(String[] args) throws FileNotFoundException {
		//Set up a File
        try {
        	File myFile = new File("hiddenHaiku.txt");
        	File myOutFile = new File("decryptedHaiku.txt");
            //Scanner object from File
            Scanner scan = new Scanner(myFile);
            //Loop through the scanner
            // make sure there IS a nextLine
            // get and print the nextLine
            PrintWriter pw = new PrintWriter(myOutFile);
            while(scan.hasNextLine())
                pw.println(decrypt(scan.nextLine()));
            pw.close(); //also flushes the PrintWriter
            scan.close();
        } catch (FileNotFoundException e){
          	System.out.println("The file we tried to read didn't exist.");
            throw e;
        }

	}
	
	private static String decrypt(String s) {
		//Take in a string, and decrypt it
		String answer = "";
		for (char c : s.toCharArray()) {
			if (!Character.isAlphabetic(c)) {
				answer += c;
			} else {
				//There IS an edge case we didn't handle
				answer += (char)(c-1);
			}
		}
		return answer;
	}
 
}
```

##### Checked Exceptions

FileNotFoundException

- handle it
- "throws" it

##### Unchecked Exceptions

RuntimeException

- can handle it
- can "throws" it
- can ignore it

---

### Basic Inheritance: Extends

```java
public class FullBagException extends RuntimeException{
}
```

The keyword `extends` indicates that:

FullBag Exception inherits from (is a) RunTimeException.

When relating the two, 

- `RunTimeException` is the **Superclass**
- `FullBagException` is the **Subclass**

### Sharing Between Super- and Sub- classes 

##### Fields

Public fields are shared.

Private fields are NOT shared.

##### Methods

Public mathods are shared. 

(Either can use the super's methods. ONLY the subclass can use the sub's methods)

Private methods are NOT shared.

##### Creating instances and casting

```java
TYPE variableName = new IMPLEMENRATION();
Scanner s = new Scanner(System.in);
IntegerArrayBag a = new SafeIntegerArrayBag(); //true
SafeIntegerArrayBag b = new IntegerArrayBag(); //false
```

##### Overriding Superclass Methods

One approach to make a "safe" add method:

The `@Override` note indicates we are trying to override a superclass method. The complier will give an error if we didn't override something.

```java
import java.util.*

public class SafeIntegerArrayBag extends IntegerArrayBag{
	ArrayList<Integer> contents;
	
	@override
    public void add(Integer x){
    	if (x==null)
    		return;
    	contents.add(x);
    }
    @override
    public Integer remove() throws EmptyBagException{
    	// won't actual throw it but we do need to do this
    	if (this.isEmpty())
    		return null;
    	contents.remove(0);
    }
}
```

### Extends Object

**In Java, every class extends exactly one class.**

**If we do not choose the superclass, the default is *Object*.**

All classes extend object, either directly or indirectly through a chain of inheritance.

**Extending Object gives us access to several useful methods:**

- `public boolean equals (Object other)`

  Test whether they have the same location in memory

- `public final Class<?> getClass()`

  Reports the class associated with an object

- `public int hashcode`

- `public String toString(Object other)`

---

### Polymorphism

Ad hoc polymorphism: Multiple methods with same name (overloaded), behavior varies by param type.

Parametric polymorphism: A method whose behavior systematically changes based on input type.

Subtyping: Param poly specifically allowing us to substitute in "subtypes". Example: subclasses

**Polymorphism occur at both run-time and at compile-time.**

### Interface

Recall that in Java, every class extends exactly one class.

Sometimes, we want to inherit behavior from more than one source. Behavior from secondary sources comes through interfaces.

```java
public class A {
  public boolean returnTrue(){return True;}
}
public interface B {
  public int returnSeven();
}
public class C extends A implements B{
  //We get returnTrue for free
  //Must implement returnSeven()
  public int returnSeven(){
    return 7;
  }
}
```

We can implement mutiple implements in a same class.

### The Comparable Interface

```java
public interface Comparable<T>{
  public int campareTo(T other);
}
/* Expectation:
 * If a > b: return positive #
 * If a < b: return negative #
 * If a == b: return 0
 */
```

---

### ListADT

Ordered sequence of items with no set size limit.

**Operations**:

- add items* `add(item)` `add(item,position)`
- remove items* `remove(position)` `remove(item)`
- set / change item's value* could implement with remove+add 
- move items around
- sort
- get length*
- filter for certain conditions
- print
- access items' value without removing*
- empty the entire list at once

**Issues**:

- null item. Not allowed. IllegalArgumentException
- duplicate items. Allowed!
- badposition (too large or too small)

### Interfaces inheriting from other interfaces

Notice that Java's List<E> interface extends the Collection<E> interface.

### Link Data Type

A chain of linked nodes

**ListNode Class**:

- Fields:

  `ListNode next;`

  `E data;`

- Methods:

  `E getData();`

  `void setData(E item);`

  `ListNode getNext();`

  `void setNext(ListNode n);`

---

#### Analyzing algorithms

Performance

- Time
- Space
- Best case
- Worst case

Errors

- Not just a binary work
- Presition
- Stability

Simplicity

- Readability
- Elegance

Versatility

- Generic



CONSTANT: $O(1)$ When input size doubles, algorithm takes same time.

LINEAR: $O(n)$ When input size doubles, method takes 2x time.

QUADRATIC: $O(n^2)$

LOGARITHMIC: $O(logn)$

EXCEPONENTIAL: $O(a^n)$



**Big-O**

A function $T(n)$ is $O(f(n))$ if for constant c and some size of n, $T(n) \leq c \cdot F(n)$ for all $n>n_0$.