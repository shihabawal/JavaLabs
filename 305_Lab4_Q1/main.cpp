#include <iostream>
#include "QueueType.h"
using namespace std;

int main() {
	int maxqueue1, numitems1, searchNum, maxqueue2, numitems2;
	cout << "Enter max queue1: ";
	cin >> maxqueue1;
	cout << "Enter no. of items1: ";
	cin >> numitems1;
	cout << "Enter queue1 items: ";
	QueueType q1(maxqueue1);

	for (int i = 0; i < numitems1; i++) {
		int num;
		cin >> num;
		q1.Enqueue(num);
	}

	cout << "Enter max queue2: ";
	cin >> maxqueue2;
	cout << "Enter no. of items2: ";
	cin >> numitems2;
	cout << "Enter queue2 items: ";
	QueueType q2(maxqueue2);

	for (int i = 0; i < numitems2; i++) {
		int num;
		cin >> num;
		q2.Enqueue(num);
	}
	cout << "Search for?: ";
	cin >> searchNum;
	if (q1.hasItem(searchNum))
		cout << "Present in queue1" << endl;
	if (q2.hasItem(searchNum))
		cout << "Present in queue2" << endl;

	if (q1 == q2)
		cout << "Identical queues";
	else
		cout << "Not identical queues";
	cout << endl << endl << "Queue1: ";
	while (true) {
		int num;
		if (q1.Dequeue(num) == Underflow)
			break;
		cout << num << " ";
	}
	cout << endl << endl << "Queue2: ";
	while (true) {
		int num;
		if (q2.Dequeue(num) == Underflow)
			break;
		cout << num << " ";
	}
	cout << endl;

	return 0;
}
