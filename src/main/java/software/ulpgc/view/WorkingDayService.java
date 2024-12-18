package software.ulpgc.view;

import io.javalin.Javalin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.control.CommandFactory;

import static software.ulpgc.view.WorkingDateDisplay.showDateForm;
import static software.ulpgc.view.WorkingDayMenu.showRedirect;
import static software.ulpgc.view.WorkingDaysDisplay.showDaysForm;

public class WorkingDayService  implements Service{
    private final int port;
    private final CommandFactory factory;
    private Javalin app;

    public WorkingDayService(int port, CommandFactory factory) {
        this.port = port;
        this.factory = factory;
    }

    @Override
    public void start() {
        app = Javalin.create()
                .get("/", ctx -> showRedirect(ctx))
                .get("/working-days", ctx -> showDaysForm(ctx))
                .post("/working-days", ctx -> execute("working-days", ctx.req(), ctx.res()))
                .get("/working-date", ctx -> showDateForm(ctx))
                .post("/working-date", ctx -> execute("working-date", ctx.req(), ctx.res()))
                .start(port);
    }

    public void execute(String command, HttpServletRequest req, HttpServletResponse res){
        factory.with(req, res).build(command).execute();
    }

    @Override
    public void stop() {
        app.stop();
    }
}
