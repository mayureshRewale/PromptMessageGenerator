package va.pmg.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import va.pmg.models.request.CgptMessage;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CgptResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("created")
    private Long created;

    @JsonProperty("choices")
    private List<Choice> choices;

    @JsonProperty("usage")
    private Usage usage;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {

        @JsonProperty("index")
        private Integer index;

        @JsonProperty("message")
        private CgptMessage message;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Usage {

        @JsonProperty("prompt_tokens")
        private Integer promptTokens;

        @JsonProperty("completion_tokens")
        private Integer completionTokens;

        @JsonProperty("total_tokens")
        private Integer totalTokens;
    }

    public String getMetadata(){
        return "{id : " + this.id + ", created : " + this.created
                + ", prompt-tokens : " + this.usage.promptTokens
                + ", completion-tokens : " + this.usage.completionTokens
                + ", total-tokens : " + this.usage.totalTokens +"}";
    }

}
