#include <iostream>
#include <cmath>
using namespace std;

int fibonacciSequence(int n, int a = 0, int b = 1, int i = 0) {
	if (n == 0)
		return i;
	else {
		cout << a << " ";
		return fibonacciSequence(n - 1, b, a + b, i + 1);
	}
}

int main() {
	int num, times;
	cout << "Enter number of Fibonacci terms to display: ";
	cin >> num;
	cout << "Fibonacci series: ";
	times = fibonacciSequence(num);
	cout << "\nNumber of recursive calls: " << times;
	cout << endl;
	return 0;
}
