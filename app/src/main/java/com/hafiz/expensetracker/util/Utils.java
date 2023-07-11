package com.hafiz.expensetracker.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Utils {
    public static boolean isEmptyString(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmptyString(String str) {
        return StringUtils.isNotEmpty(str);
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        return StringUtils.containsIgnoreCase(str, searchStr);
    }

    public static boolean isBlankString(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlankString(String str) {
        return StringUtils.isNotBlank(str);
    }

    public static boolean equals(String str1, String str2) {
        return StringUtils.equals(str1, str2);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return StringUtils.equalsIgnoreCase(str1, str2);
    }

    public static boolean equals(Integer i1, Integer i2) {
        return i1 == null ? i2 == null : i1.equals(i2);
    }

    public static boolean equals(Long l1, Long l2) {
        return l1 == null ? l2 == null : l1.equals(l2);
    }

    public static boolean equals(Double d1, Double d2) {
        return d1 == null ? d2 == null : Double.compare(d1, d2) == 0;
    }

    public static boolean isNotEqual(Double d1, Double d2) {
        return !equals(d1, d2);
    }

    public static String trimToNull(String str) {
        return Utils.trimToNull(str);
    }

    public static Double trimToNullToDouble(String str) {
        return Utils.isEmptyString(str) ? null : Double.valueOf(str);
    }

    public static <E> boolean isEmpty(Collection<E> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <E> boolean isNotEmpty(Collection<E> collection) {
        return !isEmpty(collection);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    public static <E> int size(Collection<E> collection) {
        return collection == null ? 0 : collection.size();
    }

    public static String[] csvToStringArray(String str, String regex) {
        if (str == null) str = "";
        return str.split(regex);
    }

    public static String[] csvToArray(String str) {
        return csvToStringArray(str, ",");
    }

    public static List<Long> csvToLongList(String str) {
        String[] stringArray = csvToArray(str);
        List<Long> list = new ArrayList<>();
        for (String s : stringArray) {
            try {
                list.add(Long.parseLong(s));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<String> csvToStringList(String str) {
        String[] stringArray = csvToArray(str);
        List<String> list = new ArrayList<>();
        for (String s : stringArray) {
            if (Utils.isNotBlankString(s)) {
                list.add(s);
            }
        }
        return list;
    }

    public static <T> String getCsv(List<T> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (Utils.isNotEmpty(list)) {
            for (T t : list) {
                if (t != null) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(t);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static <T> String getCsvForDisplay(List<T> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (Utils.isNotEmpty(list)) {
            for (T t : list) {
                if (t != null) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(t);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isTrue(final Boolean bool) {
        return BooleanUtils.isTrue(bool);
    }

    public static boolean isNotTrue(final Boolean bool) {
        return BooleanUtils.isNotTrue(bool);
    }

    public static boolean isFalse(final Boolean bool) {
        return BooleanUtils.isFalse(bool);
    }

    public static boolean isNotFalse(final Boolean bool) {
        return BooleanUtils.isNotFalse(bool);
    }

    public static Boolean negate(final Boolean bool) {
        return BooleanUtils.negate(bool);
    }

    public static int indexOfIgnoreCase(List<String> list, String str) {
        if (isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (equalsIgnoreCase(list.get(i), str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean invalidLocation(Double latitude, Double longitude) {
        return latitude == null || longitude == null
                || Utils.equals(latitude, 0.0) || Utils.equals(longitude, 0.0);
    }

    public static boolean nullOrZero(Double d) {
        return d == null || equals(d, 0.0);
    }

    public static boolean nonNullAndNonZero(Double d) {
        return !nullOrZero(d);
    }

    public static double stringToDouble(String str) {
        double d = 0.0;
        if (str != null && str.trim().length() > 0) {
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return d;
    }

    public static int stringToInt(String str) {
        int integer = 0;
        if (str != null && str.trim().length() > 0) {
            try {
                integer = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return integer;
    }

    public static String doubleToString(Double d) {
        if (d == null) {
            return null;
        }
        return d.toString();
    }

    public static String intToString(Integer integer) {
        if (integer == null) {
            return null;
        }
        return integer.toString();
    }

    public static String toString(Long aLong) {
        if (aLong == null) {
            return null;
        }
        return aLong.toString();
    }

    public static <T> List<T> addAllList(List<T>... listOfList) {
        List<T> newList = new ArrayList<>();
        for (List<T> list : listOfList) {
            if (Utils.isNotEmpty(list)) {
                newList.addAll(list);
            }
        }
        return newList;
    }

    public static <T extends Comparable<T>> int compareTo(T t1, T t2) {
        if (t1 != null && t2 != null) {
            return t1.compareTo(t2);
        }
        return 0;
    }

    public static Bitmap stringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
