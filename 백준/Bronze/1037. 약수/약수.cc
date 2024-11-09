#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> nums(n);
	int mx = 0;
	int mn = 1000001;
	for (int i = 0; i < n; i++) {
		cin >> nums[i];
		if (mx < nums[i]) {
			mx = nums[i];
		}
		if (mn > nums[i]) {
			mn = nums[i];
		}
	}

	int answer = mx * mn;

	cout << answer;
	return 0;
}