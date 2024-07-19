package com.aws.s3.demo.bucketoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aws.s3.demo.bucketoperations.utility.S3Util;

@SpringBootApplication
public class BucketoperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BucketoperationsApplication.class, args);
		
		System.out.println("Welcome to AWS SDK S3 Demo");
		
		// Let's create few S3 Buckets
		/*
		 * S3Util.createBucketInS3("my-aws-s3-bucket-007");
		 * S3Util.createBucketInS3("my-aws-s3-bucket-008");
		 * S3Util.createBucketInS3("my-aws-s3-bucket-009");
		 * S3Util.createBucketInS3("my-aws-s3-bucket-010");
		 */		
		
		// Listing down the above created buckets
		/*
		 * S3Util.listBucketsInS3();
		 */
		
		// Delete few Empty S3 Buckets
		/*
		 * S3Util.deleteEmptyBucketInS3("my-aws-s3-bucket-009");
		 * S3Util.deleteEmptyBucketInS3("my-aws-s3-bucket-010");
		 */
		
		// Delete a filled S3 Bucket
		/*
		 * S3Util.deleteFilledBucketInS3("my-aws-s3-bucket-008");
		 */
		
	}
}
