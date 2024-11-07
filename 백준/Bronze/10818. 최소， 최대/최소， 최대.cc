#include <iostream>
using namespace std;

int main()
{   
	ios::sync_with_stdio(0);
	int mn = 0x7FFFFFFF;
	int mx = 0X80000000;
	int n, num;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num;
		if (num > mx) {
			mx = num;
		}
		if (num < mn) {
			mn = num;
		}
		
	}
	cout << mn << " " << mx;
}
