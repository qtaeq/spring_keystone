package keystone.qtaeq.domain.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="board")
@Getter
@Setter
public class BoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // KEY
    private Long _id;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "date")
    private Timestamp date;

}
