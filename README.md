## springboot_redis 学习笔记
##### 支持的数据类型
```$xslt
string
list
set
hash
zset
```
```
| String
-----------
SET KEY VALUE
get key 
getrange key start end
getset key value //返回old值 设定新值
DEL KEY
EXISTS KEY
EXPIRE KEY seconds
KEYS pattern
Persist key  //移除key的过期时间
TTL KEY 
RENAMENX key newkey //仅当 newkey 不存在时，将 key 改名为 newkey 。
type key //返回 key 所储存的值的类型。
setex key seconds value
msetnx key1 value1 key2 value2...//0 1操作 要么多成功 要么都失败

------------------
| Hash
--------------
Hget key field
hkeys key
hvals key
klen key
hmget key field1[field2]
hgetall key
hsetnx key field value

| List
blpop key1 key2 //移除并获取列表的第一个元素 阻塞
brpop key1 key2  //移除并获取列表的最后一个元素 阻塞
lIndex key index 
llen key
lpop key
rpop key
lpush key value[value2] //插入到列表头部
rpush key value[value2] 
lset key index value
| SET
sadd key mem1
sinter key1 key2  //返回交集
sdiff key1 key2  // 返回差集
sunion key1 key2 //返回并集
SMEMBERS KEY //返回集合中所有成员
scard key //获取成员数
srem key mem1[mem2] // 移除集中中成员
spop key //移除并返回集合中的一个随机元素
SISMEMBER key member //判断元素是否在集合内
| HLL
pfadd
pfcount
pfmerge

```

redis 5种数据结构对应场景总结
https://blog.csdn.net/gaogaoshan/article/details/41039581

- 基数基数 HLL   基数估计
```
使用场景：需要统计网页每天的用户访问量的数据，同一个用户一天之内的多次访问请求只能计数一次
要求每一个网页请求都需要带上用户的 ID，无论是登陆用户还是未登陆用户都需要一个唯一 ID 来标识。
https://blog.csdn.net/qq_17305249/article/details/89669053?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
```
- watch 机制+transaction 实现 乐观锁
```aidl

```
- docker redis 性能测试
```
docker exec -it 70f2d70c2897  redis-benchmark -h 127.0.0.1 -p 6379 -c 100 -n 100000
```

- jedis /lettuce  
[jedis lettuce 比较]（https://blog.csdn.net/jetty_welcome/article/details/104338173?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task）
```
| jedis
jedis 非线程安全，使用时一般池化
从jedispool中取资源 用完之后需要手动归还
```
[jedis 非线程安全分析]（https://www.jianshu.com/p/5e4a1f92c88f）
- redis lua 实践

- redis缓存常用实现方式  1 redisTemplate  2 spring cache
```
@C

```
- RDB
- AOF

https://baijiahao.baidu.com/s?id=1660009541007805174&wfr=spider&for=pc
