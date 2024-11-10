#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	vector<int> lst;
	int num;
	int mean = 0;
	for (int i = 0; i < 5; i++) {
		cin >> num;
		lst.push_back(num);
		mean += num;
	}
	mean /= 5;
	sort(lst.begin(), lst.end());
	cout << mean << endl;
	cout << lst[2];



	

	return 0;
}