#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int t;
	cin >> t;
	for (int tc = 0; tc < t; tc++) {
		int n;
		cin >> n;
		vector<int> arr(n);
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		int mx = *max_element(arr.begin(), arr.end());
		int mn = *min_element(arr.begin(), arr.end());

		cout << (mx - mn) * 2 << endl;


	}
	return 0;
}