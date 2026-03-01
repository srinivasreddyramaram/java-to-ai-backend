# Placement Prep Assistant — Backend

> AI-powered interview question generator built with Spring Boot 4 + Google Gemini

Built live during the **"From Java to AI"** session at Malla Reddy University.

---

## What This App Does

- Student enters a topic (e.g. "Spring Boot", "Arrays", "System Design")
- App calls Google Gemini AI and returns **5 interview questions** on that topic
- Questions are saved to a database
- Student can retrieve their full practice history anytime

---

## Project Structure

```
src/main/java/com/srinivasreddyramaram/placementprep/
├── controller/    ← handles HTTP requests, nothing else
├── service/       ← all business logic lives here
├── repository/    ← talks to the database
├── model/         ← data structures (entities)
└── config/        ← beans and configuration
```

---

## Prerequisites

- Java 25
- A free Gemini API key — get one at [aistudio.google.com](https://aistudio.google.com)
- *(No Maven installation needed — Maven Wrapper is included)*

---

## Setup

**1. Clone the repo**
```bash
git clone https://github.com/srinivasreddyramaram/java-to-ai-backend.git
cd java-to-ai-backend
```

**2. Add your Gemini API key**

Open `src/main/resources/application.properties` and replace the placeholder:
```properties
gemini.api.key=YOUR_GEMINI_API_KEY_HERE
```

**3. Run the app**
```bash
# On Mac / Linux
./mvnw spring-boot:run

# On Windows
mvnw.cmd spring-boot:run
```

App starts at `http://localhost:8080`

---

## API Endpoints

### Generate interview questions
```
POST http://localhost:8080/prep?topic=Spring Boot
```

Response:
```json
{
  "id": 1,
  "topic": "Spring Boot",
  "questions": "1. What is Spring Boot?\n2. ...",
  "createdAt": "2026-02-28T10:30:00"
}
```

### View practice history
```
GET http://localhost:8080/history
```

### View your data in the browser
```
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:placementdb
Username: sa
Password: (leave blank)
```

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Framework | Spring Boot 4.0.3 |
| Language | Java 25 |
| Database | H2 (in-memory) |
| ORM | Spring Data JPA / Hibernate 7 |
| AI | Google Gemini 1.5 Flash |
| HTTP Client | RestTemplate |
| Boilerplate | Lombok |
