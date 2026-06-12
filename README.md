# 🚀 Email Writer Assistant

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


# 🔥 Core Features
```

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
```

## Generate Email Reply
```
### Endpoint

```http
POST /api/email/generate
```

### Request Body
```
```json
{
  "emailContent": "Thank you for applying. We would like to schedule an interview.",
  "tone": "Professional"
}
```
---

### Sample Response
```
Thank you for reaching out.

I appreciate the opportunity and would be happy to participate in the interview process. Please let me know the available dates and times.

I look forward to speaking with you.

Best regards

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


# 📖 Key Components

## Service

The business layer responsible for:

* Prompt creation
* Gemini API communication
* Response parsing
* Error handling

This is the core component of the application.

# 🔄 Request Lifecycle

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

# Email Writer Assistant Chrome Extension

## Overview

Email Writer Assistant is a Chrome Extension that integrates directly with Gmail and helps users generate AI-powered email replies with a single click.

The extension adds an **"AI Reply"** button to the Gmail compose window. When clicked, it sends the selected email content to a backend API, generates a professional response using AI, and automatically inserts the generated reply into the compose box.

---

## Features

* Integrates seamlessly with Gmail.
* Adds an **AI Reply** button to the compose window.
* Generates professional email responses using AI.
* Automatically inserts generated replies into Gmail.
* Lightweight and easy to use.
* Built using Manifest V3.

---

## Tech Stack

### Frontend

* JavaScript
* HTML
* CSS
* Chrome Extension Manifest V3

### Backend

* Java
* Spring Boot
* REST API

### AI Integration

* Gemini API / LLM Backend

---

## Project Structure

```text
email-writer-ext/
│
├── manifest.json
├── content.js
├── content.css
└── icons/
```

---

## How It Works

1. User opens Gmail.
2. Extension detects the Gmail compose window.
3. An **AI Reply** button is injected into the compose toolbar.
4. User clicks the button.
5. Extension extracts the email content.
6. Content is sent to the backend API:

```http
POST http://localhost:8080/api/email/generate
```

7. Backend generates an AI-powered response.
8. Generated response is inserted into the Gmail compose box.

---

## Permissions Used

### Active Tab

Allows the extension to interact with the current Gmail tab.

```json
"permissions": ["activeTab", "storage"]
```

### Host Permissions

```json
"host_permissions": [
  "http://localhost:8080/*",
  "*://mail.google.com/*"
]
```

These permissions allow:

* Communication with the backend API.
* Access to Gmail pages.

---

## Installation

### Clone Repository

```bash
git clone <repository-url>
```

### Load Extension in Chrome

1. Open Chrome.
2. Navigate to:

```text
chrome://extensions
```

3. Enable **Developer Mode**.
4. Click **Load Unpacked**.
5. Select the `email-writer-ext` folder.

The extension is now installed.

---

## Backend Setup

Start the Spring Boot backend application.

Ensure the backend is running on:

```text
http://localhost:8080
```

API Endpoint:

```http
POST /api/email/generate
```

Expected Request:

```json
{
  "emailContent": "Original email content",
  "tone": "professional"
}
```

Expected Response:

```text
Generated AI email reply
```

---

## Future Enhancements

* Multiple reply tones:

  * Professional
  * Friendly
  * Formal
  * Casual

* Custom prompt templates.

* Reply length selection.

* Dark mode support.

* Multi-language support.

* Support for Outlook and other email clients.

---

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
