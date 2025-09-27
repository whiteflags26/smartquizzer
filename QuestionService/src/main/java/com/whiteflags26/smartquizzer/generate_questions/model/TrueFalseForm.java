package com.whiteflags26.smartquizzer.generate_questions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrueFalseForm {
    private String statement;
    private boolean isTrue;
    private String explanation;
}
