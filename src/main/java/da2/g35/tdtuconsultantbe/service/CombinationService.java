package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.entity.Combination;

import java.util.List;

public interface CombinationService {
    List<Combination> getCombinationsByMajor(Long id);
    List<Combination> getCombinationsBySubject(Long id);
}
