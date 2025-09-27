package com.whiteflags26.smartquizzer.generate_questions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpinionativeForm {
    private String question;
    private String sampleAnswer;
    private String scoringGuidelines;
}
