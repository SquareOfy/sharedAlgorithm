#include <iostream>
#include <string>
using namespace std;

int main()
{   
	ios::sync_with_stdio(0);
	int cntArr[42] = {};
	int answer = 0;
	for (int i = 0; i < 10; i++) {
		int num;
		cin >> num;
		int r = num % 42;
		if (cntArr[r]== 0) {
			answer++;
			cntArr[r] += 1;
		}
	}
	cout << answer;
}
