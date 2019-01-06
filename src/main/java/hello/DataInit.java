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
			Lesson ls = new Lesson();
			ls.setName("first lesson");
			lessonRepository.save(ls);
		}
	}
}