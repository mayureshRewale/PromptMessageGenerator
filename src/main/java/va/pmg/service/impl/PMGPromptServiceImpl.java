package va.pmg.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import va.pmg.models.request.CgptRequest;
import va.pmg.models.request.PMGPromptRequest;
import va.pmg.models.response.CgptResponse;
import va.pmg.models.response.PMGServiceResponseBean;
import va.pmg.service.PMGPromptService;
import va.pmg.utils.PMGWebClientUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class PMGPromptServiceImpl implements PMGPromptService {

    @Value("${app.cgpt.model}")
    private String model;

    private final PMGWebClientUtils pmgWebClientUtils;

    @Override
    public CgptResponse generatePrompt(PMGPromptRequest pmgPromptRequest) throws Exception {
        try{
            //CREATE REQUEST FOR CGPT
            CgptRequest cgptRequest = new CgptRequest(model, pmgPromptRequest.getPrompt());

            //CALL WEBCLIENT WITH REQUEST BODY
            CgptResponse cgptResponse = pmgWebClientUtils.webClientPost(CgptResponse.class, cgptRequest);
            log.info("Json Response : {}", cgptResponse);
            log.info("Metadata : {}", cgptResponse.getMetadata());

            //RETURN STRING RESPONSE
            return cgptResponse;

        }catch (Exception e){
            log.info("Exception in generatePrompt : {}", e.getMessage());
            throw new Exception("DD-ER");
        }
    }

}
