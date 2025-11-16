package bongocat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void parseCommand_invalidCommand_throwsException() {
        assertThrows(BongoException.class, () -> {
            Parser.parseCommand("nonsense command");
        });
    }

    @Test
    public void parseCommand_todoCommand_returnsCorrectCommand() {
        Command cmd = Parser.parseCommand("todo eat");
        assertEquals("AddTodoCommand", cmd.getClass().getSimpleName());
    }
}
