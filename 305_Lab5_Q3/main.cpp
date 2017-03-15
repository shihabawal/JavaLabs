#include<iostream>
#include <fstream>
#include<string>
#include <fstream>
#include "student.h"
#include"uslist.h"

using namespace std;

typedef Student ItemType;

int main() {
	int id;
	string fname, lname;
	double grade;
	ifstream in1, in2;
	in1.open("/home/shihab/workspace/305_Lab5_Q3/studentList1.txt");
	in2.open("/home/shihab/workspace/305_Lab5_Q3/studentList2.txt");
	UnsortedType l1, l2;
	ItemType item;
	int num;
	//reading data and coping into Unsorted list
	in1 >> num;
	for (int i = 0; i < num; i++) {
		in1 >> id >> fname >> lname >> grade;
		item.setID(id);
		item.setFName(fname);
		item.setLName(lname);
		item.setGrade(grade);
		l1.InsertItem(item);
	}
	l1.ResetList();
	in2 >> num;
	for (int i = 0; i < num; i++) {
		in2 >> id >> fname >> lname >> grade;
		item.setID(id);
		item.setFName(fname);
		item.setLName(lname);
		item.setGrade(grade);
		l2.InsertItem(item);
	}
	l1.delDuplicates();
	l2.delDuplicates();
	l2.ResetList();
	UnsortedType l3 = l1 & l2;
	UnsortedType l4 = l1 | l2;
	l1.ResetList();
	l2.ResetList();
	//Printing the details for students
	cout<<"Intersection of the lists\n";
	l3.ResetList();
	for (int i = 0; i < l3.LengthIs(); i++) {
		l3.GetNextItem(item);
		item.printStudentDetails();
	}
	l4.ResetList();
	cout<<endl;
	cout<<"Union of the lists\n";
	for (int i = 0; i < l4.LengthIs(); i++) {
		l4.GetNextItem(item);
		item.printStudentDetails();
	}
	l3.ResetList();
	l4.ResetList();

	return 0;
}
