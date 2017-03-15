#include "student.h"
Student::Student(int id, string fn, string ln, double gd) {
	sid = id;
	fname = fn;
	lname = ln;
	grade = gd;
}
string Student::getFName() {
	return fname;
}
string Student::getLName() {
	return lname;
}
void Student::setFName(string fn) {
	fname = fn;

}
void Student::setLName(string ln) {
	lname = ln;

}
void Student::setID(int id) {
	sid = id;
}
void Student::setGrade(int grade){
	this->grade = grade;
}
int Student::getID() {
	return sid;
}
double Student::getGrade() {
	return grade;
}

void Student::printStudentDetails() {
	cout << sid << " " << fname.c_str() << " " << lname.c_str() << " " << grade
			<< endl;
}

RelationType Student::ComparedTo(Student otherItem) const {
	if (sid < otherItem.sid)
		return LESS;
	else if (sid > otherItem.sid)
		return GREATER;
	else
		return EQUAL;
}
