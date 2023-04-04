package thanh.be.redis;

import java.util.List;

public interface CacheService {
    void setString(String key, String value);

    void setList(String key, List value);

    Object get(Object obj);

    void delete(Object key);
}
