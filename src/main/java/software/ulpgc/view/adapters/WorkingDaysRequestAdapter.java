package software.ulpgc.view.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.control.commands.WorkingDaysCommand;

import java.io.IOException;
import java.time.LocalDate;

import static software.ulpgc.view.WorkingDaysDisplay.showDaysResult;

public class WorkingDaysRequestAdapter {
    public WorkingDaysCommand.Input inputFor(HttpServletRequest req){
        return new WorkingDaysCommand.Input(){

            @Override
            public LocalDate start() {
                return LocalDate.parse(req.getParameter("start"));
            }

            @Override
            public LocalDate end() {
                return LocalDate.parse(req.getParameter("end"));
            }
        };
    }

    public WorkingDaysCommand.Output outFor(HttpServletResponse res){
        return days ->  {
            try {
                res.setContentType("text/html");
                res.getWriter().write(showDaysResult(days));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

}
