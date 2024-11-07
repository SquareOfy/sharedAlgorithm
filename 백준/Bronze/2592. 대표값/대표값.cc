#include <iostream>
#include <string>
using namespace std;

int main()
{   
	ios::sync_with_stdio(0);
	int cntArr[100] = {};
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		int number;
		cin >> number;
		sum += number;
		cntArr[number / 10] += 1;
	}

	int mx = 0;
	int mxCnt = 0;
	for (int i = 0; i < 100; i++) {
		if (cntArr[i] > mx) {
			mx = i;
			mxCnt = cntArr[i];
		}
	}

	mx *= 10;
	cout << sum / 10 << endl << mx;
}
