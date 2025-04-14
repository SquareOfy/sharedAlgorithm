#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{	
	int N;
	cin >> N;
	vector<vector<int>> points(N);
	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;
		points[i] = { x, y };
	}

	sort(points.begin(), points.end());

	for (int i = 0; i < N; i++) {
		cout << points[i][0] << " " << points[i][1] << "\n";
	}
	return 0;
}