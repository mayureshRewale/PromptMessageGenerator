package va.pmg.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Map;

@Component
public class PMGWebClientUtils {

    private WebClient webClient;

    @Value("${app.cgpt.endpoint}")
    private String url;

    @Value("${app.cgpt.secret}")
    private String secretToken;

    public <T> T webClientGet(Class<T> responseClassType){
        webClient = WebClient.create();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(secretToken);

        return webClient.get()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .retrieve()
                .bodyToMono(responseClassType)
                .block();
    }

    public <T> T webClientGet(Class<T> responseClassType, Map<String, Object> requestParams){
        webClient = WebClient.create();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(secretToken);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParams(new LinkedMultiValueMap(requestParams))
                        .build()
                )
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .retrieve()
                .bodyToMono(responseClassType)
                .block();
    }

    public <T> T webClientPost(Class<T> responseClassType){
        webClient = WebClient.create();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(secretToken);

        return webClient.post()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .retrieve()
                .bodyToMono(responseClassType)
                .block();
    }

    public <T> T webClientPost(Class<T> responseClassType, Map<String, Object> requestParams){
        webClient = WebClient.create();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(secretToken);

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParams(new LinkedMultiValueMap(requestParams))
                        .build()
                )
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .retrieve()
                .bodyToMono(responseClassType)
                .block();
    }

    public <T> T webClientPost(Class<T> responseClassType, Object requestBody){
        webClient = WebClient.create();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", secretToken);
//        headers.setBearerAuth(secretToken);

        return webClient.post()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseClassType)
                .block();
    }

}
