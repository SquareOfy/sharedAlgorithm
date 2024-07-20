from collections import deque

n = int(input())
cards = deque([i+1 for i in range(n)])

while len(cards)>1:
    cards.popleft()
    if len(cards) == 1: break
    cards.append(cards.popleft())

print(cards[0])