package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import hello.Lesson;
import hello.LessonRepository;

@Component
public class DataInit implements ApplicationRunner {
	
	private LessonRepository lessonRepository;
	
	@Autowired
	public DataInit(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = lessonRepository.count();
		
		if (count == 0) {
			for (int i = 0; i < 2; i++) {
				Lesson ls = new Lesson();
				ls.setTitle("Lesson 1." + i);
				ls.setLessonText("Lorem ipsum dolor sit amet, consectetur "   +
								"adipiscing elit, sed do eiusmod tempor "    +
								"incididunt ut labore et dolore magna " 	  +
								"aliqua. Ut enim ad minim veniam, quis "	  +
								"nostrud exercitation ullamco laboris nisi " +
								"ut aliquip ex ea commodo consequat. Duis "  +
								"aute irure dolor in reprehenderit in "	  +
								"voluptate velit esse cillum dolore eu "	  +
								"fugiat nulla pariatur. Excepteur sint "	  +
								"occaecat cupidatat non proident, sunt "	  +
								"in culpa qui officia deserunt mollit anim " +
								"id est laborum.");
				ls.setAnswer(1);
				ls.setQuestion("Question for the lesson.");
				ls.setOption1("Correct answer");
				ls.setOption2("Incorrect answer 1");
				ls.setOption3("Incorrect answer 2");
				lessonRepository.save(ls);
			}
		}
	}
}
