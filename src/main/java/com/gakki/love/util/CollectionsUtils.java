package com.gakki.love.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/16
 * \* Time: 2:38
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class CollectionsUtils {

    public static <E> List<E> removeSame(Collection<E> tags){

        return new ArrayList<>(new LinkedHashSet<>(tags));
    }
}