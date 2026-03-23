# Contributing to Design-a-Pen

Thank you for your interest in contributing to the Pen design project! This document provides guidelines and instructions for contributing.

## Code of Conduct

Be respectful, inclusive, and professional in all interactions.

## How to Contribute

### 1. Report Bugs

Found a bug? Please create an issue with:
- Clear title describing the bug
- Step-by-step reproduction instructions
- Expected vs actual behavior
- Java version and OS information

### 2. Suggest Enhancements

Have an idea? Open an issue with:
- Clear title and description
- Use cases and benefits
- Possible implementation approaches
- Example code if applicable

### 3. Submit Code

#### Setup Development Environment

```bash
# Clone the repository
git clone https://github.com/yourusername/Design-a-Pen.git
cd Design-a-Pen

# Compile
cd src
javac Pen.java InkCartridge.java Main.java

# Run tests
java Main
```

#### Code Style Guidelines

- **Naming:** Use camelCase for variables and methods, PascalCase for classes
- **Comments:** Use Javadoc for public methods
- **Formatting:** 4-space indentation, max 100 characters per line
- **Documentation:** Update README.md if adding features

#### Making Changes

1. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. Make your changes with clear commit messages:
   ```bash
   git commit -m "Add feature X
   
   - Description of what was changed
   - Why the change was made
   - Any related issues"
   ```

3. Test thoroughly:
   ```bash
   cd src
   javac *.java
   java Main
   ```

4. Update documentation:
   - Update README.md if needed
   - Add Javadoc comments
   - Update TECHNICAL_DESIGN.md for architectural changes

5. Push to your fork and create a Pull Request:
   ```bash
   git push origin feature/your-feature-name
   ```

### 4. Documentation Improvements

Documentation is always welcome! You can:
- Fix typos and grammar
- Clarify confusing sections
- Add examples
- Improve API documentation

## Pull Request Process

1. **Title:** Clear, descriptive PR title
2. **Description:** Explain what, why, and how
3. **Related Issues:** Link to any related issues
4. **Testing:** Confirm all code runs successfully
5. **Documentation:** Update relevant docs

### PR Checklist

- [ ] Code compiles without errors
- [ ] Demo (`java Main`) runs successfully
- [ ] Javadoc added for new public methods
- [ ] Updated README.md if needed
- [ ] Updated TECHNICAL_DESIGN.md for architecture changes
- [ ] No unused imports or variables
- [ ] Follows code style guidelines

## Project Structure

```
Design-a-Pen/
├── src/                      # Java source files
│   ├── Pen.java             # Main pen class
│   ├── InkCartridge.java    # Ink management
│   └── Main.java            # Demo and examples
├── diagrams/                # Design diagrams
│   ├── ClassDiagram.puml    # UML in PlantUML format
│   └── ClassDiagram_ASCII.txt
├── README.md                # User documentation
├── TECHNICAL_DESIGN.md      # Architecture and design
├── CONTRIBUTING.md          # This file
├── LICENSE                  # MIT License
└── .gitignore              # Git ignore rules
```

## Desired Contributions

### High Priority

1. **Unit Tests** - JUnit test suite
   ```java
   class PenTest {
       @Test
       public void testStartOpensClosedPen() {}
       
       @Test
       public void testWriteRequiresOpenPen() {}
   }
   ```

2. **Additional Pen Types** - Ballpoint, Fountain, Marker
   ```java
   class BallpointPen extends Pen {}
   class FountainPen extends Pen {}
   ```

3. **Multi-Color Support**
   - Multiple ink cartridges
   - Color switching

### Medium Priority

1. **Serialization** - Save/load pen state
2. **Builder Pattern** - Fluent Pen creation
3. **Listener Pattern** - Event notifications
4. **Performance Benchmarks** - Measure operations

### Lower Priority

1. **GUI** - Visual pen representation
2. **Ant Simulation** - Realistic pen usage patterns
3. **Internationalization** - Multi-language support

## Review Process

- Code reviews typically begin within 48 hours
- Reviews focus on: code quality, design, documentation, testing
- Changes may be requested before merge
- CI/CD pipeline will verify compilation and tests

## Commit Message Guidelines

```
[TYPE] Brief description (50 chars max)

Detailed explanation if needed. Wrap at 72 characters.

- Feature 1
- Feature 2
- Bug fix 3

Fixes #123
```

**Types:**
- `feat:` New feature
- `fix:` Bug fix
- `docs:` Documentation only
- `refactor:` Code restructuring
- `test:` Test additions or changes
- `chore:` Build, dependencies, tooling

## Recognition

Contributors will be recognized in:
- README.md contributors section
- Git commit history
- Project releases

## Questions?

Open a discussion issue or contact the maintainers.

## License

All contributions are under the MIT License.

---

Thank you for making this project better! 🎉
