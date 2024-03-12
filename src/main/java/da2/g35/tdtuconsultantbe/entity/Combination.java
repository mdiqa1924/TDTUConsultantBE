package da2.g35.tdtuconsultantbe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "combination")
public class Combination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "combination_id")
    private Long id;

    @Column(name = "combination_name")
    private String name;

    @ManyToMany(mappedBy = "majorCombinations")
    List<Major> majorByCombination;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "combination_subject",
            joinColumns = @JoinColumn(name = "combination_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    List<Subject> combinationSubjects;
}
