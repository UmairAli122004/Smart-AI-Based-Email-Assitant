package com.email.writer.Service;

import com.email.writer.Entity.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class EmailGeneratorService {
    private final WebClient webClient;
    private final String apiKey;
    public EmailGeneratorService(WebClient.Builder webClientBuilder,
                                 @Value("${gemini.api.url}") String baseUrl,
                                 @Value("${gemini.api.key}") String apiKey
                                 ) {
        this.apiKey = apiKey;
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public String generateEmailReply(EmailRequest emailRequest) {
        //Build Prompt
        String prompt = buildPrompt(emailRequest);

        //Prepare raw JSON Body
        String requestBody = String.format("""
                {
                    "contents": [
                      {
                        "parts": [
                          {
                            "text": "%s"
                          }
                        ]
                      }
                    ]
                  }
                """, prompt);

        /*
        *
        *
        * Map<String, Object> body = Map.of(
            "contents", List.of(
                Map.of(
                    "parts", List.of(
                        Map.of("text", prompt)
                    )
                )
            )
        );

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(body);
        *
        * */

        //Send Request
        String response = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1beta/models/gemini-3.5-flash:generateContent")
                        .build())
                .header("x-goog-api-key", apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //Extract Response;
        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root =  mapper.readTree(response);
            return root.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asString();
        }catch(JacksonException e){
            throw new RuntimeException(e);
        }

    }


    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("""
        You are an expert email assistant.

        Generate an appropriate reply to the email below.

        Instructions:
        - Understand the context of the original email.
        - Write a natural email reply.
        - Use the requested tone.
        - Keep the response concise and relevant.
        - Do not make up information.
        - Return only the email reply text.
        - Do not include explanations or notes.

        """);

        if (emailRequest.getTone() != null && !emailRequest.getTone().isBlank()) {
            prompt.append("Tone: ")
                    .append(emailRequest.getTone())
                    .append("\n\n");
        }

        prompt.append("Original Email:\n")
                .append(emailRequest.getEmailContent());

        return prompt.toString();
    }
}
