package net.orekyuu.todo;

import net.orekyuu.moco.core.annotations.Column;
import net.orekyuu.moco.core.annotations.Table;

import java.time.LocalDateTime;

@Table(name = "todos")
public class Todo {
    @Column(name = "id", generatedValue = true, unique = true)
    private int id;
    @Column(name = "memo")
    private String memo;
    @Column(name = "completed")
    private boolean completed;
    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    public Todo() {
    }

    public Todo(String memo, boolean completed, LocalDateTime expiredAt) {
        this.memo = memo;
        this.completed = completed;
        this.expiredAt = expiredAt;
    }

    public int getId() {
        return id;
    }

    public String getMemo() {
        return memo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }
}
