package da2.g35.tdtuconsultantbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SubjectDTO {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubjectResponse{
        private Long id;
        private String name;
    }
}
