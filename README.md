# Design a Pen - Object-Oriented Design & Implementation

A complete implementation of a Pen class demonstrating object-oriented programming principles with a comprehensive design that includes state management, composition, and error handling.

## 📋 Overview

This repository contains:
- **Complete Pen Class Implementation** with state management
- **Class Diagram** (UML) showing architecture
- **Comprehensive Documentation** and usage examples
- **Demonstration Code** with error handling

## 🎯 Features

The Pen class provides four main functionalities:

### 1. **Start** - Open the Pen
- Removes the cap and makes the pen ready to write
- Checks if ink is available before opening
- Transitions from `CLOSED` to `OPEN` state

```java
Pen myPen = new Pen("Parker", "Blue", 100.0, 10.0);
myPen.start();  // Opens the pen
```

### 2. **Write** - Write with the Pen
- Records text output and consumes ink
- Validates that the pen is in `OPEN` state
- Checks for sufficient ink before writing
- Transitions to `IN_USE` state during write

```java
myPen.write("Hello, World!");  // Writes text, consumes ink
```

### 3. **Close** - Close the Pen
- Places the cap back on the pen
- Prevents ink from drying out
- Transitions from `OPEN` or `IN_USE` to `CLOSED` state

```java
myPen.close();  // Closes the pen
```

### 4. **Refill** - Refill the Ink
- Restores the ink cartridge to full capacity
- Can only be done when pen is `CLOSED`
- Transitions from `EMPTY` to `CLOSED` state

```java
myPen.refill();  // Refills the ink cartridge
```

## 🏗️ Architecture

### Class Structure

#### Pen Class
The main class representing a pen with the following attributes:
- `brand` - Brand name of the pen
- `color` - Ink color
- `inkCartridge` - The ink cartridge object
- `currentState` - Current state (CLOSED, OPEN, IN_USE, EMPTY)
- `inkUsagePerWrite` - Ink consumed per write operation

#### InkCartridge Class
Manages ink capacity and consumption:
- `maxCapacity` - Total ink capacity
- `currentInk` - Current ink amount
- Methods to consume, refill, and check ink levels

#### PenState Enum
Represents the four states of the pen:
- `CLOSED` - Pen cap is on, cannot write
- `OPEN` - Pen cap is off, ready to write
- `IN_USE` - Currently writing
- `EMPTY` - No ink available

### State Diagram

```
        CLOSED
         ↓
    (start) ↓
         ↓
    OPEN ←─────┐
     ↓         │
(write)  (close)
     ↓         │
   IN_USE ─────┘
     ↓
   EMPTY (when ink runs out)
     ↓
  (refill)
     ↓
   CLOSED
```

## 📁 Project Structure

```
Design-a-Pen/
├── src/
│   ├── Pen.java              # Main pen class with state management
│   ├── InkCartridge.java     # Ink cartridge management
│   └── Main.java             # Demonstration and examples
├── diagrams/
│   ├── ClassDiagram.puml     # UML class diagram (PlantUML format)
│   └── ClassDiagram_ASCII.txt # ASCII representation of class diagram
├── README.md                 # This file
├── LICENSE                   # MIT License
└── .gitignore               # Git ignore file
```

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- A Java compiler (javac)

### Compilation

```bash
cd src
javac Pen.java InkCartridge.java Main.java
```

### Running the Demo

```bash
java Main
```

### Output Example

```
=== PEN DESIGN AND IMPLEMENTATION DEMO ===

Pen Details: Pen{brand='Parker', color='Blue', currentState=CLOSED, remainingInk=100.00}

--- Normal Usage Demo ---

1. Starting the pen...
[Parker] Pen cap removed. Pen is ready to write.

2. Writing first message...
[Parker - Blue] Writing: "Hello, World!"
    Remaining ink: 90.00 units

3. Writing second message...
[Parker - Blue] Writing: "The Pen is working great!"
    Remaining ink: 80.00 units

4. Closing the pen...
[Parker] Pen cap placed back.

Final pen state: Pen{brand='Parker', color='Blue', currentState=CLOSED, remainingInk=80.00}
```

## 💡 Usage Examples

### Basic Usage

```java
// Create a pen with 100 units of ink, consuming 10 units per write
Pen pen = new Pen("Parker", "Blue", 100.0, 10.0);

// Start writing
pen.start();
pen.write("This is a test message");
pen.close();

// Check ink level
System.out.println("Remaining ink: " + pen.getRemainingInk());
```

### Handling Empty Pen

```java
// Use pen until it runs out of ink
pen.start();
try {
    while (pen.hasInk()) {
        pen.write("Writing message");
    }
} catch (IllegalStateException e) {
    System.out.println("No ink left!");
}

// Refill when empty
pen.close();
pen.refill();
pen.start();
pen.write("Writing after refill");
```

### Error Handling

```java
Pen pen = new Pen("Pilot", "Red", 50.0, 15.0);

// This will throw IllegalStateException
try {
    pen.write("Text");  // Pen not open yet
} catch (IllegalStateException e) {
    System.out.println("Error: " + e.getMessage());
}

// Correct usage
try {
    pen.start();
    pen.write("Text");  // Now it works
    pen.close();
} catch (IllegalStateException e) {
    System.out.println("Error: " + e.getMessage());
}
```

## 🔍 Key Design Patterns

### 1. **State Pattern**
The pen uses an enum-based state machine to manage its lifecycle and enforce valid transitions.

### 2. **Composition**
The Pen class contains an InkCartridge object, demonstrating the composition principle (has-a relationship).

### 3. **Encapsulation**
All attributes are private with controlled access through public methods.

### 4. **Exception Handling**
Invalid operations throw `IllegalStateException` with descriptive messages.

## 📊 Method Details

### Pen Methods

| Method | Parameters | Returns | Throws | Notes |
|--------|-----------|---------|--------|-------|
| `start()` | - | void | `IllegalStateException` | Opens pen, checks ink |
| `write()` | `String text` | void | `IllegalStateException` | Consumes ink, updates state |
| `close()` | - | void | `IllegalStateException` | Closes pen |
| `refill()` | - | void | `IllegalStateException` | Restores full ink capacity |
| `getCurrentState()` | - | `PenState` | - | Returns current state |
| `getRemainingInk()` | - | `double` | - | Returns remaining ink |
| `hasInk()` | - | `boolean` | - | Checks if ink is available |

### InkCartridge Methods

| Method | Parameters | Returns | Notes |
|--------|-----------|---------|-------|
| `consumeInk()` | `double amount` | void | Reduces ink by amount |
| `refill()` | - | void | Sets ink to max capacity |
| `hasInk()` | - | `boolean` | Checks if ink > 0 |
| `getRemainingInk()` | - | `double` | Returns current ink |
| `getCapacityPercentage()` | - | `double` | Returns percentage used |

## 📈 Extensions & Enhancements

Possible enhancements for this design:

1. **Multiple Ink Colors** - Support pens with multiple ink cartridges
2. **Ink Quality** - Track ink fading over time
3. **Durability** - Track pen wear and tear
4. **Persistence** - Save/load pen state from files
5. **Different Pen Types** - Ballpoint, gel, fountain pen variants
6. **Writing Speed** - Track writing speed and pressure
7. **Cost Tracking** - Track ink cost and pen value

## 🧪 Testing

The `Main.java` file includes three demonstration methods:

1. **`demonstrateNormalUsage()`** - Basic pen operations
2. **`demonstrateRefill()`** - Refilling functionality
3. **`demonstrateErrorHandling()`** - Error scenarios and exception handling

Run all demos with:
```bash
java Main
```

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

Created as a comprehensive object-oriented design and implementation exercise.

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Report bugs
- Suggest enhancements
- Submit pull requests

## 📚 Learning Resources

This project demonstrates:
- **OOP Principles**: Encapsulation, Composition, State Management
- **Design Patterns**: State Pattern, Builder Pattern (in future versions)
- **Java Best Practices**: Exception handling, documentation, code organization
- **UML Diagrams**: Class diagrams and state machines
- **SOLID Principles**: Single Responsibility, Interface Segregation

---

**Last Updated:** March 23, 2026
