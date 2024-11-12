#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	int numbers[9];
	int sum = 0;
	for (int i = 0; i < 9; i++) {
		cin >> numbers[i];
		sum += numbers[i];
	}
	bool flag = 0;
	for (int i = 0; i < 9 && !flag; i++) {
		for (int j = i + 1; j < 9; j++) {
			if (sum - numbers[i] - numbers[j] == 100) {
				for (int k = 0; k < 9; k++) {
					if (k != i && k != j) {
						cout << numbers[k] << endl;
					}
				}
			}
		}
	}

			
}
