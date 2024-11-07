#include <iostream>
#include <string>
using namespace std;

int main()
{   
	ios::sync_with_stdio(0);
	int winner=0; int mxScore =0;
	for (int i = 1; i < 6; i++) {
		int sum = 0;
		int score = 0;
		for (int j = 0; j < 4; j++) {
			cin >> score;
			sum += score;
		}
		if (sum > mxScore) {
			mxScore = sum;
			winner = i;
		}
	}
	cout << winner << " " << mxScore;
}
