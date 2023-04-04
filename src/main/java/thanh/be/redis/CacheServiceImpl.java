package thanh.be.redis;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@Component
@Slf4j
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {
    private final RedisTemplate template;

    @Override
    public void setString(String key, String value) {
        try {
            template.opsForValue().set(key, value);
        } catch (RuntimeException e) {
            log.error(e.toString());
            throw new RuntimeException(e);

        }

    }

    @Override
    public void setList(String key, List value) {
        try {
            template.opsForList().rightPushAll(key, value);
        } catch (RuntimeException e) {
            log.error(e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object get(Object obj) {
        try {
            return template.opsForList().range((String) obj, 0, -1);
        } catch (RuntimeException e) {
            log.error(e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Object key) {
        try {
            template.delete(key);
        } catch (Exception e) {
            log.error(e.toString());
            throw new RuntimeException(e);
        }
    }
}
