package com.aws.s3.demo.bucketoperations.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.aws.s3.demo.bucketoperations.utility.S3Util;

@RestController
@RequestMapping("/aws/s3")
public class AWSS3Controller {

	@GetMapping("/buckets")
	public List<Bucket> getAllS3Buckets() {
		return S3Util.listBucketsInS3();
	}
	
	@PostMapping("/create-bucket/{bucketName}")
	public void createS3Bucket(@PathVariable String bucketName) {
		S3Util.createBucketInS3(bucketName);
	}
	
	@DeleteMapping("/delete-empty-bucket/{bucketName}")
	public void deleteEmptyS3Bucket(@PathVariable String bucketName) {
		S3Util.deleteEmptyBucketInS3(bucketName);
	}
	
	@DeleteMapping("/delete-filled-bucket/{bucketName}")
	public void deleteFilledS3Bucket(@PathVariable String bucketName) {
		S3Util.deleteFilledBucketInS3(bucketName);
	}
	

}
