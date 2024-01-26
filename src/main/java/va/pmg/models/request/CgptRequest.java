package va.pmg.models.request;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CgptRequest {

    private String model;

    private List<CgptMessage> messages;

//    private int n;
//
//    private double temperature;

    public CgptRequest(String model, String prompt) {
        this.model = model;
        this.messages = Arrays.asList(new CgptMessage("user", prompt));
    }

}
