import math

import matplotlib.pyplot as plt


x=[]
y=[]


y1 = []


for i in range(360):
    yy = math.sin(math.pi/180*i)
    yy1 = math.cos(math.pi/180*i)

    x.append(i)
    y.append(yy)
    y1.append(yy1)

plt.plot(x,y,'r')
plt.plot(x,y1,'b')
plt.show()




def cost(x,y,W):
    loss =0
    for i in range(len(x)):
        hx = W * x[i]