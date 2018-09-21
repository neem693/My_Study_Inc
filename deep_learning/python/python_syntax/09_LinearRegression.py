


import tensorflow as tf


import numpy as np

def display(str):
    print("------------{}-----------".format(str))

# xy = np.loadtxt('Data/simple.txt', unpack=True)
# xy = np.loadtxt('Data/simple2.txt', unpack=True, delimiter=',', skiprows=1)
# print(xy)
# print(type(xy))
# print(xy[0], xy[1])

xy = np.loadtxt('Data/cars.csv', unpack=True, delimiter=',', skiprows=1)

display('xy')
print(xy)


x = xy[0]       # speed 속도
y = xy[1]       # dist 제동거리

X = tf.placeholder(tf.float32)
Y = tf.placeholder(tf.float32)

W = tf.Variable(tf.random_uniform([1], -1, 1))
b = tf.Variable(tf.random_uniform([1], -1, 1))

hypothesis = W*X + b
cost = tf.reduce_mean(tf.square(hypothesis-Y)) #cost = (hypothesis - Y)**2/ len(Y)
learning_rate = tf.Variable(0.001) #W의 이동간격

optimizer = tf.train.GradientDescentOptimizer(learning_rate)
train = optimizer.minimize(cost)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(2001): #0~2000
    sess.run(train, feed_dict={X: x, Y: y}) #학스시키기
    if i%20 == 0:
        print(i,sess.run(cost, feed_dict={X: x, Y: y}))

# print(sess.run(hypothesis, feed_dict={X: [30, 50]}))

WW = sess.run(W)
bb = sess.run(b)

print(WW,bb)

sess.close()


def prediction(x,W,b):
    return W*x +b

#30일때 제동거리
print("30일 때 제동거리 예측 : {}".format(prediction(30,WW,bb)))
print("25일 때 제동거리 예측 : {}".format(prediction(25,WW,bb)))
print("15일 때 제동거리 예측 : {}".format(prediction(15,WW,bb)))



# 문제
# cars.csv 파일을 이용해서
# 속도가 30과 50일 때의 제동거리를 구해보세요.
# import matplotlib.pyplot as plt
#
# def prediction(x, W, b):
#     return W*x + b
#
# plt.plot(x, y, 'ro')
# plt.plot((0, 25), (0, prediction(25, WW, bb)))
# plt.plot((0, 25), (prediction(0, WW, bb), prediction(25, WW, bb)))
# plt.show()






