#ifndef s_h
#define s_h
#include <iostream>
#include <string>
using namespace std;
enum RelationType {
	LESS, GREATER, EQUAL
};

class Student {
public:
	Student(int id = 0, string fname = " ", string lname = " ", double gd = 0);
	string getFName();
	string getLName();
	void setFName(string fn);
	void setLName(string ln);
	void setID(int id);
	void setGrade(int grade);
	int getID();
	double getGrade();
	void printStudentDetails();
	RelationType ComparedTo(Student) const;
	Student& operator= (const Student &s);

private:
	int sid;
	string fname;
	string lname;
	double grade;
};
#endif
