package com.springboot.concepts.utils;
import org.springframework.data.domain.*;
import java.util.List;

public class PageUtils {

    public static boolean isValidPageInfo(int pageNumber, int pageSize) {
        return pageNumber >= 0 && pageSize > 0;
    }

    public static Pageable createPageable(int pageNumber, int pageSize) {
        return PageRequest.of(--pageNumber, pageSize);
    }

    public static <T> Page<T> convertListToPage(List<T> list, Pageable pageable) throws IllegalArgumentException {
        long start, end;
        start = pageable.getOffset();

        if (start + pageable.getPageSize() > list.size()) {
            end = list.size();
        } else {
            end = (start + pageable.getPageSize());
        }

        return new PageImpl<>(list.subList((int) start, (int) end), pageable, list.size());
    }

}

