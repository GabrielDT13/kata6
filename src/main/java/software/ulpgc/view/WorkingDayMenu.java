package software.ulpgc.view;

import io.javalin.http.Context;

public class WorkingDayMenu {

    public static void showRedirect(Context ctx){
        ctx.html(
                "<html>" +
                        "<head><meta charset=\"UTF-8\"><title>Menú Principal</title></head>" +
                        "<body>" +
                        "<h1>Bienvenido a la Calculadora de Días Laborales</h1>" +
                        "<ul>" +
                        "<li><a href='/working-days'>Calcular Días Laborales</a></li>" +
                        "<li><a href='/working-date'>Calcular Próxima Fecha Laboral</a></li>" +
                        "</ul>" +
                        "</body>" +
                "</html>"
        );

    }
}
