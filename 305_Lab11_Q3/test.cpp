#include <iostream>
#include "PQueueType.h"

#define int ItemType
using namespace std;

int main() {
	PQueueType p;
	int num;
	cout << "Enter 7 integers for the Max Heap\n";
	for (int i = 0; i < 7; i++) {
		cin>>num;
		p.Enqueue(num);
	}
	cout<<"Max Heap Array: ";
	p.printPQueueItems(cout);
	cout<<"Enter integer to dequeue: ";
	cin>>num;
	p.Dequeue(num);
	cout<<"Dequeued item: "<<num<<endl;
	cout<<"Max Heap Array: ";
	p.printPQueueItems(cout);
	return 0;
}
