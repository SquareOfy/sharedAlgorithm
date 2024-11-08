#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> numbers(n);
	for (int i = 0; i < n; i++) {
		cin >> numbers[i];
	}
	sort(numbers.begin(), numbers.end());
	for (int i:numbers) {
		cout << i<<endl;
	}
	return 0;
}