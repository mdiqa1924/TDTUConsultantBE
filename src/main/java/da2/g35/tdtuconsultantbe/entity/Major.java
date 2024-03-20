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
@Table(name = "major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private Long id;

    @Column(name = "major_code")
    private String code;

    @Column(name = "major_name")
    private String name;

    @Column(name = "major_img")
    private String img;

    @Column(name = "major_intro", columnDefinition="TEXT")
    private String intro;

    @Column(name = "major_condition")
    private String condition;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToMany(mappedBy = "userMajors")
    List<User> whoseMajors;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "major_combination",
            joinColumns = @JoinColumn(name = "major_id"),
            inverseJoinColumns = @JoinColumn(name = "combination_id")
    )
    List<Combination> majorCombinations;
}
