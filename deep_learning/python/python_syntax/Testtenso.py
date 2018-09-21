import tensorflow as tf

# -1 ~ 1 사이의 난수 1개
print(tf.random_uniform([1],-1,1))
x= tf.random_uniform([1],-1,1)
y= tf.random_uniform([3],-10,10)

sess = tf.Session();
print(sess.run(x))
print(sess.run(y))