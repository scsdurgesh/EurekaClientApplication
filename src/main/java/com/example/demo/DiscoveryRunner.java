package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class DiscoveryRunner implements CommandLineRunner {

	
	@Autowired
	private DiscoveryClient discoverClient;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("-----------Service Running -------");
		List<String> serviceList=discoverClient.getServices();
		for(String service:serviceList)
		{
			System.out.println(service);
			List<ServiceInstance> instances=discoverClient.getInstances(service);
			for(ServiceInstance instance:instances)
			{
				System.out.println(instance.getHost()+" "+instance.getPort() +" "+instance.getUri());
			}
		}
		System.out.println("---------------------------------------------");
	}

	
}
