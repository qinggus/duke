package bongocat.commands;

import bongocat.tasks.Task;
import bongocat.tasks.TaskList;
import bongocat.ui.Ui;
import bongocat.storage.Storage;

public class FindWord extends Command {

    private final String keyword;

    public FindWord(String keyword) {
        this.keyword = keyword.toLowerCase().trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        // Get matching tasks
        var results = tasks.findTasks(keyword);

        ui.showFindResults(results);
    }
}
