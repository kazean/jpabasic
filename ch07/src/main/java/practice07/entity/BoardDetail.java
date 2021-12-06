package practice07.entity;

import javax.persistence.*;

@Entity
public class BoardDetail {
    @Id
    private Long boardId;

    @MapsId
    @OneToOne
    private Board board;

    private String content;
}
