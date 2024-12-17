package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 클래스가 스프링 부트의 테스트 클래스
@SpringBootTest
@ActiveProfiles("test")
class SbbApplicationTests {

	@Autowired //Autowired 의존성 주입, questionRepositoryory 객체 주입
	private QuestionRepository questionRepository;

	@Autowired // 의존성 주입
	private AnswerRepository answerRepository;
	@Transient // 메서드가 종료될 때까지 DB 세션이 유지
	@Transactional // 해당 메서드 실행 동안 세션이 유지
	@Test
		// testJpa가 테스트임을 나타냄
	void testJpa() {
		// 질문을 조회한 후 이 질문에 달린 답변 전체를 구하는 테스트 코드
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네, 자동으로 생성됩니다.", answerList.get(0).getContent());

		// id값을 활용해 답변 데이터 조회
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());

//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네, 자동으로 생성됩니다.");
//		a.setQuestion(q); // 어떤 질문의 답변인지 알기 위에 Question 객체 필요
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a); // 저장


		// count 메서드는 테이블 행의 개수를 리턴
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());

//		데이터 수정
//		Optional<Question> oq = this.questionRepository.findById(1);
//		// assertTrue() 괄호 안에 값이 참인지 판단
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);

		// sbb% 'sbb'로 시작하는 문자열
		// %sbb 'sbb'로 끝나는 문자열
		// %sbb% 'sbb'를 포함하는 문자열
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가?", q.getSubject());


//		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(19, q.getId());


		// findById로 호출한 값이 존재할 수도 있고, 존재하지 않을 수도 있어서
		// 리턴 값을 Optional 사용
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) { // isPresent() 메서드로 값이 존재하는지 확인
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(9, q.getId());
		// findall은 select * from 와 같은 의미
//
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1); // 첫번째 질문 저장
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2); // 두번째 질문 저장
	}
}