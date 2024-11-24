#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int p;
		cin >> p;
		int mxPrice = 0;
		string mxName;
		for (int j = 0; j < p; j++) {
			int price;
			string name;
			cin >> price >> name;
			if (mxPrice < price) {
				mxPrice = price;
				mxName = name;
			}
		}
		cout << mxName << endl;

	}
	return 0;
}