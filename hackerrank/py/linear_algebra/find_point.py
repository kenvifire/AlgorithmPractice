t = int(raw_input(""))
while t > 0:
    arr = map(int, raw_input().split())
    px = arr[0]
    py = arr[1]
    qx = arr[2]
    qy = arr[3]
    t -= 1
    print 2*qx - px, 2*qy - py

