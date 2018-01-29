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

### Storing Java Variables

Stack: variables

Heap: store anything where we don't know its size and anything with "new"

Primitive types: stored entirely in the stack



### Passing Arguments

java passess arguments to methods by value

Primitive types: The value is all the data

Arrays: Value is the reference to some data. The reference is copied. The called method can change the variable in the parent method.

Strings: String in Java are immutable. we can still pass a reference, but we cannot modify that data.