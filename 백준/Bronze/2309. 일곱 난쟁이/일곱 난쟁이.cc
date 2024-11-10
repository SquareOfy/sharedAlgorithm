#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;


int main() {
	vector<int> lst;
	int input;
	int sum = 0;
	for (int i = 0; i < 9; i++) {
		cin >> input;
		sum += input;
		lst.push_back(input);
	}
	bool flag = 0;
	for (int i = 0; i < 9 && !flag; i++) {
		for (int j = i+1; j < 9; j++) {
			if (sum - lst[i] - lst[j] == 100) {
				lst[i] = 0;
				lst[j] = 0;
				flag= 1;
				break;
			}
		}
	}
	sort(lst.begin(), lst.end());
	for (int i = 2; i < 9; i++) {
		cout << lst[i] << endl;
	}


	return 0;
}