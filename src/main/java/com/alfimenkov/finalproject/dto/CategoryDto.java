package com.alfimenkov.finalproject.dto;

import com.alfimenkov.finalproject.entity.Tour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "tours")
    private List<CategoryTourDto> tours;
}
