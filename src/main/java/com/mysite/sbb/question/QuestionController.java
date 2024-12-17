package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/question") // //question을 프리픽스 하기 위해서
@RequiredArgsConstructor // 애너테이션 생성자 방식 -> questionRepository 객체 주입
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
//  @ResponseBody <- 템플릿 사용할 시에는 필요없음
    public String list(Model model) { // 자바 클래스(Java class)와 템플릿(template) 간의 연결 고리
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    // 변하는 id 값을 얻을 때
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}