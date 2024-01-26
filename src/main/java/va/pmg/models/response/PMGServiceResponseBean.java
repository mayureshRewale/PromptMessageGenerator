package va.pmg.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PMGServiceResponseBean {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("data")
    private Object data;

    @JsonProperty("message")
    private String message;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("status")
    private Boolean status;

}
