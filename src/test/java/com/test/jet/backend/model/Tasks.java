package com.test.jet.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tasks {
    private int id;
    private String title;
    private String due_at;
    private boolean is_completed;
    private Author author;
}
