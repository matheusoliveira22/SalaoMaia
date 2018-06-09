package com.les.salaomaia.classes.auxiliares;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Classe responsável por criar e enviar emails.
 *
 * @version 1.0
 */
public class Email {

   // Atributos
   private final String remetente;
   private final String senha;
   private String destinatario;
   private String assunto;
   private String conteudo;

   /**
    * Construtor base da classe.
    *
    * @param r Email do remetente.
    * @param s Senha do remetente.
    */
   public Email(String r, String s) {
      destinatario = null;
      remetente = r;
      senha = s;
      assunto = null;
      conteudo = null;
      destinatario = null;
   }

   /**
    * Método utilizado para enviar o email.
    *
    * @return True se o email for enviado com sucesso.
    */
   public boolean enviarEmail() {
      // Verificando se há destinatarios. Se não houver, lançar exceção.
      if (destinatario == null) {
         throw new IllegalStateException("Destinatários não definidos");
      }

      // Definindo as propriedades para o hotmail/outlook (Email da empresa)
      Properties props = new Properties();
      props.put("mail.transport.protocol", "smtp");
      props.put("mail.smtp.host", "smtp.live.com");
      props.put("mail.smtp.socketFactory.port", "587");
      props.put("mail.smtp.socketFactory.fallback", "false");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "587");

      // Iniciando a sessão e enviando o email. Se ouver alguma exceção, retornar false. Caso 
      // contrario, retornar verdadeiro.
      try {
         Session sessao = criarSessao(props);
         Message msgEmail = new MimeMessage(sessao);
         Address[] destinatarios = InternetAddress.parse(destinatario);

         msgEmail.setFrom(new InternetAddress(remetente));
         msgEmail.setRecipients(Message.RecipientType.TO, destinatarios);
         msgEmail.setSubject(assunto);
         msgEmail.setText(conteudo);
         Transport.send(msgEmail);
         return true;
      }
      catch (MessagingException e) {
         return false;
      }
   }

   /**
    * Método interno utilizado para criar uma sessão.
    *
    * @param p Propriedades da conexão.
    * @return
    */
   private Session criarSessao(Properties p) {
      Session sessao = Session.getDefaultInstance(p, new Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(remetente, senha);
         }
      });
      sessao.setDebug(true);
      return sessao;
   }

   /**
    * Método interno utilizado para formatar o lista de destinatários.
    *
    * @param d Destinatarios do email.
    * @return
    */
   private String formatarStringDestinatarios(String... d) {
      StringBuilder strDestinatatios = new StringBuilder();
      for (int posicao = 0; posicao < d.length; posicao++) {
         strDestinatatios.append(d[posicao]);
         if (posicao < d.length - 1) {
            strDestinatatios.append(", ");
         }
      }
      return strDestinatatios.toString();
   }

   /**
    * Método utilizado para seta os destinatários do email.
    *
    * @param d Destinatarios do email.
    */
   public void setDestinatarios(String... d) {
      destinatario = formatarStringDestinatarios(d);
   }

   /**
    * Método utilizado para setar o assunto do email.
    *
    * @param a Assunto do email.
    */
   public void setAssunto(String a) {
      assunto = a;
   }

   /**
    * Método utilizado para setar o assunto do email.
    *
    * @param c Conteudo do email.
    */
   public void setConteudo(String c) {
      conteudo = c;
   }

   /**
    * Método utilizado para se obter o remetente do email.
    *
    * @return O email o remetente.
    */
   public String getRemetente() {
      return remetente;
   }

   /**
    * Método utilizado para se obter o(s) destinatário(s) do email.
    *
    * @return O(s) destinatário(s) do email.
    */
   public String getDestinatario() {
      return destinatario;
   }

   /**
    * Método utilizado para se obter o assunto do email.
    *
    * @return O assundo do email.
    */
   public String getAssunto() {
      return assunto;
   }

   /**
    * Método utilizado para se obter o conteudo do email.
    *
    * @return O conteudo do email.
    */
   public String getConteudo() {
      return conteudo;
   }
}
