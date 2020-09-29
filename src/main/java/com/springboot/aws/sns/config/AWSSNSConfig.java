package com.springboot.aws.sns.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AWSSNSConfig {

	// SECTION 1 OPTION 1: Create a S3 client with in-program credential
	//
//	BasicAWSCredentials awsCreds = new BasicAWSCredentials("", "");


	// SECTION 1 OPTION 2: Create a S3 client with the aws credentials set in OS (require config and crendentials in .aws folder.) Demonstrate at the end of this video.
	//

    public static final String SECRET_KEY = "";
    public static final String ACCESS_KEY = "";

    @Primary
    @Bean
    public AmazonSNSClient getSnsClient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY,
                        SECRET_KEY)))
                .build();
    }
}
