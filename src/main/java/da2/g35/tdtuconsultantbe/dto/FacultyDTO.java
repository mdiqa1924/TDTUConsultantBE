package da2.g35.tdtuconsultantbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FacultyDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FacultyResponse{
        private Long id;
        private String name;
        private String found;
        private String url;
        private String img;
    }
}
