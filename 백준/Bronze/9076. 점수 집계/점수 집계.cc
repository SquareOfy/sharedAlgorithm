#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;


int main() {
	int t;
	cin >> t;
	for (int tc = 0; tc < t; tc++) {
		vector<int> scores;
		int score;
		for (int i = 0; i < 5; i++) {
			cin >> score;
			scores.push_back(score);
		}
		sort(scores.begin(), scores.end());
		if (scores[3] - scores[1] >= 4) {
			cout << "KIN" << endl;
		}
		else {
			cout << scores[1] + scores[2] + scores[3] << endl;
		}
	}
	return 0;
}