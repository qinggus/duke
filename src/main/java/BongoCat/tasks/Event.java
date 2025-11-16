package bongocat.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Event Class - Extends as a type of Task
 */
public class Event extends Task {
    private final LocalDate from;
    private final LocalDate to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getTypeIcon() {
        return "[E]";
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return getTypeIcon()
                + statusBox()
                + " " + name
                + " (from: " + from.format(fmt)
                + " to: " + to.format(fmt) + ")";
    }

    @Override
    public String toSaveFormat() {
        return "E | " + (isDone ? "[X]" : "[ ]") + " | " + name
                + " | " + from.toString()
                + " | " + to.toString();
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }
}
