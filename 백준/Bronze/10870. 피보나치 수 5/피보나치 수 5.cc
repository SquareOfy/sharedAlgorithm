#include <iostream>
using namespace std;

int fibo[21] = {};
int get_fibo(int n) {
	if (n == 0) {
		return 0;
	}
	if (fibo[n] != 0) {
		return fibo[n];
	}
	return get_fibo(n - 1) + get_fibo(n - 2);
}


int main()
{
	ios::sync_with_stdio(0);
	int n;
	fibo[1] = 1;
	cin >> n;
	cout << get_fibo(n);

}
