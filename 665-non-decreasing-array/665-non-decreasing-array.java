class Solution {
	public boolean checkPossibility(int[] arr) {
        //find idx where anomaly happens
		int index = findAnomaly(arr);
        //no anomaly found, array is already in increasing order
		if (index == -1) {
			return true;
		}
        //store curr idx value 
        //change curr value to value on next
		int temp = arr[index];
		arr[index] = arr[index + 1];
        //check for anomaly in updated array, if no anomaly found return true
		if (findAnomaly(arr) == -1) {
			return true;
		}

        //now, replacing by next value didn't work
        //try replacing with curr value
		arr[index] = temp;
		arr[index + 1] = temp;
        //check if anomalies are fixed
		if (findAnomaly(arr) == -1) {
			return true;
		}
		return false;
	}

	public int findAnomaly(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return -1;
	}
}