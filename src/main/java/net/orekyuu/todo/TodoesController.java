package net.orekyuu.todo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/todoes")
public class TodoesController {

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
        Todoes.create(new Todo(memo, false, LocalDateTime.now().plusWeeks(2)));
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
