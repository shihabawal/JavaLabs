#ifndef itt_h
#define itt_h
struct LocateRecord
{
  int studentId;
  int  recordNumber;
};

class Student
{
private:
LocateRecord stu_r;
public:

Student()
{
	stu_r.studentId = -1;
	stu_r.recordNumber= -1;
}
Student(const Student & sr)
{
	stu_r = sr.stu_r;
}

bool operator < (const Student & sr)
{
	return  (stu_r.studentId < sr.stu_r.studentId);
}
bool operator == (const Student & sr)
{
	return  (stu_r.studentId < sr.stu_r.studentId);
}
bool operator > (const Student & sr)
{
	return  (stu_r.studentId > sr.stu_r.studentId);
}

void setStudentRecord(const Student & sr)
{
	stu_r = sr.stu_r;
}
void setStudentRecord(int sid, int rno)
{
	stu_r.studentId=sid;
	stu_r.recordNumber= rno;
}
LocateRecord getStudentRecord()
{
	return stu_r;
}

};
#endif
