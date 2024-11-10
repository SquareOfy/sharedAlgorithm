#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	string s;
	cin >> s;
	vector<int> lst;
	for (char c : s) {
		lst.push_back(c - '0');
	}

	sort(lst.begin(), lst.end());
	for (int i = lst.size() - 1;i >= 0; i--) {
		cout << lst[i];
	}


	

	return 0;
}