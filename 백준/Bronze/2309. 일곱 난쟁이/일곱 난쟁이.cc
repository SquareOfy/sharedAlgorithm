#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;
vector<int> result(7);
vector<int> heights;

bool flag = 0;
void pick_height(int level, int nxtIdx, int sum) {
	if (7 - level > 9 - nxtIdx) {
		return;
	}
	if (flag) {
		return;
	}
	if (level == 7) {
		if (not flag && sum == 100) {
			flag = 1;
			for (int h : result) {
				cout << h << endl;
			}
		}
		
		return;
	}
	for (int i = nxtIdx; i < 9; i++) {
		result[level] = heights[i];
		pick_height(level + 1, i + 1, sum + heights[i]);
	}

}

int main() {
	int input;
	for (int i = 0; i < 9; i++) {
		cin >> input;
		heights.push_back(input);

	}
	sort(heights.begin(), heights.end());
	pick_height(0, 0, 0);


	return 0;
}