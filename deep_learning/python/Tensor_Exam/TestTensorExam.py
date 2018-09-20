import tensorflow as tf
import matplotlib.pyplot as plt
x = tf.placeholder(tf.int32)
#y = tf.placeholder(tf.int32)

# y = x^2 + 2*x + 1

#res = tf.square(x,2)

res = x**2 + 2*x + 1

xx=[]
yy=[]


sess = tf.Session()

for i in range(-100,100):
    y = sess.run(res,feed_dict={x : i})
    xx.append(i)
    yy.append(y)
    print(i,":",y)

plt.plot(xx,yy,"ro")
plt.show()

# c = tf.square(2,10)
# print(tf.square(2,10))

