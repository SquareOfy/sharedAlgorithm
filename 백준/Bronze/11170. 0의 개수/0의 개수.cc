#include <iostream>
#include <string>

using namespace std;


int main()
{
	ios::sync_with_stdio(0);
	int t; 
	cin >> t;
	for (int tc = 0; tc < t; tc++) {
		int n, m;
		int cnt = 0;
		cin >> n >> m;

		for (int num = n; num <= m; num++) {
			for (char c : to_string(num)) {
				if (c == '0') {
					cnt++;
				}
			}
		}

		cout << cnt << endl;

	}
	
	

}
