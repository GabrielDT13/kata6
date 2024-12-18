package software.ulpgc.view.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.control.commands.WorkingDateCommand;

import java.io.IOException;
import java.time.LocalDate;

import static software.ulpgc.view.WorkingDateDisplay.showDateResult;

public class WorkingDateRequestAdapter {
    public WorkingDateCommand.Input inputFor(HttpServletRequest req){
        return new WorkingDateCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(req.getParameter("start"));
            }

            @Override
            public int workingDays() {
                return Integer.parseInt(req.getParameter("days"));
            }
        };
    }

    public WorkingDateCommand.Output outputFor(HttpServletResponse res){
        return result -> {
            try {
                res.setContentType("text/html");
                res.getWriter().write(showDateResult(result));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
