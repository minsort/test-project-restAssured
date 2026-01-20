package com.restAssured.tests.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {
    private Project project;
    private String summary;
    private String description;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Project {
        private String id;
    }

}
