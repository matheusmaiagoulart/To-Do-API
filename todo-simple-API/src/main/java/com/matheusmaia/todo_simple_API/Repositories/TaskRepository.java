package com.matheusmaia.todo_simple_API.Repositories;

import com.matheusmaia.todo_simple_API.Model.Task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
