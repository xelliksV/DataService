package com.apihack.controllers;

import com.apihack.model.Consent;
import com.apihack.model.ConsentRequest;
import com.apihack.model.ConsentResponse;
import com.apihack.model.ConsentType;
import com.apihack.repositories.ConsentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("/consents")
@RequiredArgsConstructor
public class ConsentsController {
    private static final String ACCOUNT_URL_TEMPLATE = "https://%s.open.bankingapi.ru/account-consents/%s";
    private static final String PAYMENT_URL_TEMPLATE = "https://%s.open.bankingapi.ru/payment-consents/%s";

    private final WebClient.Builder builder;
    private final ConsentRepository repository;

    @PostMapping("/account/request")
    public void getAccountConsent(@RequestParam String bank, @RequestParam String clientId) {
        ConsentRequest request = new ConsentRequest();
        request.setClient_id(clientId);
        Mono<ConsentResponse> consentResponseMono = builder.build()
                .post()
                .uri(String.format(ACCOUNT_URL_TEMPLATE, bank, "request"))
                .header("Authorization", "Bearer " + System.getenv(bank + "_token"))
                .contentType(MediaType.APPLICATION_JSON)
                .header("X-Requesting-Bank", "team098")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ConsentResponse.class);
        repository.save(new Consent(clientId, Objects.requireNonNull(consentResponseMono.block()).getConsent_id(), ConsentType.ACCOUNT));
    }
}
