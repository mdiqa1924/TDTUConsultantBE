package da2.g35.tdtuconsultantbe.entity;

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
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Long id;

    @Column(name = "faculty_name")
    private String name;

    @Column(name = "faculty_founding")
    private String found;

    @Column(name = "faculty_url")
    private String url;

    @Column(name = "faculty_img")
    private String img;

    @OneToMany(mappedBy = "faculty")
    private Set<Major> majors;

    @ManyToMany(mappedBy = "facultyHobbies")
    List<Hobby> hobbyByFaculty;
}
