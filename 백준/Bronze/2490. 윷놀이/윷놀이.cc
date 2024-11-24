#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
	string output[5] = { "E", "A", "B", "C", "D" };
	for (int i = 0; i < 3; i++) {
		int input;
		int zero = 0;
		for (int j = 0; j < 4; j++) {
			cin >> input;
			if (input == 0) {
				zero += 1;
			}
		}
		cout << output[zero]<< endl;
	}
	return 0;
}