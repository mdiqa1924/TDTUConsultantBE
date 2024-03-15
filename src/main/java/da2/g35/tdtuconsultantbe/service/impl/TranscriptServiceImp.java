package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.TranscriptDTO;
import da2.g35.tdtuconsultantbe.entity.*;
import da2.g35.tdtuconsultantbe.repository.*;
import da2.g35.tdtuconsultantbe.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TranscriptServiceImp implements TranscriptService {
    @Autowired
    private TranscriptRepository transcriptRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private CombinationRepository combinationRepository;

    @Override
    public TranscriptDTO.TranscriptUpdateForm getTranscriptByUser(Long id) {
        User user = userRepository.findById(id).get();
        Transcript transcript = transcriptRepository.findByUser(user);

        TranscriptDTO.TranscriptUpdateForm response = new TranscriptDTO.TranscriptUpdateForm();
        response.setToan(transcript.getToan());
        response.setVatLy(transcript.getVatLy());
        response.setHoaHoc(transcript.getHoaHoc());
        response.setTiengAnh(transcript.getTiengAnh());
        response.setSinhHoc(transcript.getSinhHoc());
        response.setDiaLy(transcript.getDiaLy());
        response.setLichSu(transcript.getLichSu());
        response.setGdcd(transcript.getGdcd());
        response.setGdqp(transcript.getGdqp());
        response.setGdtc(transcript.getGdtc());
        response.setNguVan(transcript.getNguVan());
        response.setTinHoc(transcript.getTinHoc());
        response.setCongNghe(transcript.getCongNghe());

        return response;
    }

    @Override
    public Transcript update(Long id, TranscriptDTO.TranscriptUpdateForm transcriptUpdateForm) {
        Transcript thisTranscript = transcriptRepository.findById(id).get();
        thisTranscript.setToan(transcriptUpdateForm.getToan());
        thisTranscript.setNguVan(transcriptUpdateForm.getNguVan());
        thisTranscript.setTiengAnh(transcriptUpdateForm.getTiengAnh());
        thisTranscript.setVatLy(transcriptUpdateForm.getVatLy());
        thisTranscript.setHoaHoc(transcriptUpdateForm.getHoaHoc());
        thisTranscript.setSinhHoc(transcriptUpdateForm.getSinhHoc());
        thisTranscript.setLichSu(transcriptUpdateForm.getLichSu());
        thisTranscript.setDiaLy(transcriptUpdateForm.getDiaLy());
        thisTranscript.setGdcd(transcriptUpdateForm.getGdcd());
        thisTranscript.setCongNghe(transcriptUpdateForm.getCongNghe());
        thisTranscript.setTinHoc(transcriptUpdateForm.getTinHoc());
        thisTranscript.setGdqp(transcriptUpdateForm.getGdqp());
        thisTranscript.setGdtc(transcriptUpdateForm.getGdtc());

        Transcript result = transcriptRepository.save(thisTranscript);
        return result;
    }

    //get all possible majors for User based on 3 highest scores
    //in their Transcript
//    public List<Major> getPossibleMajorsByTranscript(Transcript transcript){
//        List<String> subjects = getThreeHighestScores(transcript);
//        List<Subject> subjectList = new ArrayList<>();
//        for(String s : subjects){
//            subjectList.add(subjectRepository.findByName(s));
//        }
//        Combination combination = combinationRepository.findCombinationByCombinationSubjects(subjectList);
//        List<Major> majors = majorRepository.findByMajorCombinations(combination);
//        return majors;
//    }

    public List<String> getThreeHighestScores(Transcript transcript){
        HashMap<String, Double> scores = new HashMap<String, Double>();
        scores.put("Toan", transcript.getToan());
        scores.put("Ngu Van", transcript.getNguVan());
        scores.put("Tieng Anh", transcript.getTiengAnh());
        scores.put("Vat Ly", transcript.getVatLy());
        scores.put("Hoa hoc", transcript.getHoaHoc());
        scores.put("Sinh hoc", transcript.getSinhHoc());
        scores.put("Lich su", transcript.getLichSu());
        scores.put("Dia ly", transcript.getDiaLy());
        scores.put("GDCD", transcript.getGdcd());
        scores.put("Cong nghe", transcript.getCongNghe());
        scores.put("Tin hoc", transcript.getTinHoc());
        scores.put("GDQP", transcript.getGdqp());
        scores.put("GDTC", transcript.getGdtc());

        List<String> subjects = scores.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        return subjects;
    }
}
