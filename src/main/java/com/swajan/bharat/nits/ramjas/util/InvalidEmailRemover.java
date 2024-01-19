package com.swajan.bharat.nits.ramjas.util;

import jakarta.mail.BodyPart;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvalidEmailRemover {

    public static Set<String> readInvalidEmails(){
        Set<String> invalidEmails = new HashSet<>();

        File file = new File("C:\\Users\\nites\\Documents\\projects\\ramjas-alma-matters\\src\\main\\resources\\cleanupmails\\invalidemails");
        for (File f : file.listFiles()){
            //System.out.println(f.getPath());
            invalidEmails.addAll(emailFromMail(f));
        }

        System.out.println(invalidEmails.size());
        System.out.println(invalidEmails);

        return invalidEmails;
    }


    public static Set<String> emailFromMail(File file) {
        Session session = Session.getDefaultInstance(new Properties());
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            MimeMessage mimeMessage = new MimeMessage(session, is);

            // Get the content of the email
            Object content = mimeMessage.getContent();

            if (content instanceof MimeMultipart) {
                // If the content is multipart, iterate through the parts
                MimeMultipart multipart = (MimeMultipart) content;
                for (int i = 0; i < multipart.getCount(); i++) {
                    BodyPart bodyPart = multipart.getBodyPart(i);
                    return findEmailsInLine(getContentAsString(bodyPart));
                }
            } else {
                // If the content is not multipart, simply print it
               // System.out.println("Content: " + content);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static Set<String> emailFromMail(String filepath) {
        Set<String> mailsFromMail = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;


            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                mailsFromMail.addAll(findEmailsInLine(line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Set<String> findEmailsInLine(String line) {
        Set<String> mailsFromMail = new HashSet<>();
        String emailRegex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            mailsFromMail.add(matcher.group());
        }
        //System.out.println("findEmailsInLine :" + mailsFromMail);
        return mailsFromMail;
    }
    private static String getContentAsString(BodyPart bodyPart) throws IOException, MessagingException {
        // Assuming 'message/delivery-status' part is plain text
        InputStream inputStream = bodyPart.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }
}
