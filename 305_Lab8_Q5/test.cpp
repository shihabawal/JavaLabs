#include <iostream>
#include <cmath>
using namespace std;

bool binarySearchHelper(int *arr, int l, int target, int f = 0) {
	int mid = (f + l) / 2;
	if (arr[mid] == target)
		return true;
	else if (f > l)
		return false;
	else {
		if (target > arr[mid])
			return binarySearchHelper(arr, l, target, mid + 1);
		else
			return binarySearchHelper(arr, mid - 1, target, f);
	}
}

bool binarySearch(int *arr, int size, int target) {
	return binarySearchHelper(arr, size - 1, target);
}

bool search(int *arr, int size, int target, int i = 0) {
	if (arr[i] == target)
		return true;
	else if (i >= size)
		return false;
	else
		return search(arr, size, target, i + 1);
}

int main() {
	int arr[5], num;
	cout << "Enter 5 array elements: ";
	for (int i = 0; i < 5; i++)
		cin >> arr[i];
	cout << "Enter target to search: ";
	cin >> num;
	(binarySearch(arr, 5, num)) ? cout << "Found " : cout << "Not Found ";
	cout << "with binary search\n";
	(search(arr, 5, num)) ? cout << "Found " : cout << "Not Found ";
	cout << "with normal search\n";
	return 0;
}
