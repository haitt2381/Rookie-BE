package com.nashtech.rookie.dto.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public final class ErrorResponse extends AbstractResponse {

  @JsonProperty("errors")
  Map<String, String> errors;

}
