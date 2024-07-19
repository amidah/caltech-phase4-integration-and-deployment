package com.aws.s3.demo.bucketoperations.utility;

import java.util.Iterator;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Util {

	// List all the buckets created in AWS S3
	public static List<Bucket> listBucketsInS3() {
		List<Bucket> bucketList = null;
		try {
			AmazonS3 ref = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
			bucketList = ref.listBuckets();
			System.out.println("AWS S3 Buckets Size: " + bucketList.size());
			bucketList.forEach((bucket) -> System.out.println(bucket.getName()));
		} catch (Exception e) {
			System.out.println("Exception occurred during listing of S3 buckets: " + e);
		}
		return bucketList;
	}

	// Create new buckets in AWS S3
	public static void createBucketInS3(String bucketName) {
		try {
			AmazonS3 ref = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
			ref.createBucket(bucketName);
			System.out.println("A new bucket is created with name " + bucketName);
		} catch (Exception e) {
			System.out.println("Exception occurred while creating the bukcet: " + e);
		}
	}

	// Delete empty buckets in AWS S3
	public static void deleteEmptyBucketInS3(String bucketName) {
		try {
			AmazonS3 ref = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
			ref.deleteBucket(bucketName);
			System.out.println("The bucket with name " + bucketName + " is deleted.");
		} catch (Exception e) {
			System.out.println("Exception Occurred while deleting the empty bucket: " + e);
		}
	}

	// Delete filled buckets in AWS S3
	public static void deleteFilledBucketInS3(String bucketName) {
		try {
			AmazonS3 ref = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();

			// Get all the objects present inside the S3 bucket
			ObjectListing objListing = ref.listObjects(bucketName);

			Iterator<S3ObjectSummary> iterator = objListing.getObjectSummaries().iterator();

			while (iterator.hasNext()) {
				// Get each S3 bucket object
				S3ObjectSummary objSummary = iterator.next();
				// Delete each S3 bucket object
				ref.deleteObject(bucketName, objSummary.getKey());
			}

			System.out.println("Objects Removed from S3 Bucket: " + bucketName);

			deleteEmptyBucketInS3(bucketName);
			
			System.out.println("The bucket with name " + bucketName + " is deleted");
		} catch (Exception e) {
			System.out.println("Exception occurred while deleting a filled bucket with name: " + bucketName);
		}
	}
}
