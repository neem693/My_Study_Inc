
import math
import matplotlib.pyplot as plt

def sigmoid(z):
    return 1. / (1. + math.e**-z)

# H(x) = Wx
# z = Wx
print(math.e)
print(sigmoid(-100))    # 0에 수렴
print(sigmoid(-10))
print(sigmoid(0))       # 0.5
print(sigmoid(10))
print(sigmoid(100))     # 1에 수렴

xx, yy = [], []
for i in range(-10, 10):
    n = sigmoid(i)

    xx.append(i)
    yy.append(n)

plt.plot(xx, yy, 'r')
plt.show()

