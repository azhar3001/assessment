package com.mydemo.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiStateDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("capital")
    private String capital;

    @JsonProperty("government_menteri_besar")
    private String picName;

}
