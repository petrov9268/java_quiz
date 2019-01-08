package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import hello.Lesson;
import hello.LessonRepository;
import hello.Comments;
import hello.CommentsRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /course (after Application path)
public class MainController {
	@Autowired // This means to get the bean called lessonRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private LessonRepository lessonRepository;
	@Autowired
	private CommentsRepository commentsRepository;

	@GetMapping(path="course")
    public String showCoursePage(Model model) {
		Page<Lesson> pg = getPage(0, 10);
		model.addAttribute("hasContent", pg.hasContent());
		if (pg.hasContent()) {
			model.addAttribute("lessons", pg.getContent());
		}
        return "course";
    }
	
	/*@GetMapping(path="course/add") // Map ONLY GET Requests
	public @ResponseBody String addLesson(@RequestParam Long id,
											@RequestParam String name,
											@RequestParam String comment) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Comments cm = new Comments();
		cm.setLessonId(id);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		cm.setDate(LocalDateTime.now().format(df));
		cm.setName(name);
		cm.setComment(comment);
		commentsRepository.save(cm);
		return "Saved";
	}*/

	@GetMapping(path="course/all")
	public @ResponseBody Iterable<Comments> getAllComments() {
		// This returns a JSON or XML with the lessons
		return commentsRepository.findAll();
	}
	
	@GetMapping(path = "course/edit")
	public String showEditPage(@RequestParam(value = "page", required = false) Integer page, Model model) {
		model.addAttribute("currPage", page);
		if (page != null) {
			Lesson ls = getPage(page).getContent().get(0);
			model.addAttribute("lessonTitle", ls.getTitle());
			model.addAttribute("lessonText", ls.getLessonText());
		}
		return "edit";
	}
	
	@PostMapping(path = "course/edit")
	public String addLesson(@RequestParam(value = "page", required = false) Integer page,
							@RequestParam String title,
							@RequestParam String lessonText) {
		if (page != null) {
			List<Lesson> pg = getPage(page).getContent();
			if (pg.isEmpty()) {
				return "redirect:"; //do a proper 404 page
			}
			Lesson ls = pg.get(0);
			ls.setTitle(title);
			ls.setLessonText(lessonText);
			lessonRepository.save(ls);
			return "redirect:/course/show?page=" + page;	
		}
		Lesson ls = new Lesson();
		ls.setTitle(title);
		ls.setLessonText(lessonText);
		lessonRepository.save(ls);
		return "redirect:/course/show?page=" + (lessonRepository.count() - 1);
	}
	
	@PostMapping(path = "course/edit", params = "delete")
	public String deleteLesson(@RequestParam int page) {
		lessonRepository.deleteById(getPageId(page));
		return "redirect:";
	}
	
	
	@GetMapping(path="course/test")
	public @ResponseBody List<Comments> testFunc(@RequestParam int page) {
		return lessonRepository.findById(getPageId(page)).get().getLessonComments();
	}
	
	@GetMapping(path="course/show")
    public String showPage(@RequestParam int page, Model model) {
        Page<Lesson> pg = getPage(page);
		if (!pg.hasContent()) {
			return "redirect:"; //do a proper 404 page
		}
		String title = new String("");
		String lessonText = new String("");
		/*for (Lesson ls : pg.getContent()) {
			title = ls.getTitle();
			lessonText = ls.getLessonText();
		}*/
		Lesson ls = pg.getContent().get(0);
		model.addAttribute("lessonTitle", ls.getTitle());
		model.addAttribute("lessonText", ls.getLessonText());
		model.addAttribute("currPage", page);
		if (!pg.isFirst()) {
			model.addAttribute("prevPage", page - 1);
		}
		if (!pg.isLast()) {
			model.addAttribute("nextPage", page + 1);
		}
		List<Comments> cm = ls.getLessonComments();
		if (!cm.isEmpty()) {
			model.addAttribute("lessonComments", cm);
		}
		return "show";
    }
	
	@PostMapping(path="course/show")
	public String postComment(@RequestParam int page,
							  @RequestParam String name,
							  @RequestParam String comment) {
		Comments cm = new Comments();
		cm.setLessonId(getPageId(page));
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		cm.setDate(LocalDateTime.now().format(df));
		cm.setName(name);
		cm.setComment(comment);
		commentsRepository.save(cm);
		return "redirect:/course/show?page=" + page;
	}
	
	public Page<Lesson> getPage(int page) {
		return lessonRepository.findAll(new PageRequest(page, 1));
	}
	
	public Page<Lesson> getPage(int page, int size) {
		return lessonRepository.findAll(new PageRequest(page, size));
	}
	
	public Long getPageId(int page) {
		return getPage(page).getContent().get(0).getId();
	}
}
