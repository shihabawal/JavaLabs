//Sam Andy John Peter Danny

#include <iostream>
#include "dll.h"
#include "dll.cpp"
using namespace std;

int main() {
	DoublyLinkedList<int> l;
	int num;
	int item;
	cout<<"Enter num of items to enter: ";
	cin>>num;
	cout<<"Enter items: ";
	for (int i=0; i<num; i++){
		cin>>item;
		l.InsertItem(item);
	}
	cout<<"Original Items: ";
	l.print();
	cout<<"Enter item to print from; ";
	cin>>item;
	l.ResetList(item);
	bool end;
	cout<<"Items: ";
	l.GetNextItem(item,end);
	cout<<item<<" ";
	while (!end){
		l.GetNextItem(item,end);
		cout<<item<<" ";
	}
	cout<<endl;
	l.ResetList();
	l.Rotate();
	cout<<"Original rotated: ";
	l.print();
	return 0;
}
