package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id // id 속성을 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //속성에 값을 일일이 입력하지 않아도 자동으로 1씩 증가
    private Integer id;

    // 열의 세부 설정
    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // casecade 부분은 게시글 하나를 삭제할 때 거기 달린 답변이 여러개여도 함께 삭제하는 속성
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}