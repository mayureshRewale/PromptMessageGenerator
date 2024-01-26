package va.pmg.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PMGPromptRequest {

    @JsonProperty("prompt")
    private String prompt;

}
