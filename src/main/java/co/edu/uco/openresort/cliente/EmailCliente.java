package co.edu.uco.openresort.cliente;

import co.edu.uco.openresort.excepcion.ExcepcionEmailNoEnviado;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class EmailCliente {

    private static final String MENSAJE_EMAIL_NO_ENVIADO = "No fue posible enviar el correo de confirmación, intente nuevamente";


    public static void enviarCorreo(String emisor,String receptor, String asunto, String mensaje) throws IOException {
        Email de = new Email(emisor);
        Email para = new Email(receptor);

        Content contenido = new Content("text/plain", mensaje);
        Mail mail = new Mail(de,asunto,para,contenido);

        SendGrid enviador = new SendGrid(System.getenv("OPENRESORT_API_KEY"));
        Request peticion = new Request();

        try{
            peticion.setMethod(Method.POST);
            peticion.setEndpoint("mail/send");
            peticion.setBody(mail.build());
            Response respuesta = enviador.api(peticion);

            System.out.println("Respuesta de SendGrid:");
            System.out.println("codigo de respuesta: "+respuesta.getStatusCode());
            System.out.println("cuerpo de respuesta: "+respuesta.getBody());
            System.out.println("encabezado de respuesta: "+respuesta.getHeaders());

            if (respuesta.getStatusCode()!=202){
                throw new ExcepcionEmailNoEnviado(MENSAJE_EMAIL_NO_ENVIADO);
            }

        } catch (IOException exception){
            throw exception;
        }

    }
}
