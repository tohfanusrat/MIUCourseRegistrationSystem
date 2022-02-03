package edu.miu.cs.cs425.eregistrar.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequestBody {
    @NotNull
    private Long userId;
    @NotNull
    private Long academicBlockId;
    @NotNull
    private Long courseId;
    @NotNull
    private Integer priorityIndex;
}

