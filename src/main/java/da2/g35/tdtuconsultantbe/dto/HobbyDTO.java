package da2.g35.tdtuconsultantbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MBTITestResult{
        private String email;
        private String result;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MBTITestResponse{
        private String name;
        private String description;
        private List<String> majors;
    }
}
