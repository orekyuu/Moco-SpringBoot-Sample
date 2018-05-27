package net.orekyuu.todo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TodoService {

    @Transactional
    public void createTodo(String memo) {
        Todoes.create(new Todo(memo, false, LocalDateTime.now().plusWeeks(2)));
        if (memo.isEmpty()) {
            throw new RuntimeException("rollback test");
        }
    }
}
