
# coding: utf-8

# # Tensorflow 기초
# tensorflow란 tensor의 흐름을 graph형태로 구성하기 때문에 지어진 이름이다.
# tensor란 데이터 및 데이터에 대한 연산을 담는 클래스이다.
# 그 종류에는 Contant, Variable, Placeholder, Operation 있다. 
# 
# ### 1. tensor Contant

# In[1]:


import tensorflow as tf
import numpy as np

hello = tf.constant('Hello, TensorFlow!')
a = tf.constant(3)
b = tf.constant(9)

print(hello)
print(a)

sess = tf.Session()

print(sess.run(hello)) 
print(sess.run(a*b))


# #### session을 새로 할당받고, 실행(run)을 하여야 실제 계산이 된다

# In[2]:


import tensorflow as tf
import numpy as np

# tensorflow 내부에 상수(constant) 정의
hello = tf.constant('Hello, TensorFlow!')
a = tf.constant(3)
b = tf.constant(9)

print(hello)
print(a)

# tf session을 만들어야 실제 tf 생성 및 메모리 할당이 된다.
sess = tf.Session()

# tf 내부의 값을 보려면 sess.run()의 결과로 그 값을 받아야 한다.
print(sess.run(hello)) 
print(sess.run(a*b))


# In[3]:


res_hello = sess.run(hello)
res_ab = sess.run(a*b)
print('Type', type(res_hello))
print('Type', type(res_ab))
print(res_ab.shape, len(res_ab.shape))


# ### 2. 행렬 데이타로 해보기

# In[4]:


# Build a dataflow graph.
c = tf.constant([[1.0, 2.0], [3.0, 4.0]])
d = tf.constant([[1.0, 1.0], [0.0, 1.0]])
e = tf.matmul(c, d)

# Construct a `Session` to execute the graph.
sess = tf.Session()

# Execute the graph and store the value that `e` represents in `result`.

print('tf:', c, d, e)
print('c from run():\n', sess.run(c))
print('d from run():\n', sess.run(d))
print('e from run():\n', sess.run(e))



# In[5]:


result = sess.run(tf.matmul(c, d))
print('result type:', type(result))
print(result)


# #### tensor의 shape,  numpy(ndarray)의 shape

# In[6]:


print(c.shape)
print(c.get_shape())
print(e.shape)
print(e.get_shape())




