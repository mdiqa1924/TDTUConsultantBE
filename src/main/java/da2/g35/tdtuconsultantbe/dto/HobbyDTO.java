package da2.g35.tdtuconsultantbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class HobbyDTO {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HobbyResponse{
        private Long id;
        private String code;
        private String name;
        private String description;
    }
}
