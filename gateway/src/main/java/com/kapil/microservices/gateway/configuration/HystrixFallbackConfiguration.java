package com.kapil.microservices.gateway.configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@SuppressWarnings("deprecation")
@Configuration
public class HystrixFallbackConfiguration {

	@Bean
	public ZuulFallbackProvider zuulFallbackProvider() {

		return new ZuulFallbackProvider() {

			@Override
			public String getRoute() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ClientHttpResponse fallbackResponse() {
				// TODO Auto-generated method stub
				return new ClientHttpResponse() {

					@Override
					public HttpHeaders getHeaders() {
						// TODO Auto-generated method stub
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						headers.setAccessControlAllowCredentials(true);
						headers.setAccessControlAllowOrigin("*");
						return headers;
					}

					@Override
					public InputStream getBody() throws IOException {
						// TODO Auto-generated method stub
						return new ByteArrayInputStream(
								"{\"factorA\":\"Sorry, Service is Down! \",\"factorB\":\"?\",\"id\":null}".getBytes());
					}

					@Override
					public String getStatusText() throws IOException {
						// TODO Auto-generated method stub
						return HttpStatus.OK.toString();
					}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						// TODO Auto-generated method stub
						return HttpStatus.OK;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						// TODO Auto-generated method stub
						return HttpStatus.OK.value();
					}

					@Override
					public void close() {
						// TODO Auto-generated method stub
					}
				};
			}
		};
	}
}
