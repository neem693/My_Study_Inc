import tensorflow as tf

def test1():
    value  = tf.Variable(0)
    one    = tf.constant(1)
    state  = tf.add(value, one)
    update = tf.assign(value, state)

    sess = tf.Session()
    sess.run(tf.global_variables_initializer())

    for i in range(3):
        #print(sess.run(update), sess.run(value), sess.run(state))
        print(sess.run(state), sess.run(update), sess.run(value))
        # print(sess.run(state))

    sess.close()


test1()