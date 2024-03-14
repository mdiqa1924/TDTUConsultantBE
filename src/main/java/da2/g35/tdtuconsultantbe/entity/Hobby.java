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
@Table(name = "hobby")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    private Long id;

    @Column(name = "hobby_code")
    private String code;

    @Column(name = "hobby_name")
    private String name;

    @Column(name = "hobby_description")
    private String description;

    @ManyToMany(mappedBy = "userHobbies")
    List<User> whoseHobbies;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "hobby_faculty",
            joinColumns = @JoinColumn(name = "hobby_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    List<Faculty> facultyHobbies;
}
