#include<iostream>
#include <fstream>
#include<string>
#include <fstream>
#include "student.h"
#include"uslist.h"

using namespace std;

typedef Student ItemType;

int main() {
	ifstream in;
	in.open("/home/shihab/workspace/305_Lab5_Q2/students.txt");
	UnsortedType l;
	ItemType item;
	int id,num,i=0;
	string fname, lname;
	double grade;
	in>>num;
	while (i<num){
		in>>id>>fname>>lname>>grade;
		item.setID(id); item.setFName(fname);
		item.setLName(lname); item.setGrade(grade);
		l.InsertItem(item);
		i++;
	}
	l.delDuplicates();
	for (int i=0; i<l.LengthIs(); i++){
		l.GetNextItem(item);
		item.printStudentDetails();
	}
	l.ResetList();
	return 0;
}
