import tensorflow as tf



def test2():
    a = tf.constant(3)
    b = tf.constant(5)
    # add = tf.add(a, b)

    x = tf.placeholder(tf.int32)
    y = tf.placeholder(tf.int32)

    add = tf.add(x, y)

    sess = tf.Session()
    sess.run(tf.global_variables_initializer())

    print(sess.run(add, feed_dict={x: 3, y: 5}))
    feed = {x: [3,5], y: [2,7]}
    # feed = dict(x=5, y=7)
    print(sess.run(add, feed_dict=feed))
    sess.close()


test2()