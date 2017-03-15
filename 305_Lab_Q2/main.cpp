#include <iostream>
#include "queuetype.h"
using namespace std;

int main() {
	int num;
	QueueType q1;
	ItemType item;
	cout << "Enter no. of queue items: ";
	cin >> num;
	cout << "Enter queue items: ";
	for (int i = 0; i < num; i++) {
		cin >> item;
		q1.Enqueue(item);
	}
	QueueType q2 = q1;

	if (q1 == q2)
		cout << "Identical" << endl;
	if (q1.hasDuplicate())
		cout<<"Has Duplicate"<<endl;
	cout << "Queue1: " << endl;
	while (true) {
		if (q1.Dequeue(item) == Underflow)
			break;
		cout << item << " ";
	}
	cout << endl;
	cout << "Queue2: " << endl;
	while (true) {
		if (q2.Dequeue(item) == Underflow)
			break;
		cout << item << " ";
	}
	return 0;
}
