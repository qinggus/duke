
package bongocat.commands;

import bongocat.tasks.*;
import bongocat.storage.Storage;
import bongocat.ui.Ui;
import bongocat.BongoException;
import java.io.IOException;

public class AddDeadlineCommand extends Command {
    private final String name;
    private final String by;

    public AddDeadlineCommand(String name, String by) {
        this.name = name;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BongoException {
        Task t = new Deadline(name, by);
        tasks.addTask(t);
        try { storage.save(tasks.getAllTasks()); } catch (IOException e) { }
        ui.showTaskAdded(t, tasks.size());
    }
}
