package hello;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import hello.Comments;

// This will be AUTO IMPLEMENTED by Spring into a Bean called lessonRepository
// CRUD refers Create, Read, Update, Delete

public interface CommentsRepository extends PagingAndSortingRepository<Comments, Long> {

}
