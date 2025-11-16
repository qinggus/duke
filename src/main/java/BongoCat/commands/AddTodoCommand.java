package bongocat.commands;

import bongocat.tasks.Task;
import bongocat.tasks.TaskList;
import bongocat.tasks.ToDo;
import bongocat.ui.Ui;
import bongocat.storage.Storage;

import java.io.IOException;

public class AddTodoCommand extends Command {

    private final String name;

    public AddTodoCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        Task newTask = new ToDo(name);

        // Duplicate check
        if (tasks.isDuplicate(newTask)) {
            ui.showDuplicate(newTask);
            return;
        }

        // Add task
        tasks.addTask(newTask);
        ui.showAdd(newTask, tasks.size());

        // Save file — CATCH IOException here
        try {
            storage.save(tasks.getTasks());
        } catch (IOException e) {
            ui.showError("Error saving file: " + e.getMessage());
        }
    }
}
