package software.ulpgc.view;

import io.javalin.http.Context;

public class WorkingDaysDisplay {
    public static  void showDaysForm(Context ctx){
        ctx.html(
                "<html>" +
                        "<head><meta charset=\"UTF-8\"><title>Calculadora de Días Laborales</title></head>" +
                        "<body>" +
                        "<h1>Calculadora de Días Laborales entre Dos Fechas</h1>" +
                        "<form action='/working-days' method='post'>" +
                        "  Fecha de inicio (yyyy-MM-dd): <input type='text' name='start' required><br>" +
                        "  Fecha de finalización (yyyy-MM-dd): <input type='text' name='end' required><br>" +
                        "  <input type='submit' value='Calcular'>" +
                        "</form>" +
                        "</body>" +
                "</html>"
        );
    }

    public static String showDaysResult(int result){
        return ("<html>" +
                "<head><meta charset=\"UTF-8\"><title>Calculadora de Días Laborales</title></head>" +
                "<body>" +
                "<h1>Días Laborales: " + result + "</h1>" +
                "<a href='/'>Volver a Menú Principal</a>" +
                "</body>" +
                "</html>");
    }
}
