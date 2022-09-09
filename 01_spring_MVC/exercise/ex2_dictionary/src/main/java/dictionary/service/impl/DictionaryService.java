package dictionary.service.impl;

import dictionary.model.Dictionary;
import dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    private static Map<Integer, Dictionary> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(1, new Dictionary("hello", "xin chào"));
        dictionaryMap.put(2, new Dictionary("apple", "quả táo"));
        dictionaryMap.put(3, new Dictionary("green", "màu xanh lá"));
        dictionaryMap.put(4, new Dictionary("black", "màu đen"));
        dictionaryMap.put(5, new Dictionary("banana", "quả chuối"));
        dictionaryMap.put(6, new Dictionary("bye", "tạm biệt"));
    }

    @Override
    public List<Dictionary> findAll() {
        return new ArrayList<>(dictionaryMap.values());
    }
}
