package va.pmg.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import va.pmg.models.request.PMGPromptRequest;
import va.pmg.models.response.PMGServiceResponseBean;
import va.pmg.service.PMGPromptService;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/prompt")
@RequiredArgsConstructor
public class PMGPromptController {

    private final PMGPromptService pmgPromptService;

    @CrossOrigin
    @GetMapping("/generate-prompt/{message}")
    public ResponseEntity<PMGServiceResponseBean> generatePromptResponse(@PathVariable("message") String message){
        try{

            return ResponseEntity.ok()
                    .body(
                            PMGServiceResponseBean.builder()
                                    .data(pmgPromptService.generatePrompt(new PMGPromptRequest(message)).getChoices().get(0).getMessage().getContent())
                                    .message("Prompt generated successfully")
                                    .status(Boolean.TRUE)
                                    .build()
                    );

        }catch (Exception e){
            log.error("Exception in generatePromptResponse : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(PMGServiceResponseBean.builder()
                            .errorMessage("Something went wrong... Please try again!!!!")
                            .status(Boolean.FALSE)
                            .build()
                    );
        }
    }

    @CrossOrigin
    @GetMapping("/generate-test-prompt/{message}")
    public ResponseEntity<PMGServiceResponseBean> generateTestResponse(@PathVariable("message") String message){
        try{
            log.info("Message : {}", message);
            TimeUnit.SECONDS.sleep(8);
            return ResponseEntity.ok()
                    .body(
                            PMGServiceResponseBean.builder()
                                    .data("Process Response for message : " + message)
                                    .message("Prompt generated successfully")
                                    .status(Boolean.TRUE)
                                    .build()
                    );

        }catch (Exception e){
            log.error("Exception in generateTestResponse : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(PMGServiceResponseBean.builder()
                            .errorMessage("Something went wrong... Please try again!!!!")
                            .status(Boolean.FALSE)
                            .build()
                    );
        }
    }

}
