#include<iostream>
#include <fstream>
#include<string>
#include <fstream>
#include "student.h"
#include"uslist.h"

using namespace std;

typedef Student ItemType;

double calc_avg(UnsortedType l) {
	ItemType item;
	l.ResetList();
	double avg = 0;
 	for (int i = 0; i < l.LengthIs(); i++) {
		l.GetNextItem(item);
		avg += item.getGrade();
	}
	l.ResetList();
	return avg/l.LengthIs();
}

UnsortedType read (char *f){
	ItemType item;
	UnsortedType l;
	ifstream in;
	in.open(f);
	int id,num;
	string fname, lname;
	double grade;
	in>>num;
	for(int i=0; i<num; i++){
		in>>id>>fname>>lname>>grade;
		item.setID(id); item.setFName(fname);
		item.setLName(lname); item.setGrade(grade);
		l.InsertItem(item);
	}
	l.ResetList();
	in.close();
	return l;
}

void print (UnsortedType l){
	ItemType item;
	l.ResetList();
	for (int i=0; i<l.LengthIs(); i++){
		l.GetNextItem(item);
		item.printStudentDetails();
	}
	l.ResetList();
	cout<<endl;
}

int main() {
	UnsortedType l;
	l = read("/home/shihab/workspace/305_Lab5_Q3ab/studentdata.txt");
	print (l);
	cout<<calc_avg(l)<<endl;
	return 0;
}
