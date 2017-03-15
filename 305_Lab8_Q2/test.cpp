#include <iostream>
using namespace std;

void IntegerPalindrome(int value) {
	if (value >= 9)
		cout << 9;
	else {
		cout << value;
		IntegerPalindrome(value + 1);
		cout << value;
	}
}

int main() {
	int num;
	cout<<"Enter an integer: ";
	cin>>num;
	IntegerPalindrome(num);
	cout<<endl;
	return 0;
}
