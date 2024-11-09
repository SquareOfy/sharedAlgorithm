#include <iostream>

using namespace std;

int main() {

	int mnHam = 2001;
	int mnDrink = 2001;
	for (int i = 0; i < 3; i++) {
		int price;
		cin >> price;
		if (price < mnHam) {
			mnHam = price;
		}
	}

	for (int i = 0; i < 2; i++) {
		int price;
		cin >> price;
		if (price < mnDrink) {
			mnDrink = price;
		}
	}

	cout << (mnHam + mnDrink) - 50;

	return 0;
}