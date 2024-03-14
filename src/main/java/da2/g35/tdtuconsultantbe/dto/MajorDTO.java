package da2.g35.tdtuconsultantbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MajorDTO {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MajorResponse{
        private Long id;
        private String code;
        private String name;
    }
}
