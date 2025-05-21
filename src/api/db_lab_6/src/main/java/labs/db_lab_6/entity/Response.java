package labs.db_lab_6.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "responses")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "graphic")
    private String graphic;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "response", orphanRemoval = true)
    private List<Dataset> datasets;

    @OneToMany(mappedBy = "response", orphanRemoval = true)
    private List<Feedback> feedbacks;
}
