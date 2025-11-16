
package bongocat.parser;

import bongocat.commands.*;
import bongocat.BongoException;

public class Parser {

    public static Command parse(String input) throws BongoException {
        String trimmed = input.trim();

        if (trimmed.equals("bye")) return new ExitCommand();
        if (trimmed.equals("list")) return new ListCommand();
        if (trimmed.equals("space left")) return new SpaceLeftCommand();

        if (trimmed.startsWith("mark ")) return new MarkCommand(parseNum(trimmed, 5));
        if (trimmed.startsWith("unmark ")) return new UnmarkCommand(parseNum(trimmed, 7));
        if (trimmed.startsWith("delete ")) return new DeleteCommand(parseNum(trimmed, 7));

        if (trimmed.startsWith("todo")) {
            String name = trimmed.substring(4).trim();
            if (name.isEmpty()) throw new BongoException("Description cannot be empty lah.");
            return new AddTodoCommand(name);
        }

        if (trimmed.startsWith("deadline")) {
            String[] parts = trimmed.split(" /by ");
            if (parts.length < 2) throw new BongoException("Deadline must have /by");
            return new AddDeadlineCommand(parts[0].substring(8).trim(), parts[1].trim());
        }

        if (trimmed.startsWith("event")) {
            String[] parts = trimmed.split(" /from | /to ");
            if (parts.length < 3) throw new BongoException("Event must have /from and /to");
            return new AddEventCommand(parts[0].substring(5).trim(), parts[1].trim(), parts[2].trim());
        }

        throw new BongoException("Unknown command!");
    }

    private static int parseNum(String input, int offset) throws BongoException {
        try { return Integer.parseInt(input.substring(offset).trim()); }
        catch (Exception e) { throw new BongoException("Invalid number."); }
    }
}
