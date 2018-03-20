package familyEducation;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jhyarrow.familyEducation.service.QuestionService;

public class PDFTest extends JUnitTest{
	@Autowired
	private QuestionService questionService;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void test() {
		questionService.getQuestion();
	}
	
}
