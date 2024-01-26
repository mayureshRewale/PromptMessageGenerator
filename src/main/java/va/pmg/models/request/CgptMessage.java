package va.pmg.models.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CgptMessage {

    private String role;

    private String content;

}
