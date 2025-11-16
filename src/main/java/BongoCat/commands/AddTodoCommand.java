
package bongocat.commands;

import bongocat.tasks.*;
import bongocat.storage.Storage;
import bongocat.ui.Ui;
import bongocat.BongoException;
import java.io.IOException;
/**
 * Adds Todo Task
 */
public class AddTodoCommand extends Command {
    private final String name;

    public AddTodoCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BongoException {
        Task t = new ToDo(name);
        tasks.addTask(t);
        try { storage.save(tasks.getAllTasks()); } catch (IOException e) { }
        ui.showTaskAdded(t, tasks.size());
    }
}
