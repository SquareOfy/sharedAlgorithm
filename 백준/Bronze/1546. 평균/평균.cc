#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {

	int n;
	cin >> n;
	vector<int> arr(n);
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	double mx =*max_element(arr.begin(), arr.end());
	double answer = 0;
	for (int i = 0; i < n; i++) {
		answer += arr[i] / mx * 100;
	}

	answer /= n;
	cout << answer;
	return 0;
}