package com.alfimenkov.finalproject.dto;

import javafx.scene.transform.Scale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class CategoryTourDto {

    @JsonProperty(value = "name")
    private String name;

}
