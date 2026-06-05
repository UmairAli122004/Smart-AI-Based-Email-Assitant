# 🚀 Email Writer Assistant - Backend

AI-powered email reply generation service built with **Spring Boot** and **Google Gemini AI**.

The application analyzes incoming email content, applies a desired communication tone, and generates a context-aware email response using Gemini.

---

## 📌 Why This Project?

Writing professional email replies can be repetitive and time-consuming.

This service automates that process by:

✅ Understanding the original email context

✅ Generating human-like responses

✅ Supporting different communication tones

✅ Providing a simple REST API for frontend integration

---

## 🏗 Architecture

```text
Frontend Client
       │
       ▼
REST Controller
       │
       ▼
EmailGeneratorService
       │
       ▼
Prompt Builder
       │
       ▼
Google Gemini API
       │
       ▼
Generated Email Reply
       │
       ▼
Frontend Client
```

---

## ⚙️ Tech Stack

| Technology     | Purpose                    |
| -------------- | -------------------------- |
| Java 21+       | Programming Language       |
| Spring Boot    | Backend Framework          |
| Spring WebFlux | Non-blocking HTTP Client   |
| WebClient      | External API Communication |
| Lombok         | Boilerplate Reduction      |
| Gemini API     | AI Content Generation      |
| Maven          | Dependency Management      |

---

# 📂 Project Structure

```text
src/main/java/com/email/writer

├── Configuration
│   └── Config.java
│
├── Controller
│   └── EmailGeneratorController.java
│
├── Entity
│   └── EmailRequest.java
│
├── Service
│   └── EmailGeneratorService.java
│
└── EmailWriterApplication.java
```

---

# 🔥 Core Features

### AI Email Reply Generation

Generate professional email responses from incoming email content.

### Custom Tone Support

Examples:

* Professional
* Formal
* Friendly
* Casual
* Polite
* Enthusiastic

### REST API Integration

Frontend applications can consume the service through a simple API endpoint.

### Environment-Based Configuration

Sensitive Gemini credentials are stored securely using environment variables.

---

# 🌐 API Documentation

## Generate Email Reply

### Endpoint

```http
POST /api/email/generate
```

### Request Body

```json
{
  "emailContent": "Thank you for applying. We would like to schedule an interview.",
  "tone": "Professional"
}
```

### Request Model

| Field        | Type   | Required |
| ------------ | ------ | -------- |
| emailContent | String | ✅        |
| tone         | String | ❌        |

---

### Sample Response

```text
Thank you for reaching out.

I appreciate the opportunity and would be happy to participate in the interview process. Please let me know the available dates and times.

I look forward to speaking with you.

Best regards
```

---

# 🧠 Prompt Engineering Strategy

The service dynamically constructs a prompt before sending it to Gemini.

Prompt objectives:

* Understand email context
* Generate a natural reply
* Respect requested tone
* Keep response concise
* Avoid hallucinated information
* Return only the email body

This approach ensures consistent and predictable AI responses.

---

# 🔧 Configuration

## application.properties

```properties
spring.application.name=email-writer-sb

gemini.api.url=${GEMINI_API_URL}
gemini.api.key=${GEMINI_API_KEY}
```

---

## Environment Variables

```bash
GEMINI_API_URL=https://generativelanguage.googleapis.com

GEMINI_API_KEY=YOUR_API_KEY
```

Never commit API keys to source control.

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/your-username/email-writer-backend.git

cd email-writer-backend
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run Application

```bash
mvn spring-boot:run
```

or

```bash
java -jar target/email-writer-backend.jar
```



### Body

```json
{
  "emailContent": "Thank you for your application.",
  "tone": "Friendly"
}
```

---

Using cURL:

```bash
curl --location 'http://localhost:8080/api/email/generate' \
--header 'Content-Type: application/json' \
--data '{
    "emailContent":"Thank you for your application.",
    "tone":"Professional"
}'
```

---

# 📖 Key Components

## Service

The business layer responsible for:

* Prompt creation
* Gemini API communication
* Response parsing
* Error handling

This is the core component of the application.

---

---

# 🔄 Request Lifecycle

```text
1. User submits email content
          │
          ▼
2. REST Controller receives request
          │
          ▼
3. Service builds AI prompt
          │
          ▼
4. Request sent to Gemini API
          │
          ▼
5. Gemini generates response
          │
          ▼
6. Response parsed
          │
          ▼
7. Email reply returned to client
```

---

# 🚧 Future Enhancements

* Email Subject Generation
* Multi-Language Support
* Reply Length Control
* Conversation Context Support
* Template-Based Responses
* User Authentication
* Docker Support
* Kubernetes Deployment
* AI Response Caching

---

# 👨‍💻 Umair Ali

Built as a practical AI integration project demonstrating:

* Spring Boot Development
* REST API Design
* External API Integration
* Prompt Engineering
* Environment-Based Configuration
* Clean Layered Architecture

---

⭐ If you found this project useful, consider giving it a star.
