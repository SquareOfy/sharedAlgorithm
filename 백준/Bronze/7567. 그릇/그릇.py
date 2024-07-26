plates = input()

h = 10

for i in range(1, len(plates)):
    if plates[i] != plates[i-1]:
        h+=10
    else:
        h+=5
print(h)