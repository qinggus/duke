package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addTask_validTask_taskIsAdded() {
        TaskList list = new TaskList();
        ToDo todo = new ToDo("eat rice");

        list.addTask(todo);

        assertEquals(1, list.size());
        assertEquals(todo, list.getTask(0));
    }

    @Test
    public void addTask_multipleTasks_correctOrder() {
        TaskList list = new TaskList();
        list.addTask(new ToDo("eat"));
        list.addTask(new ToDo("sleep"));
        list.addTask(new ToDo("code"));

        assertEquals("code", list.getTask(2).getName());
    }
}
