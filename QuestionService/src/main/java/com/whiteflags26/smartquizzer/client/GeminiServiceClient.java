package com.whiteflags26.smartquizzer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.whiteflags26.smartquizzer.client.dto.GeminiRequest;

@FeignClient(name = "ai-service")
public interface GeminiServiceClient {
    @PostMapping("/api/ai/gemini/generate")
    Object generateContent(@RequestBody GeminiRequest request);
}
