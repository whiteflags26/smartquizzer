package com.whiteflags26.smartquizzer.generate_questions.service;

import com.whiteflags26.smartquizzer.client.GeminiServiceClient;
import com.whiteflags26.smartquizzer.client.UserServiceClient;
import com.whiteflags26.smartquizzer.generate_questions.model.TrueFalseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenerateTrueFalseService {

    private final GeminiServiceClient geminiServiceClient;
    private final UserServiceClient userServiceClient;

    public GenerateTrueFalseService(GeminiServiceClient geminiServiceClient, UserServiceClient userServiceClient) {
        this.geminiServiceClient = geminiServiceClient;
        this.userServiceClient = userServiceClient;
    }

    public TrueFalseForm generateTrueFalse(String passage) {
        String prompt = "Generate one true/false statement based on the given passage. " +
                "The statement should be related to the passage and could be either true or false. " +
                "Format the response as a JSON object with these fields: " +
                "\"statement\" (the statement text), " +
                "\"isTrue\" (a boolean value, true if the statement is true according to the passage, false if it's false), " +
                "\"explanation\" (explanation of why the statement is true or false). " +
                "Here's the passage:\n\n" + passage;

        // Use GeminiRequest DTO
        com.whiteflags26.smartquizzer.client.dto.GeminiRequest request =
            new com.whiteflags26.smartquizzer.client.dto.GeminiRequest(prompt, "TrueFalseForm");
        Object response = geminiServiceClient.generateContent(request);
        return (TrueFalseForm) response;
    }
}
