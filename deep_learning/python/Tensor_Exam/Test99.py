
import tensorflow as tf

def NineNine(dan):
    first  = tf.placeholder(tf.int32)
    second = tf.placeholder(tf.int32)
    mul = first * second # tf.mul(first, second)

    sess = tf.Session()
    sess.run(tf.global_variables_initializer())

    for i in range(1, 10):
        # print('{} x {} = {}'.format(dan, i, i*dan))
        print('{} x {} = {}'.format(dan, i,
                                    sess.run(mul, feed_dict={first: i, second: dan})))
    sess.close()



    # first  = tf.placeholder(tf.int32)
    # second = tf.constant(dan)
    # mul = first * second # tf.mul(first, second)
    #
    # sess = tf.Session()
    # sess.run(tf.global_variables_initializer())
    #
    # for i in range(1, 10):
    #     # print('{} x {} = {}'.format(i, dan, i*dan))
    #     print('{} x {} = {}'.format(dan, i,
    #                                 sess.run(mul, feed_dict={first: i})))
    # sess.close()


for dan in range(2,10):
    NineNine(dan)
    print('-'*30)