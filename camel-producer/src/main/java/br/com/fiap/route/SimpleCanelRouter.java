package br.com.fiap.route;

import java.io.File;

import org.apache.camel.builder.RouteBuilder;

public class SimpleCanelRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:" + System.getProperty("user.dir") + File.separator + "inputFolder").to("jms:queue:augusto");
		
	}

}
