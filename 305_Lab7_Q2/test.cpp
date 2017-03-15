#include <iostream>
#include <string>
#include "cul.h"
#include "cul.cpp"
using namespace std;

int main() {
	CircularUnsortedList<string> l;
	int num;
	string item;
	cout<<"Enter num of item to enter: ";
	cin>>num;
	cout<<"Enter items: ";
	for (int i=0; i<num; i++){
		cin>>item;
		l.InsertItem(item);
	}
	cout<<"Original Items: ";
	l.print();
	cout<<"Enter item to print from: ";
	cin>>item;
	l.ResetList(item);
	cout<<"Items: ";
	bool end;
	l.GetNextItem(item, end);
	cout<<item<<" ";
	while (!end){
		l.GetNextItem(item,end);
		cout<<item<<" ";
	}
	cout<<endl;
	l.Rotate();
	cout<<"Rotated Items: ";
	l.print();
	return 0;
}
