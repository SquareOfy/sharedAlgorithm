n= int(input ())
room = 1
i = 1

while n > room:
    room += 6 * i
    i += 1
print(i)
