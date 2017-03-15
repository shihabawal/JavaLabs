#include <iostream>
#include <string>
#include <fstream>
#include "cul.h"
#include "cul.cpp"
using namespace std;

int main() {
	CircularUnsortedList<string> l;
	ifstream in;
	char *task = new char[20];
	char *name = new char[20];
	string tasks[5], names[5];
	in.open("/home/shihab/workspace/305_Lab7_Q2b/in.txt");
	cout<<"\t\t";
	for (int i = 0; i < 5; i++) {
		in.getline(task, 100, ',');
		tasks[i] = tasks[i].assign(task);
		cout<<tasks[i]<<"|  ";
	}

	for (int i = 0; i < 5; i++) {
		in.getline(name, 100, ',');
		names[i] = names[i].assign(name);
		l.InsertItem(names[i]);
	}
	cout<<"\n--------------------"
			"--------------------"
			"--------------------"
			"--------------------"
			"--------------------"
			"--------------------\n";
	for (int i=1; i<=6; i++){
		cout<<"Day"<<i<<"\t\t";
		l.print();
		l.Rotate();
	}
}
