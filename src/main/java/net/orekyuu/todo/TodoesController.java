package net.orekyuu.todo;

import net.orekyuu.todo.Todo;
import net.orekyuu.todo.TodoList;
import net.orekyuu.todo.TodoService;
import net.orekyuu.todo.Todoes;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/todoes")
public class TodoesController {

    private TodoService todoService;

    public TodoesController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> index() {
        return Todoes.all().toList();
    }

    @GetMapping("{id}")
    public Todo show(@PathVariable("id") int id) {
        return todo(id).firstOrNull();
    }

    @PostMapping
    public void create(@RequestParam("memo") String memo) {
        todoService.createTodo(memo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        todo(id).delete();
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") int id, @RequestParam("memo") String memo, @RequestParam("completed") boolean completed) {
        todo(id).update(Todoes.MEMO.set(memo), Todoes.COMPLETED.set(completed));
    }

    private TodoList todo(int id) {
        return Todoes.all().where(Todoes.ID.eq(id));
    }
}
