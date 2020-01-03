package map;


/**
 * @author luokai
 * @description:
 * @date: 2020-01-01
 * @version: 1.0
 */
public interface ST<K, V> {
    /**
     * 放入队列
     *
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * 获取队列
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 删除
     *
     * @param key
     */
    void delete(K key);

    /**
     * 是否包含
     *
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 获取有多少数量
     *
     * @return
     */
    int size();

    /**
     * 获取最小值
     *
     * @return
     */
    V min();
}
