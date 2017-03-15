#ifndef emp_h
#define emp_h
#include <iostream>
#include <string>
using namespace std;
enum RelationType {
	LESS, EQUAL, GREATER
};

/*
 Define the employee class with required member variables and member functions.
 */
class Employee {
private:
	int eid;
	string name;
	int did;
public:
	Employee(int empid = 0, string n = "", int deptid = 0);
	void printDetails();
	RelationType ComparedTo(const Employee & e);
	int getEID() {
		return eid;
	}
	int getDID() {
		return did;
	}
};
#endif
