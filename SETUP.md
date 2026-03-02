# Setup Guide — Windows

Follow these steps in order. Takes about 10 minutes on first run.

---

## Step 0 — Install Java 25

1. Go to **https://adoptium.net**
2. Download **Java 25**, Windows x64 `.msi` installer
3. Run the installer — on the "Custom Setup" screen, make sure these are enabled:
   - **Set JAVA_HOME variable** ✅
   - **Add to PATH** ✅

Verify the install — open Command Prompt and run:
```cmd
java -version
```
You should see something like `openjdk version "25"`. If you see an error, restart your laptop and try again.

---

## Step 1 — Get your free Gemini API key

1. Go to **https://aistudio.google.com**
2. Sign in with your Google account
3. Click **"Get API key"** → **"Create API key"**
4. Copy the key and keep it handy

---

## Step 2 — Clone the repo

Open Command Prompt, navigate to where you want the project, and run:
```cmd
git clone https://github.com/srinivasreddyramaram/java-to-ai-backend.git
cd java-to-ai-backend
```

---

## Step 3 — Add your API key

Open this file in Notepad (or any editor):
```
src\main\resources\application.properties
```

Find this line:
```
gemini.api.key=YOUR_GEMINI_API_KEY_HERE
```

Replace `YOUR_GEMINI_API_KEY_HERE` with the key you copied in Step 1. Save the file.

---

## Step 4 — Run the app

In Command Prompt, from inside the `java-to-ai-backend` folder:
```cmd
mvnw.cmd spring-boot:run
```

> First run will download Maven and all dependencies — this takes 2-3 minutes.
> After that it starts in under 10 seconds.

When you see this line, the app is ready:
```
Started PlacementPrepApplication in 2.3 seconds
```

---

## Step 5 — Test it

**View your database in the browser:**
```
http://localhost:8080/h2-console
```
- JDBC URL: `jdbc:h2:mem:placementdb`
- Username: `sa`
- Password: *(leave blank)*
- Click **Connect**

**Generate interview questions (use Postman or browser):**
```
POST http://localhost:8080/prep?topic=Spring Boot
POST http://localhost:8080/prep?topic=Arrays
POST http://localhost:8080/prep?topic=System Design
```

**View your full practice history:**
```
GET http://localhost:8080/prep/history
```

---

## Troubleshooting

**`java` is not recognized**
→ Java isn't on your PATH. Re-run the JDK installer and make sure "Add to PATH" is checked. Restart Command Prompt after.

**`JAVA_HOME` not set**
→ Re-run the JDK installer and check the "Set JAVA_HOME variable" option. Restart your laptop.

**Port 8080 already in use**
→ Something else is running on port 8080. Add this line to `application.properties` and restart:
```
server.port=8081
```
Then use `http://localhost:8081` instead.

**`mvnw.cmd` is blocked by Windows**
→ Right-click `mvnw.cmd` → Properties → check **Unblock** at the bottom → OK. Then retry.

**API key error / 400 Bad Request from Gemini**
→ Double-check your API key in `application.properties`. Make sure there are no extra spaces.

**STS/Eclipse: "Could not find or load main class"**
→ STS can't find the JDK. Fix:
1. Right-click project → **Build Path → Configure Build Path**
2. Go to the **Libraries** tab
3. Click **Add Library** → **JRE System Library** → **Installed JREs**
4. Click **Add** → **Standard VM** → browse to your JDK installation folder (e.g. `C:\Program Files\Eclipse Adoptium\jdk-25...`)
5. Click **Finish** → **Apply and Close**
6. Right-click project → **Run As → Spring Boot App**
