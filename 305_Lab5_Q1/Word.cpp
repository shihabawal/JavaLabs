#include "Word.h"
Word::Word(string wd) {
	word = wd;
}
string Word::getWord() {
	return word;
}

void Word::setWord(string wd) {
	word = wd;

}

void Word::printWord() {
	cout << word;
}

RelationType Word::ComparedTo(Word otherItem) const {
	if (word < otherItem.word)
		return LESS;
	else if (word > otherItem.word)
		return GREATER;
	else
		return EQUAL;
}
