package da2.g35.tdtuconsultantbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transcript")
public class Transcript {
    @Id
    @Column(name = "account_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private User user;

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
