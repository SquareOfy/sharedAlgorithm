#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
	int t;
	cin >> t;
	vector<int> lst(10);
	for (int tc = 0; tc < t; tc++) {
		for (int i = 0; i < 10; i++) {
			cin >> lst[i];
		}
		sort(lst.begin(), lst.end());
		cout << lst[7] << endl;

	}
	return 0;
}