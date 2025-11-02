package com.apihack.model.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsentGetResponse {

    private Data data;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Data {
        private String consentId;
        private String status;
        private String creationDateTime;
        private String statusUpdateDateTime;
        private List<String> permissions;
        private String expirationDateTime;
    }
}
