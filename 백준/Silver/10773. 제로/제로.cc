#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);

	int k;
	cin >> k;
	vector<int> numbers(k);
	for (int i = 0; i < k; i++) {
		int n;
		cin >> n;
		if (n == 0) {
			numbers.pop_back();
		}
		else {
			numbers.push_back(n);

		}

	}
	long long sum = 0;
	for (int num : numbers) {
		sum += num;

	}

	cout << sum;
			
}
