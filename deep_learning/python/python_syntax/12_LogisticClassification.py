
import tensorflow as tf

x = [[1, 1, 1, 1, 1, 1],    #bias 인자
     [2, 3, 3, 5, 7, 2],    #x1 <=학습시간
     [1, 2, 5, 5, 5, 5]]    #x2 <=출석횟수
y =  [0, 0, 0, 1, 1, 1]     #y

X = tf.placeholder(tf.float32)
Y = tf.placeholder(tf.float32)

W = tf.Variable(tf.random_uniform([1, 3], -1, 1))

z = tf.matmul(W, X)
hypo = tf.div(1., 1.+tf.exp(-z))
cost = -tf.reduce_mean(Y*tf.log(hypo) + (1-Y)*tf.log(1-hypo))

rate = tf.Variable(0.1)
train= tf.train.GradientDescentOptimizer(rate).minimize(cost)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(2001):
    sess.run(train, feed_dict={X: x, Y: y})
    if i%20 == 0:
        print(sess.run(cost, feed_dict={X: x, Y: y}),
              sess.run(W))

print(sess.run(hypo, feed_dict={X: [[1], [3], [1]]}) > 0.5)
print(sess.run(hypo, feed_dict={X: [[1], [4], [2]]}) > 0.5)
print(sess.run(hypo, feed_dict={X: [[1], [4], [5]]}) > 0.5)
print(sess.run(hypo, feed_dict={X: [[1], [6], [4]]}) > 0.5)
print(sess.run(hypo, feed_dict={X: [[1], [2], [5]]}))
print(sess.run(hypo, feed_dict={X: [[1], [3], [5]]}))
print(sess.run(hypo, feed_dict={X: [[1], [1], [5]]}))

values = [[1, 1, 1, 1],
          [3, 4, 4, 6],
          [1, 2, 5, 4]]
print(sess.run(hypo, feed_dict={X: values}) > 0.5)

sess.close()







