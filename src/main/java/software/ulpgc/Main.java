package software.ulpgc;

import io.javalin.Javalin;
import software.ulpgc.control.CommandFactory;
import software.ulpgc.control.commands.WorkingDateCommand;
import software.ulpgc.control.commands.WorkingDaysCommand;
import software.ulpgc.view.WorkingDayService;
import software.ulpgc.view.adapters.WorkingDateRequestAdapter;
import software.ulpgc.view.adapters.WorkingDaysRequestAdapter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CommandFactory factory = new CommandFactory();
        factory.register("working-days", workingDaysBuilder());
        factory.register("working-date", workingDateBuilder());
        new WorkingDayService(3000, factory).start();
    }

    private static CommandFactory.Builder workingDaysBuilder() {
        return ((req, res) ->{
            WorkingDaysRequestAdapter adapter = new WorkingDaysRequestAdapter();
            return new WorkingDaysCommand(adapter.inputFor(req), adapter.outFor(res));
        });
    }

    private static CommandFactory.Builder workingDateBuilder() {
        return ((req, res) ->{
            WorkingDateRequestAdapter adapter = new WorkingDateRequestAdapter();
            return new WorkingDateCommand(adapter.inputFor(req), adapter.outputFor(res));
        });
    }
}
