//main.cpp
#include<iostream>
#include <fstream>
#include<string>
#include <fstream>
#include "Word.h"
#include"uslist.h"
using namespace std;

int Occurrence(const UnsortedType & list, ItemType item) {
	int count = 0;
	UnsortedType tmplst = list;
	tmplst.ResetList();
	ItemType tmp;
	for (int i = 0; i < list.GetLength(); i++) {
		tmp = tmplst.GetNextItem();
		if (tmp.ComparedTo(item) == EQUAL)
			count++;
	}
	tmplst.ResetList();
	return count;
}

int main() {
	ifstream in;
	in.open("/home/shihab/Desktop/Random/C++/305test/input.txt");
	UnsortedType l(50);
	Word item, nextitem;
	string s;
	while (!in.eof()) {
		in >> s;
		//for some reason in>>s reads the last word twice
		item.setWord(s);
		if (l.InsertItem(item) == Fail) {
			cout << "List full";
			return 0;
		}
	}
	UnsortedType temp = l;
	int num = 0;
	while (temp.GetLength() != 0) {
		item = temp.GetNextItem();
		item.printWord();
		num = Occurrence(temp, item);
		cout << " " << num << endl;
		for (int i = 0; i < num; i++) {
			temp.ResetList();
			temp.DeleteItem(item);
		}
	}
}

