# 📚 Event Management System (Java Console App)

This is a Java-based console application for managing events. Users can create events, register for them, search/filter events, and modify event details. The system uses well-known software design patterns to ensure maintainability and flexibility.

---

## ✅ Features

- 🎯 Create events with:
  - Name, location, date, time, organizer, description
  - Up to 3 categories and 3 tags

- 🔍 Search events by:
  - Name
  - Category
  - Tag
  - Alphabetical sorting (A-Z / Z-A)

- ✏️ Modify event fields:
  - Location, date, time, description, categories, tags

- 🔄 Undo last modification (Command Pattern)

- 🧾 Register for an event with automatic logging (Observer Pattern)

---

## 🛠 Technologies Used

- Java 21
- Maven
- Object-Oriented Programming
- Command Line Interface (CLI)

---

## 🧱 Design Patterns Implemented

| Pattern      | Purpose                                      | Used In                                   |
|--------------|----------------------------------------------|--------------------------------------------|
| Singleton    | Ensures single instance of event manager     | `EventManager` class                       |
| Command      | Encapsulates modify/undo logic               | `Command` interface & related classes      |
| Observer     | Notifies observers upon registration         | `EventObserver`, `RegistrationLogger`      |

---

## 🧩 Class Structure

