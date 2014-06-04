package my_shoot.service.impl;

import my_shoot.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author: harry.chen
 * @since: 14-6-4 下午4:00
 */
@Service
public class ServiceImpl implements BaseService {
    @Override
    public String base() {
        return "base";
    }
}
