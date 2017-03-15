#include <iostream>
#include "queuetype.h"
using namespace std;

int main() {
	int choice, i=0;
	ItemType t;
	cout<<"1. New car registration"<<endl
			<<"2. renewal of old car"<<endl
			<<"3. end"<<endl<<"Choice: ";
	cin>>choice;
	QueueType q1, q2;
	while (choice != 3){
		i++;
		switch (choice){
		case 1:
			t.setCounter_no(1);
			t.setTicket_no(i);
			q1.Enqueue(t);
			break;
		case 2:
			t.setCounter_no(2);
			t.setTicket_no(i);
			q2.Enqueue(t);
			break;
		default:
			cout<<"Invalid choice!";
		}
		cout<<"Choice: ";
		cin>>choice;
	}
	q1.printItems(cout);
	q2.printItems(cout);
}
