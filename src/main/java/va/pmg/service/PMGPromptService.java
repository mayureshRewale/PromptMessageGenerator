package va.pmg.service;

import va.pmg.models.request.PMGPromptRequest;
import va.pmg.models.response.CgptResponse;

public interface PMGPromptService {

    CgptResponse generatePrompt(PMGPromptRequest pmgPromptRequest) throws Exception;

}
