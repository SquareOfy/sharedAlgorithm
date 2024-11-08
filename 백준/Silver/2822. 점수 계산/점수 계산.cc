#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	vector<pair<int, int>> score(8);
	for (int i = 0; i < 8; i++) {
		int s;
		cin >> s;
		score[i] = { s, i };
	}

	sort(score.begin(), score.end());
	int answer = 0;
	vector<int> indices;
	for (int i = 7; i > 2; i--) {
		answer += score[i].first;
		indices.push_back(score[i].second);
	}
	cout << answer<<endl;
	sort(indices.begin(), indices.end());
	for (int idx : indices) {
		cout << idx + 1 << " ";
	}
	cout << endl;
	return 0;
}