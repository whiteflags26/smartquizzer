package com.whiteflags26.smartquizzer.generate_questions.service;

import com.whiteflags26.smartquizzer.client.GeminiServiceClient;
import com.whiteflags26.smartquizzer.client.UserServiceClient;
import com.whiteflags26.smartquizzer.generate_questions.model.MCQForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenerateMCQService {

    private final GeminiServiceClient geminiServiceClient;
    private final UserServiceClient userServiceClient;

    public GenerateMCQService(GeminiServiceClient geminiServiceClient, UserServiceClient userServiceClient) {
        this.geminiServiceClient = geminiServiceClient;
        this.userServiceClient = userServiceClient;
    }

    public MCQForm generateMCQ(String passage) {
        String prompt = "Generate one multiple choice question based on the given passage. " +
                "The question should test understanding of the passage. " +
                "Provide 4 options labeled A, B, C, D with one correct answer. " +
                "Format the response as a JSON object with these fields: " +
                "\"question\" (the question text), " +
                "\"options\" (an array of 4 option texts without the A, B, C, D labels), " +
                "\"correctOption\" (the text of the correct option), " +
                "\"explanation\" (explanation of why the answer is correct). " +
                "Here's the passage:\n\n" + passage;

        com.whiteflags26.smartquizzer.client.dto.GeminiRequest request =
            new com.whiteflags26.smartquizzer.client.dto.GeminiRequest(prompt, "MCQForm");
        Object response = geminiServiceClient.generateContent(request);
        return (MCQForm) response;
    }
}
