package com.proyectoFinal.messageBean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/jms/MyQueue")
})
public class exampleMessageBean implements MessageListener {
    
    public exampleMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage) message;
        try {
            System.out.println("mensaje recivido"+textMessage.getText());
        } catch (JMSException ex) {
            Logger.getLogger(exampleMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
