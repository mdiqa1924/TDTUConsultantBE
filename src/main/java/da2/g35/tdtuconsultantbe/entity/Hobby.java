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
@Table(name = "hobby")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    private Long id;

    @Column(name = "hobby_name")
    private String name;

    @ManyToMany(mappedBy = "userHobbies")
    List<User> whoseHobbies;

    @ManyToMany(mappedBy = "majorHobbies")
    List<Major> majorByHobby;
}
