#include "emp.h"
//Constructor with arguments
Employee::Employee(int empid, string n, int deptid) {
	eid = empid;
	name = n;
	did = deptid;
}
//Function to print the the details of the employee.
void Employee::printDetails() {
	cout << eid << " " << name.c_str() << " " << did << endl;
}
//Function to check if key values (ids of the employees) match.
RelationType Employee::ComparedTo(const Employee & e) {
	if (eid < e.eid)
		return LESS;
	else if (eid == e.eid)
		return EQUAL;
	else
		return GREATER;
}
