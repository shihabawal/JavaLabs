#include "BinarySearchTree.h"
#include "BinarySearchTree.cpp"
#include <iostream>
using namespace std;

//This class must be used if needed
//This class used by for  testing only and for your understanding only

class Integer {
public:
	Integer() {
		value = -1;
	} //NULL
	Integer(int v) {
		value = v;
	}
	Integer& operator=(const Integer & item) {
		value = item.value;
		return *this;
	}
	bool operator==(const Integer & item) {
		return (value == item.value);
	}
	bool operator<(const Integer & item) {
		return (value < item.value);
	}
	bool operator>(const Integer & item) {
		return (value > item.value);
	}
	int getValue() {
		return value;
	}
	void setValue(int v) {
		value = v;
	}
	friend ostream& operator <<(ostream & outStream, const Integer & integer) {
		outStream << integer.value << endl;
		return outStream;
	}

private:
	int value;
};

typedef Integer ItemType;

int numIsLessThan(Integer *arr, int num, int length,  int i = 0) {
	if (i >= length)
		return 0;// leaf node
	else {
		if (arr[i] < num)
			return numIsLessThan(arr, num, length, 2 * i + 1)
					+ numIsLessThan(arr, num, length, 2 * i + 2) + 1;
		else
			return numIsLessThan(arr, num, length, 2 * i + 1);
	}

}

int main() {
	BinarySearchTree<ItemType> bst;
	bst.InsertItem(ItemType(9));
	bst.InsertItem(ItemType(5));
	bst.InsertItem(ItemType(12));
	bst.InsertItem(ItemType(1));
	bst.InsertItem(ItemType(7));
	bst.InsertItem(ItemType(10));
	int length = bst.LengthIs();
	Integer *arr = new Integer[100];
	bst.arrayBST(arr);
	cout << "BST in an array: ";
	for (int i = 0; i < length; i++) {
		cout << arr[i].getValue() << " ";
	}
	cout << endl;
	(bst.isComplete()) ?
			cout << "Complete BST\n" : cout << "Not complete BST\n";
	cout << "Integers less than 10: " << numIsLessThan(arr, 10, length);
	return 0;
}

