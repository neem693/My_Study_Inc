
import tensorflow as tf

a = tf.constant(1)
b = tf.constant(2)


c = tf.add(a,b)
d = tf.multiply(c,2)
e = tf.div(d,2)

tf.summary.histogram('a', a)
tf.summary.histogram('b', b)
tf.summary.histogram('c', c)
tf.summary.histogram('d', d)
tf.summary.histogram('e', e)



sess = tf.Session()



merged = tf.summary.merge_all()
writer = tf.summary.FileWriter("/tmp/result1", sess.graph )

summary,res= sess.run([merged,e])
writer.add_summary(summary, global_step=1)

print("e=",res)
# tensorboard --logdir=/tmp/result1
