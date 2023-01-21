package com.example.billing.service;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

@Service
public class BillingService implements BillingInterface {

    static double wDiscount = 0.0;
    static double finalPrice = 0.0;
    int count=20;


    static String para ="";
    public  void  generatePDF(String whname,int pid,String pname,int price,double gst)  {
        Document doc = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("/Users/suthir/Documents/bill.pdf"));
            System.out.println("PDF created");
            doc.open();
            doc.add(new Paragraph("Product Bill" + "\n" +"Wholesaler Name\n"+ "Product ID\n" + "Product Name\n" + "MRP\n"+"Qty\n"+"GST\n"));
            if (count > 10 && count <= 50) {
                wDiscount += (price * count * 0.1);
            }
            else if (count > 50 && count <= 100) {
                wDiscount += (price * count * 0.2);
            }
            else if (count > 100) {
                wDiscount += (price * count * 0.3);
            }
            finalPrice = (wDiscount+(finalPrice*(gst/100)));
            para += whname + " \n" +pid+" \n"+pname+"\n "+price+" \n"+count+" \n"+gst+"%\n";
            doc.add(new Paragraph( para));
            doc.add(new Paragraph("GST: "+ gst));
            doc.add(new Paragraph("Total amount: "+finalPrice));
            System.out.println("Pdf created");
            doc.close();
            writer.close();
        } catch(DocumentException e)
        {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }

    public void sendEmail(){
        // email ID of Recipient.
        String recipient = "ssuthir27@gmail.com";
        // email ID of  Sender.
        String sender = "suthir.cs19@bitsathy.ac.in";
        // using host as localhost
        String host = "127.0.0.1";
        // Getting system properties
        Properties properties = System.getProperties();
        // Setting up mail server
        properties.setProperty("mail.smtp.host", host);
        // creating session object to get properties
        javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties);
        try
        {
            // MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From Field: adding senders email to from field.
            message.setFrom(new InternetAddress(sender));
            // Set To Field: adding recipient's email to from field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            // Set Subject: subject of the email
            message.setSubject("This is Subject");
            // set body of the email.
            message.setText("This is a test mail");
            // Send email.
            Transport.send(message);
            System.out.println("Mail successfully sent");
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
    }





