#include <iostream>
using namespace std;

long long fibo[91] = {};
long long get_fibo(int n) {
	fibo[1] = 1;
	for (int i = 2; i <= n; i++) {
		fibo[i] = fibo[i - 1] + fibo[i - 2];
	}
	return fibo[n];
}


int main()
{
	ios::sync_with_stdio(0);
	int n;
	cin >> n;
	cout << get_fibo(n);

}
