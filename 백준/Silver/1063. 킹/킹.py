k, s, n = input().split()

king_r = int(k[1]) - 1
king_c = ord(k[0]) - ord('A')
stone_r = int(s[1]) - 1
stone_c = ord(s[0]) - ord('A')

flag = king_r == stone_r and king_c == stone_c
move_dict = {'R': (0, 1), 'L': (0, -1), 'B': (-1, 0), 'T': (1, 0), \
             'RT': (1, 1), 'LT': (1, -1), 'RB': (-1, 1), 'LB': (-1, -1)}

for i in range(int(n)):
    move = input()
    d = move_dict[move]
    du = king_r + d[0]
    dv = king_c + d[1]
    if du < 0 or dv < 0 or du >= 8 or dv >= 8:
        continue

    king_r = du
    king_c = dv

    if king_r == stone_r and king_c == stone_c:
        du = stone_r + d[0]
        dv = stone_c + d[1]
        if du < 0 or dv < 0 or du >= 8 or dv >= 8:
            king_r -= d[0]
            king_c -= d[1]
            continue
        stone_r = du
        stone_c = dv

print(chr(king_c + ord('A')) + str((king_r + 1)))
print(chr(stone_c + ord('A')) + str((stone_r + 1)))
