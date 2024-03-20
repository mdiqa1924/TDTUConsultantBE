package da2.g35.tdtuconsultantbe.dto;

import da2.g35.tdtuconsultantbe.entity.Combination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class MajorDTO {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MajorResponse{
        private Long id;
        private String code;
        private String name;
        private String img;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherMajors{
        private String code;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MajorDetailResponse{
        private Long id;
        private String code;
        private String name;
        private String intro;
        private String facultyName;
        private String condition;
        private List<CombinationDTO.CombinationResponse> combinations;
        private List<OtherMajors> others;
        private String img;
    }
}
