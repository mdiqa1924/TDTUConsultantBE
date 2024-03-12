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
@Table(name = "user")
public class User {
    @Id
    @Column(name = "account_id")
    private Long id;

    private String fullname;
    private String dob;
    private String phoneNumber;
    private String school;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_hobby",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id")
    )
    List<Hobby> userHobbies;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_major",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "major_id")
    )
    List<Major> userMajors;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Transcript transcript;
}
