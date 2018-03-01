package com.kevinjanvier.app;

import hello.wsdl.GetQuoteResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComsumesoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComsumesoapApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(QuoteClient quoteClient){
		return args->{
			String ticket ="MTS OUTBOX";
			if (args.length > 0){
				ticket = args[0];
			}
			GetQuoteResponse response = quoteClient.getQuote(ticket);
			System.err.println("MY RESPONSE QUOTEA" + response.getGetQuoteResult());
		};
	}
}
