import math
import matplotlib.pyplot as plt

xx,yy = [],[]

xx1,yy1 = [],[]

xx2,yy2 = [],[]

for i in range(-360,360):
    x,y = i,math.sin(i*math.pi/180)

    xx.append(i)
    yy.append(y)

    xx1.append(i)
    yy1.append(math.cos(i*math.pi/180))





plt.plot(xx, yy, 'r')
plt.plot(xx1, yy1, 'g')

plt.show()