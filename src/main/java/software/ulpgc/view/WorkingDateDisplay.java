package software.ulpgc.view;

import io.javalin.http.Context;

import java.time.LocalDate;

public class WorkingDateDisplay {

    public static void showDateForm(Context ctx){
        ctx.html(
                "<html>" +
                        "<head><meta charset=\"UTF-8\"><title>Calculadora del Proximos Día Laboral</title></head>" +
                        "<body>" +
                        "<h1>Calculadora de Fecha Finalización de Días Laborales</h1>" +
                        "<form action='/working-date' method='post'>" +
                        "  Fecha de inicio (yyyy-MM-dd): <input type='text' name='start' required><br>" +
                        "  Número de días laborales: <input type='number' name='days' required><br>" +
                        "  <input type='submit' value='Calcular'>" +
                        "</form>" +
                        "</body>" +
                        "</html>"
        );
    }

    public static String showDateResult(LocalDate result){
        return ("<html>" +
                "<head><meta charset=\"UTF-8\"><title>Calculadora del Proximos Día Laboral</title></head>" +
                "<body>" +
                "<h1>Día Laborable de Finalización: " + result + "</h1>" +
                "<a href='/'>Volver a Menú Principal</a>" +
                "</body>" +
                "</html>");
    }
}
