package com.whiteflags26.smartquizzer.client.dto;

public class GeminiRequest {
    private String prompt;
    private String responseType;

    public GeminiRequest() {}

    public GeminiRequest(String prompt, String responseType) {
        this.prompt = prompt;
        this.responseType = responseType;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
