package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.TranscriptDTO;
import da2.g35.tdtuconsultantbe.entity.Transcript;

public interface TranscriptService {
    TranscriptDTO.TranscriptUpdateForm getTranscriptByUser(Long id);
    Transcript update(Long id, TranscriptDTO.TranscriptUpdateForm transcriptUpdateForm);
}
