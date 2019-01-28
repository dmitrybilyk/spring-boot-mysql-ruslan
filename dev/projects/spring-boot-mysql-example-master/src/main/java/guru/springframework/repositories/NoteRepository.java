package guru.springframework.repositories;

import guru.springframework.domain.Note;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface NoteRepository extends CrudRepository<Note, Integer> {
}
