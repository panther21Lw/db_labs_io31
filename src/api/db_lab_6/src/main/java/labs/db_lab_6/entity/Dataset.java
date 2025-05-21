package labs.db_lab_6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "datasets")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "response_id")
    @JsonIgnore
    private Response response;

    @Column(name = "text")
    private String text;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "diagram")
    private String diagram;

    @Column(name = "label")
    private String label;

    @Column(name = "source")
    private String source;

    @Column(name = "created_att")
    private LocalDateTime createdAt;
}
