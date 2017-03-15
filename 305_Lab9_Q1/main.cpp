#include <iostream>
using namespace std;

double PIh(int n, double sum) {
	if (n == 0) {
		return 3.0 + sum;
	} else if (n % 2 == 0) {
		return PIh(n-1, sum - (4.0 / ((2.0 * n) * (2.0 * n + 1.0) * (2.0 * n + 2.0))));
	} else {
		return PIh(n-1, sum + (4.0 / ((2.0 * n) * (2.0 * n + 1.0) * (2.0 * n + 2.0))));
	}
}

double PI(int n) {
	return PIh(n, 0);
}

int main() {
	cout << PI(40) << endl;
	return 0;
}
