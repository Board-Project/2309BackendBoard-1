package com.github.board.repository.Articles;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
@Table(name = "post")
public class ArticleEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "title",length =20,nullable = true)
    private String title;

    @Column(name = "content",length = 50,nullable = true)
    private String content;



}
