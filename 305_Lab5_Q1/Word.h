#ifndef s_h
#define s_h
#include <iostream>
#include <string>
using namespace std;
enum RelationType {
	LESS, GREATER, EQUAL
};

class Word {
public:
	Word(string fname = " ");
	string getWord();
	void setWord(string wd);
	void printWord();
	RelationType ComparedTo(Word) const;
private:
	string word;

};
#endif
