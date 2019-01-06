package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.Lesson;

// This will be AUTO IMPLEMENTED by Spring into a Bean called lessonRepository
// CRUD refers Create, Read, Update, Delete

public interface LessonRepository extends CrudRepository<Lesson, Long> {

}