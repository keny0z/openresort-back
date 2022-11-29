package co.edu.uco.openresort.cliente;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class EmailCliente {
    public static void enviarCorreo(String emisor,String receptor, String asunto, String mensaje) throws IOException {
        Email de = new Email(emisor);
        Email para = new Email(receptor);

        Content contenido = new Content("text/html", mensaje);
        Mail mail = new Mail(de,asunto,para,contenido);

        SendGrid enviador = new SendGrid("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");
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
        } catch (IOException exception){
            throw exception;
        }

    }
}
