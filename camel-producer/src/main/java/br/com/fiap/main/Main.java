package br.com.fiap.main;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import br.com.fiap.route.SimpleCanelRouter;

public class Main {
	
	public static void main(String[] args) {
		
		SimpleCanelRouter routerBuilder = new SimpleCanelRouter();
		CamelContext context = new DefaultCamelContext();
		
		//Configurando o JSM
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		try {
			
			context.addRoutes(routerBuilder);
			context.start();
			Thread.sleep(5 * 60 * 1000);
			context.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
