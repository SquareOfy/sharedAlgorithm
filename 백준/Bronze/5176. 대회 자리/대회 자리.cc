#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
	int t;
	cin >> t;
	for (int tc = 0; tc < t; tc++) {
		int p, m;
		cin >> p >> m;
		vector<int> lst(m, 0);
		int answer = 0;
		for (int i = 1; i <= p; i++) {
			int seat;
			cin >> seat;
			seat -= 1;
			if(lst[seat] != 0) {
				answer += 1;
			}
			else {
				lst[seat] = i;
			}
		}
		cout << answer << endl;

	}
	return 0;
}