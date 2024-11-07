#include <iostream>
#include <string>
using namespace std;

int main()
{   
	ios::sync_with_stdio(0);
	int t;
	cin >> t;
	for (int tc = 0; tc < t; tc++) {
		int num;
		cin >> num;
		int i = 0;

		while (num>0) {
			if (num % 2 == 1) {
				cout << i << " ";
			}
			num /= 2;
			i++;
		}

	}

}
