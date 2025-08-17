# Java RMI Calculator Assignment

## Overview
Hello! This is my submission for the **Java RMI Calculator Assignment**. The main goal of this project is to learn **how Java RMI works** and how multiple clients can interact with a single server.

In this project:
- The **server maintains a shared stack** for all connected clients.
- Clients can:
    - Push integer values onto the stack
    - Perform operations (`min`, `max`, `gcd`, `lcm`) on all stack values
    - Pop values from the stack
    - Delay a pop operation for a specified number of milliseconds
    - Check if the stack is empty

The client program is interactive and runs in the terminal. This makes it easy to test various operations in real-time.

---

## Files in the Project

- **Calculator.java** → The remote interface that defines all operations the server provides.
- **CalculatorImplementation.java** → Server-side implementation of the remote interface. Handles the stack and calculations.
- **CalculatorServer.java** → Starts the RMI server and registers the calculator service.
- **CalculatorClient.java** → Interactive client that allows users to communicate with the server via the terminal.

---

## How to Compile and Run

### Step 1: Compile the Java files
Open a terminal in the project directory and type:
```bash
javac *.java

```

### Step 2: Start the RMI registry

Open a new terminal in the same directory and type:
```bash
rmiregistry
```

### Step 3: Step 3: Start the Server

In another terminal, start the server:
```bash
java CalculatorServer
```
You should see a message like:
```bash
[Server] Calc RMI Server is running...
[Server] Now you need to run the client file to connect client with the Server, Thankyou
```

### Step 4: Start the Client

Open a separate terminal and run:
```bash
java CalculatorClient
```
You should see a menu like:
```bash
=== Calculator Menu ===
1. Push Value
2. Push Operation (min, max, gcd, lcm)
3. Pop
4. Delay Pop
5. Check if Empty
6. Exit
```

## How to Use the Client

Push a Value <br>
      •	Select option 1 <br>
      •	Enter any integer value <br>
      •	Example:

```bash
Choose an option: 1
Enter integer value: 15
[Server] Value pushed: 15
```

Push an Operation <br>
	•	Select option 2 <br>
	•	Enter one of: min, max, gcd, lcm <br>
	•	Example:
```bash
Choose an option: 2
Enter operation (min/max/gcd/lcm): gcd
[Server] Operation 'gcd' result pushed: 3
```
Pop a Value <br>
      •	Select option 2 <br>
  •	The top value will be popped from the stack and displayed. <br><br>
Delay Pop <br>
  •	Select option 4 <br>
  •	Enter the delay time in milliseconds <br>
  •	After the delay, the top value will be popped and shown. <br><br>
Check if Stack is Empty <br>
  •	Select option 5 <br>
  •	Returns true if the stack has no elements, false otherwise. <br><br>
Exit <br>
  •	Select option 6 to close the client.

## How to Use the Client

### Push a Value 
```bash
Choose an option: 1
Enter integer value: 12
[Server] Value pushed: 12
Choose an option: 1
Enter integer value: 18
[Server] Value pushed: 18
```

### Performing Operation
```bash
Choose an option: 2
Enter operation (min/max/gcd/lcm): gcd
[Server] Operation 'gcd' result pushed: 6
```

### Popping Value 
```bash
Choose an option: 3
[Server] Value popped: 6
```

## Multiple Clients

You can run multiple clients simultaneously in separate terminals.
All clients share the same stack on the server, so changes by one client are visible to all others.

## Notes / Tips
•	Make sure the RMI registry is running before starting the server. <br>
•	The stack is shared among all clients in this version. <br>
•	The client program is fully interactive and will wait for user input in a loop. <br>
•	All operations are synchronized to prevent conflicts when multiple clients access the stack simultaneously.

## Author

### Dhwanil Trivedi <br>
### Student id :- a1990797 <br>
### Course: Distributed Systems (DS) <br>
### Assignment 1 – Java RMI Calculator
