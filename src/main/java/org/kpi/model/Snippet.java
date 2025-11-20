package org.kpi.model;

import lombok.Data;

@Data
public class Snippet {
    private int id;
    private String title;
    private String commandBody;
    private String description;
}