# From Java to AI — Slide Deck
### Talk portion: ~35–45 min | Malla Reddy University

---

## SLIDE 1 — Title

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║         FROM JAVA TO AI                              ║
║         in 45 minutes 🚀                             ║
║                                                      ║
║   Building an AI-powered app with Spring Boot        ║
║   + Google Gemini                                    ║
║                                                      ║
║   @srinivasreddyramaram                              ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 2 — Hook

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   You know Java.                                     ║
║                                                      ║
║   You can write a class.                             ║
║   You can write a method.                            ║
║   You know what an object is.                        ║
║                                                      ║
║   ✅ That's all you need for today.                  ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 3 — The Problem

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   This is how we all start 😅                        ║
║                                                      ║
║   public class Main {                                ║
║     public static void main(String[] args) {         ║
║                                                      ║
║       // connect to database here                    ║
║       // call an API here                            ║
║       // validate input here                         ║
║       // save to file here                           ║
║       // everything here                             ║
║     }                                                ║
║   }                                                  ║
║                                                      ║
║        Works. But doesn't scale.                     ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 4 — What is Spring Boot?

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   Spring Boot =                                      ║
║   Java + superpowers                                 ║
║                                                      ║
║   It handles the boring stuff so                     ║
║   you can focus on the real stuff.                   ║
║                                                      ║
║   ┌─────────────────────────────────────┐            ║
║   │  You write: business logic          │            ║
║   │  Spring handles: wiring, DB,        │            ║
║   │                  HTTP, config...    │            ║
║   └─────────────────────────────────────┘            ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 5 — Concept 1: Dependency Injection

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   DEPENDENCY INJECTION                               ║
║   "Stop newing, start receiving"                     ║
║                                                      ║
║   ❌ Plain Java                                       ║
║   PrepService service = new PrepService();           ║
║                                                      ║
║   ✅ Spring                                           ║
║   public PrepController(PrepService service) {       ║
║       this.service = service; // handed to you       ║
║   }                                                  ║
║                                                      ║
║   🍕 Analogy: You don't grow wheat to make pizza.   ║
║      Zomato delivers. Spring delivers.               ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 6 — Concept 2: Beans

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   BEANS                                              ║
║   "Objects managed by Spring"                        ║
║                                                      ║
║   Spring has a container (like a factory).           ║
║   It creates objects, stores them,                   ║
║   and gives them where needed.                       ║
║                                                      ║
║   These objects are called BEANS.                    ║
║                                                      ║
║   @Service     →  service bean                       ║
║   @Repository  →  database bean                      ║
║   @RestController → API bean                         ║
║                                                      ║
║   You write the class. Spring makes the object.      ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 7 — Concept 3: Annotations

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   ANNOTATIONS                                        ║
║   "Post-it notes for your code"                      ║
║                                                      ║
║   @SpringBootApplication   start here                ║
║   @RestController          I handle HTTP             ║
║   @Service                 I have business logic     ║
║   @Repository              I talk to the DB          ║
║   @Entity                  I am a database table     ║
║                                                      ║
║   Spring reads these labels at startup               ║
║   and does the right thing automatically.            ║
║                                                      ║
║   You annotate. Spring acts.                         ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 8 — Concept 4: Layered Architecture

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   LAYERED ARCHITECTURE                               ║
║   "Everyone does ONE job"                            ║
║                                                      ║
║   🧑‍💼 Controller   takes the order                  ║
║         │                                            ║
║   👨‍🍳 Service      cooks the food                   ║
║         │                                            ║
║   🗄️  Repository   gets from storage                ║
║         │                                            ║
║   💾   Database    stores the data                   ║
║                                                      ║
║   In our app:                                        ║
║   PrepController → PrepService → PrepSessionRepo     ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 9 — Concept 5: Spring Data JPA

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   SPRING DATA JPA                                    ║
║   "Database without writing SQL"                     ║
║                                                      ║
║   ❌ Old way (JDBC — 20+ lines)                      ║
║   Connection conn = DriverManager.getConnection(...) ║
║   PreparedStatement stmt = conn.prepareStatement(...)║
║   ResultSet rs = stmt.executeQuery();                ║
║   // ... 15 more lines                               ║
║                                                      ║
║   ✅ Spring Data JPA — 1 line                        ║
║   repository.findAll()   // get all rows             ║
║   repository.save(obj)   // insert/update            ║
║   repository.findById(1) // get by id                ║
║                                                      ║
║   You get these for FREE just by extending           ║
║   JpaRepository                                      ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 10 — Concept 6: REST API

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   REST API                                           ║
║   "Your Java methods become URLs"                    ║
║                                                      ║
║   @PostMapping                                       ║
║   public PrepSession generate(@RequestParam          ║
║                               String topic) { ... } ║
║                                                      ║
║   becomes ↓                                          ║
║                                                      ║
║   POST http://localhost:8080/prep?topic=Arrays       ║
║                                                      ║
║   ┌─────────────────────────────────┐                ║
║   │ GET    →  read / fetch          │                ║
║   │ POST   →  create / send         │                ║
║   │ PUT    →  update                │                ║
║   │ DELETE →  remove                │                ║
║   └─────────────────────────────────┘                ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 11 — Concept 7: application.properties

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   application.properties                             ║
║   "One file to rule them all"                        ║
║                                                      ║
║   ❌ Hardcoded in Java (bad)                          ║
║   String key = "AIzaSy...";                          ║
║   String url = "http://prod-server.com";             ║
║                                                      ║
║   ✅ In application.properties (good)                ║
║   gemini.api.key=YOUR_KEY                            ║
║   gemini.api.url=https://...                         ║
║                                                      ║
║   Change config without touching code.               ║
║   Different values for dev / test / prod.            ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 12 — The Full Picture

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   YOUR REQUEST                                       ║
║   POST /prep?topic=Arrays                            ║
║          │                                           ║
║          ▼                                           ║
║   PrepController   (@RestController)                 ║
║          │                                           ║
║          ▼                                           ║
║   PrepService      (@Service)                        ║
║     ├─ calls Gemini API  → gets 5 questions          ║
║     └─ saves to database                             ║
║          │                                           ║
║          ▼                                           ║
║   PrepSessionRepository  (@Repository)               ║
║          │                                           ║
║          ▼                                           ║
║   H2 Database (in-memory)                            ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 13 — Before vs After

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   BEFORE Spring Boot                                 ║
║   ─────────────────                                  ║
║   Setup web server manually                          ║
║   Write JDBC boilerplate                             ║
║   Configure Tomcat XML                               ║
║   Manage object lifecycles                           ║
║   Handle HTTP parsing                                ║
║                                                      ║
║   AFTER Spring Boot                                  ║
║   ────────────────                                   ║
║   mvn spring-boot:run   ← that's it                  ║
║                                                      ║
║   Spring Boot auto-configures everything.            ║
║   You write the logic. It handles the plumbing.      ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 14 — Live Demo Transition

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   Enough slides.                                     ║
║                                                      ║
║   Let's BUILD it. 🛠️                                 ║
║                                                      ║
║   github.com/srinivasreddyramaram/java-to-ai-backend ║
║                                                      ║
║   Branch: main  ← clone this                         ║
║                                                      ║
║   mvnw spring-boot:run                               ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SLIDE 15 — Closing / What's Next

```
╔══════════════════════════════════════════════════════╗
║                                                      ║
║   What you built today:                              ║
║                                                      ║
║   ✅ A Spring Boot REST API                          ║
║   ✅ Connected to Google Gemini AI                   ║
║   ✅ Saves history to a database                     ║
║   ✅ Tested with a real API client                   ║
║                                                      ║
║   What to explore next:                              ║
║                                                      ║
║   → Spring Security (add login)                      ║
║   → Deploy to Railway / Render (free hosting)        ║
║   → Connect a React frontend                         ║
║   → Try Claude / OpenAI APIs                         ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

---

## SPEAKER NOTES

### Slide 3 (The Problem)
> "Show BadExample.java — everything crammed into one file. Ask: who has written code like this? (everyone raises hand). This works for assignments. But in a company with 50 engineers, this becomes a nightmare."

### Slide 5 (DI)
> "Constructor injection is the Spring way. The object is handed to you — you never call `new` on a service yourself. Spring figures out the right object to give you."

### Slide 8 (Layered Architecture)
> "Open the project. Show the 4 packages: controller, service, repository, model. Each file does exactly one job. Finding a bug? You know exactly which layer to look in."

### Slide 9 (JPA)
> "JpaRepository is an interface — you never write its implementation. Spring generates the SQL at runtime. Magic? No — just good design."

### Slide 10 (REST API)
> "Open Bruno / Postman. Hit the endpoint live. Students see: Java method → HTTP endpoint. That's the moment it clicks."

### Slide 14 (Demo)
> "Now let students clone, run, and hit their own API. Walk them through adding their Gemini key. First successful response = dopamine hit."
