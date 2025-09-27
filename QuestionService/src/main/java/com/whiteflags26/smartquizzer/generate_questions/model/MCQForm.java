package com.whiteflags26.smartquizzer.generate_questions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MCQForm {
    private String question;
    private List<String> options;
    private String correctOption;
    private String explanation;
}
