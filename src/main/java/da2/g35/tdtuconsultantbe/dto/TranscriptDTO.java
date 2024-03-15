package da2.g35.tdtuconsultantbe.dto;

import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.entity.Transcript;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class TranscriptDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TranscriptUpdateForm {
        private double toan;
        private double nguVan;
        private double tiengAnh;
        private double vatLy;
        private double hoaHoc;
        private double sinhHoc;
        private double lichSu;
        private double diaLy;
        private double gdcd;
        private double congNghe;
        private double tinHoc;
        private double gdqp;
        private double gdtc;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TranscriptResponse{
        private Long id;
        private TranscriptUpdateForm scores;
//        private List<Major> majorList;
    }

}
