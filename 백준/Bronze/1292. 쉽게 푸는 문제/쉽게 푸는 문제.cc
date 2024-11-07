#include <iostream>
#include <string>
using namespace std;

int main()
{   
	ios::sync_with_stdio(0);
	int idx = 0;
	int i = 1; 
	int cnt = 0;
	int a, b;
	int answer = 0;
	cin >> a >> b;
	while (1) {
		idx += 1;
		if (idx >= a) {
			answer += i;
		}
		if (idx == b) {
			break;
		}
		cnt += 1;
		if (cnt == i) {
			i += 1;
			cnt = 0;
		}

	}
	cout << answer;
}
