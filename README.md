# Design a Pen - Low-Level Design (LLD)

A complete object-oriented design and implementation of a Pen system demonstrating state management, composition, and error handling principles.

## Overview

The Pen system implements a real-world pen with four core operations:
- **start()** - Open the pen (CLOSED → OPEN)
- **write(text)** - Write with the pen (OPEN → IN_USE → OPEN)
- **close()** - Close the pen (any state → CLOSED)
- **refill()** - Refill ink cartridge (EMPTY → CLOSED)

## Project Structure

```
Design-a-Pen/
├── src/
│   ├── Pen.java              # Main pen class with state management
│   ├── InkCartridge.java     # Ink cartridge management
│   └── Main.java             # Demo & usage examples
├── README.md                 # This file
├── LLD_DESIGN.md            # Complete design documentation
└── LICENSE                  # MIT License
```

## Quick Start

### Compilation
```bash
cd src
javac Pen.java InkCartridge.java Main.java
```

### Run Demo
```bash
java Main
```

## Basic Usage

```java
// Create pen with 100 units ink, 10 units per write
Pen pen = new Pen("Parker", "Blue", 100.0, 10.0);

// Write workflow
pen.start();                    // Open pen
pen.write("Hello, World!");     // Write & consume 10 units
pen.write("Another message");   // Write again
pen.close();                    // Close pen

// Refill & continue
pen.refill();                   // Restore ink to full
pen.start();
pen.write("After refill");
pen.close();
```

## Classes

### Pen.java
- **Attributes**: brand, color, inkCartridge, currentState, inkUsagePerWrite
- **Methods**: start(), write(), close(), refill(), getters
- **States**: CLOSED, OPEN, IN_USE, EMPTY

### InkCartridge.java
- **Attributes**: maxCapacity, currentInk
- **Methods**: consumeInk(), refill(), hasInk(), getters

### PenState Enum
- CLOSED: Cap on, cannot write
- OPEN: Cap off, ready to write
- IN_USE: Currently writing
- EMPTY: No ink left

## State Diagram

```
CLOSED →[start+ink]→ OPEN ←[close]← IN_USE
                      ↓               ↑
                   [write]         [write]
                      
EMPTY ←[write-noink]— OPEN/IN_USE
  ↓
[refill]
  ↓
CLOSED
```

## Error Handling

All invalid operations throw `IllegalStateException`:
- start() when not CLOSED
- write() when not OPEN/IN_USE or no ink
- close() when already CLOSED
- refill() when OPEN or IN_USE

## Key Design Principles

1. **Encapsulation** - All attributes private
2. **State Management** - Enum-based state machine
3. **Composition** - Pen "has-a" InkCartridge
4. **Fail-Fast** - Exceptions on invalid operations
5. **Validation** - Pre-condition checks before state changes

## Documentation

See [LLD_DESIGN.md](LLD_DESIGN.md) for:
- Complete class diagrams (Mermaid)
- Detailed method specifications
- Sequence diagrams
- Design patterns & principles
- Testing considerations
- Future enhancements

## Requirements

- Java 8 or higher
- No external dependencies

## License

MIT License - see [LICENSE](LICENSE) file
