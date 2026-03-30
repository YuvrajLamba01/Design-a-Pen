# Design a Pen

Advanced object-oriented Pen design with modular components and a clean class diagram.

## Project Structure

```
Design-a-Pen/
├── src/
│   ├── Pen.java
│   ├── PenType.java
│   ├── Refill.java
│   ├── CapMechanism.java
│   ├── OperatingMechanism.java
│   ├── ClickMechanism.java
│   └── Main.java
├── ClassDiagram.md
├── README.md
└── LICENSE
```

## Quick Start

```bash
cd src
javac *.java
java Main
```

## Classes

- `Pen`: Main controller for open, close, click, write, and refill flow.
- `PenType`: Enum for `BALLPOINT`, `GEL`, `FOUNTAIN`, `MARKER`.
- `Refill`: Tracks ink capacity and consumption.
- `CapMechanism`: Controls cap open/close state.
- `OperatingMechanism`: Interface for writing mechanism behavior.
- `ClickMechanism`: Click-based implementation of `OperatingMechanism`.
- `Main`: Demo runner with normal flow, refill flow, and error handling.

## Diagram

See [ClassDiagram.md](ClassDiagram.md) for the complete Mermaid class diagram.

## Requirements

- Java 8 or higher
- No external dependencies

## License

MIT License - see [LICENSE](LICENSE).
