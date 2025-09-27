package com.whiteflags26.smartquizzer.generate_questions.service;

import com.whiteflags26.smartquizzer.client.GeminiServiceClient;
import com.whiteflags26.smartquizzer.client.UserServiceClient;
import com.whiteflags26.smartquizzer.generate_questions.model.OpinionativeForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OpinionativeService {

    private final GeminiServiceClient geminiServiceClient;
    private final UserServiceClient userServiceClient;

    public OpinionativeService(GeminiServiceClient geminiServiceClient, UserServiceClient userServiceClient) {
        this.geminiServiceClient = geminiServiceClient;
        this.userServiceClient = userServiceClient;
    }

    public OpinionativeForm generateOpinionQuestion(String passage) {
        String prompt = "Generate one opinion-based question from the given passage. " +
                "The question should encourage expressing personal views about ideas or themes in the passage. " +
                "Format the response as a JSON object with these fields: " +
                "\"question\" (the opinion-based question), " +
                "\"sampleAnswer\" (a sample answer to the question), " +
                "\"scoringGuidelines\" (brief guidelines on how to evaluate answers to this question). " +
                "Here's the passage:\n\n" + passage;

        com.whiteflags26.smartquizzer.client.dto.GeminiRequest request =
            new com.whiteflags26.smartquizzer.client.dto.GeminiRequest(prompt, "OpinionativeForm");
        Object response = geminiServiceClient.generateContent(request);
        return (OpinionativeForm) response;
    }
}
