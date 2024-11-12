#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;



int main()
{
	ios::sync_with_stdio(0);
	int k;
	cin >> k;
	for (int t = 0; t < k; t++) {
		int n; 
		cin >> n;
		vector<int> score(n);
		int mn = 101;
		int mx = -1;
		for (int i = 0; i < n; i++) {
			cin >> score[i];
			if (score[i] > mx) {
				mx = score[i];
			}
			if (score[i] < mn) {
				mn = score[i];
			}
		}

		sort(score.begin(), score.end());
		int largest_gap = 0;
		for (int i = 1; i < n; i++) {
			if (score[i] - score[i - 1] > largest_gap) {
				largest_gap = score[i] - score[i - 1];
			}
		}
		cout << "Class " << t+1 << endl;
		cout << "Max " << mx << ", Min " << mn << ", Largest gap " << largest_gap << endl;
	}
}
