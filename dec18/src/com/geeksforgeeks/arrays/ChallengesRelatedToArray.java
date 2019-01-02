package com.geeksforgeeks.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChallengesRelatedToArray {

	@Test
	void kadanesArray() {
		//Given an array arr of N integers. Find the contiguous sub-array with maximum sum

		int[] arr1= {1, 2, 3, -2, 5};
		int[] ar2= {-1, -2, -3, -4};
		int[] arr2= {1, 2, 3, -10, 5};

		kadaneAlog(arr1);
		kadaneAlog(ar2);
		kadaneAlog(arr2);	

	}

	private void kadaneAlog(int arr[]) {
		int max_so_far = -9999999;
		int max_ending_here = 0;
		for(int i=0; i<arr.length; i++) {
			max_ending_here= max_ending_here+arr[i];			
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;			
		}		
		System.out.println(max_so_far);
	}

	@Test
	void missingNumber() {
		//Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.
		int arr1[]= {1, 2, 3, 5};
		int arr2[] = {1, 2, 3, 4, 5, 6, 7, 8, 10};

		missingNumberAlgo(arr1,5);
		missingNumberAlgo(arr2,10);


	}

	private void missingNumberAlgo(int arr[], int arrsize) {
		//find the missing number in the sequential array
		int supposedToBeSum= (arrsize*(arrsize+1))/2;
		int actualSum=0;

		for(int i=0; i<arr.length;i++) {
			actualSum+=arr[i];
		}

		System.out.print("Missing number :: ");
		System.out.println(supposedToBeSum-actualSum);
	}


	@Test
	void subArrayWithSum() {

		int arr[] = {15, 2, 4, 8, 9, 5, 10, 23}; 
		int n = arr.length; 
		int sum = 23; 
		subArraySum(arr, n, sum);
	}


	/* Returns true if the there is a subarray of arr[] with sum equal to 
		'sum' otherwise returns false. Also, prints the result */
	int subArraySum(int arr[], int n, int sum) 
	{ 
		int curr_sum, i, j; 

		// Pick a starting point 
		for (i = 0; i < n; i++) 
		{ 
			curr_sum = arr[i]; 

			// try all subarrays starting with 'i' 
			for (j = i + 1; j <= n; j++) 
			{ 
				if (curr_sum == sum) 
				{ 
					int p = j - 1; 
					System.out.println("Sum found between indexes " + i 
							+ " and " + p); 
					return 1; 
				} 
				if (curr_sum > sum || j == n) 
					break; 
				curr_sum = curr_sum + arr[j]; 
			} 
		} 

		System.out.println("No subarray found"); 
		return 0; 
	} 


} 

