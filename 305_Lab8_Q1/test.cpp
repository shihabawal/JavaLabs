#include <iostream>
using namespace std;

double harmonicSeries(int n, double sum = 0) {
	if (n == 1)
		return sum + 1.0;
	else {
		sum += 1.0 / n;
		return harmonicSeries(n - 1, sum);
	}
}

double alternateSeries(int n, double sum = 0) {
	if (n == 1)
		return 1.0 + sum;
	else {
		if (n % 2 == 0)
			sum -= 1.0 / n;
		else
			sum += 1.0 / n;
		return alternateSeries(n - 1, sum);
	}
}

int main() {
	cout << "Harmonic series of 7: " << harmonicSeries(7) << endl;
	cout << "Alternate series of 7: " << alternateSeries(7) << endl;
	return 0;
}

